package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Minimal;
import pages.BankUsersPage;
import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_18_Create_Department_master  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC18 Create Department master";

	testDescription="Create Department master";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC18";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String departcode,
		String departaddress,
		String departdesc,String country,
		String city,String postalcode,String searchkeyword,String auth1,String auth2,String authorizepwd,String daat7,
		String data8,String data12,String firstname,
		String data8s,String data12w,String data14) throws Exception{
	
	AuthorizePasswd=authorizepwd;
	
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickParametersMenu()
.clickdepartmentmaster()


.createDepartment(departcode, departaddress, departdesc, country, city, postalcode, searchkeyword)



.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Bank Department Master Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Bank Department Master Creation Request")

.logout(true,usertype);	

AuthUsername=auth1;


getSABBUrl();

new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()

.filterRequestFromAdminDateline("Bank Department Master Request","Pending for Authorization")
.sabbAuthorization()
.filterRequestFromAdminDateline("Bank Department Master Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted")

.clickParametersMenu()
.clickdepartmentmaster()
.filterdepartmentMaster(departcode,"Active", "true",departcode)
.filterdepartmentMasterid(departdesc);

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



