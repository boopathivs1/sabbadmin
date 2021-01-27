package Ajman_Testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_56_Matrix_Creation  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC56 Matrix Creation";

	testDescription="Matrix Creation - Sequential Auth Multiple slab";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC56";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void MatrixCreationNoCheck(String casename,String Username,String Password,String Otp,String groupName,String corpid,String fromAccno,String moduleName,String Accno,String Submodulename,String functiondropdown,String authtype,String auth1,String authorizepwd,String fromAmount,String ToAmount,String user1,String user2,String user3,String user4,String user5) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickSetuppagemenu()
.clickMatrixmenu()
.clickMatrixAssignCorporatePage(groupName)
.clickAccessRights(corpid)
	//.matrixCreationFilter(fromAccno,moduleName)

	//.matrixCreationFilter(fromAccno,moduleName)

	.SequentialParallelmatrixCreation(fromAccno, moduleName, Accno, Submodulename, functiondropdown, authtype)
	.clickAddSlab()
	//.accessRightsAmount("2000","3000")
	.accessRightsAmountAddslab(fromAmount,ToAmount)

	
	.addMultislabUserSearch("4","1","AND","4","1","4",user1,user2)
	.multiSlabAddRound()
	.addMultislabUserSearch("5","1","OR","5","1","5",user3,user4)

	.multiSlabAddRound()
	.addMultislabUserSearch("6","1","ONLY","6","1","6",user5,user1)

	
	
	
.saveMatrix()
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Authorization Matrix Configuration Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth1, "Authorization Matrix Configuration Creation Request")
	.logout(true,usertype);	
	AuthUsername=auth1;
	getAjmanUrl();

	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Authorization Matrix Configuration Request","Pending for Authorization")
	.authorization()
	.filterRequestFromAdminDateline("Authorization Matrix Configuration Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")

	.clickSetuppagemenu()
	.clickMatrixmenu()
		.clickMatrixAssignCorporatePage(groupName)
	.clickAccessRights(corpid)

	
	.matrixCreationFilter(fromAccno,moduleName)
	.matrixResult(Accno, Submodulename)

.verifyMatrixPresent(functiondropdown,authtype)
.clickConfigurelink(functiondropdown,authtype)
.clickViewMatrix();
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


	
	