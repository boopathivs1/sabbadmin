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

public class TC_23_Delete_Reject_Reason  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC23 Delete Reject Reason";

	testDescription="Delete Reject Reason";	
	browserName="Chrome";
	dataSheetName="AjmanCIBAdmin";
	category="Sanity";
	authors="Sreejith";
	testKeyword="TC23";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String Rejectcode,
		String Rejectdesc,String auth1,String auth2,String authorizepwd,String params,String ngcf,String gnfcn,String daat7,String datas3,String daatsd7,
		String data8,String data12,String firstname,
		String data8s,String data12w,String data15) throws Exception{
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
.DeleteRejectreason()
.clicksaabCorporateRequestPage()
//.clickDatelinemenu()
.filterRequestFromAdminDateline("Dateline Reject Reason Request","Pending for Authorization")

.verifyAdminbuzz(auth1,auth2, "Dateline Reject Reason Deletion Request")

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

.deleteRejectReason("//h4[.='"+Rejectcode+"']","Reject Reason has deleted successfully","Reject Reason has not deleted successfully");
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



