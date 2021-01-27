package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_40_Delete_Group  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC40 Delete Group";

	testDescription="Delete Group";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC40";
	LogoutStatus=true;
	usertype="CIBAdmin";
}

@Test(groups={"sanity"},dataProvider="fetch")
	public void createAccessRights(String casename,String Username,String Password,
			String Otp,String groupid,String updategroupname,String auth1,
			String auth2,String authorizepwd,String data2,String data3,String data4,String data66,
			String data5,String data6,String data19,String data20,String data21,String data22,String data23,String data24) throws Exception{	

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

.filterCorporateGroup(groupid,updategroupname)
.filterCorporateGroupEditbutton(updategroupname)
.deleteCorporateGroup()
//.editCorporateGroup(groupid,updateGroupname, Country,fileLocation)
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Group Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Group Deletion Request")
	.logout(true,usertype);	

	AuthUsername=auth1;
	getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Group Request","Pending for Authorization")
	.sabbAuthorization()
	.filterRequestFromAdminDateline("Group Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")
	.clickSetuppagemenu()
	.MasterMenu()
	.clickCorporatesubMenu()
	.filterCorporateGroup(groupid,updategroupname)
	.verifyGroupNotPresent(updategroupname);
	//.filterCorporateGroupEditbutton(updateGroupname);
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


	
	