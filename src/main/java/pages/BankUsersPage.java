package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.seleniumhq.jetty9.server.Authentication.User;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class BankUsersPage extends ProjectWrapp{
	public  BankUsersPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	

	public BankUsersPage clickBankManageUserspagemenu(){
		
		clickByXpathExplict(prop.getProperty("Click.Manage.Users.xpath"));
		return this;
	}
	

	public RolesPage clickRolesMenu(){
		
		clickByXpathExplict(prop.getProperty("Click.roles.menu.xpath"));
		return new RolesPage(driver, test);
	}
	
	
	
	
	
	public BankUsersPage clickCreateUsers(){
		locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.createusers.link.xpath"));
		return this;
		}
	
	
	public BankUsersPage fillBankCreateUsersForm(String userid,String firstname,String phonenumber,String emailid,String empid,String department) throws InterruptedException{
Thread.sleep(4000);
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.userid.xpath"),userid);
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.firstname.xpath"),firstname);
		
		String mobileno= phonenumber;   
		mobileno = mobileno.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String phnum = mobileno.replaceAll("\\s", "");
		
		
		
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.telephone.xpath"),phnum);
		
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),emailid);		
		Thread.sleep(2000);
		String empnum=regvalue(empid);

		enterByXpathExplict(prop.getProperty("Enter.employid.xpath"),empnum);
		
		dropdownSelection(prop.getProperty("Click.bank.department.xpath"),department);
		
//		dropdownSelection(prop.getProperty("Enter.createUsers.form.country.xpath"),empid);
		Thread.sleep(2000);
//		dropdownSelection(prop.getProperty("Enter.createUsers.form.city.xpath"),City);
		//enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),"testk@mailinator.com");		
	
	//	enterByXpathExplict(prop.getProperty("Enter.createUsers.form.designation.xpath"),"testk");		
		Thread.sleep(2000);
		//dropdownSelection(prop.getProperty("Enter.createUsers.form.corporatechannels.xpath"),corporateChannels);
		clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
		clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
		pageScroll400();
		Thread.sleep(2000);
		pageScroll400();
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("button.create.button.xpath"));
			Thread.sleep(6000);	
			defaultcontent();	
		return this;
	}

	
	public BankUsersPage fillBankAjmanCreateUsersForm(String userid,String firstname,String phonenumber,String emailid,String empid,String department,String Userbranch) throws InterruptedException{
Thread.sleep(4000);
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.userid.xpath"),userid);
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.firstname.xpath"),firstname);
		
		String mobileno= phonenumber;   
		mobileno = mobileno.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String phnum = mobileno.replaceAll("\\s", "");
		
		
		
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.telephone.xpath"),phnum);
		
		enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),emailid);		
		Thread.sleep(2000);
		String empnum=regvalue(empid);

		enterByXpathExplict(prop.getProperty("Enter.employid.xpath"),empnum);
		
		dropdownSelection(prop.getProperty("Click.bank.department.xpath"),department);
		
//		dropdownSelection(prop.getProperty("Enter.createUsers.form.country.xpath"),empid);
		Thread.sleep(2000);
//		dropdownSelection(prop.getProperty("Enter.createUsers.form.city.xpath"),City);
		//enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),"testk@mailinator.com");		
	
	//	enterByXpathExplict(prop.getProperty("Enter.createUsers.form.designation.xpath"),"testk");		
		Thread.sleep(2000);
		//dropdownSelection(prop.getProperty("Enter.createUsers.form.corporatechannels.xpath"),corporateChannels);

		dropdownSelection(prop.getProperty("click.ajman.userbrach.xpath"),Userbranch);
		
		
		clickByXpathExplict(prop.getProperty("click.calendar.icon.xpath"));
		clickByXpathExplict(prop.getProperty("click.today.calendar.xpath"));
		pageScroll400();
		Thread.sleep(2000);
		pageScroll400();
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("button.create.button.xpath"));
			Thread.sleep(6000);	
			defaultcontent();	
		return this;
	}
	
	public Userspage navigateToUsersPage(){
		return new Userspage(driver, test);
	}
	
	public BankUsersPage createUsersFilter(String userid,String status,String searchKeyword,String searchenable) throws InterruptedException{
	locateFrame("icanvas");
			Thread.sleep(14000);
			
	dropdownSelection(prop.getProperty("select.usersearch.xpath"),userid);
	dropdownSelection(prop.getProperty("select.usersearchStatus.xpath"),status);
	if(searchenable.equalsIgnoreCase("true")){
	enterByXpathExplict(prop.getProperty("enter.inputsearchkeyword.xpath"),searchKeyword);
	}
	
	
	//clickByXpathExplict(prop.getProperty("click.button.usersfilter.button.xpath"));

	clickByXpathExplict(prop.getProperty("click.filter.bankusers.search.xpath"));
	
	
	pageScroll400();
	Thread.sleep(4000);
		return this;
		}
	

	
	
	public Userspage verifyUseIdpresent(String userid) throws InterruptedException{
	////edit		
			
			for(int i=1;i<10;i++){
	boolean a=VerifyElementpresentreturn("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"'])");
	reportStep("account number has present in this page", "PASS");
	if(a){
		reportStep("User id  has been diplaying in this page", "PASS");
//		clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='testqa100'])/following::button[text()='Show'][1]");
		
		break;
	}
	else {
		int c=i+1;
		reportStep(""+userid+" User account  has not been diplaying in this page", "INFO");

		reportStep(""+userid+" trying find account number in another page number", "INFO");
//		boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
		boolean b=VerifyElementpresentreturn(".//ul[contains(@class,'pagination')]//a[text()='"+c+"']");
		
		
		
		if(b){
		clickByXpathExplict(".//ul[contains(@class,'pagination')]//a[text()='"+c+"']");
		Thread.sleep(2000);
		}
		else {
			reportStep(""+userid+" Account number has not diplaying in this page", "FAIL");
			break;
		}
	}
	}
	return new Userspage(driver, test);
	}
	
	
	
	
	public BankUsersPage filleditBankUsersForm(String userid,String firstname,String phonenumber,String emailid,String empid,String department) throws InterruptedException{
		Thread.sleep(4000);
			//	enterByXpathExplict(prop.getProperty("Enter.createUsers.form.userid.xpath"),userid);
				enterByXpathExplict(prop.getProperty("Enter.createUsers.form.firstname.xpath"),firstname);
				
				String mobileno= phonenumber;   
				mobileno = mobileno.replaceAll("[^a-zA-Z0-9]", " ");  
				
				String phnum = mobileno.replaceAll("\\s", "");
				
				
				
				enterByXpathExplict(prop.getProperty("Enter.createUsers.form.telephone.xpath"),phnum);
				
//				enterByXpathExplict(prop.getProperty("Enter.createUsers.form.email.xpath"),emailid);		
	//			Thread.sleep(2000);
		//		String empnum=regvalue(empid);

			//	enterByXpathExplict(prop.getProperty("Enter.employid.xpath"),empnum);
				
				dropdownSelection(prop.getProperty("Click.bank.department.xpath"),department);
				
//				dropdownSelection(prop.getProperty("Enter.createUsers.form.country.xpath"),empid);
				Thread.sleep(2000);
				clickByXpathExplict(prop.getProperty("click.edituser.update.button.xpath"));

					Thread.sleep(2000);	
					defaultcontent();	
				return this;
			}

	
	
	
	
	
	
	public BankUsersPage editUsersFormByAttribute(String firstname,String phonenumber,String emailid,String empid) throws InterruptedException{
		AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.firstname.xpath"),"value",firstname);
		
		
		String userph=phonenumber;   
		userph = userph.replaceAll("[^a-zA-Z0-9]", " ");  
		
		String phno = userph .replaceAll("\\s", "");
		
		
		AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.telephone.xpath"),"value",phno);
		
		AttributesVerifyxpath(prop.getProperty("Enter.createUsers.form.email.xpath"),"value",emailid);
		String emploid=regvalue(empid);
		
		AttributesVerifyxpath(prop.getProperty("Enter.employid.xpath"),"value",emploid);
		

		return this;
	}
	public BankUsersPage deleteuserVerify(String xpath,String validmsg,String errormsg){
		
		//	VerifyElementnotPresent(xpath,validmsg,errormsg);
			
			Boolean a=VerifyElementpresentreturn(xpath);

			if(a){
			reportStep("User  has not deleted Sucessfully","FAIL");	
			}

			else{
				reportStep("User has deleted Sucessfully","PASS");	
			}
				
			
			
			return this;
		}

	public BankUsersPage clickUsersAssignRolesLink(String userid){
		clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::span[text()='Assign Roles'])[1]");
		
		return this;
	}
	
	public BankUsersPage verifyAssignRoles(){
verifyTextByXpathExplicitwait(prop.getProperty("verify.assign.user.roles.xpath"),Assignrole);		


		return this;
	}

	
	public BankUsersPage verifyAccess(){
verifyTextByXpathExplicitwait(prop.getProperty("verify.bank.access.assign.xpath"),"Assigned");		


		return this;
	}
	
	public BankUsersPage verifyAccessUnAssign(){
verifyTextByXpathExplicitwait(prop.getProperty("access.unassign.xpath"),"Un-Assigned");		


		return this;
	}	
	
	
	
	
	public BankUsersPage NewAssignRolesLink(){
	
		clickByXpathExplict(prop.getProperty("click.user.New.assignroles.xpath"));
		
		return this;
	}
	
	
	public BankUsersPage clickBankAccessRighstXpath(){
		
		clickByXpathExplict(prop.getProperty("click.Bank.accessrights.xpath"));
		
		return this;
	}
	
public BankUsersPage clickBankeditAccessXpath(){
		
		clickByXpathExplict(prop.getProperty("click.Bank.editAccess.xpath"));
		
		return this;
	}
	

public Userspage clickBankdeleteAccessXpath(){
	
	clickByXpathExplict(prop.getProperty("delete.bankaccessrights.xpath"));
	clickByXpathExplict(prop.getProperty("delete.bankaccess.yes.rights.xpath"));


	
	
	return new Userspage(driver, test);
}

public BankUsersPage selectAllAccessXpath(){
		
		clickByXpathExplict(prop.getProperty("click.selectall.access.xpath"));
		
		return this;
	}

public Userspage updateAccessXpath(){
		
		clickByXpathExplict(prop.getProperty("click.editAccess.update.xpath"));
		
		return new Userspage(driver, test);
	}




	
	public BankUsersPage clickAssignRolesCheckbox(){
	clickJs(prop.getProperty("click.assign.checkbox.role.xpath"));
 Assignrole=getTextByXpath(prop.getProperty("get.roles.assign.xpath"));
			
	
		return this;
	}
	
	public BankUsersPage clicknewAssignRolesCheckbox(){
		clickJs(prop.getProperty("click.assign.checkbox.new.role.xpath"));
	 Assignrole=getTextByXpath(prop.getProperty("get.roles.new.assign.xpath"));
				
		
			return this;
		}
	public BankUsersPage clicknewRolesCheckbox(){
		clickJs(prop.getProperty("click.roles.admin.user.xpath"));
	 Assignrole=getTextByXpath(prop.getProperty("click.roles.admin.gettext.user.xpath"));
				
		
			return this;
		}
	
	
	
	
	
	public Userspage clickAssignsubmit(){
		clickJs(prop.getProperty("click.roles.assign.button.xpath"));
			return new Userspage(driver, test);
		}
	
	
	
	
	
	
	public BankUsersPage clickUsersEditLink(String userid){
		clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::span[text()='Edit'])[1]");
		
		return this;
	}
	
	
	public Userspage clickUsersDeActivateLink(String userid){
		clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::span[text()='De-Activate'])[1]");
		Boolean a=VerifyElementpresentreturn(prop.getProperty("Click.Logout.yesButton.xpath"));
if (a) {
	clickByXpathExplict(prop.getProperty("Click.Logout.yesButton.xpath"));
}
		return new Userspage(driver, test);
	}
	
	public Userspage clickUsersActivateLink(String userid){
		clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"']//following::span[text()='Activate'])[1]");
		
		return new Userspage(driver, test);
	}
	
	
	public BankUsersPage clickUsersDeleteLink(){
		clickByXpathExplict(prop.getProperty("editform.deletebutton.xpath"));
		clickByXpathExplict(prop.getProperty("users.yes.button.xpath"));
		
		defaultcontent();
		
		return this;
	}
	
	
	public Userspage navigatesabbcorp(){
		try {
		readytimes();
			readystate();
			jqueryload();
		} catch (InterruptedException e1) {
		}

		return new Userspage(driver,test);
	}
	
	
	
	
	public BankUsersPage verifyeditUserIdpresent(String userid,String xpath) throws InterruptedException{
	////edit		
			
			for(int i=1;i<40;i++){
				//Thread.sleep(4000);
	boolean a=VerifyElementpresentreturn("(.//strong[contains(text(),'User ID')]/following::span[text()='"+userid+"'])");
	reportStep("account number has present in this page", "PASS");
	if(a){
		reportStep("User id  has been displaying in this page", "PASS");
		pageScroll();
		Thread.sleep(4000);
		clickByXpathExplict(xpath);
		
		break;
	}
	else {
		int c=i+1;
		reportStep(""+userid+" User account  has not been diplaying in this page", "INFO");

		reportStep(""+userid+" trying find account number in another page number", "INFO");
		boolean b=VerifyElementpresentreturn(".//ul[contains(@class,'pagination')]//a[text()='"+c+"']");
		if(b){			
//			.//ul[contains(@class,'pagination')]//a[text()='2']
		clickByXpathExplict(".//ul[contains(@class,'pagination')]//a[text()='"+c+"']");
		Thread.sleep(4000);
		}
		else {
			reportStep(""+userid+" Account number has not diplaying in this page", "FAIL");
			break;
		}
	}
	}
	return this;
	}
}