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

public class TC_22_Edit_Reject_Reason  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC22 Edit Reject Reason";

	testDescription="Edit Reject Reason";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Sreejith";
	testKeyword="TC22";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String Rejectcode,
		String Rejectdesc,String description ,String auth1,String auth2,String authorizepwd,String params,String ngcf,String gnfcn,String daat7,String datas3,String daatsd7,
		String data8,String data12,String firstname,
		String data8s,String data12w) throws Exception{
	AuthorizePasswd=authorizepwd;
	
	
	try{
		getAjmanUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.clickWorkflowMenu()
.clickRejectReasonMenu()

.filterRejectReason("Active","true",Rejectcode)
.verifyCreatedRejectReason(Rejectcode)
.editRejectreason(description)
.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Dateline Reject Reason Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Dateline Reject Reason Updation Request")

.logout(true,usertype);	

AuthUsername=auth1;



getAjmanUrl();
new SaabCorporateAdminHomePage(driver, test)
.enterUsernameID(AuthUsername)
.enterPassword(Password)
.clickLoginButtonFinal()


.filterRequestFromAdminDateline("Dateline Reject Reason Request","Pending for Authorization")
.authorization()
.filterRequestFromAdminDateline("Dateline Reject Reason Request","Accepted")
.verifyDatelineRequestADMINLogin("Accepted")

.clickWorkflowMenu()
.clickRejectReasonMenu()
.filterRejectReason("Active","true",Rejectcode)
//.filterdepartmentMasterid(departdesc);
.verifyCreatedRejectReason(Rejectcode);
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



