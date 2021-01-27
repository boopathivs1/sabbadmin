package Ajman_Testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_42_Edit_Corporate  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC42 Edit Corporate";

	testDescription="Edit Corporate";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC42";
	LogoutStatus=true;
	usertype="CIBAdmin";
}

@Test(groups={"sanity"},dataProvider="fetch")
public void createAccessRights(String casename,String Username,String Password,
		String Otp,
String groupid,String groupName,String corpidname,String corpname,String segment,
String industry,
String country,String channels,String  loginsecuirty,String transactionSecurity,String auth1,String auth2,
String authorizepwd,String data20,String data21,String data22,String data23) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
		getAjmanUrl();
new SaabCorporateAdminHomePage(driver, test)

.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickSetuppagemenu()


//.verifyCoridPresent(corpidname);


.MasterMenu()
.clickCorporatesubMenu()

.filterCorporateGroup(groupid,groupName)
.viewCorporateGroup(groupName)
.filterCorporateid(corpidname, corpname)
.verifyCorporateidPresent(corpidname, corpname)
.editCorporateName(corpname)
.editCorpFormSubmission(segment, industry, country, channels, loginsecuirty, transactionSecurity)
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Corporate Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Corporate Updation Request")
.logout(true,usertype);	

AuthUsername=auth1;
getAjmanUrl();
new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()
.filterRequestFromAdminDateline("Corporate Request","Pending for Authorization")
.authorization()
.filterRequestFromAdminDateline("Corporate Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted")




.clickSetuppagemenu()
.MasterMenu()
.clickCorporatesubMenu()

.filterCorporateGroup(groupid,groupName)

.viewCorporateGroup(groupName)
.filterCorporateid(corpidname, corpidname)
.verifyCorporateidPresent(corpidname, corpname)
.editCorporateName(corpname);
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