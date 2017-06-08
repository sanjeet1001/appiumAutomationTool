

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UPMTestCases extends basepage {
	
	public UPMTestCases(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void DestroyDriver() throws Exception {
		driver.quit();
	}
	
	@Test
	public void TC0018_LoginWithValidIdAndPass() throws InterruptedException{
		waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/login_with_email_ll"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/login_with_email_ll")).click();
    	waitForVisibilityOf(By.id("email"));
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
	}
	
	@Test
	public void LogoutFromDashBoard() throws InterruptedException{
		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/profile_tab")).click();
		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/logout_ll")).click();
		
	}
	
	@Test
	public void TC0020_LoginWithInvalidId() throws InterruptedException{
		waitForVisibilityOf(By.id("com.pointedsquares.gamy5.android:id/login_with_email_ll"));
    	driver.findElement(By.id("com.pointedsquares.gamy5.android:id/login_with_email_ll")).click();
    	waitForVisibilityOf(By.id("email"));
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("whoissanjet@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id("com.pointedsquares.gamy5.android:id/sign_in_button")).click();
	}
	
	@Test
	public void ChangePassword() throws InterruptedException{
		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/change_password_tv")).click();
		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/old_password_et")).click();
		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/old_password_et")).sendKeys("Abcd@123");
		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/new_password_et")).click();
		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/new_password_et")).sendKeys("Abcd@1234");
		driver.findElement(By.id("com.pointedsquares.gamy5.android:id/main_ll")).click();
	}
	

}
