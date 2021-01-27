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

public class TC_22_Edit_Error_Message  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC22 Edit Error Message";

	testDescription="Edit Error Message";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC22";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String errorcode,
		String ibmessage,String ibarabic,String coremessage,String corearabic,String auth1,String auth2,String authorizepwd,String daat7,String datas3,String daatsd7,
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
.clickerrorManage()

.filtererror("IB Code", "Active","true",errorcode)
.verifyerrorPresent(errorcode)
.clickediterror(errorcode)
.editerrorMessage(ibmessage, ibarabic, coremessage, corearabic)
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Error Message Management Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Error Message Management Updation Request")

.logout(true,usertype);	

AuthUsername=auth1;



getSABBUrl();

new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()

.filterRequestFromAdminDateline("Error Message Management Request","Pending for Authorization")
.sabbAuthorization()
.filterRequestFromAdminDateline("Error Message Management Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted")

.clickParametersMenu()
.clickerrorManage()

.filtererror("IB Code", "Active","true",errorcode)
.verifyerrorPresent(errorcode);



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



