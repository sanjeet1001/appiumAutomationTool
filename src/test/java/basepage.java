

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;

/**
 * Created by Sanjeet
 */
public class basepage {

	private String serviceURL = "http://gamy5deva-api.azurewebsites.net";
	private String commonIdPath = "com.pointedsquares.gamy5.android:id";
    By emailId = By.id("email");
    By password = By.id("password");
    By login_Button = By.id("sign_in_button");
    By existingUser_login = By.id(commonIdPath + "/login_with_email_ll");
    By location = By.id("com.android.packageinstaller:id/permission_allow_button");
	
    protected AndroidDriver driver;

    public basepage(AndroidDriver driver) {
        this.driver = driver;
    }
    
    public void Login() throws InterruptedException{
    	try{
        	waitForElement(By.id("com.android.packageinstaller:id/permission_allow_button"),10);
    	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	}catch(Exception ac){}

    	Thread.sleep(3000);
    	//waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
    }
    
    public void LoginWithLowBalanceAccount() throws InterruptedException{
    	try{
        	waitForElement(By.id("com.android.packageinstaller:id/permission_allow_button"),10);
    	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	}catch(Exception ac){}

    	Thread.sleep(3000);
    	//waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).sendKeys("lowbalanceaccount@pcmylife.com");
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
    }
    
    
    public void forDebugger() throws InterruptedException{
    	try{
        	waitForElement(By.id("com.android.packageinstaller:id/permission_allow_button"),10);
    	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	}catch(Exception ac){}
    	
    	Thread.sleep(3000);
    	//waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("sanjeetksahu7@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
    	try{
    		waitForElement(By.id("com.pointedsquares.gamy5.android:id/debug_url"),3);
    		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/debug_url")).click();
    		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/debug_url")).clear();
    		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/debug_url")).sendKeys(serviceURL);
    		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/debug_submit")).click();
    		Thread.sleep(5000);
    		Login();
    		waitForElement(By.id("com.pointedsquares.gamy5.android:id/debug_cancel"),3);
    		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/debug_cancel")).click();
    		
    	}catch(Exception ex){}
    }
    protected void waitForVisibilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    protected void waitForElement(By locator, int time){
    	WebDriverWait wait = new WebDriverWait(driver , time);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }


    public void swipeLeftToRight() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.01);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.9);
        swipeObject.put("endY", 0.6);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void swipeFirstCarouselFromRightToLeft() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.9);
        swipeObject.put("startY", 0.2);
        swipeObject.put("endX", 0.01);
        swipeObject.put("endY", 0.2);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }

    public void performTapAction(WebElement elementToTap) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 360); // in pixels from left
        tapObject.put("y", (double) 170); // in pixels from top
        tapObject.put("element", Double.valueOf(((RemoteWebElement) elementToTap).getId()));
        js.executeScript("mobile: tap", tapObject);
    }
    
}
