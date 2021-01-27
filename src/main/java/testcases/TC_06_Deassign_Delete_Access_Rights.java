package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_06_Deassign_Delete_Access_Rights  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC06 Deassign or Delete Access Rights";

	testDescription="Deassign or Delete Access Rights";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC06";
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
.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[2]")
//.clickUsersAssignRolesLink(userid)
.clickBankAccessRighstXpath()

.clickBankeditAccessXpath()
.clickBankdeleteAccessXpath()

//.selectAllAccessXpath()
//.updateAccessXpath()
.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Bank User Access Rights Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Bank User Access Rights Deletion Request")

.logout(true,usertype);	

AuthUsername=auth1;
getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	
	.filterRequestFromAdminDateline("Bank User Access Rights Request","Pending for Authorization")
	.sabbAuthorization()
	.filterRequestFromAdminDateline("Bank User Access Rights Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")

	.clickBankUserspagemenu()
	.clickBankManageUserspagemenu()
	.createUsersFilter("User Id","Active",userid,"true")

	
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[2]")
	//.NewAssignRolesLink()
	
	//.clickUsersAssignRolesLink(userid)
	.clickBankAccessRighstXpath()

	.verifyAccessUnAssign();
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


	
	