package Ajman_Testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_50_Assign_Corporates  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC50_Assign_Corporates";

	testDescription="Assign Corporates";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC50";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void assignUsers(String casename,String Username,String Password,String Otp,String userid,String auth1,String auth2,String groupname,String authorizepwd,String data11,String data12,String data13,String data14,String data15,String data16,String data17,String data18,String data19,String data20,String data21,String data22) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickUserspagemenu()

.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[contains(text(),'Assign Users')])[1]")
//.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
//	.createUsersFilter("User Id","Active",userid,"true")
	.ajmanCreateUsersFilter("User Id","Active",userid,"true")

	
	
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button//span[contains(text(),'Assign Corporates')])[1]")
.clickNewAssignCorporate()
.corporateSelectionoptions()

.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("User Corporate Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "User Corporate Assign Request")
.logout(true,usertype);		

	
AuthUsername=auth1;
getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("User Corporate Request","Pending for Authorization")
	//.authorization()
	.datelineAuthorization()
	.filterRequestFromAdminDateline("User Corporate Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")
	.clickUserspagemenu()
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[contains(text(),'Assign Users')])[1]")
//	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
//		.createUsersFilter("User Id","Active",userid,"true")
	
		.ajmanCreateUsersFilter("User Id","Active",userid,"true")

		.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button//span[contains(text(),'Assign Corporates')])[1]")
	.verifyCorporateAssigned();
	
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


	
	