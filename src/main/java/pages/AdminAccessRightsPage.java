package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class AdminAccessRightsPage extends ProjectWrapp{
	public  AdminAccessRightsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}



	public Userspage editAccessform() throws InterruptedException{
		

		clickByXpathExplict(prop.getProperty("click.uncheck.bank.access.xpath"));
		clickByXpathExplict(prop.getProperty("click.uncheck.bank.access.update.xpath"));

		return new Userspage(driver, test);
	}	
		
		
	public Userspage deleteAccessform() throws InterruptedException{
		

		clickByXpathExplict(prop.getProperty("click.delete.assign.rights.xpath"));
		clickByXpathExplict(prop.getProperty("click.delete.yesButton.xpath"));

		return new Userspage(driver, test);
	}	

	
	public AdminAccessRightsPage filterAccessrights(String templateName) throws InterruptedException{

		locateFrame("icanvas");
		
		dropdownSelection(prop.getProperty("access.searchby.xpath"),"Template Name");
		
				dropdownSelection(prop.getProperty("access.searchstatus.xpath"),"Active");
				
				enterByXpathExplict(prop.getProperty("enter.accesssearch.template.xpath"),templateName);
				clickByXpathExplict(prop.getProperty("access.clickfilter.button.xpath"));
				
				VerifyElementPresent("(.//h4[text()='"+templateName+"']//following::button[@id='btnedit'])","template has created","template has not created");
		clickByXpathExplict("(.//h4[text()='"+templateName+"']//following::button[@id='btnedit'])");
				
				
		
		return this;
	}

public AdminAccessRightsPage deleteAccessVerify(String xpath,String validmsg,String errormsg){
	
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

	public AdminAccessRightsPage filterAccess(String templateName) throws InterruptedException{

		locateFrame("icanvas");
		
		dropdownSelection(prop.getProperty("access.searchby.xpath"),"Template Name");
		
				dropdownSelection(prop.getProperty("access.searchstatus.xpath"),"Active");
				
				enterByXpathExplict(prop.getProperty("enter.accesssearch.template.xpath"),templateName);
				clickByXpathExplict(prop.getProperty("access.clickfilter.button.xpath"));
				
				
		
		return this;
	}	
	public Userspage createAccessRightsForm(String TemplateId,String TemplateName,String moduleName,String Segment ) throws InterruptedException{

		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.createnewaccessrights.xpath"));
	//	dropdownSelection(xpath1, xpath2);
		
enterByXpathExplict(prop.getProperty("enter.template.code.xpath"),TemplateId);		

enterByXpathExplict(prop.getProperty("enter.template.description.xpath"),TemplateName);		


dropdownSelection(prop.getProperty("dropdown.moduleaccess.xpath"),moduleName);

		
enterByXpathExplict(prop.getProperty("enter.prvileges.xpath")," test");		
dropdownSelection(prop.getProperty("multiselect.access.xpath"),Segment);
		
clickJs(prop.getProperty("access.select.all.xpath"));
		
		clickByXpathExplict(prop.getProperty("access.create.final.button.xpath"));
		
		
		
		
		
		return new Userspage(driver, test);
	}
	







}


