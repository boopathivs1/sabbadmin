package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_58_Matrix_Creation  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC58 Matrix Creation";

	testDescription="Matrix Creation - Parallel Auth Single slab";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC58";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void MatrixCreationNoCheck(String casename,String Username,String Password,String Otp,String groupName,String corpid,String fromAccno,String moduleName,String Accno,String Submodulename,String functiondropdown,String authtype,String auth1,String authorizepwd,String fromAmount,String ToAmount,String user1,String user2,String user3,String user4,String User5) throws Exception{	
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
	//.matrixCreationFilter(fromAccno,moduleName)

	.SequentialParallelmatrixCreation(fromAccno, moduleName, Accno, Submodulename, functiondropdown, authtype)
	.accessRightsAmount(fromAmount,ToAmount)
	
	/*
	.addslab("1", "0","AND","1","1","1","0")
	.addRound()
	.addslab("2", "2","OR","2","3","2","1")
	.addRound()
	.addslab("3", "4","ONLY","3","5","3","2")
.saveMatrix()
*/

	
	
	
	
.addslabUserSearch("1","AND","1","1",user1,user2)
//.addslab("1", "0","AND","1","1","1","0")
.addRound()
.addslabUserSearch("2","OR","2","2",user3,user4)
//.addslab("2", "2","OR","2","3","2","1")
.addRound()
//.addslab("3", "4","ONLY","3","5","3","2")
//.addslabUserSearch("2","OR","2","2",user3,user4)
.addslabUserSearch("3","ONLY","3","3",User5,user1)
.saveMatrix()


.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Authorization Matrix Configuration Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth1, "Authorization Matrix Configuration Creation Request")
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


	
	