import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class TournamentTestCases extends basepage {

	public TournamentTestCases(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private String commonIdPath = "com.pointedsquares.gamy5.android:id";
    By emailId = By.id("email");
    By password = By.id("password");
    By login_Button = By.id("sign_in_button");
    By existingUser_login = By.id(commonIdPath + "/login_with_email_ll");
    By location = By.id("com.android.packageinstaller:id/permission_allow_button");
	
    public TournamentTestCases tournamentTab() throws InterruptedException{
		Login();
        waitForVisibilityOf(By.id(commonIdPath +"/tournament_tab"));
        driver.findElement(By.id(commonIdPath +"/tournament_tab")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id,'header_name')]"));
		return new TournamentTestCases(driver);
	}
    
    public TournamentTestCases TourCheckAllCategory() throws InterruptedException{
		try{
        	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
    	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
		
	 	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath +"/sign_in_button")).click();
        waitForVisibilityOf(By.id(commonIdPath +"/tournament_tab"));
        driver.findElement(By.id(commonIdPath +"/tournament_tab")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'itemTitle') and contains(@text , 'Management')]"));
        Thread.sleep(5000);
        driver.scrollTo("Management");
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'itemTitle') and contains(@text , 'Academics')]"));
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'itemTitle') and contains(@text , 'Management')]"));
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'itemTitle') and contains(@text , 'Technology')]"));
		return new TournamentTestCases(driver);
	}
    
    public TournamentTestCases TourSubjectCheck() throws InterruptedException{
		try{
        	waitForVisibilityOf(By.id("com.android.packageinstaller:id/permission_allow_button"));
    	 	driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
    	}catch(Exception ac){
    		
    	}
	 	waitForVisibilityOf(existingUser_login);
    	driver.findElement(existingUser_login).click();
        waitForVisibilityOf(emailId);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys("whoissanjeet@gmail.com");
        driver.findElement(password).click();
        driver.findElement(password).sendKeys("Abcd@123");
        driver.navigate().back();
        driver.findElement(By.id(commonIdPath +"/sign_in_button")).click();
        waitForVisibilityOf(By.id(commonIdPath +"/tournament_tab"));
        driver.findElement(By.id(commonIdPath +"/tournament_tab")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id , 'itemTitle') and contains(@text , 'Management')]"));
        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'subject_name') and contains(@text , 'Advanced Mathematics')]"));
        int width = ele.getSize().width;
        int height = ele.getSize().height + 30;
		int startx = (int)(width *(0.8));
		int endx = (int)(width *(0.2));
	    driver.swipe(startx, height, endx, height, 6000);
	    Thread.sleep(20000);
		return new TournamentTestCases(driver);
	}
    
    //Successfully Register for a Tournament
    public TournamentTestCases RegisterToTournament() throws InterruptedException{
    	ArrayList<String> tourList = new ArrayList();
    	int x , y1 , y2;
    	float xStart, xEnd, yStart;
    	int endCheck = 0;
    	Login();
    	waitForVisibilityOf(By.id(commonIdPath +"/tournament_tab"));
        driver.findElement(By.id(commonIdPath +"/tournament_tab")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id,'header_name')]"));
        //driver.swipe(411,290,411,900,2000);
        Thread.sleep(2000);
        try{
            waitForElement(By.id(commonIdPath +"/flavor_name") , 20);
        }
        catch(Exception ex){
        	assertTrue(false , "ERROR : No registered tournament found.");
        }
        while(true){
        	if(!tourList.contains(driver.findElement(By.id(commonIdPath +"/flavor_name")).getText())){
        		tourList.add(driver.findElement(By.id(commonIdPath +"/flavor_name")).getText());
        		endCheck = 0;
        		driver.findElement(By.id(commonIdPath +"/flavor_name")).click();
                waitForElement(By.id(commonIdPath +"/type_btn") , 20);
                String isRegister  = driver.findElement(By.id(commonIdPath +"/type_btn")).getText();
                System.out.println("You are already registered with tournament " + tourList.get(tourList.size()-1));
                if(isRegister.equals("REGISTER")){
                	driver.findElement(By.id(commonIdPath +"/type_btn")).click();
                	waitForElement(By.id(commonIdPath +"/type_btn") , 20);
                	assertTrue((driver.findElement(By.id(commonIdPath +"/type_btn")).getText().equals( "UNREGISTER")) , "UNREGISTER BUTTON NOT FOUND");
                	Thread.sleep(5000);
                }
                
        	}
        	else{
        		endCheck++;
        		if(endCheck == 2)
        		break;
        	}
        	driver.navigate().back();
        	waitForElement(By.id(commonIdPath +"/flavor_name") , 20);
        	x = driver.findElement(By.id(commonIdPath +"/flavor_name")).getSize().width;
            xStart = (float) (x * 0.7);
            xEnd = (float) (x * 0.05);
            y1 = driver.findElement(By.id(commonIdPath +"/flavor_name")).getLocation().getY();
            y2 = driver.findElement(By.id(commonIdPath +"/flavor_name")).getSize().height;
            yStart = ((float)(y1) + (float)(y2)) /2;
            System.out.println("X star :" + xStart + " xEnd :" +xEnd+ " yStar : "+yStart);
            driver.swipe((int)(xStart), (int)(yStart), (int)(xEnd), (int)(yStart), 1000);
        }

        Thread.sleep(5000);
    	return new TournamentTestCases(driver);
    }
    
    //Successfully Un-Register for a Tournament
    public TournamentTestCases UnregisterFromTournament() throws InterruptedException{
    	int count = 0;
    	ArrayList<String> tourList = new ArrayList();
    	Login();
    	waitForVisibilityOf(By.id(commonIdPath +"/tournament_tab"));
        driver.findElement(By.id(commonIdPath +"/tournament_tab")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id,'header_name')]"));
        driver.swipe(411,290,411,900,2000);
        try{
            waitForElement(By.id(commonIdPath +"/my_tournaments_count_tv") , 20);
        }
        catch(Exception ex){
        	assertTrue(false , "ERROR : No registered tournament found.");
        }
        count = Integer.parseInt(driver.findElement(By.id(commonIdPath +"/my_tournaments_count_tv")).getText());
        driver.findElement(By.id(commonIdPath +"/tournament_view_all")).click();
        waitForElement(By.id(commonIdPath +"/listViewFlavour") , 5);
        List<WebElement> registeredTournaments = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id , 'listViewFlavour')]/*"));
        registeredTournaments.get(0).findElement(By.xpath("//android.widget.Button[contains(@resource-id , 'type_btn')]")).click();
        waitForElement(By.id(commonIdPath +"/listViewFlavour") , 40);
        driver.navigate().back();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id,'header_name')]"));
        if(count > 1){
        	assertTrue((Integer.parseInt(driver.findElement(By.id(commonIdPath +"/my_tournaments_count_tv")).getText()) == count-1) , "ERROR : Tournament number should not be same.");
        }
        else{
        	try{
        		driver.findElement(By.id(commonIdPath +"/my_tournaments_count_tv"));
        		assertTrue(false , "ERROR : My tournament should not present.");
        	}
        	catch(Exception ex){
        		
        	}
        }
        Thread.sleep(5000);
    	return new TournamentTestCases(driver);
    }
    
    //Register for a Tournament with low Balance
    public TournamentTestCases RegisterWithlowBalance() throws InterruptedException{
    	ArrayList<String> tourList = new ArrayList();
    	LoginWithLowBalanceAccount();
    	waitForVisibilityOf(By.id(commonIdPath +"/tournament_tab"));
        driver.findElement(By.id(commonIdPath +"/tournament_tab")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id,'header_name')]"));
        driver.swipe(411,290,411,900,2000);
        Thread.sleep(5000);
        try{
        	waitForElement(By.xpath("//android.widget.TextView[contains(@resource-id , 'flavor_name')]") , 20);
        }
        catch(Exception ex){
        	assertTrue(false , "ERROR : No tournament found.");
        }
        
        driver.findElement(By.id(commonIdPath +"/flavor_name")).click();
        waitForElement(By.id(commonIdPath +"/type_btn") , 20);
        String isRegister  = driver.findElement(By.id(commonIdPath +"/type_btn")).getText();
        if(isRegister.equals("REGISTER")){
        	driver.findElement(By.id(commonIdPath +"/type_btn")).click();
        	waitForElement(By.id(commonIdPath +"/message_text") , 20);
        	assertTrue((driver.findElement(By.xpath("//android.widget"
        			+ ".TextView[contains(@resource-id , 'message_text')]"))
        			.getText().equals( "Does not have enough Coins in the "
        			+ "Wallet to Register for this Tournament ")) , 
        			"UNREGISTER BUTTON NOT FOUND");
        	Thread.sleep(5000);
        }
        System.out.println(isRegister);
        Thread.sleep(5000);
    	return new TournamentTestCases(driver);
    }
    
    //Display List of Declared Tournaments
    public TournamentTestCases trytomoveslider() throws InterruptedException{
    	ArrayList<String> tourList = new ArrayList();
    	String tourName = "";
    	Login();
    	waitForVisibilityOf(By.id(commonIdPath +"/tournament_tab"));
        driver.findElement(By.id(commonIdPath +"/tournament_tab")).click();
        waitForVisibilityOf(By.xpath("//android.widget.TextView[contains(@resource-id,'header_name')]"));
        try{
            waitForElement(By.id(commonIdPath +"/flavor_name") , 20);
        }
        catch(Exception ex){
        	assertTrue(false , "ERROR : No registered tournament found.");
        }
        while(true){
        	tourName =driver.findElement(By.id(commonIdPath +"/flavor_name")).getText(); 
        	int x = driver.findElement(By.id(commonIdPath +"/flavor_name")).getSize().width;
            float xStart = (float) (x * 0.7);
            float xEnd = (float) (x * 0.05);
            
            int y1 = driver.findElement(By.id(commonIdPath +"/flavor_name")).getLocation().getY();
            int y2 = driver.findElement(By.id(commonIdPath +"/flavor_name")).getSize().height;
            
            float yStart = ((float)(y1) + (float)(y2)) /2;
            System.out.println("X star :" + xStart + " xEnd :" +xEnd+ " yStar : "+yStart);
            driver.swipe((int)(xStart), (int)(yStart), (int)(xEnd), (int)(yStart), 1000);
            if(!tourList.contains(tourName)){
            	tourList.add(tourName);
            	System.out.println(tourName);
            }
            else{
            	break;
            }
        }
        System.out.println(tourList.size());
    	return new TournamentTestCases(driver);
    }
}
