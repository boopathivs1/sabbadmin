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

public class TC_33_Delete_Limit_Geography  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC33 Delete Limit (Geography)";

	testDescription="Delete Limit (Geography)";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC33";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String transactionname,
		String searchkeyword,String limitid,String limittransname,String auth1,String auth2,
		String authorizepwd,String data11,String data1s,
		String data1sss,String data12,String firstname,String autsdsdh,
		String data8s,String data12w,String data14,String date) throws Exception{

	String limitnum=regvalue(limitid);

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
.limitSearch(limitnum, limittransname)
.deletelimit(limitnum)


.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Transaction Limits Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Transaction Limits Deletion Request")

.logout(true,usertype);	

AuthUsername=auth1;



getSABBUrl();
new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()

.filterRequestFromAdminDateline("Transaction Limits Request","Pending for Authorization")
.sabbAuthorization()
.filterRequestFromAdminDateline("Transaction Limits Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted")
.clickParametersMenu()
.clicktransconfig()
.filterTransconfig(transactionname, searchkeyword)
.clicktransname(searchkeyword)
.limitSearch(limitnum, limittransname)
.verifylimitnotPresent(limitnum);



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



