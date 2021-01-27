package testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class deassigncorporateuser  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC53a De-Assign Corporates ";

	testDescription="De-Assign Corporates";	
	browserName="Chrome";
	dataSheetName="SaabCIBDev";
	category="Sanity";
	authors="Boopathi";
	testKeyword="De-Assign Corporates";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void SADADPaymentReports(String casename,String Username,String Password,String Otp,String userid,String auth1,String auth2,String groupname,String data1,String data11,String data12,String data13,String data14,String data15,String data16,String data17,String data18,String data19,String data20,String data21,String data22) throws Exception{	
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickUserspagemenu()
.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("User Id","Active",userid,"true")
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[text()='Assign Corporates'])[1]")
.getCorporateid()
		.clickNewAssignCorporate()
		.chooseOptionsAssignCorporate()
	//	.chooseOptionsAssignCorporate()
		.submitAssignCorporate()
		.clicksaabCorporateRequestPage()
		.filterRequestFromAdminDateline("User Corporate Request","Pending for Authorization")

		.verifyAdminbuzz(auth1,auth2, "User Corporate Assign Request")
			.logout(true,usertype);	

	

AuthUsername=auth1;

getSABBUrl();
new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()
.filterRequestFromAdminDateline("User Corporate Request","Pending for Authorization")
.authorization()
.filterRequestFromAdminDateline("User Corporate Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted")
.clickUserspagemenu()
.clickAssignUsers("(.//h4[text()='"+groupname+"']//following::span[text()='Assign Users'])[1]")
	.createUsersFilter("User Id","Active",userid,"true")
	.verifyeditUserIdpresent(userid,"(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::button/span[text()='Assign Corporates'])[1]")
	.verifyCorporateDeAssigned();
	
		
}}