package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_54_Matrix_Deletion  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC54 Matrix Deletion";

	testDescription="Matrix Deletion  No Check";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC54";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
	public void MatrixCreationNoCheck(String casename,String Username,String Password,
			String Otp,String groupName,String corpid,String fromAccno,String moduleName,
			String functiondropdown,String authtype,String auth1,String auth2,String accno,
			String submodulename,String authorizepwd,String data19,String data20,String data21,String data22,String data23,String data24) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickSetuppagemenu()
.clickMatrixmenu()
.clickMatrixAssignCorporatePage(groupName)

	.clickAccessRights(corpid)
.matrixCreationFilter(fromAccno,moduleName)

.matrixResult(accno,submodulename)

	.RemoveNoCheckmatrixCreation(functiondropdown,authtype)
	
	.clicksaabCorporateRequestPage()
	.filterRequestFromAdminDateline("Authorization Matrix Configuration Request","Pending for Authorization")

	.verifyAdminbuzz(auth1,auth2, "Authorization Matrix Configuration Deletion Request")
		.logout(true,usertype);	

			
AuthUsername=auth1;
getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Authorization Matrix Configuration Request","Pending for Authorization")
	.sabbAuthorization()
	.filterRequestFromAdminDateline("Authorization Matrix Configuration Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")

	.clickSetuppagemenu()
	.clickMatrixmenu()
		.clickMatrixAssignCorporatePage(groupName)
	.clickAccessRights(corpid)
	.matrixCreationFilter(fromAccno,moduleName)

.verifyMatrixNotPresent(functiondropdown,authtype);
	logout(LogoutStatus,usertype);	
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


	
	