package Ajman_Testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_48_Edit_Users  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC48 Edit Users";

	testDescription="Edit Users";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC48";
	LogoutStatus=true;
	usertype="CIBAdmin";

}


@Test(groups={"sanity"},dataProvider="fetch")
public void editUser(String casename,String Username,String Password,String Otp,String userid,String firstname,String phonenumber,String emailid,String Country,String City,String corporateChannels,String idIssuingCountry,String idtype,String PassportNumber,String Securitychoosen,String TransactionSecurityChoosen,String auth1,String auth2,String groupname,String authorizepwd,String data3) throws Exception{
	AuthorizePasswd=authorizepwd;
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickUserspagemenu()
.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[contains(text(),'Assign Users')])[1]")

	//.createUsersFilter("User Id","Active",userid,"true")
	.ajmanCreateUsersFilter("User Id","Active",userid,"true")
//.verifyUseIdpresent(userid);
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")

	.clickUsersEditLink(userid)
	.fillAjmaneditUsersForm(firstname, Country, City, corporateChannels, idIssuingCountry, idtype, PassportNumber,Securitychoosen, TransactionSecurityChoosen)
	//.ajmanCreateUsersFilter("User Id","Active",userid,"true")
	//.verifyUseIdpresent(userid)
	
	.clicksaabCorporateRequestPage()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Pending for Authorization")

	.verifyAdminbuzz(auth1,auth2, "Corporate User Profile Updation Request")

	.logout(true,usertype);	

	
	
AuthUsername=auth1;
getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Pending for Authorization")
	//.authorization()
	.datelineAuthorization()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")
	.clickUserspagemenu()
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[contains(text(),'Assign Users')])[1]")
		//.createUsersFilter("User Id","Active",userid,"true")
		.ajmanCreateUsersFilter("User Id","Active",userid,"true")
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")

	.clickUsersEditLink(userid)
	.editUsersFormByAttribute(firstname, phonenumber, emailid, PassportNumber);		
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


	
	