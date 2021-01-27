package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_09_DeActivate_User  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC09 DeActivate User";

	testDescription="DeActivate User";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC09";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String Otp,String userid,String auth1,String auth2,String authorizepwd,String data4,String data5,String data6,String daat7,String data8,String data9,String data11,String data12,String data13,String firstname,String phonenumber,String emailid,String empid) throws Exception{
	AuthorizePasswd=authorizepwd;
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickBankUserspagemenu()
.clickBankManageUserspagemenu()
.createUsersFilter("User Id","Active",userid,"true")
//.verifyUserCreation("userid");
.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]")
//.clickUsersAssignRolesLink(userid)
.clickUsersDeActivateLink(userid)



.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Bank User Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Bank User De-Activation Request")

.logout(true,usertype);	

AuthUsername=auth1;
getSABBUrl();
//	getnewurl("http://192.168.12.13/sabb-qa-admin/login");
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
	.createUsersFilter("User Id","De-Active",userid,"true")

	//(.//strong[contains(text(),'User ID')]/following::span[text()='sridhar06']//following::span[text()='De-Activate'])[1]
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]");

	logout(LogoutStatus,usertype);	
	//.NewAssignRolesLink()
	
	//.clickUsersAssignRolesLink(userid)
//	.clickBankAccessRighstXpath()

//	.verifyAccessUnAssign();
	

	
	


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


	
	