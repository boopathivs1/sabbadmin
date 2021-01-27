package Ajman_Testcases;

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

public class TC_24_Update_Winow_Timings  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC24 Update Winow Timings";

	testDescription="Update Winow Timings";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC24";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String transactionname,
		String searchkeyword,String fromtime,String totime,String auth1,String auth2,
		String fromtimeindex,String totimeindex,String authorizepwd,String daatsd7,
		String data8,String data12,String firstname,String autsdsdh,
		String data8s,String data12w,String data14) throws Exception{

	AuthorizePasswd=authorizepwd;
	String fromtiming=regvalue(fromtimeindex);
String totiming=regvalue(totimeindex);	
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickParametersMenu()
.clicktransconfig()
.filterTransconfig(transactionname, searchkeyword)
.fillTransname(searchkeyword, fromtime, totime,fromtiming,totiming)

.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Transaction Window Timing Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Transaction Window Timing Creation Request")

.logout(true,usertype);	

AuthUsername=auth1;



getAjmanUrl();
new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()

.filterRequestFromAdminDateline("Transaction Window Timing Request","Pending for Authorization")
.authorization()
.filterRequestFromAdminDateline("Transaction Window Timing Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted")
.clickParametersMenu()
.clicktransconfig()
.filterTransconfig(transactionname, searchkeyword)
.clicktransname(searchkeyword);



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



