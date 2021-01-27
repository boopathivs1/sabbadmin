package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CorporateAccessRights extends ProjectWrapp{
	public CorporateAccessRights (RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	
	public CorporateAccessRights filterAccessrights(String templateName) throws InterruptedException{

		locateFrame("icanvas");
		
		dropdownSelection(prop.getProperty("access.searchby.xpath"),"Template Name");
		
				dropdownSelection(prop.getProperty("access.searchstatus.xpath"),"Active");
				
				enterByXpathExplict(prop.getProperty("enter.accesssearch.template.xpath"),templateName);
				clickByXpathExplict(prop.getProperty("access.clickfilter.button.xpath"));
				
//				VerifyElementPresent("(.//h4[text()='"+templateName+"']//following::button[@id='btnedit'])","template has created","template has not created");
	//	clickByXpathExplict("(.//h4[text()='"+templateName+"']//following::button[@id='btnedit'])");
				
				
		
		return this;
	}

	
	public CorporateAccessRights verifyDeleteAccessrights(String templateName) throws InterruptedException{
		VerifyElementnotAvailable(".//h4[text()='"+templateName+"']","Module Access has deleted successfully","Module Access has not deleted successfully");


//VerifyElementnotPresent(".//span[text()='"+templateName+"']","Access has deleted successfully","Access has not deleted successfully");
	return this;
}
	public CorporateAccessRights defaultSwicth() throws InterruptedException{
		
defaultcontent();
	return this;
}
	
	
	
	
	public CorporateAccessRights clickeditAccess(String templateName) throws InterruptedException{
clickByXpathExplict(".//h4[text()='"+templateName+"']//following::button[1]");
		
	

	return this;
}
	
	public CorporateAccessRights verifyModuleAssigned() throws InterruptedException{
	
Boolean a=VerifyElementpresentreturn(prop.getProperty("verify.active.mod.assign.xpath"));
if(a){
	reportStep("Module has Assigned","PASS");
}
	else {
		reportStep("Module has not Assigned","FAIL");
		
	}
	
	
			

			return this;
	}
	
	
	
	public Userspage deleteAccessform() throws InterruptedException{
		

		clickByXpathExplict(prop.getProperty("click.delete.assign.rights.xpath"));
		clickByXpathExplict(prop.getProperty("click.delete.yesButton.xpath"));

		return new Userspage(driver, test);
	}	

	


	public Userspage submitUpdateAccess() throws InterruptedException{
		
	clickByXpathExplict(".//input[@name='templateDetails[0].businessFunctionDetails[0].privileges']");



	clickByXpathExplict(".//button[@id='btnUpdate']");
	
	
	
	
	return new Userspage(driver, test);
}

	
	
	public Userspage submiteditAccess() throws InterruptedException{
	clickByXpathExplict(".//input[@name='templateDetails[0].businessFunctionDetails[0].privileges']");
	clickByXpathExplict(".//button[@id='btnUpdate']");
	
	
	
	
	return new Userspage(driver, test);
}
		
	
	
	
	public CorporateAccessRights verifyAssigned() throws InterruptedException{
	
	VerifyElementnotPresent("(.//span[text()='Assigned'])[1]","Module has Assigned","Module has not Assigned");
	
	
			return this;
			}
			
			
	
	public CorporateAccessRights filterCorporateAccess(String ModuleTemplateName) throws InterruptedException{

		//	locateFrame("icanvas");
			
			dropdownSelection(prop.getProperty("access.searchby.xpath"),"Corporate Name");
			
					dropdownSelection(prop.getProperty("access.searchstatus.xpath"),"Active");
					
					enterByXpathExplict(prop.getProperty("enter.accesssearch.template.xpath"),ModuleTemplateName);
					clickByXpathExplict(prop.getProperty("access.clickfilter.button.xpath"));
					
//					VerifyElementPresent("(.//h4[text()='"+ModuleTemplateName+"']//following::button[@id='btnedit'])[1]","Module  has created","Corporatae has not created");
					
					
			
			return this;
		}
		
	
	public Userspage editCorporateAccess(String ModuleTemplateName) throws InterruptedException{

		//	locateFrame("icanvas");
			
					clickByXpathExplict("(.//h4[text()='"+ModuleTemplateName+"']//following::button[@id='btnedit'])[1]");
	clickByXpathExplict(".//input[@name='templateDetails[10].businessFunctionDetails[0].privileges']");					
	clickByXpathExplict(prop.getProperty("Corporate.edit.submit.seg.xpath"));
	
	
	return new Userspage(driver, test);
		}
	
	
	
	
	
	public CorporateAccessRights filterCorporateAccessRights(String templatename) throws InterruptedException{

		
		dropdownSelection(prop.getProperty("access.searchby.xpath"),"Template Name");
		
				dropdownSelection(prop.getProperty("access.searchstatus.xpath"),"Active");
				
				enterByXpathExplict(prop.getProperty("enter.accesssearch.template.xpath"),templatename);
				clickByXpathExplict(prop.getProperty("access.clickfilter.button.xpath"));
				
				VerifyElementPresent("(.//h4[text()='"+templatename+"']//following::button[@id='btnedit'])[1]","Access Rights  has created","Access Rights has not created");
				
				
		
		return this;
	}
	
	
	public CorporateAccessRights ClickeditCorporateAccessRights(String templatename) throws InterruptedException{
	
	clickByXpathExplict("(.//h4[text()='"+templatename+"']//following::button[@id='btnedit'])[1]");
	

	return this;		
	}
	public Userspage createCorporateAccess(String templatename,String templateid,String description, String modulename) throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.createnewgroup.button.xpath"));
		enterByXpathExplict(prop.getProperty("enter.admin.groupcode.xpath"), templatename);
		enterByXpathExplict(prop.getProperty("enter.groupdesc.xpath"),templateid);
		
		enterByXpathExplict(prop.getProperty("enter.prvileges.xpath"),description);
		
		
		
		
		dropdownSelection(prop.getProperty("dropdown.moduleaccess.xpath"),modulename);
		
		clickJs(prop.getProperty("click.selectall.assignaccess.xpath"));
		
		clickByXpathExplict(prop.getProperty("admin.creategroup.button.xpath"));
		
		

		
		return new Userspage(driver, test);
	}
	
	

	

	
	
	
	

	
	
	
}