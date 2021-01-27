package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_52_Deassign_Access_Rights extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC52 Deassign Access Rights to corporate User";

	testDescription="Deassign Access Rights to corporate User";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC52";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void deleteDeassignAccessRights(String casename,String Username,String Password,String Otp,String userid,String auth1,String auth2,String groupname,String authorizepwd,String data11,String data12,String data13,String data14,String data15,String data16,String data17,String data18,String data19,String data20,String data21,String data22) throws Exception{	
	AuthorizePasswd=authorizepwd;
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickUserspagemenu()
.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("User Id","Active",userid,"true")
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[text()='Assign Corporates'])[1]")
.clickAssignAccessRights()
.clickEditAssignAccessRights()
.clickDeleteAssignAccessRights()

.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Users Corporate Access Right Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Users Corporate Access Right Deletion Request")
	.logout(true,usertype);	
AuthUsername=auth1;
getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Users Corporate Access Right Request","Pending for Authorization")
//	.authorization()
	.sabb_DatelineAuthorization()
//	.datelineAuthorization()
	.filterRequestFromAdminDateline("Users Corporate Access Right Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")
	.clickUserspagemenu()
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
		.createUsersFilter("User Id","Active",userid,"true")
	
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[text()='Assign Corporates'])[1]")
.clickAssignAccessRights()
.verifyCorporateAccessAssignedStatus("Un-Assigned");
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


	
	