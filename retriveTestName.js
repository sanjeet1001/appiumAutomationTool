// "child_process"" module used to access the Windows command line
// "fs" module used to access the file system
var exec = require('child_process').execSync;
var fs = require('fs');
// To store all the servers which are going to be started leter.
var serverList = "";
//storing the selenium grid command.
serverList = 'start cmd.exe /k "java -jar selenium-server-standalone-3.4.0.jar -role hub"\n';
// devices array contains all the connected devices id.
var devices = []; 
// json object is used to store configuration of appium server for each device. 
var json = {"class":"","capabilities":[],"configuration":{}}; 
// Starting port number for appium server which is increased by 1 for each 
// device detected. JSON and XML need different ports. 
var portJSON = 5566;
var portXML = 5566;
// starting bootstrap port for appium server which is increased by 1 for each 
// device detected.
var bport = 8181;
// xml variable use to create testng.xml file.
var xml ="";
//methods array use to store all the test methods.
var methods = [];

var isTrue = new Boolean(true);
const parallelMode = 1;
const serialMode = 2; 

const readline = require('readline');

const testMode = readline.createInterface({
                    input: process.stdin,
                    output: process.stdout
                });

//fetching the current location in forward and backward slash format.
//__dirname gives us current directory location with backward slash(c:\users\)
// serverDir contains current directory location with forward slash(c:/user/)
var dirname = __dirname.split("\\");
var serverDir = "";
for(var i = 0; i < dirname.length; i++){
    serverDir = serverDir + dirname[i] + "/";
}

//Fetching the connected android device id in the array 'devices',
//executing the adb devices command to get the connected device list and 
//storing the result in deviceList variable.
var deviceList = exec("adb devices", {encoding: 'utf8'}).split('\n');

//"adb devices" command has irrelevant output in the first line and the last
// two lines; hence reading the device ids only from the remaining lines
//@todo: Track the device status and throw an error appropriately
var deviceIndex = 0;
var deviceListLimit = deviceList.length - 2; 
for (var index of deviceList){
    if((deviceIndex != 0) && (deviceIndex < deviceListLimit)){
        devices[deviceIndex - 1] = index.split('\t')[0];
    }
    deviceIndex++;
}

//creating the json for each device to be read by the Appium server
for(var i = 0; i < devices.length; i++){
    json.class = "org.openqa.grid.common.RegistrationRequest";
    json.capabilities = [
        {
            "browserName" : "Android",
            "maxInstances":1,
            "platformName":"ANDROID",
            "deviceName":devices[i],
            "newCommandTimeout":"30",
            "deviceReadyTimeout":5
        }
    ];

    json.configuration = {
        "cleanUpCycle":2000,
        "timeout":10800,
        "url":"http://127.0.0.1:!port!/wd/hub",
        "host":"127.0.0.1",
        "port": portJSON,
        "proxy":"org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
        "maxSession":1,
        "register":true,
        "registerCycle":5000,
        "hubPort":4444,
        "hubHost":"127.0.0.1"
    };

    //saving the command that starts appium server for each device.
    serverList = serverList + 'start cmd.exe /k "appium --nodeconfig ' 
        + __dirname + '\\nodeconfig' + i + '.json -p ' + portJSON + ' -bp ' 
        + bport + ' -U ' + devices[i] + '"\n';
    portJSON++;
    bport++;
}

//Retrieving all the test method 
methods = fs.readFileSync(serverDir + 'src/test/resources/MethodNames.txt'
            , 'utf8').split('\r\n');

testMode.question('Press 1 to run testcases in paraller\nPress 2 to run '+
    'testcases sequential\nPress any other key to exit..\n:', (answer) => {

    //saving all the server start command into servers.bat file in current 
    //directory.
    if(answer == parallelMode){
        Parallel();
    }
    else if(answer == serialMode){
        Sequential();
    }
    else{
        process.exit();
    }
    
    fs.writeFile(serverDir + "servers.bat", serverList, function(err) {
            if(err){
                return console.log(err);
            } 
            else{              
                //saving the json file with name nodeconfig1, nodeconfig2 ....
                fs.writeFile(serverDir + "nodeconfig" + i + ".json", JSON.stringify(json)
                    , function(err) {
                        if(err){
                                return console.log(err);
                        }
                        else{                    
                                //executing the servers.bat file to start all the servers
                                require('child_process')
                                    .exec("servers.bat", function (err, stdout, stderr) {
                                    if (err) {
                                        return console.log(err);
                                    }
                                    console.log(stdout);
                                });
                                testMode.close();
                        }
                });
            }
    });
});

//The Parallel method is used to create testng.xml file such that all the 
//testcases will be divided among all the connected devices for execution.
function Parallel(){
    //Allocating the total number of tests amongst the total number of 
    //devices in round robin
    var testDivision = Math.floor(methods.length / devices.length);
    var remainingTest = methods.length % devices.length;
    //currentTest help
    var currentTest=0;
    xml = '<?xml version="1.0" encoding="UTF-8"?>';
    xml = xml + '<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">';
    xml = xml + '<suite name="Suite"  verbose="1" parallel="tests" thread-count="' 
        + devices.length + '">';
    for(var i = 0; i < devices.length; i++){
        xml = xml + '<test name="test' 
                + i + '"><parameter name="DeviceId" value="'
        xml = xml + devices[i] + '"></parameter><parameter name="Port" value="'
                + portXML + '">';
        xml = xml + '</parameter><classes><class name="AppiumTest"><methods>';
            for(var j = 0; j < testDivision; j++){
                xml = xml +'<include name="' + methods[currentTest++] + '" />';
            }
            if(remainingTest > 0){
                xml = xml +'<include name="' + methods[currentTest++] + '" />';
                remainingTest--;
            }
        xml = xml + '</methods></class></classes></test>';
        portXML++;
    }
    xml = xml + '</suite>';
    fs.writeFile(serverDir + "testng.xml", xml, function(err) {
            if(err) {
                return console.log(err);
            }
    });
}

//The Sequential method used to create testng.xml file such that all the testcases will be run into all the connected devices.
function Sequential(){
    var currentTest=0;
    xml = '<?xml version="1.0" encoding="UTF-8"?><!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">';
    xml = xml + '<suite name="Suite"  verbose="1" parallel="tests" thread-count="' + devices.length + '">';
    for(var i = 0; i < devices.length; i++){
        xml = xml + '<test name="test' + i + '"><parameter name="DeviceId" value="' 
        xml = xml + devices[i] + '"></parameter><parameter name="Port" value="' + portXML + '">';
        xml = xml + '</parameter><classes><class name="AppiumTest" /></classes></test>';
        portXML++;
    }
    xml = xml + '</suite>';
    fs.writeFile(serverDir + "testng.xml", xml, function(err) {
            if(err) {
                return console.log(err);
            }
    });
}