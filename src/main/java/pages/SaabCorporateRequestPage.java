package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SaabCorporateRequestPage extends ProjectWrapp{
	public  SaabCorporateRequestPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	
	public CorporateAdminUsersPage clickUsersmenu(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.users.menu.xpath"));
		clickByXpathExplict(prop.getProperty("click.usersSubmenu.xpath"));
		return new CorporateAdminUsersPage(driver,test);
	}
	public SystemParameters clickParametersMenu(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.systemparameters.xpath"));
		return new SystemParameters(driver, test);
	}
	
	public WorkflowPage clickWorkflowMenu(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.workflow.xpath"));
		return new WorkflowPage(driver, test);
	}
	
	
	
	public SaabCorporateRequestPage reportfieds() throws InterruptedException{
	
	clickByXpathExplict(prop.getProperty("click.admin.reports.menu.xpath"));
	clickByXpathExplict(prop.getProperty("click.admin.subreports.menu.xpath"));
return this;
	}
	
	public SaabCorporateRequestPage reportform(String reportname,String fromdate,String todate) throws InterruptedException{
		
		
		locateFrame("icanvas");
		
		
		dropdownSelection(prop.getProperty("enter.reports.name.admin.xpath"),reportname);
		

		enterByXpathExplict(prop.getProperty("enter.admin.fromdate.reports.menu.xpath"),fromdate);
		enterByXpathExplict(prop.getProperty("enter.admin.todate.reports.menu.xpath"),todate);

		
		
		clickByXpathExplict(prop.getProperty("click.adminreports.filter.xpath"));
		

		verifyElementpresentByXpathExplicitw(prop.getProperty("verify.admin.reports.table.xpath"));
		defaultcontent();
	return this;
		}
	
	
	public BankUsersPage clickBankUserspagemenu(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("Click.BankUsers.page.Menu.xpath"));
		return new BankUsersPage(driver,test);
	}
	
	public Userspage clickUserspagemenu(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.users.menu.xpath"));
		clickByXpathExplict(prop.getProperty("click.usersSubmenu.xpath"));
		return new Userspage(driver,test);
	}
	
	
	
	
	
//	click.admin.setup.module.xpath
	
			public setupPage clickSetuppagemenu(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.admin.setup.module.xpath"));
		return new setupPage(driver,test);
	}
	
			public AdminAccessRightsPage clickSetup(){
				defaultcontent();
				clickByXpathExplict(prop.getProperty("click.admin.setup.module.xpath"));
				return new AdminAccessRightsPage(driver,test);
			}
			
			
			
	public SaabCorporateRequestPage filterRequestFromAdminDateline(String selectType,String status) throws InterruptedException{
		

		locateFrame("icanvas");
		try {
readytimes();
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

		dropdownSelection(prop.getProperty("paymentdd.selecttype.xpath"),selectType);
		
dropdownSelection(prop.getProperty("payment.status.xpath"),status);
clickByXpathExplict(prop.getProperty("click.filter.admindeateline.xpath"));
Thread.sleep(1000);
try {
	
readytimes();
	readystate();
	jqueryload();
} catch (InterruptedException e1) {
}

		return this;
	}
	
	
	public SaabCorporateRequestPage verifyDatelineRequestADMINLogin(String ReferenceNumStatus) throws InterruptedException{
	
	verifyTextlistcontainXpath(prop.getProperty("Filter.DepositReferno.xpath"),getrefnumer);
	if(ReferenceNumStatus.equalsIgnoreCase("Accepted")){
	verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
//	verifyTextcontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),ReferenceNumStatus);
	
		int a=getSizeByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"));
	
		verifyTextsizecontainslistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),a);
	}
	
	
		
		return this;
	}
	
	
	
	
	public SaabCorporateRequestPage authorization() throws InterruptedException{
//		authorizeRequest();
		CorporateAdminAuthorizeRequest();
//	authorizefromDatelineRequest();
			defaultcontent();
			Thread.sleep(3000);

			return this;
		}

	public SaabCorporateRequestPage sabbAuthorization() throws InterruptedException{
		SabbAdminAuthorizeRequest();
		defaultcontent();
			Thread.sleep(3000);

			return this;
		}
	
	
	
	
	
	public SaabCorporateRequestPage datelineAuthorization() throws InterruptedException{
//		authorizeRequest();
//		CorporateAdminAuthorizeRequest();
	authorizefromDatelineRequest();
			defaultcontent();
			Thread.sleep(3000);

			return this;
		}
	
	
	public SaabCorporateRequestPage sabb_DatelineAuthorization() throws InterruptedException{
	
	saab_AuthorizefromDatelineRequest();
	defaultcontent();
	return this;
}

	public SaabCorporateRequestPage verifyAdminbuzz(String auth1,String auth2,String datelinekeyword) throws InterruptedException{
		Thread.sleep(3000);
		
		String userid1= auth1;   
		userid1 = userid1.replaceAll("[^a-zA-Z0-9]", " ");  	
		String usernamevalue1 = userid1 .replaceAll("\\s", "");
	
		String userid2= auth2;   
		userid2 = userid2.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String usernamevalue2 = userid2 .replaceAll("\\s", "");
	
		AdminDatelinePageBuzz(usernamevalue1,usernamevalue2,datelinekeyword);
		return this;
	}
	
	
	

	
}
