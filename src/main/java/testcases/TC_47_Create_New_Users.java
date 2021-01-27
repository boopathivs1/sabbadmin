package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_47_Create_New_Users  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC47 Create New Users";

	testDescription="Create New Users";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC47";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String Otp,String userid,String firstname,String phonenumber,String emailid,String Country,String City,String corporateChannels,String idIssuingCountry,String idtype,String PassportNumber,String Securitychoosen,String TransactionSecurityChoosen,String auth1,String auth2,String groupname,String authorizepwd,String data3) throws Exception{
	AuthorizePasswd=authorizepwd;
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickUserspagemenu()
.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")

	.clickCreateUsers()
	.fillCreateUsersForm(userid,firstname,phonenumber,emailid,Country,City,corporateChannels,idIssuingCountry,idtype,PassportNumber,Securitychoosen,TransactionSecurityChoosen)

//	.createUsersFilter("User Id","Pending for Authorization","null","false")
	//.verifyUseIdpresent(userid)

	.clicksaabCorporateRequestPage()
	//.clickDatelinemenu()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Pending for Authorization")

	.verifyAdminbuzz(auth1,auth2, "Corporate User Profile Creation Request")

	.logout(true,usertype);	

	AuthUsername=auth1;
	
	getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	
	.filterRequestFromAdminDateline("Corporate User Profile Request","Pending for Authorization")
//	.authorization()
	.sabb_DatelineAuthorization()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")

	.clickUserspagemenu()
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
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
	
	// TODO: handle exception
}

}
}


	
	