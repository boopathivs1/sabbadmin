package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_51_Assign_Modify_Rights  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC51 Assign/Modify";

	testDescription="Assign/Modify Access Rights";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC51";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void assignModifAccessRights(String casename,String Username,String Password,String Otp,
		String userid,String auth1,String auth2,String groupname,
		String authorizepwd,String data11,String data12,String data13,String data14,String data15,
		String data16,String data17,String data18,String data19,String data20,String data21,String data22) throws Exception{	
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
.fillAccessRights()
.clicksaabCorporateRequestPage()
.filterRequestFromAdminDateline("Users Corporate Access Right Request","Pending for Authorization")


//.clickDatelinemenu()
	.verifyAdminbuzz(auth1,auth2, "Users Corporate Access Right Updation Request")
	//.logout(true);
	.logout(true,usertype);	

AuthUsername=auth1;
getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(AuthUsername)
	.enterPassword(Password)
	.clickLoginButtonFinal()
	.filterRequestFromAdminDateline("Users Corporate Access Right Request","Pending for Authorization")
	//.authorization()
	.sabb_DatelineAuthorization()
	.filterRequestFromAdminDateline("Users Corporate Access Right Request","Accepted")
	.verifyDatelineRequestADMINLogin("Accepted")
	.clickUserspagemenu()
	.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
		.createUsersFilter("User Id","Active",userid,"true")
	
	
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[text()='Assign Corporates'])[1]")
.clickAssignAccessRights()
.verifyCorporateAccessAssignedStatus("Assigned");
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


	
	