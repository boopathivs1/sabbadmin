package Ajman_Testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_45_Edit_Assign_access_rights  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC45";

	testDescription="Edit/Assign access rights";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC45";
	LogoutStatus=true;
	usertype="CIBAdmin";
}

@Test(groups={"sanity"},dataProvider="fetch")
	public void createAccessRights(String casename,String Username,String Password,
			String Otp,String groupid,String groupName,String corpname,String templateName,String auth1,
			String auth2,String gridtemplateName_module,String authorizepwd,String data3,String data4,
			String data5,String data18,String data19,String data20,String data21,String data22,String data23) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()


.clickSetuppagemenu()
//.MasterMenu()
.clickCorporatesubMenu()


.filterCorporateGroup(groupid, groupName)
//.filterCorporateGroup(groupName)
.viewCorporateGroup(groupName)
.filterCorporate(corpname)
.clickViewAccessRights(corpname)
.defaultSwicth()
.filterAccessrights(gridtemplateName_module)
//.filterAccessrights(templateName)
.clickeditAccess(templateName)
.submitUpdateAccess()







.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Corporate Access Right Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Corporate Access Right Updation Request")
	.logout(true,usertype);	

	








	AuthUsername=auth1;
getAjmanUrl();

	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Corporate Access Right Request","Pending for Authorization")
	.authorization()
	.filterRequestFromAdminDateline("Corporate Access Right Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")

	
	.clickSetuppagemenu()
	//.MasterMenu()
	.clickCorporatesubMenu()


	.filterCorporateGroup(groupid, groupName)
	.viewCorporateGroup(groupName)
	.filterCorporate(corpname)
	.clickViewAccessRights(corpname)
	.defaultSwicth()
	.filterAccessrights(gridtemplateName_module)
	.clickeditAccess(gridtemplateName_module)
	.logout(true,usertype);	

	
	
	
	loginfoSuccess(testCaseName,testDescription);
	
	}

catch (Exception e) {
	logfailed(testCaseName,testDescription);
	log.error(e);


	logout(LogoutStatus,usertype);	
throw new Exception();
	
	// TODO: handle exception
}

}
}	