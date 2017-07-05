
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class UPMTestCases extends basepage {
	
	public UPMTestCases(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String commonIdPath = "com.pointedsquares.gamy5.android:id";
	String androidIDs = "com.android.packageinstaller:id";
    By emailId = By.id("email");
    By password = By.id("password");
    By login_Button = By.id("sign_in_button");
    By existingUser_login = By.id(commonIdPath + "/login_with_email_ll");
    By location = By.id(androidIDs + "/permission_allow_button");
    
    String withoutDebuggerEmail = "whoissanjeet@gmail.com";
    String withoutDebuggerPassword = "Abcd@123";
   
    /* @brief TC0001 SignUp with new EmailId //It require OTP so it is completed before
     * 		  the OTP part.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases JoinUsWithNewId() throws InterruptedException{
    	
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
    	waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
    	driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
    	driver.findElement(By.id(commonIdPath + "/email")).sendKeys("hghsdfasdfasdfasdfgv@ipdeer.com");
    	driver.findElement(By.id(commonIdPath + "/password"))
    	.sendKeys(withoutDebuggerPassword);
    	driver.findElement(By.id(commonIdPath + "/register_button")).click();
    	
    	/*It will wait for 50 second to find the great message*/
    	waitForElement(
    			By.xpath("//android.widget.TextView[contains(@text , 'GREAT!')]"), 
    			50
    	);
    	Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
    
    /* @brief TC0018 Login with registered email Id  and password
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases loginWithCorrenctEmailId() throws InterruptedException {
	 	try{
	    	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
		 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
		}catch(Exception ac){
			
		}
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys(withoutDebuggerEmail);
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(withoutDebuggerPassword);
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        
        /*It will wait for Sit N Go tab which is come after login*/
        waitForElement(By.xpath("//android.widget.TextView[contains"
        		+ "(@text , 'Sit N Go')]") , 40);
        Thread.sleep(5000);
        return new UPMTestCases(driver);
    }
    
    /* @brief TC0019 Login with Invalid email Id and test passes when login fails
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases loginWithInvalidEmailId() throws InterruptedException {
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){}
    	
    	/* Attempt to enter the unregistered email id  */
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjetgmaicom");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(withoutDebuggerPassword);
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        
        return new UPMTestCases(driver);
    }

    /* @brief TC0020 Login with unregistered email Id and test passes when login fails
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases loginWithUnregisteredEmailId() throws InterruptedException {
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){}
    	
    	/* Attempt to enter the unregistered email id  */
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(withoutDebuggerPassword);
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        
        /* The following call gets a error message 'Invalid Username or Password' */
        waitForElement(By.xpath("//android.widget.TextView[contains"
        		+ "(@text , 'Invalid Username or Password')]"),40);
        Thread.sleep(5000);
        return new UPMTestCases(driver);
    }
    /* @brief TC0021 Login with wrong password and test passes when login fails
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases loginWithWrongPassword() throws InterruptedException {
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){}
    	
    	/* Attempt to enter the unregistered email id  */
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("ddddaa");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        
        /* The following call gets a error message 'Invalid Username or Password' */
        waitForElement(By.xpath("//android.widget.TextView[contains"
        		+ "(@text , 'Invalid Username or Password')]"),40);
        Thread.sleep(5000);
        return new UPMTestCases(driver);
    }
    
    /* @brief TC0002 Give an existing email id on sign up and then change
     * 		 to another email id
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
	public UPMTestCases SignUpwithRegisteredEmailID() throws InterruptedException{
		Random rand = new Random();
		int createNewEmail = rand.nextInt(1000);
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
		 waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
		 driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
		 driver.findElement(By.id(commonIdPath + "/email"))
		 .sendKeys(withoutDebuggerEmail);
		 driver.findElement(By.id(commonIdPath + "/password")).click();
		 driver.findElement(By.id(commonIdPath + "/password"))
		 .sendKeys(withoutDebuggerPassword);
		 driver.findElement(By.id(commonIdPath + "/register_button")).click();
		 
		 /*This will check the message "Name 'Email' is already taken"*/
		 waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Name " +
				 withoutDebuggerEmail + " is already taken.')]") , 40);
		 Thread.sleep(7000);
		 driver.findElement(By.id("android:id/button1")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id(commonIdPath + "/email")).clear();
		 driver.findElement(By.id(commonIdPath + "/email"))
		 .sendKeys("sendingrandomemaildvdv"+createNewEmail+"@dummy.com");
		 driver.findElement(By.id(commonIdPath + "/password")).clear();
		 driver.findElement(By.id(commonIdPath + "/password")).click();
		 driver.findElement(By.id(commonIdPath + "/password"))
		 .sendKeys(withoutDebuggerPassword);
		 driver.findElement(By.id(commonIdPath + "/register_button")).click();
		 waitForElement(By.xpath("//android.widget.TextView[contians(@text , "
		 		+ "'You are now signed with Gamy5')]") , 50);
		 Thread.sleep(5000);
		 return new UPMTestCases(driver);
	}
    
	/* @brief TC0004 Signing Up with empty password.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
	public UPMTestCases SignUpWithEmptyPassword() throws InterruptedException{
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
		 waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
		 driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
		 driver.findElement(By.id(commonIdPath + "/email"))
		 .sendKeys("whoissanjeet@gmail.com");
		 driver.navigate().back();
		 driver.findElement(By.id(commonIdPath + "/register_button")).click();
		 
		 Thread.sleep(5000);
		 return new UPMTestCases(driver);
	}
	
	/* @brief TC0005 Signing Up with empty password.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
	public UPMTestCases SignUpWithInvalidEmail() throws InterruptedException{
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
		 waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
		 driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
		 driver.findElement(By.id(commonIdPath + "/email"))
		 .sendKeys("whoissanjeetgmail.com");
		 driver.findElement(By.id(commonIdPath + "/password")).sendKeys("adfsd");
		 driver.navigate().back();
		 driver.findElement(By.id(commonIdPath + "/register_button")).click();
		 
		 Thread.sleep(5000);
		 return new UPMTestCases(driver);
	}
	
	/* @brief Try to move from signup to signin page.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases SignUpPagetoSignInPage() throws InterruptedException{
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
    	waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
		 driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
		 waitForVisibilityOf(By.id(commonIdPath + "/sign_in_tv"));
		 driver.findElement(By.id(commonIdPath + "/sign_in_tv")).click();
		 Thread.sleep(5000);
		 return new UPMTestCases(driver);
    }
    
    /* @brief Login and Logout check.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases LoginAndLogout() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tab"));
        driver.findElement(By.id(commonIdPath + "/profile_tab")).click();
        driver.findElement(By.id(commonIdPath + "/logout_ll")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id(commonIdPath + "/logout_ll")).click();
        driver.findElement(By.id("android:id/button2")).click();
        waitForVisibilityOf(existingUser_login);
    	Login();
    	Thread.sleep(5000);
        return new UPMTestCases(driver);
    }
    
    /* @brief TC0020 Try to login with invalid id.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases LoginWithInvalidId() throws InterruptedException{
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
		waitForVisibilityOf(By.id(commonIdPath + "/login_with_email_ll"));
    	driver.findElement(By.id(commonIdPath + "/login_with_email_ll")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("whoissanjet@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(withoutDebuggerPassword);
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        Thread.sleep(5000);
        return new UPMTestCases(driver);
	}
    
    /* @brief TC0020 Try to login with invalid id.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    
    public UPMTestCases LoginWithEmptyPassword() throws InterruptedException{
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys(withoutDebuggerEmail);
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        Thread.sleep(5000);
        return new UPMTestCases(driver);
    }
    
    /* @brief TC0027-Verify with valid New and Old Password
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases ChangePassword() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tab_name"));
        driver.findElement(By.id(commonIdPath + "/profile_tab_name")).click();
        driver.findElement(By.id(commonIdPath + "/change_password_tv")).click();
        driver.findElement(By.id(commonIdPath + "/old_password_et")).click();
        driver.findElement(By.id(commonIdPath + "/old_password_et"))
        .sendKeys(withoutDebuggerPassword);
        driver.navigate().back();
        waitForVisibilityOf(By.id(commonIdPath + "/new_password_et"));
        driver.findElement(By.id(commonIdPath + "/new_password_et")).click();
        driver.findElement(By.id(commonIdPath + "/new_password_et"))
        .sendKeys(withoutDebuggerPassword);
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/rest_button")).click();
        
        /*Wait for GREAT! pop-up message*/
        waitForElement(By.xpath("//android.widget.TextView[contains(@text ,"
        		+ " 'GREAT!')]") , 50);
        Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
    
    public UPMTestCases CompleteProfileAferRegistration() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tab_name"));
        driver.findElement(By.id(commonIdPath + "/profile_tab_name")).click();
        Thread.sleep(3000);
        driver.findElement(By.id(commonIdPath + "/profile_tv")).click();
//        waitForVisibilityOf(By.id(commonIdPath + "/profile_pic_iv"));
//        driver.findElement(By.id(commonIdPath + "/profile_pic_iv")).click();
//        driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//        driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
        driver.findElement(By.id(commonIdPath + "/male_iv")).click();
        driver.findElement(By.id(commonIdPath + "/first_name_et")).clear();
        driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
        driver.findElement(By.id(commonIdPath + "/last_name_et")).clear();
        driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/display_name_et")).clear();
    	driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys("$9911");
    	driver.navigate().back();
    	driver.findElement(By.id(commonIdPath + "/country_et")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text ,"
    			+ " 'Andorra')]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id(commonIdPath + "/age_category_et")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text ,"
    			+ " '25 - 35 years.')]")).click();
    	Thread.sleep(1000);
        driver.findElement(By.id(commonIdPath + "/done_tv")).click();
        Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
    
    /* @brief TC0028-Verify with Invalid Old Password.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases InvalidOldPasswordInChangePasswordTab() 
    		throws InterruptedException{
    	Login();
    	waitForVisibilityOf(By.id(commonIdPath + "/profile_tab_name"));
	    driver.findElement(By.id(commonIdPath + "/profile_tab_name")).click();
	    driver.findElement(By.id(commonIdPath + "/change_password_tv")).click();
	    driver.findElement(By.id(commonIdPath + "/old_password_et"))
	    .sendKeys("Abddcd@123");
	    driver.navigate().back();
	    waitForVisibilityOf(By.id(commonIdPath + "/new_password_et"));
	    driver.findElement(By.id(commonIdPath + "/new_password_et")).click();
	    driver.findElement(By.id(commonIdPath + "/new_password_et"))
	    .sendKeys(withoutDebuggerPassword);
	    driver.navigate().back();
	    waitForVisibilityOf(By.id(commonIdPath + "/rest_button"));
	    driver.findElement(By.id(commonIdPath + "/rest_button")).click();
	    
	    /*Wait for GREAT! pop-up message*/
        waitForElement(By.xpath("//android.widget.TextView[contains(@text , "
        		+ "'Incorrect password.')]") , 50);
	    Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
    
    /* @brief TC0029-Leave Old Password field empty and tap on Reset.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases EmptyOldPasswordInChangePasswordTab() throws InterruptedException{
    	Login();
		waitForVisibilityOf(By.id(commonIdPath + "/profile_tab_name"));
		driver.findElement(By.id(commonIdPath + "/profile_tab_name")).click();
		driver.findElement(By.id(commonIdPath + "/change_password_tv")).click();
		driver.findElement(By.id(commonIdPath + "/old_password_et")).sendKeys("");
		driver.navigate().back();
		waitForVisibilityOf(By.id(commonIdPath + "/rest_button"));
		driver.findElement(By.id(commonIdPath + "/rest_button")).click();
		Thread.sleep(5000);
		return new UPMTestCases(driver);	
	}
	
    /* @brief TC0030-Leave New Password field empty and tap on Reset.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
	public UPMTestCases EmptyNewPasswordInChangePasswordTab() throws InterruptedException{
    	Login();
	    waitForVisibilityOf(By.id(commonIdPath + "/profile_tab_name"));
	    driver.findElement(By.id(commonIdPath + "/profile_tab_name")).click();
	    driver.findElement(By.id(commonIdPath + "/change_password_tv")).click();
	    driver.findElement(By.id(commonIdPath + "/old_password_et")).sendKeys("abcdef");
	    driver.navigate().back();
	    waitForVisibilityOf(By.id(commonIdPath + "/rest_button"));
	    driver.findElement(By.id(commonIdPath + "/rest_button")).click();
	    Thread.sleep(5000);
	    return new UPMTestCases(driver);
	}
 

    /* @brief Update profile after login with existing Email and password with all positive scenario.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases ProfileUpdate() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tab"));
        driver.findElement(By.id(commonIdPath + "/profile_tab")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tv"));
        driver.findElement(By.id(commonIdPath + "/profile_tv")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/female_iv"));
        driver.findElement(By.id(commonIdPath + "/female_iv")).click();
        driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
        driver.findElement(By.id(commonIdPath + "/first_name_et")).clear();
        driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
        driver.findElement(By.id(commonIdPath + "/last_name_et")).clear();
        driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
        driver.findElement(By.id(commonIdPath + "/display_name_et")).clear();
        driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys("SkS2222");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/done_tv")).click();
        Thread.sleep(5000);
        return new UPMTestCases(driver);
    }
        
    /* @brief TC0010- Trying to update the profile with empty name.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases ProfileUpdateWithEmptyName() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tab"));
        driver.findElement(By.id(commonIdPath + "/profile_tab")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tv"));
        driver.findElement(By.id(commonIdPath + "/profile_tv")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/female_iv"));
        driver.findElement(By.id(commonIdPath + "/female_iv")).click();
        driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
        driver.findElement(By.id(commonIdPath + "/first_name_et")).clear();
        driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/done_tv")).click();
        Thread.sleep(5000);
        return new UPMTestCases(driver);
    }
    
    /* @brief TC0033- Inviting friends through Facebook.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases InviteFriendFromFacebook() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/wallet_tab_name"));
    	driver.findElement(By.id(commonIdPath + "/wallet_tab_name")).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/invite_ll"));
    	driver.findElement(By.id(commonIdPath + "/invite_ll")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text, "
    			+ "'Facebook')]/..")).click();
    	waitForVisibilityOf(By.id("com.facebook.katana:id/status_text"));
    	driver.findElement(By.id("com.facebook.katana:id/status_text")).sendKeys("Hi");
    	driver.findElement(By.id("com.facebook.katana:id/button_share")).click();
    	Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
    
    /* @brief TC0033- Inviting friends through Gmail.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases InviteFriendFromGmail() throws InterruptedException{
    	Login();
        waitForVisibilityOf(By.id(commonIdPath + "/wallet_tab_name"));
    	driver.findElement(By.id(commonIdPath + "/wallet_tab_name")).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/invite_ll"));
    	driver.findElement(By.id(commonIdPath + "/invite_ll")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text,"
    			+ " 'Gmail')]/..")).click();
    	waitForVisibilityOf(By.id("com.google.android.gm:id/to"));
    	driver.findElement(By.id("com.google.android.gm:id/to"))
    	.sendKeys(withoutDebuggerEmail);;
    	driver.findElement(By.id("com.google.android.gm:id/send")).click();
    	Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
    
    /* @brief TC0033- Inviting friends through Messaging.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases InviteFriendFromMessaging() throws InterruptedException{
    	Login();
    	waitForVisibilityOf(By.id(commonIdPath + "/wallet_tab_name"));
    	driver.findElement(By.id(commonIdPath + "/wallet_tab_name")).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/invite_ll"));
    	driver.findElement(By.id(commonIdPath + "/invite_ll")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Messaging')]/..")).click();
    	waitForVisibilityOf(By.id("com.android.mms:id/recipient_rows_scroller"));
    	driver.findElement(By.id("com.android.mms:id/recipient_rows_scroller")).click();
    	driver.findElement(By.id("com.android.mms:id/recipient_rows_scroller")).sendKeys("8297139374");;
    	driver.findElement(By.id("com.android.mms:id/send_button")).click();
    	Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
    

//    public UPMTestCases CompleteSignUpProcess(){
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys("waww@ipdeer.com");
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(withoutDebuggerPassword);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/profile_pic_iv_demo"));
//		driver.findElement(By.id(commonIdPath + "/profile_pic_iv_demo")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@text , 'Camera')]"));
//		driver.findElement(By.xpath("//android.widget.TextView[contains(@text , 'Camera')]")).click();
//		waitForVisibilityOf(By.id("com.android.camera:id/v6_shutter_button_internal"));
//		driver.findElement(By.id("com.android.camera:id/v6_shutter_button_internal")).click();
//		waitForVisibilityOf(By.id("com.android.camera:id/v6_btn_done"));
//		driver.findElement(By.id("com.android.camera:id/v6_btn_done")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/save"));
//		driver.findElement(By.id(commonIdPath + "/save")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys("TtTtTt");
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		return new UPMTestCases(driver);
//    }
//    
//    //Give an existing email id on sign up and then change to another email id
//    public UPMTestCases VarifySignUp_TC0002(){
//    	String existingEmail = withoutDebuggerEmail;
//    	String newEmail = "qqqq@ipdeer.com";
//    	String password = withoutDebuggerPassword;
//		String msg = "//android.widget.TextView[contains(@text , 'Name "+existingEmail+" is already taken.')]";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(withoutDebuggerEmail);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(withoutDebuggerPassword);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.xpath(msg));
//		driver.findElement(By.id("android:id/button1")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/email"));
//		driver.findElement(By.id(commonIdPath + "/email")).clear();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys("qqqq@ipdeer.com");
//		driver.findElement(By.id(commonIdPath + "/password")).clear();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(withoutDebuggerPassword);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//    	return new UPMTestCases(driver);
//    }
//    
//  //Give an existing email id on sign up and then trying to sign in.
//    public UPMTestCases VarifySignUp_TC0003(){
//    	String existingEmail = withoutDebuggerEmail;
//    	String newEmail = "qqqq@ipdeer.com";
//    	String password = withoutDebuggerPassword;
//		String msg = "//android.widget.TextView[contains(@text , 'Name "+existingEmail+" is already taken.')]";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(existingEmail);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(password);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.xpath(msg));
//		driver.findElement(By.id("android:id/button1")).click();
//		driver.findElement(By.id(commonIdPath + "/sign_in_tv")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/email"));
//		driver.findElement(By.id(commonIdPath + "/email")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(existingEmail);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(password);
//		driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
//    	return new UPMTestCases(driver);
//    }
//    
//    //Didn't receive the activation code? Resend it.
//    public UPMTestCases VarifyTheRegistration_TC0006(){
//    	String email = "var@ipdeer.com";
//    	String pass = "123";
//    	String recendMsg = "//android.widget.TextView[contains(@text , '"+email+" registered successfully. Verification email sent to the registered email.')]";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/resend_textview"));
//		driver.findElement(By.id(commonIdPath + "/resend_textview")).click();
//		waitForVisibilityOf(By.xpath(recendMsg));
//		driver.findElement(By.id("android:id/button1")).click();
//    	return new UPMTestCases(driver);
//    }
//    
//    //Enter wrong activation code and it says "Your email confirmation request is unsuccessful. Please try again"
//    public UPMTestCases VarifyTheRegistration_TC0007(){
//    	String email = "hjh@ipdeer.com";
//    	String pass = "123";
//    	Random rand = new Random();
//    	int num;
//    	String otp="";
//    	for(int i = 0; i < 6; i++){
//    		num = rand.nextInt(9);
//    		otp = otp + num;
//    	}
//    	String recendMsg = "//android.widget.TextView[contains(@text , '"+email+" registered successfully. Verification email sent to the registered email.')]";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).sendKeys(otp);
//		waitForVisibilityOf(By.xpath(recendMsg));
//    	return new UPMTestCases(driver);
//    }
//    
//    //Select no gender and tap on done.
//    public UPMTestCases VarifyTheProfile_TC0009() throws InterruptedException{
//    	String email = "hjh@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "ddddss";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		waitForVisibilityOf(By.xpath("//android.widget.Button[contains(@resource-id, 'button1')]"));
//		Thread.sleep(5000);
//    	return new UPMTestCases(driver);
//    }
//    
//    //Leave Last name empty and tap on done.
//    public UPMTestCases VarifyTheProfile_TC0010() throws InterruptedException{
//    	String email = "ghgggg@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "hgfdd";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		Thread.sleep(5000);
//    	return new UPMTestCases(driver);
//    }
//    
//    public UPMTestCases VarifyTheProfile_TC0011() throws InterruptedException{
//    	String email = "ghgggg@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "hgfdd";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		Thread.sleep(5000);
//    	return new UPMTestCases(driver);
//    }
//    
//    //Enter Numbers or special Characters in First Name and tap on done.
//    public UPMTestCases VarifyTheProfile_TC0012() throws InterruptedException{
//    	String email = "dsdssd@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "hgfdd";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("@@11dd");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		Thread.sleep(5000);
//    	return new UPMTestCases(driver);
//    }
//    
//    //Enter Numbers or special Characters in Last Name and tap on done.
//    public UPMTestCases VarifyTheProfile_TC0013() throws InterruptedException{
//    	String email = "dsdssd@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "hgfdd";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("@Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		Thread.sleep(5000);
//    	return new UPMTestCases(driver);
//    }
//    
//    //Enter Numbers or special Characters in Last Name and tap on done.
//    public UPMTestCases VarifyTheProfile_TC0014() throws InterruptedException{
//    	String email = "dsdssd@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "$99999";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		Thread.sleep(5000);
//    	return new UPMTestCases(driver);
//    }
//    
//    //Empty Display Name
//    public UPMTestCases VarifyTheProfile_TC0015() throws InterruptedException{
//    	String email = "dsdssd@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "$99999";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		Thread.sleep(5000);
//    	return new UPMTestCases(driver);
//    }
//    
//    //Don't have a referral code?
//    public UPMTestCases VarifyTheProfile_TC0016() throws InterruptedException{
//    	String email = "dsdssd@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "aa9999";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		waitForVisibilityOf(By.xpath("//TextInputLayout[contains(@text , 'Referral code')]"));
//		driver.findElement(By.id(commonIdPath + "/cancel_button")).click();
//		return new UPMTestCases(driver);
//    }
//    
//    //Incorrect referral codes are not accepted.
//    public UPMTestCases VarifyTheProfile_TC0017() throws InterruptedException{
//    	String email = "dfffff@ipdeer.com";
//    	String pass ="123";
//    	String displayName = "aa9999";
//    	try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
//		driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
//		driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
//		driver.findElement(By.id(commonIdPath + "/password")).click();
//		driver.findElement(By.id(commonIdPath + "/password")).sendKeys(pass);
//		driver.findElement(By.id(commonIdPath + "/register_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/verification_code_et"));
//		driver.findElement(By.id(commonIdPath + "/verification_code_et")).click();
//		try{
//        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
//    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
//    	}catch(Exception ac){
//    		
//    	}
//		waitForVisibilityOf(By.id(commonIdPath + "/male_iv"));
//		driver.findElement(By.id(commonIdPath + "/male_iv")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/first_name_et")).sendKeys("Sanjeet");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/last_name_et")).sendKeys("Sahu");
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).click();
//		driver.findElement(By.id(commonIdPath + "/display_name_et")).sendKeys(displayName);
//		driver.navigate().back();
//		driver.findElement(By.id(commonIdPath + "/done_tv")).click();
//		waitForVisibilityOf(By.xpath("//TextInputLayout[contains(@text , 'Referral code')]"));
//		driver.findElement(By.xpath("//TextInputLayout[contains(@text , 'Referral code')]")).sendKeys("454555");
//		driver.findElement(By.id(commonIdPath + "/submit_button")).click();
//		waitForVisibilityOf(By.id(commonIdPath + "/submit_button"));
//		return new UPMTestCases(driver);
//    }
//    
    
    /* @brief Did you forgot your password? Reset password now.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases VarifyForgotPassword_TC0022(){
    	String email = withoutDebuggerEmail;
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
    	driver.findElement(existingUser_login).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/reset_password_tv"));
    	driver.findElement(By.id(commonIdPath + "/reset_password_tv")).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/email"));
    	driver.findElement(By.id(commonIdPath + "/email")).click();
    	driver.findElement(By.id(commonIdPath + "/email")).sendKeys(email);
    	driver.navigate().back();
    	driver.findElement(By.id(commonIdPath + "/send_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@text ,"
    			+ " 'Password reset mail sent to this "+email+"')]"));
    	
    	return new UPMTestCases(driver);
    }
    
    /* @brief Did you forgot your password? Reset password with unregistered email id.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases VarifyForgotPassword_TC0023(){
    	String unregistredEmail = "whoissanjddet@gmail.com";
    	try{
        	waitForVisibilityOf(By.id(androidIDs + "/permission_allow_button"));
    	 	driver.findElement(By.id(androidIDs + "/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
    	driver.findElement(existingUser_login).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/reset_password_tv"));
    	driver.findElement(By.id(commonIdPath + "/reset_password_tv")).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/email"));
    	driver.findElement(By.id(commonIdPath + "/email")).click();
    	driver.findElement(By.id(commonIdPath + "/email")).sendKeys(unregistredEmail);
    	driver.navigate().back();
    	driver.findElement(By.id(commonIdPath + "/send_button")).click();
    	waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@text ,"
    			+ " 'No user "+unregistredEmail+" found. if this error occurs again please contact our support')]"));
    	return new UPMTestCases(driver);
    }
    
    /* @brief Checking the Coins are displaying or not.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases VerifyWallet_TC0031() throws InterruptedException{
    	Login();
    	waitForVisibilityOf(By.id(commonIdPath + "/wallet_tab_name"));
    	driver.findElement(By.id(commonIdPath + "/wallet_tab_name")).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/free_coins"));
    	return new UPMTestCases(driver);
    }
    
    /* @brief TC0032-Verifying view transaction tab
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases ViewTransactions() throws InterruptedException{
    	Login();
    	waitForVisibilityOf(By.id(commonIdPath + "/wallet_tab_name"));
    	driver.findElement(By.id(commonIdPath + "/wallet_tab_name")).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/view_transactions_tv"));
    	driver.findElement(By.id(commonIdPath + "/view_transactions_tv")).click();
    	waitForElement(By.xpath("//android.widget.TextView[contains(@text , 'Transactions')]") , 40);
    	Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
    
    /* @brief Verifying whether it is redirecting to the play store or not.
     * @param None
     * @return Returns a UPMTestCases driver object so that it can be closed
     * 
     * @note
     * */
    public UPMTestCases VerifyRateTheApp_TC0034() throws InterruptedException{
    	Login();
		waitForVisibilityOf(By.id(commonIdPath + "/profile_tab_name"));
		driver.findElement(By.id(commonIdPath + "/profile_tab_name")).click();
		waitForVisibilityOf(By.id(commonIdPath + "/rate_the_app_tv"));
		driver.findElement(By.id(commonIdPath + "/rate_the_app_tv")).click();
		/* Right now the given link redirecting to facebook page.*/
		waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@text , "
				+ "'Facebook')]"));
		Thread.sleep(5000);
    	return new UPMTestCases(driver);
    }
}
