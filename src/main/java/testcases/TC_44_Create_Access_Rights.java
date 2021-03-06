package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_44_Create_Access_Rights  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC44 Create Access Rights";

	testDescription="Create Access Rights";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC44";
	LogoutStatus=true;
	usertype="CIBAdmin";
}

@Test(groups={"sanity"},dataProvider="fetch")
	public void createAccessRights(String casename,String Username,String Password,
			String Otp,String groupid,String groupName,String corpname,String templateName,String templateid,
			String description,String Dropdownmodulename,String auth1,String auth2,String gridtemplateName_module,
			String authorizepwd,String data18,String data19,String data20,String data21,String data22,String data23) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()

.clickSetuppagemenu()
.MasterMenu()
.clickCorporatesubMenu()
.filterCorporateGroup(groupid, groupName)
//.filterCorporateGroup(groupName)
.viewCorporateGroup(groupName)
.filterCorporate(corpname)
.clickViewAccessRights(corpname)
.createCorporateAccess(templateName,templateid,description,Dropdownmodulename)
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Corporate Access Right Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Corporate Access Right Creation Request")
	.logout(true,usertype);	

	
	








	AuthUsername=auth1;
	getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Corporate Access Right Request","Pending for Authorization")
	.sabbAuthorization()
	.filterRequestFromAdminDateline("Corporate Access Right Request","Accepted")
	//.verifyDatelineRequestADMINLogin("Accepted")
	.clickSetuppagemenu()
	.MasterMenu()
	.clickCorporatesubMenu()

	
	.filterCorporateGroup(groupid, groupName)
	//.filterCorporateGroup(groupName)
	.viewCorporateGroup(groupName)
	.filterCorporate(corpname)
	.clickViewAccessRights(corpname)
	.defaultSwicth()
	.filterAccessrights(gridtemplateName_module)
	.verifyModuleAssigned();




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