package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class RolesPage  extends ProjectWrapp{
	public  RolesPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	public RolesPage createRoelsFilter(String status,String searchKeyword,String searchenable) throws InterruptedException{
		locateFrame("icanvas");
				Thread.sleep(14000);
				
		dropdownSelection(prop.getProperty("select.usersearch.xpath"),"Role Id");
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

	public RolesPage deleterolesVerify(String xpath,String validmsg,String errormsg){
		
		//	VerifyElementnotPresent(xpath,validmsg,errormsg);
			
			Boolean a=VerifyElementpresentreturn(xpath);

			if(a){
			reportStep("roles  has not deleted Sucessfully","FAIL");	
			}

			else{
				reportStep("roles has deleted Sucessfully","PASS");	
			}
				
			
			
			return this;
		}


	public Userspage verifyUseIdpresent(String roleid) throws InterruptedException{
		////edit		
				
				for(int i=1;i<10;i++){
		boolean a=VerifyElementpresentreturn("(.//strong[contains(text(),'Role ID')]/following::span[text()='"+roleid+"'])");
		reportStep("role id has present in this page", "PASS");
		if(a){
			reportStep("role id  has been diplaying in this page", "PASS");
//			clickByXpathExplict("(.//strong[contains(text(),'User ID')]/following::span[text()='testqa100'])/following::button[text()='Show'][1]");
			
			break;
		}
		else {
			int c=i+1;
			reportStep(""+roleid+" role id  has not been diplaying in this page", "INFO");

			reportStep(""+roleid+" trying find role id in another page number", "INFO");
//			boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
			boolean b=VerifyElementpresentreturn(".//ul[contains(@class,'pagination')]//a[text()='"+c+"']");
			
			
			
			if(b){
			clickByXpathExplict(".//ul[contains(@class,'pagination')]//a[text()='"+c+"']");
			Thread.sleep(2000);
			}
			else {
				reportStep(""+roleid+" role id has not diplaying in this page", "FAIL");
				break;
			}
		}
		}
		return new Userspage(driver, test);
		
	}

	
	public RolesPage verifyeditroleIDpresent(String roleid,String xpath) throws InterruptedException{
		////edit		
				
				for(int i=1;i<40;i++){
					//Thread.sleep(4000);
		boolean a=VerifyElementpresentreturn("(.//strong[contains(text(),'Role ID')]/following::span[text()='"+roleid+"'])");
		reportStep("role id has present in this page", "PASS");
		if(a){
			reportStep("role id  has been displaying in this page", "PASS");
			pageScroll();
			Thread.sleep(4000);
			clickByXpathExplict(xpath);
			
			break;
		}
		else {
			int c=i+1;
			reportStep(""+roleid+" role id  has not been diplaying in this page", "INFO");

			reportStep(""+roleid+" trying find role id in another page number", "INFO");
			boolean b=VerifyElementpresentreturn(".//ul[contains(@class,'pagination')]//a[text()='"+c+"']");
			if(b){			
//				.//ul[contains(@class,'pagination')]//a[text()='2']
			clickByXpathExplict(".//ul[contains(@class,'pagination')]//a[text()='"+c+"']");
			Thread.sleep(4000);
			}
			else {
				reportStep(""+roleid+" role id has not diplaying in this page", "FAIL");
				break;
			}
		}
		}
		return this;
		}
	
	public Userspage clickUsersDeleteLink(){
		clickByXpathExplict(prop.getProperty("editform.deletebutton.xpath"));
		clickByXpathExplict(prop.getProperty("users.yes.button.xpath"));
		
		defaultcontent();
		
		return new Userspage(driver, test);
	}

	
	
	public BankAccessRightsPage clickCreateAccessLink(){
		
		
		clickByXpathExplict(prop.getProperty("click.createusers.link.xpath"));
		
		
		
		return new BankAccessRightsPage(driver, test);
	}
	
public BankAccessRightsPage clickEditAccessLink(){
		
		
	clickByXpathExplict(prop.getProperty("click.bank.edit.link.xpath"));
		
		
		
		return new BankAccessRightsPage(driver, test);
	}
	
	
	
	
	
	
	
	public RolesPage verifyRoles(String description){
		
		verifybyAttributesxpath(prop.getProperty("verify.roles.desc.attribute.xpath"),description,"value");
		
		
		return this;
	}
	
	
	public RolesPage verifymodule(String modulename){
		
		verifyTextByXpathExplicitwait(prop.getProperty("verify.admin.module.display.xpath"),modulename);
		
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
public Userspage createRoles(String roleid,String rolesname,String description) throws InterruptedException{
	locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.createusers.link.xpath"));
enterByXpathExplict(prop.getProperty("enter.template.code.xpath"),roleid);		
dropdownSelection(prop.getProperty("roles.dropdown.xpath"),rolesname);

enterByXpathExplict(prop.getProperty("enter.template.description.xpath"),description);		

clickByXpathExplict(prop.getProperty("admin.creategroup.button.xpath"));
			return new Userspage(driver, test);
	}
	
	

public Userspage editRoles(String rolesname,String description) throws InterruptedException{
	//locateFrame("icanvas");

//		clickByXpathExplict(prop.getProperty("click.createusers.link.xpath"));
//enterByXpathExplict(prop.getProperty("enter.template.code.xpath"),roleid);		
//dropdownSelection(prop.getProperty("roles.dropdown.xpath"),rolesname);

enterByXpathExplict(prop.getProperty("enter.template.description.xpath"),description);		
Thread.sleep(10000);
clickByXpathExplict(prop.getProperty("role.update.button.xpath"));
			return new Userspage(driver, test);
	}
	
	
	
	
	
public RolesPage deleteAccessVerify(String xpath,String validmsg,String errormsg){
	
	//	VerifyElementnotPresent(xpath,validmsg,errormsg);
		
		Boolean a=VerifyElementpresentreturn(xpath);

		if(a){
		reportStep(errormsg,"FAIL");	
		}

		else{
			reportStep(validmsg,"PASS");	
		}
			
		
		
		return this;
	}


	
	
	
	
	
	
	
	

	
	
	
}