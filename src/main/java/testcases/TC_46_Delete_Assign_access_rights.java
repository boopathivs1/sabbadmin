package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_46_Delete_Assign_access_rights  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC46 Delete/Assign access rights";

	testDescription="Delete/Assign access rights";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC46";
	LogoutStatus=true;
	usertype="CIBAdmin";
}

@Test(groups={"sanity"},dataProvider="fetch")
	public void createAccessRights(String casename,String Username,String Password,
			String Otp,String groupid,String groupName,String corpname,String auth1,
			String auth2,String gridtemplateName_module,String authorizepwd,String data3,String data4,
			String data5,String data18,String data19,String data20,String data21,String data22,String data23,String data24) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
	getSABBUrl();
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
.clickeditAccess(gridtemplateName_module)
.deleteAccessform()







.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Corporate Access Right Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Corporate Access Right Deletion Request")
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
	.verifyDatelineRequestADMINLogin("Accepted")

	
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
	.verifyDeleteAccessrights(gridtemplateName_module)
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


	
	