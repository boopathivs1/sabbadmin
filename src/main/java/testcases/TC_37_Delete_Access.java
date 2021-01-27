package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_37_Delete_Access  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC37 Delete Access";

	testDescription="Delete Access Rights Master";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC37";
	LogoutStatus=true;
	usertype="CIBAdmin";
}

@Test(groups={"sanity"},dataProvider="fetch")
	public void deleteAccessRights(String casename,String Username,String Password,
			String Otp,String TemplateID,String TemplateName,String ModuleName,String Segment,
			String auth1,String auth2,String authorizepwd,String Daat12,String data14,
			String data2,String data3,String data4,String data5,String data6,String data22,String data23,String data24) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
	getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()





.clickSetuppagemenu()
.clickMasterMenu()
.filterAccessrights(TemplateName)
//.editAccessform()

.deleteAccessform()
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Master Access Right Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Master Access Right Deletion Request")
	.logout(true,usertype);	

	AuthUsername=auth1;
getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Master Access Right Request","Pending for Authorization")
	.sabbAuthorization()
	.filterRequestFromAdminDateline("Master Access Right Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")
	.clickSetuppagemenu()
	.clickMasterMenu()
	.filterAccess(TemplateName)
	.deleteAccessVerify(".//span[text()='"+ModuleName+"']","Access has deleted successfully","Access has not deleted successfully");
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