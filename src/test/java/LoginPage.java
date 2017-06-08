
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends basepage {
	
	private String commonIdPath = "com.pointedsquares.gamy5.android:id";
	private String correctEmail = "whoissanjeet@gmail.com";
	private String incorrectEmail = "whoissanjt@gmail.com";
	private String correctPassword = "Abcd@123";
	private String incorrectPassword = "abcd123";
    By emailId = By.id("email");
    By password = By.id("password");
    By login_Button = By.id("sign_in_button");
    By existingUser_login = By.id(commonIdPath + "/login_with_email_ll");
    By location = By.id("com.android.packageinstaller:id/permission_allow_button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public LoginPage loginWithWrongEmailId() {
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
    	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        
        return new LoginPage(driver);
    }
    
 public LoginPage loginWithCorrenctEmailId() {
	 	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        
        return new LoginPage(driver);
    }
    
    public LoginPage JoinUsWithNewId(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	waitForVisibilityOf(By.id(commonIdPath + "/join_us_tv"));
    	driver.findElement(By.id(commonIdPath + "/join_us_tv")).click();
    	driver.findElement(By.id(commonIdPath + "/email")).sendKeys("abcd@ipdeer.com");
    	driver.findElement(By.id(commonIdPath + "/password")).sendKeys("Abcd@123");
    	driver.findElement(By.id(commonIdPath + "/register_button")).click();
    	return new LoginPage(driver);
    }
    
    public LoginPage LoginAndLogout(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath +"/sign_in_button")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tab"));
        driver.findElement(By.id(commonIdPath + "/profile_tab")).click();
        driver.findElement(By.id(commonIdPath + "/logout_ll")).click();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id(commonIdPath + "/logout_ll")).click();
        driver.findElement(By.id("android:id/button2")).click();
        waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        return new LoginPage(driver);
    }
    
    
    public LoginPage LoginWithInvalidId(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		waitForVisibilityOf(By.id(commonIdPath + "/login_with_email_ll"));
    	driver.findElement(By.id(commonIdPath + "/login_with_email_ll")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("whoissanjet@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        return new LoginPage(driver);
	}
    
    public LoginPage AddFavoriteFromFavoriteList(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		waitForVisibilityOf(By.id(commonIdPath + "/login_with_email_ll"));
    	driver.findElement(By.id(commonIdPath + "/login_with_email_ll")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/subject_image"));
        List subject = driver.findElements(By.id(commonIdPath + "/subject_image"));
        ((WebElement) subject.get(0)).click();
        driver.findElement(By.id(commonIdPath + "/favorite_icon"));
        List fav = driver.findElements(By.id(commonIdPath + "/favorite_icon"));
        ((WebElement) fav.get(0)).click();
        return new LoginPage(driver);
	}
    
    public LoginPage RemoveFavoriteFromFavoriteList(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		waitForVisibilityOf(By.id(commonIdPath + "/login_with_email_ll"));
    	driver.findElement(By.id(commonIdPath + "/login_with_email_ll")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath + "/sign_in_button")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/subject_image"));
        List subject = driver.findElements(By.id(commonIdPath + "/subject_image"));
        ((WebElement) subject.get(0)).click();
        List fav = driver.findElements(By.id(commonIdPath + "/favorite_icon"));
        ((WebElement) fav.get(0)).click();
        return new LoginPage(driver);
	}
    
    public LoginPage LoginWithEmptyPassword(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
        
        return new LoginPage(driver);
    }
    
    public LoginPage ChangePassword(){
    	//waitForVisibilityOf(By.className("android.widget.TextView"));
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	 	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name"));
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name")).click();
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/change_password_tv")).click();
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/old_password_et")).click();
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/old_password_et")).sendKeys("Abcd@123");
         driver.navigate().back();
          waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/new_password_et"));
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/new_password_et")).click();
          driver.findElement(By.id("com.pointedsquares.gamy5.android:id/new_password_et")).sendKeys("gamy5");
          driver.navigate().back();
         driver.findElement(By.id("com.pointedsquares.gamy5.android:id/rest_button")).click();
    	return new LoginPage(driver);
    }
    
    public LoginPage CompleteProfileAferRegistration(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	 	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name"));
        
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name")).click();
        
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tv")).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/profile_pic_iv"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_pic_iv")).click();
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        //((AndroidDriver) driver).startActivity("com.android.gallery.", "Gallery");
       
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/male_iv"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/male_iv")).click();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/first_name_et")).sendKeys("Vasu");
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/last_name_et"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/last_name_et")).click();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/last_name_et")).sendKeys("kumar");
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/display_name_et")).clear();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/display_name_et")).sendKeys("vasu");
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/done_tv")).click();
       
    	return new LoginPage(driver);
    }
    
    public LoginPage InvalidOldPasswordInChangePasswordTab(){
	    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
		 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		 	waitForVisibilityOf(existingUser_login);
	    	driver.findElement(existingUser_login).click();
	        waitForVisibilityOf(emailId);
	        driver.findElement(emailId).click();
	        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
	        driver.findElement(password).click();
	        driver.findElement(password).sendKeys("Abcd@123");
	        driver.navigate().back();
	        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
	    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name"));
    	    driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name")).click();
    	    driver.findElement(By.id("com.pointedsquares.gamy5.android:id/change_password_tv")).click();
    	    driver.findElement(By.id("com.pointedsquares.gamy5.android:id/old_password_et")).sendKeys("Abcd@123");
    	    driver.navigate().back();
    	    waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/new_password_et"));
    	    driver.findElement(By.id("com.pointedsquares.gamy5.android:id/new_password_et")).click();
    	     driver.findElement(By.id("com.pointedsquares.gamy5.android:id/new_password_et")).sendKeys("Abcd@123");
    	     driver.navigate().back();
    	    waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/rest_button"));
    	    driver.findElement(By.id("com.pointedsquares.gamy5.android:id/rest_button")).click();
    		return new LoginPage(driver);
    }
    
    public LoginPage EmptyOldPasswordInChangePasswordTab(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	 	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
		 waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name"));
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name")).click();
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/change_password_tv")).click();
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/old_password_et")).sendKeys("");
		 driver.navigate().back();
		 waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/rest_button"));
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/rest_button")).click();
		 return new LoginPage(driver);	
	}
	    
	public LoginPage EmptyNewPasswordInChangePasswordTab(){
		waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	 	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
	    waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name"));
	        
	        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tab_name")).click();
	        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/change_password_tv")).click();
	        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/old_password_et")).sendKeys("abcdef");
	        driver.navigate().back();
	        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/rest_button"));
	        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/rest_button")).click();
	    	return new LoginPage(driver);
	}
	
	public LoginPage SignUpwithRegisteredEmailID(){
		waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		 waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/join_us_tv"));
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/join_us_tv")).click();
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/email")).sendKeys("swathireedy2594@gmail.com");
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/password")).click();
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/password")).sendKeys("Abcd@123");
		 driver.findElement(By.xpath("android.widget.ImageView[@clickable='true']['2']")).click();
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/register_button")).click();
		 return new LoginPage(driver);
	}
    
	public LoginPage SignUpWithEmptyPassword(){
		waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		 waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/join_us_tv"));
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/join_us_tv")).click();
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/email")).sendKeys("swathireedy2594@gmail.com");
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/password")).click();
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/password")).sendKeys("");
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/register_button")).click();
		 return new LoginPage(driver);
	}
	
    public LoginPage SignUpPagetoSignInPage(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/join_us_tv"));
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/join_us_tv")).click();
		 waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/sign_in_tv"));
		 driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_tv")).click();
		 return new LoginPage(driver);
    }
    
    public LoginPage ViewTransactions(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	 	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/wallet_tab_name")).click();
    	 waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/view_transactions_tv"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/view_transactions_tv")).click();
    
    	 return new LoginPage(driver);
    }
    
    public LoginPage ProfileUpdate(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath +"/sign_in_button")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tab"));
        driver.findElement(By.id(commonIdPath + "/profile_tab")).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/profile_tv"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tv")).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/female_iv"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/female_iv")).click();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/first_name_et")).click();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/first_name_et")).clear();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/first_name_et")).sendKeys("Sanjeet");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/last_name_et")).click();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/last_name_et")).clear();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/last_name_et")).sendKeys("Sahu");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/display_name_et")).click();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/display_name_et")).clear();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/display_name_et")).sendKeys("SkS2222");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/done_tv")).click();
        return new LoginPage(driver);
    }
    
    public LoginPage ProfileUpdateWithEmptyName(){
    	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath +"/sign_in_button")).click();
        waitForVisibilityOf(By.id(commonIdPath + "/profile_tab"));
        driver.findElement(By.id(commonIdPath + "/profile_tab")).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/profile_tv"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tv")).click();
        waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/female_iv"));
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/female_iv")).click();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/first_name_et")).click();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/first_name_et")).clear();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/first_name_et")).sendKeys("");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/done_tv")).click();
        return new LoginPage(driver);
    }
//    public void T0019_UnregisteredEmail(){
//    	invalidLogin();
//    	if(!driver.findElements(By.id("android:id/button1")).isEmpty()) {
//    		System.out.println("Test Passed");
//    	}
//    }
    
    
}
