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

public class TC_28_Create_Limit  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC28 Create Limit";

	testDescription="Create Limit (Group/Corporate)";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC28";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String transactionname,
		String searchkeyword,String groupid,String corpid,String auth1,String auth2,String channel,
		String transCurrency,String perlimitAmount,String LimitCurrency,
		String dailyLimitAmount,String authorizepwd,String LimitID,String autsdsdh,
		String data8s,String data12w,String data14) throws Exception{
	AuthorizePasswd=authorizepwd;
	String grpid=regvalue(groupid);
	String crpid=regvalue(corpid);
	String perlimit=regvalue(perlimitAmount);
	String dailylimit=regvalue(dailyLimitAmount);

	
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickParametersMenu()
.clicktransconfig()
.filterTransconfig(transactionname, searchkeyword)
.clicktransname(searchkeyword)
//.limitCatSelection(grpid, crpid)
.ajmanGrouplimitCatSelection_channel(channel,grpid,crpid,LimitID)


.ajmanGrouplimitForm(transCurrency, perlimit, LimitCurrency, dailylimit)

.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Transaction Limits Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Transaction Limits Creation Request")

.logout(true,usertype);	

AuthUsername=auth1;



getAjmanUrl();

new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()

.filterRequestFromAdminDateline("Transaction Limits Request","Pending for Authorization")
.authorization()
.filterRequestFromAdminDateline("Transaction Limits Request","Accepted")
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



