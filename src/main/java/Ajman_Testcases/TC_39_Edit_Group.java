package Ajman_Testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_39_Edit_Group  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC39 Edit Group";

	testDescription="Edit Group";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Sreejith";
	testKeyword="TC39";
	LogoutStatus=true;
	usertype="CIBAdmin";
}

@Test(groups={"sanity"},dataProvider="fetch")
	public void createAccessRights(String casename,String Username,String Password,
			String Otp,String groupid,String groupname,String Country,String auth1,
			String auth2,String updateGroupname,String authorizepwd,String data3,String data4,
			String data5,String data6,String data19,String data20,String data21,String data22,String data23,String data24) throws Exception{	
	AuthorizePasswd=authorizepwd;
	String fileLocation=caseImgpath;

	try{	
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickSetuppagemenu()
.MasterMenu()
.clickCorporatesubMenu()

.filterCorporateGroup(groupid,groupname)
.filterCorporateGroupEditbutton(groupname)
.AjmaneditCorporateGroup(groupid,updateGroupname, Country,fileLocation)
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Group Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Group Updation Request")
	.logout(true,usertype);	

	AuthUsername=auth1;
	getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Group Request","Pending for Authorization")
	.authorization()
	.filterRequestFromAdminDateline("Group Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")
	.clickSetuppagemenu()
	.MasterMenu()
	.clickCorporatesubMenu()
	.filterCorporateGroup(groupid,updateGroupname)
	.filterCorporateGroupEditbutton(updateGroupname);
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


	
	