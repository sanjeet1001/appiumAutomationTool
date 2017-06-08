

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class androidsetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium(String Device, String Port) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("no-reset", "true");
        capabilities.setCapability("full-reset", "False");
        capabilities.setCapability("browserName", "Android");
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "ANDROID");
        capabilities.setCapability("deviceName",Device);
        capabilities.setCapability("udid", Device);
        capabilities.setCapability("app", "C:/Users/PS-Analyst-05/Desktop/app/app-debug.apk");
        capabilities.setCapability("appPackage", "com.pointedsquares.gamy5.android");
       driver = new AndroidDriver(new URL("http://0.0.0.0:"+Port+"/wd/hub"), capabilities);
       //capabilities.setCapability("appActivity", "com.pointedsquares.gamy5.android.SplashActivity");
      
    }
    
}
 