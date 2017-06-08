
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class AppiumTest extends androidsetup{
	boolean isFirst = true;
	
	@AfterClass
	public void endDriver() throws Exception{
		driver.quit();
	}
	
	@BeforeMethod
	@Parameters({"DeviceId", "Port"})
	public void setUp(String DeviceId, String Port) throws Exception {
		if(isFirst == true){
			prepareAndroidForAppium(DeviceId, Port);
	        isFirst =false;
		}
		else{
			driver.resetApp();
		}
	
    }

    @AfterMethod
	public void tearDown() throws Exception {
        //driver.quit();
    }

//    @Test
//    public void loginWithWrongEmailId() throws InterruptedException {
//         new LoginPage(driver).loginWithWrongEmailId();
//    }
//
//    @Test
//    public void loginWithCorrenctEmailId() throws InterruptedException {
//         new LoginPage(driver).loginWithCorrenctEmailId();
//    }
//    
//    @Test
//    public void JoinUsWithNewId() throws InterruptedException {
//         new LoginPage(driver).JoinUsWithNewId();
//    }
//    
//    @Test
//    public void LoginAndLogout() throws InterruptedException {
//         new LoginPage(driver).LoginAndLogout();
//    }
//    
//    @Test
//    public void LoginWithInvalidId() throws InterruptedException {
//         new LoginPage(driver).LoginWithInvalidId();
//    }
//    
//    @Test
//    public void AddFavoriteFromFavoriteList() throws InterruptedException {
//         new LoginPage(driver).AddFavoriteFromFavoriteList();
//    }
//    
//    @Test
//    public void RemoveFavoriteFromFavoriteList() throws InterruptedException {
//         new LoginPage(driver).RemoveFavoriteFromFavoriteList();
//    }
//    
//    @Test
//    public void LoginWithEmptyPassword() throws InterruptedException {
//         new LoginPage(driver).LoginWithEmptyPassword();
//    }
//    
//    @Test
//    public void ChangePassword() throws InterruptedException {
//         new LoginPage(driver).ChangePassword();
//    }
//    
//    @Test
//    public void CompleteProfileAferRegistration() throws InterruptedException {
//         new LoginPage(driver).CompleteProfileAferRegistration();
//    }
//    
//    @Test
//    public void InvalidOldPasswordInChangePasswordTab() throws InterruptedException {
//         new LoginPage(driver).InvalidOldPasswordInChangePasswordTab();
//    }
//    
//    @Test
//    public void EmptyOldPasswordInChangePasswordTab() throws InterruptedException {
//         new LoginPage(driver).EmptyOldPasswordInChangePasswordTab();
//    }
//    
//    @Test
//    public void EmptyNewPasswordInChangePasswordTab() throws InterruptedException {
//         new LoginPage(driver).EmptyNewPasswordInChangePasswordTab();
//    }
//    
//    @Test
//    public void SignUpwithRegisteredEmailID() throws InterruptedException {
//         new LoginPage(driver).SignUpwithRegisteredEmailID();
//    }
//    
//    @Test
//    public void SignUpWithEmptyPassword() throws InterruptedException {
//         new LoginPage(driver).SignUpWithEmptyPassword();
//    }
//    
//    @Test
//    public void SignUpPagetoSignInPage() throws InterruptedException {
//         new LoginPage(driver).SignUpPagetoSignInPage();
//    }
//    
//    @Test
//    public void ViewTransactions() throws InterruptedException {
//         new LoginPage(driver).ViewTransactions();
//    }
    
	  @Test
	  public void ProfileUpdate() throws InterruptedException {
	       new LoginPage(driver).ProfileUpdate();
	  }
	  
	  @Test
	  public void ProfileUpdateWithEmptyName() throws InterruptedException {
	       new LoginPage(driver).ProfileUpdateWithEmptyName();
	  }
    
}

