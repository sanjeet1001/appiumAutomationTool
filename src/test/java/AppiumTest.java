
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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

    @Test
    public void loginWithInvalidEmailId() throws InterruptedException {
         new UPMTestCases(driver).loginWithInvalidEmailId();
    }
    

    @Test
    public void loginWithCorrenctEmailId() throws InterruptedException {
         new UPMTestCases(driver).loginWithCorrenctEmailId();
    }
    
    @Test
    public void JoinUsWithNewId() throws InterruptedException {
         new UPMTestCases(driver).JoinUsWithNewId();
    }
    
    @Test
    public void LoginAndLogout() throws InterruptedException {
         new UPMTestCases(driver).LoginAndLogout();
    }
    
    @Test
    public void SignUpWithInvalidEmail() throws InterruptedException {
         new UPMTestCases(driver).SignUpWithInvalidEmail();
    }
    
    @Test
    public void loginWithWrongPassword() throws InterruptedException {
         new UPMTestCases(driver).loginWithWrongPassword();
    }
    
    @Test
    public void LoginWithInvalidId() throws InterruptedException {
         new UPMTestCases(driver).LoginWithInvalidId();
    }
    
    @Test
    public void LoginWithEmptyPassword() throws InterruptedException {
         new UPMTestCases(driver).LoginWithEmptyPassword();
    }
    
    @Test
    public void ChangePassword() throws InterruptedException {
         new UPMTestCases(driver).ChangePassword();
    }
    
    @Test
    public void CompleteProfileAferRegistration() throws InterruptedException {
         new UPMTestCases(driver).CompleteProfileAferRegistration();
    }
    
    @Test
    public void InvalidOldPasswordInChangePasswordTab() throws InterruptedException {
         new UPMTestCases(driver).InvalidOldPasswordInChangePasswordTab();
    }
    
    @Test
    public void EmptyOldPasswordInChangePasswordTab() throws InterruptedException {
         new UPMTestCases(driver).EmptyOldPasswordInChangePasswordTab();
    }
    
    @Test
    public void EmptyNewPasswordInChangePasswordTab() throws InterruptedException {
         new UPMTestCases(driver).EmptyNewPasswordInChangePasswordTab();
    }
    
    @Test
    public void SignUpwithRegisteredEmailID() throws InterruptedException {
         new UPMTestCases(driver).SignUpwithRegisteredEmailID();
    }
    
    @Test
    public void SignUpWithEmptyPassword() throws InterruptedException {
         new UPMTestCases(driver).SignUpWithEmptyPassword();
    }
    
    @Test
    public void SignUpPagetoSignInPage() throws InterruptedException {
         new UPMTestCases(driver).SignUpPagetoSignInPage();
    }
    
    @Test
    public void ViewTransactions() throws InterruptedException {
         new UPMTestCases(driver).ViewTransactions();
    }
    
	  @Test
	  public void ProfileUpdate() throws InterruptedException {
	       new UPMTestCases(driver).ProfileUpdate();
	  }
	  
	  @Test
	  public void ProfileUpdateWithEmptyName() throws InterruptedException {
	       new UPMTestCases(driver).ProfileUpdateWithEmptyName();
	  }
    
	  @Test
	  public void InviteFriendFromFacebook() throws InterruptedException {
	       new UPMTestCases(driver).InviteFriendFromFacebook();
	  }
	  
	  @Test
	  public void InviteFriendFromGmail() throws InterruptedException {
	       new UPMTestCases(driver).InviteFriendFromGmail();
	  }
	  
	  @Test
	  public void InviteFriendFromMessaging() throws InterruptedException {
	       new UPMTestCases(driver).InviteFriendFromMessaging();
	  }
	  
	  @Test
	  public void VerifyRateTheApp_TC0034() throws InterruptedException {
	       new UPMTestCases(driver).VerifyRateTheApp_TC0034();
	  }	  
	  
	  @Test
	  public void tournamentTab() throws InterruptedException {
	       new TournamentTestCases(driver).tournamentTab();
	  }
	  
	  @Test
	  public void TourCheckAllCategory() throws InterruptedException {
	       new TournamentTestCases(driver).TourCheckAllCategory();
	  }
    
    @Test
	  public void TourSubjectCheck() throws InterruptedException {
    	  new TournamentTestCases(driver).TourSubjectCheck();
	  }
      
      @Test
	  public void RegisterToTournament() throws InterruptedException {
    	  new TournamentTestCases(driver).RegisterToTournament();
	  }
	  
	  @Test
	  public void UnregisterFromTournament() throws InterruptedException {
    	  new TournamentTestCases(driver).UnregisterFromTournament();
	  }
	  
	  @Test
	  public void RegisterWithlowBalance() throws InterruptedException {
    	  new TournamentTestCases(driver).RegisterWithlowBalance();
	  }
	  
	  @Test
	  public void trytomoveslider() throws InterruptedException {
    	  new TournamentTestCases(driver).trytomoveslider();
	  }
	  
	  @Test
	  public void SNGCheckAllCategory_TC1001() throws InterruptedException {
    	  new SNGTestCases(driver).SNGCheckAllCategory_TC1001();
	  }
    
//	  @Test
//	  public void CompleteSignUpProcess() throws InterruptedException {
//	  	  new UPMTestCases(driver).CompleteSignUpProcess();
//	  }
//	  
//	  @Test
//	  public void VarifySignUp_TC0002() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifySignUp_TC0002();
//	  }
//	  
//	  @Test
//	  public void VarifySignUp_TC0003() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifySignUp_TC0003();
//	  }
//	  
//	  @Test
//	  public void VarifyTheRegistration_TC0006() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheRegistration_TC0006();
//	  }
//	  
//	  @Test
//	  public void VarifyTheRegistration_TC0007() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheRegistration_TC0007();
//	  }
//	  
//	  @Test
//	  public void VarifyTheProfile_TC0009() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0009();
//	  }
//	  
//	  @Test
//	  public void VarifyTheProfile_TC0010() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0010();
//	  }
//	  
//	  @Test
//	  public void VarifyTheProfile_TC0011() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0011();
//	  }
//	  
//	  @Test
//	  public void VarifyTheProfile_TC0012() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0012();
//	  }
//	  
//	  @Test
//	  public void VarifyTheProfile_TC0013() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0013();
//	  }	  
//	  
//	  @Test
//	  public void VarifyTheProfile_TC0014() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0014();
//	  }	  
//	  
//	  @Test
//	  public void VarifyTheProfile_TC0015() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0015();
//	  }
//	  
//	  @Test
//	  public void VarifyTheProfile_TC0016() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0016();
//	  }
//    
//	  @Test
//	  public void VarifyTheProfile_TC0017() throws InterruptedException {
//	  	  new UPMTestCases(driver).VarifyTheProfile_TC0017();
//	  }
	  
	  @Test
	  public void VarifyForgotPassword_TC0022() throws InterruptedException {
	  	  new UPMTestCases(driver).VarifyForgotPassword_TC0022();
	  }
	  
	  @Test
	  public void VarifyForgotPassword_TC0023() throws InterruptedException {
	  	  new UPMTestCases(driver).VarifyForgotPassword_TC0023();
	  }
	  
	  @Test
	  public void VerifyWallet_TC0031() throws InterruptedException {
	  	  new UPMTestCases(driver).VerifyWallet_TC0031();
	  }
	  
	  
	  @Test
	  public void PlayerJoin_TC1007() throws InterruptedException {
	  	  new SNGTestCases(driver).PlayerJoin_TC1007();
	  }
	  
	  @Test
	  public void PlayerJoin_TC1008() throws InterruptedException {
		  new SNGTestCases(driver).PlayerJoin_TC1008();
	  }
	  
	  @Test
	  public void Questions_TC1016() throws InterruptedException {
		  new SNGTestCases(driver).Questions_TC1016();
	  }
	  
	  @Test
	  public void Options_TC1017() throws InterruptedException {
		  new SNGTestCases(driver).Options_TC1017();
	  }
	  
	  @Test
	  public void CoinsCollection_TC1014() throws InterruptedException {
		  new SNGTestCases(driver).CoinsCollection_TC1014();
	  }
	  
	  @Test
	  public void Exit_TC1027() throws InterruptedException {
		  new SNGTestCases(driver).Exit_TC1027();
	  }
	  
	  @Test
	  public void Exit_TC1028() throws InterruptedException {
		  new SNGTestCases(driver).Exit_TC1028();
	  }
	  
	  @Test
	  public void Exit_TC1029() throws InterruptedException {
		  new SNGTestCases(driver).Exit_TC1029();
	  }
	  
	  @Test
	  public void ExitFromTheTable_TC1031() throws InterruptedException {
		  new SNGTestCases(driver).ExitFromTheTable_TC1031();
	  }
    
	  @Test
	  public void Favorite_TC1003() throws InterruptedException {
		  new SNGTestCases(driver).Favorite_TC1003();
	  }
	  
	  @Test
	  public void Favorite_TC1004() throws InterruptedException {
		  new SNGTestCases(driver).Favorite_TC1003();
	  }
    
	  @Test
	  public void Favorite_TC1002() throws InterruptedException {
		  new SNGTestCases(driver).Favorite_TC1002();
	  }
	  
	  @Test
	  public void RuleOfTheGame_TC1005() throws InterruptedException {
		  new SNGTestCases(driver).RuleOfTheGame_TC1005();
	  }	  
	  
	  @Test
	  public void CloseBtnOfRule_TC1006() throws InterruptedException {
		  new SNGTestCases(driver).CloseBtnOfRule_TC1006();
	  }	 
    
	  @Test
	  public void JoinInMiddleOfTheGame_TC1009() throws InterruptedException {
		  new SNGTestCases(driver).JoinInMiddleOfTheGame_TC1009();
	  }
	  
	  @Test
	  public void ExitFromTheTable_TC1032() throws InterruptedException {
		  new SNGTestCases(driver).ExitFromTheTable_TC1032();
	  }
}

