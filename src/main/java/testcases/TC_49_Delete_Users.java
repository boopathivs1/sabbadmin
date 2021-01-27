package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_49_Delete_Users  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC49";

	testDescription="Delete Users";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC49";
	LogoutStatus=true;
	usertype="CIBAdmin";

	
	
}


@Test(groups={"sanity"},dataProvider="fetch")
public void deleteUser(String casename,String Username,String Password,String Otp,String userid,String auth1,String auth2,String groupname,String authorizepwd,String City,String corporateChannels,String idIssuingCountry,String idtype,String PassportNumber,String Securitychoosen,String TransactionSecurityChoosen,String datas,String dataa,String daatss,String data2,String data3) throws Exception{
	AuthorizePasswd=authorizepwd;
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickUserspagemenu()


.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	
	

	.createUsersFilter("User Id","Active",userid,"true")
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")

	.clickUsersEditLink(userid)
	.clickUsersDeleteLink()
	.clicksaabCorporateRequestPage()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Pending for Authorization")

	.verifyAdminbuzz(auth1,auth2, "Corporate User Profile Deletion Request")

	.logout(true,usertype);	

	
	
	
	AuthUsername=auth1;
	getSABBUrl();

	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Pending for Authorization")
	.sabb_DatelineAuthorization()
	.filterRequestFromAdminDateline("Corporate User Profile Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")
	.clickUserspagemenu()
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
		.createUsersFilter("User Id","Active",userid,"true")
	.deleteuserVerify("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]","Deleted User id has been deleted sucessfully","Deleted User id has not not been deleted successfully");
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


	