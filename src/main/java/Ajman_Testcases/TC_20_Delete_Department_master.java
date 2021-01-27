package Ajman_Testcases;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Minimal;
import pages.BankUsersPage;
import pages.SaabCorporateAdminHomePage;
import pages.SaabHomePage;
import wrappers.ProjectWrapp;

public class TC_20_Delete_Department_master  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC20 Delete Department master";

	testDescription="Delete Department master";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC20";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String departcode,
		String departdesc,String auth1,String auth2,String authorizepwd,String params,String ngcf,String gnfcn,String daat7,String datas3,String daatsd7,
		String data8,String data12,String firstname,
		String data8s,String data12w,String data14) throws Exception{
	
	AuthorizePasswd=authorizepwd;
	
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickParametersMenu()
.clickdepartmentmaster()


.filterdepartmentMaster(departcode,"Active", "true",departcode)
.filterdepartmentMasterid(departdesc)
.deleteDepartment()



.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Bank Department Master Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Bank Department Master Deletion Request")

.logout(true,usertype);	

AuthUsername=auth1;



getAjmanUrl();
new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()

.filterRequestFromAdminDateline("Bank Department Master Request","Pending for Authorization")
.authorization()
.filterRequestFromAdminDateline("Bank Department Master Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted")

.clickParametersMenu()
.clickdepartmentmaster()
.filterdepartmentMaster(departcode,"Active", "true",departcode)
//.filterdepartmentMasterid(departdesc);
.verifyDeleteMasterid(departdesc);
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



