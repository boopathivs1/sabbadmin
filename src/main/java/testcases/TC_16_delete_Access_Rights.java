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

public class TC_16_delete_Access_Rights  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC16 delete Access Rights";

	testDescription="delete Access Rights";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC16";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String Otp,String roleid,String modulename,String auth1,String auth2,String authorizepwd,String data2,String data3,String daat7,String data8,String data9,String data11,String data12,String data13,String firstname,String phonenumber,String emailid,String empid) throws Exception{
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
.verifyeditroleIDpresent(roleid, "(.//strong[contains(text(),'Role ID')]/following::span[text()='"+roleid+"']//following::button)[2]")
.clickEditAccessLink()
.deleteAccessform()



.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Bank Role Access Rights Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Bank Role Access Rights Deletion Request")

.logout(true,usertype);	

AuthUsername=auth1;
getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	
	.filterRequestFromAdminDateline("Bank Role Access Rights Request","Pending for Authorization")
	.sabbAuthorization()
	.filterRequestFromAdminDateline("Bank Role Access Rights Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")


	.clickBankUserspagemenu()
	.clickRolesMenu()
	.createRoelsFilter("Active",roleid,"true")
	
	.verifyeditroleIDpresent(roleid, "(.//strong[contains(text(),'Role ID')]/following::span[text()='"+roleid+"']//following::button)[2]")
.deleteAccessVerify(".//span[text()='"+modulename+"']","Access has deleted successfully","Access has not deleted successfully");
	
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


	
	