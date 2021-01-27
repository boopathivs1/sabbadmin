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

public class TC_17_Update_Password_Policy  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC17 Update Password Policy";

	testDescription="Update Password Policy";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC17";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String pwdminilength,String pwdmaxlength,
		String forcepwd,String lockdays,String auth1,String auth2,
		String authorizepwd,String data2,String data3,String daat7,String data8,String data12,String data13,String firstname,String phonenumber,String emailid,String empid) throws Exception{
	AuthorizePasswd=authorizepwd;
	
	String minidays=regvalue(pwdminilength);
	String maxdays=regvalue(pwdmaxlength);
	String forcepasswd=regvalue(forcepwd);
	String locknum=regvalue(lockdays);
	
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickParametersMenu()
.updatePassword(minidays, maxdays, forcepasswd, locknum)
.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("PassWord Policy Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "PassWord Policy Updation Request")

.logout(true,usertype);	

AuthUsername=auth1;



getAjmanUrl();
new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()

.filterRequestFromAdminDateline("PassWord Policy Request","Pending for Authorization")
.authorization()
.filterRequestFromAdminDateline("PassWord Policy Request","Accepted")
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



