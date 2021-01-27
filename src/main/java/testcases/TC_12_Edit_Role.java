package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.BankUsersPage;
import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_12_Edit_Role  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC12 Edit Role";

	testDescription="Edit Role";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC12";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String Otp,String roleid,String rolesname,String description,String auth1,String auth2,String authorizepwd,String data6,String daat7,String data8,String data9,String data11,String data12,String data13,String firstname,String phonenumber,String emailid,String empid) throws Exception{
	AuthorizePasswd=authorizepwd;
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickBankUserspagemenu()
.clickRolesMenu()
//.clickRolesMenu()
.createRoelsFilter("Active",roleid,"true")
.verifyeditroleIDpresent(roleid, "(.//strong[contains(text(),'Role ID')]/following::span[text()='"+roleid+"']//following::button)[1]")
.editRoles(rolesname, description)


//.createRoles(roleid,rolesname,description)
.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Bank Role Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Bank Role Updation Request")

.logout(true,usertype);	

AuthUsername=auth1;
getSABBUrl();
//	getnewurl("http://192.168.12.13/sabb-qa-admin/login");
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	
	.filterRequestFromAdminDateline("Bank Role Request","Pending for Authorization")
	.sabbAuthorization()
	.filterRequestFromAdminDateline("Bank Role Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")


	.clickBankUserspagemenu()
	.clickRolesMenu()
	.createRoelsFilter("Active",roleid,"true")
//	.verifyeditroleIDpresent(roleid, "(.//strong[contains(text(),'Role ID')]/following::span[text()='"+roleid+"']//following::button/span[2])[1]")
	.verifyeditroleIDpresent(roleid, "(.//strong[contains(text(),'Role ID')]/following::span[text()='"+roleid+"']//following::button)[1]")
.verifyRoles(description);
	logout(LogoutStatus,usertype);	

	

	//(.//strong[contains(text(),'User ID')]/following::span[text()='sridhar06']//following::span[text()='De-Activate'])[1]
//	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[2])[1]");
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


	
	