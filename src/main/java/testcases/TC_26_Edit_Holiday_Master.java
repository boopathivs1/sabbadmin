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

public class TC_26_Edit_Holiday_Master  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC26 Edit Holiday Master";

	testDescription="Edit Holiday Master";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC26";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String transactionname,
		String searchkeyword,String description,String auth1,String auth2,
		String date,String authorizepwd,String datas3,String daatsd7,
		String data8,String data12,String firstname,String autsdsdh,
		String data8s,String data12w,String data14,String datde) throws Exception{
	

	AuthorizePasswd=authorizepwd;
	
	try{
	getSABBUrl();
		new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickParametersMenu()
.clicktransconfig()
.filterTransconfig(transactionname, searchkeyword)
.clicktransname(searchkeyword)
.clickwindownext()
.clickeditholidayicon()
.submiteditFormHoliday(description,date,false)

.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Holiday Master Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Holiday Master Updation Request")

.logout(true,usertype);	

AuthUsername=auth1;


getSABBUrl();

new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()

.filterRequestFromAdminDateline("Holiday Master Request","Pending for Authorization")
.sabbAuthorization()
.filterRequestFromAdminDateline("Holiday Master Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted");


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



