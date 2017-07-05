

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.NetworkConnectionSetting;

import io.appium.java_client.android.AndroidDriver;


public class SNGTestCases extends basepage {
	 public SNGTestCases(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 
	private String commonIdPath = "com.pointedsquares.gamy5.android:id";
    By emailId = By.id("email");
    By password = By.id("password");
    By login_Button = By.id("sign_in_button");
    By existingUser_login = By.id(commonIdPath + "/login_with_email_ll");
    By location = By.id("com.android.packageinstaller:id/permission_allow_button");

    //Checking SitnGo Dashboard
    public SNGTestCases SNGCheckAllCategory_TC1001() throws InterruptedException{
		Login();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/header_name"));
        Thread.sleep(5000);
        driver.scrollTo("Technology");
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'itemTitle') and contains(@text , 'Academics')]"));
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'itemTitle') and contains(@text , 'Technology')]"));
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'itemTitle') and contains(@text , 'Management')]"));
		return new SNGTestCases(driver);
	}
    
    //Checking User in Joining the table with enough balance.
    public SNGTestCases PlayerJoin_TC1007() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	try{
    		waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/debug_cancel"));
    		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/debug_cancel")).click();
    	}catch(Exception ex){
    		
    	}
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 40);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	return new SNGTestCases(driver);
    }
    
    //User doesn't have enough balance to join the table (pre-requirement coin should be less then stake value)
    public SNGTestCases PlayerJoin_TC1008() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/header_name"));
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'InSufficient Balance.')]"));
    	Thread.sleep(7000);
    	return new SNGTestCases(driver);
    }
    
    //Questions are displaying properly or not? (pre-requirement coin should be greater then stake value)
    public SNGTestCases Questions_TC1016() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/header_name"));
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	Thread.sleep(5000);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Still Waiting.....')]") , 2);
    	}catch(Exception ex){
    		
    	}
    	waitForVisibilityOf(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'question_one_linear')]/android.webkit.WebView/android.webkit.WebView/android.view.View"));
    	
    	String contDesc = driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'question_one_linear')]/android.webkit.WebView/android.webkit.WebView/*")).getAttribute("name");
    	Thread.sleep(7000);
    	return new SNGTestCases(driver);
    }
    
    //Options are displaying properly or not?
    public SNGTestCases Options_TC1017() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"),5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	Thread.sleep(5000);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Still Waiting.....')]") , 2);
    	}catch(Exception ex){
    		
    	}
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/choice_linear"));
    	List<WebElement> choices = driver.findElements(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'choice_linear')]/*"));
    	
    	boolean noOfChoice = true;
    	if(choices.size()!=4){
    		
    		noOfChoice = false;
    	}
    	assertTrue(noOfChoice , "Choice not equal to 4");
    	
    	Thread.sleep(7000);
    	return new SNGTestCases(driver);
    }
    
    //Coins collections from all active players.
    public SNGTestCases CoinsCollection_TC1014() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"),5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	Thread.sleep(5000);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Still Waiting.....')]") , 2);
    	}catch(Exception ex){
    		
    	}
    	waitForVisibilityOf(By.xpath("//android.widget.RelativeLayout[contains(@resource-id , 'topL')]"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/pool_currency_layout"));
    	List<WebElement> playerList = driver.findElements(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'player_list')]/*"));
    	int playerCount = 1;
    	for(int i = 0; i < 5; i++){
    		try{
    			driver.findElement(By.id("com.pointedsquares.gamy5.android:id/player_name_"+i));
    			playerCount++;
    		}catch(Exception ex){
    			
    		}
    	}
    	System.out.println(playerCount);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/pool_amount"));
    	Thread.sleep(7000);
    	return new SNGTestCases(driver);
    }
    
  //Checking when User exits from table..
    public SNGTestCases Exit_TC1027() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"),5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	Thread.sleep(5000);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Still Waiting.....')]") , 2);
    	}catch(Exception ex){
    		
    	}
    	waitForVisibilityOf(By.xpath("//android.widget.RelativeLayout[contains(@resource-id , 'topL')]"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/pool_currency_layout"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/exit_player")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/negative_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"));
    	Thread.sleep(7000);
    	return new SNGTestCases(driver);
    }
    
    //Checking when User exits during the message "Finding room for you".
    public SNGTestCases Exit_TC1028() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/wallet_tab")).click();
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/free_coins"));
    	String coinsBefore = driver.findElement(By.id("com.pointedsquares.gamy5.android:id/free_coins")).getText().toString();
    	System.out.println(coinsBefore);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sitngo_tab")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"),5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/exit_player")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/negative_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"));
    	driver.navigate().back();
    	driver.navigate().back();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/wallet_tab"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/wallet_tab")).click();
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/free_coins"));
    	String coinsAfter = driver.findElement(By.id("com.pointedsquares.gamy5.android:id/free_coins")).getText().toString();

    	System.out.println(coinsAfter);
    	boolean isCoinEqual = true;
    	if(!coinsBefore.equals(coinsAfter)){
    		isCoinEqual = false;
    	}
    	assertTrue(isCoinEqual , "Coins Not Found Same After Exiting From Message \"Finding room for you\"");
    	Thread.sleep(7000);
    	return new SNGTestCases(driver);
    }
    
    //User exits during the message "Game will begin in X seconds."
    public SNGTestCases Exit_TC1029() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/wallet_tab")).click();
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/free_coins"));
    	String coinsBefore = driver.findElement(By.id("com.pointedsquares.gamy5.android:id/free_coins")).getText();
    	System.out.println(coinsBefore);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sitngo_tab")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"),5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Waiting for Players to Join.\nPlease wait 9 seconds, approximately.')]"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/exit_player")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/negative_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"));
    	driver.navigate().back();
    	driver.navigate().back();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/wallet_tab"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/wallet_tab")).click();
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/free_coins"));
    	String coinsAfter = driver.findElement(By.id("com.pointedsquares.gamy5.android:id/free_coins")).getText();
    	System.out.println(coinsAfter);
    	boolean isCoinEqual = true;
    	if(!coinsBefore.equals(coinsAfter)){
    		isCoinEqual = false;
    	}
    	assertTrue(isCoinEqual , "Coins Not Found Same After Exiting From Message \"Finding room for you\"");
    	Thread.sleep(7000);
    	return new SNGTestCases(driver);
    }
    
    //Checking when User doesn't respond to the questions some specific number of consecutive questions
    public SNGTestCases ExitFromTheTable_TC1031() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"),5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Waiting for Players to Join.\nPlease wait 9 seconds, approximately.')]"));
    	Thread.sleep(4000);
    	int noOfTest = 0;
    	ArrayList<String> playersOnTable = new ArrayList();
    	ArrayList<String> seatsWithoutPlayer = new ArrayList();
    	for(; noOfTest < 3; noOfTest++){
    		try{

    			driver.findElement(By.id("com.pointedsquares.gamy5.android:id/player_name_1"));
    			playersOnTable.add("one");
    		}catch(Exception ex){
    			seatsWithoutPlayer.add("one");
    		}
    		try{
    			driver.findElement(By.id("com.pointedsquares.gamy5.android:id/player_name_2"));
    			playersOnTable.add("two");
    		}catch(Exception ex){
    			seatsWithoutPlayer.add("two");
    		}
    		try{
    			driver.findElement(By.id("com.pointedsquares.gamy5.android:id/player_name_3"));
    			playersOnTable.add("three");
    		}catch(Exception ex){
    			seatsWithoutPlayer.add("three");
    		}
    		try{
    			driver.findElement(By.id("com.pointedsquares.gamy5.android:id/player_name_4"));
    			playersOnTable.add("four");
    		}catch(Exception ex){
    			seatsWithoutPlayer.add("four");
    		}
    		try{
    			driver.findElement(By.id("com.pointedsquares.gamy5.android:id/player_name_5"));
    			playersOnTable.add("five");
    		}catch(Exception ex){
    			seatsWithoutPlayer.add("five");
    		}
    		try{
    			driver.findElement(By.id("com.pointedsquares.gamy5.android:id/player_name_6"));
    			playersOnTable.add("six");
    		}catch(Exception ex){
    			seatsWithoutPlayer.add("six");
    		}
    		try{
				driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id , 'anim_coin_one')]"));
			}catch(Exception ex){
				
			}
    		
    		waitForVisibilityOf(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'question_one_linear')]/android.webkit.WebView/android.webkit.WebView/android.view.View"));
    		String question = driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'question_one_linear')]/android.webkit.WebView/android.webkit.WebView/android.view.View")).getAttribute("name");
    		System.out.println(question);
    		waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'timer_value')]"),40);
//    		waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/choice_linear"));
//    		List<WebElement> choices = driver.findElements(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'choice_linear')]/*"));
//    		boolean isFourChoice = true;
//    		if(choices.size() != 4){
//    			isFourChoice = false;
//    		}
//    		assertTrue(isFourChoice , "Error: Question not have four choice");
//    		System.out.println(choices.size());
//    		List<WebElement> abc = driver.findElements(By.xpath("//android.widget.ImageView[contains(@resource-id , 'arc_progress')]"));
//    		System.out.println(driver.findElement(By.id("com.pointedsquares.gamy5.android:id/progressBarHorizontal")).getAttribute("text"));
//    		System.out.println(driver.findElement(By.id("com.pointedsquares.gamy5.android:id/progressBarHorizontal")).getAttribute("name"));
//    		System.out.println(driver.findElement(By.id("com.pointedsquares.gamy5.android:id/arc_progress")).getAttribute("text"));
//    		while(!driver.findElement(By.id("com.pointedsquares.gamy5.android:id/timer_value")).getAttribute("name").equals("0")){
//    			System.out.println(driver.findElement(By.id("com.pointedsquares.gamy5.android:id/timer_value")).getAttribute("name"));
//    		}
    		playersOnTable.clear();
    	}
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'Sorry, we have to remove you from the table because you did not answer 3 consecutive questions.')]"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button"));
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"));
    	driver.navigate().back();
    	driver.navigate().back();
    	Thread.sleep(7000);
    	return new SNGTestCases(driver);
    }

    //Checking Favorites adding.
    public SNGTestCases Favorite_TC1002() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/subject_image"));
        List subject = driver.findElements(By.id(commonIdPath + "/subject_image"));
        ((WebElement) subject.get(0)).click();
        driver.findElement(By.id(commonIdPath + "/favorite_icon"));
        List fav = driver.findElements(By.id(commonIdPath + "/favorite_icon"));
        ((WebElement) fav.get(0)).click();
        return new SNGTestCases(driver);
	}
    
    //Remove Favorites 
    public SNGTestCases Favorite_TC1003() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@text , 'My Favorites')]/following-sibling::android.widget.TextView[contains(@text , 'More')]"));
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'My Favorites')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'header_name') and contains(@text , 'Favorites')]"));
        List<WebElement> favList = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id , 'listViewFavorite')]/*"));
        favList.get(0).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/favorite_icon"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/favorite_icon")).click();
        //waitForVisibilityOf(By.id("android:id/message"));
        //waitForVisibilityOf(By.linkText("Removed successfully"));
        return new SNGTestCases(driver);
	}
    
    public SNGTestCases AddAndRemoveFavorite() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/subject_image"));
        List subject = driver.findElements(By.id(commonIdPath + "/subject_image"));
        ((WebElement) subject.get(0)).click();
        driver.findElement(By.id(commonIdPath + "/favorite_icon"));
        List fav = driver.findElements(By.id(commonIdPath + "/favorite_icon"));
        ((WebElement) fav.get(0)).click();
        driver.navigate().back();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@text , 'My Favorites')]/following-sibling::android.widget.TextView[contains(@text , 'More')]"));
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'My Favorites')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'header_name') and contains(@text , 'Favorites')]"));
        List<WebElement> favList = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id , 'listViewFavorite')]/*"));
        favList.get(0).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/favorite_icon"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/favorite_icon")).click();
        //waitForVisibilityOf(By.id("android:id/message"));
        //waitForVisibilityOf(By.linkText("Removed successfully"));
        return new SNGTestCases(driver);
	}
    
    //Checking Rules of the Game.
    public SNGTestCases RuleOfTheGame_TC1005() throws InterruptedException{
    	Login();
    	 waitForVisibilityOf(By.id(commonIdPath + "/subject_image"));
         List subject = driver.findElements(By.id(commonIdPath + "/subject_image"));
         ((WebElement) subject.get(0)).click();
         waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/info_icon"));
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/info_icon")).click();
         waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'app_info_title')]"));
        return new SNGTestCases(driver);
	}
    
    //Checkin close button in Rules of the Game.
    public SNGTestCases CloseBtnOfRule_TC1006() throws InterruptedException{
    	Login();
    	 waitForVisibilityOf(By.id(commonIdPath + "/subject_image"));
         List subject = driver.findElements(By.id(commonIdPath + "/subject_image"));
         ((WebElement) subject.get(0)).click();
         waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/info_icon"));
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/info_icon")).click();
         waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'app_info_title')]"));
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/cross_button")).click();
         waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'app_info_title')]"));
        return new SNGTestCases(driver);
	}
    
    //User try to join in middle of the game(When table has less than 6 members) 
    //(NOTE : This testcase require at list one active table with at list one vacant position)
    public SNGTestCases JoinInMiddleOfTheGame_TC1009() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"),5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	Thread.sleep(5000);
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Still Waiting.....')]") , 2);
		return new SNGTestCases(driver);
	}
    
    public SNGTestCases ExitFromTheTable_TC1032() throws InterruptedException{
    	String flavour = "Electrical";
    	
    	forDebugger();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/header_name"),120);
    	try{
    		waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]") , 5);
    	}catch(Exception ex){
    		driver.scrollTo("Academics");
    	}
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Academics') and contains(@resource-id , 'itemTitle')]/following-sibling::android.widget.TextView[contains(@text , 'More')]")).click();
    	waitForElement(By.id("com.pointedsquares.gamy5.android:id/search_all"), 10);
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/search_all")).sendKeys(flavour);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavour_name_list') and contains(@text , 'Electrical Engineering')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]"),5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'stake_amount') and contains(@text , '500')]")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]"), 5);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'message_text') and contains(@text , 'You are about to play Electrical Engineering game with 500 coins stake.')]")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/positive_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Finding room for you...')]"));
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'response') and contains(@text , 'Waiting for Players to Join.\nPlease wait 9 seconds, approximately.')]"));
    	waitForVisibilityOf(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'question_one_linear')]/android.webkit.WebView/android.webkit.WebView/android.view.View"));
		String question = driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id , 'question_one_linear')]/android.webkit.WebView/android.webkit.WebView/android.view.View")).getAttribute("name");
		System.out.println(question);
		waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'timer_value')]"),40);
//		NetworkConnectionSetting wifiOff = new NetworkConnectionSetting(false , false, false);
//		wifiOff.setData(false);
//		wifiOff.setWifi(false);
//		driver.setNetworkConnection(wifiOff);
		System.out.println("aaa");
		driver.openNotifications();
		Thread.sleep(25000);
    	return new SNGTestCases(driver);
    	
    }

}
