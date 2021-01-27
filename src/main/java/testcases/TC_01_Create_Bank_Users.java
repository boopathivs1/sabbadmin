package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_01_Create_Bank_Users  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC01 Create Bank Users";

	testDescription="Create Bank Users.";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC01";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String Otp,String userid,String firstname,String phonenumber,String emailid,String empid,String auth1,String auth2,String authorizepwd,String department,String data5,String data6,String daat7,String data8,String data9,String data11,String data12,String data13) throws Exception{
	AuthorizePasswd=authorizepwd;
	
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()


.clickBankUserspagemenu()
.clickBankManageUserspagemenu()
.clickCreateUsers()
.fillBankCreateUsersForm(userid, firstname, phonenumber, emailid, empid,department)
.navigateToUsersPage()
//.createUsersFilter("User Id","Pending for Authorization","null","false")
//.verifyUseIdpresent(userid)
.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Bank User Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Bank User Creation Request")

.logout(true,usertype);	

AuthUsername=auth1;




getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	
	.filterRequestFromAdminDateline("Bank User Request","Pending for Authorization")
	.sabbAuthorization()
	.filterRequestFromAdminDateline("Bank User Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")

	.clickBankUserspagemenu()
	.clickBankManageUserspagemenu()
	.createUsersFilter("User Id","Active",userid,"true")
	//.verifyUserCreation("userid");
.verifyUseIdpresent(userid);
	logout(LogoutStatus,usertype);	



	loginfoSuccess(testCaseName,testDescription);
	
	}

catch (Exception e) {
	logfailed(testCaseName,testDescription);
	log.error(e);

	logout(LogoutStatus,usertype);	
throw new Exception();
	
	}

}
}


	
	