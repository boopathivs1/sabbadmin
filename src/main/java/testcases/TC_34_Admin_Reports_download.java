package testcases;

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

public class TC_34_Admin_Reports_download  extends ProjectWrapp
{
@BeforeClass(groups={"common"})
public void setDatag() {
	testCaseName="TC34 Admin Reports and its download";

	testDescription="Admin Reports and its download";	
	browserName="Chrome";
	dataSheetName="SaabCIBAdmin";
	category="Sanity";
	authors="Boopathi";
	testKeyword="TC34";
	LogoutStatus=true;
	usertype="CIBAdmin";

}

@Test(groups={"sanity"},dataProvider="fetch")
public void createUser(String casename,String Username,String Password,String otp,String reportname,String reportname2,String reportname3,String fromdate,
		String todate,String authorizepwd,String data2s,String data3s,
		String data1,String data2,String data3,String daat7,String data8,String data12,String data13,String firstname,String phonenumber) throws Exception{
	
	AuthorizePasswd=authorizepwd;
	
	try{
		getSABBUrl();
	new SaabCorporateAdminHomePage(driver, test)
	.enterUsernameID(Username)
.enterPassword(Password)
.clickLoginButtonFinal()
.reportfieds()
.reportform(reportname, "01/01/2020","20/10/2020")
.reportform(reportname2,"01/01/2020","20/10/2020")
.reportform(reportname3,"01/01/2020","20/10/2020");
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



