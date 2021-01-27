package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class BankAccessRightsPage  extends ProjectWrapp{
	public  BankAccessRightsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

public Userspage fillAccessform(String templateid,String templatename,String Description,String modulename) throws InterruptedException{
		
		
		enterByXpathExplict(prop.getProperty("enter.admin.access.code.xpath"),templateid);
		enterByXpathExplict(prop.getProperty("enter.admin.access.desc.xpath"),templatename);
		enterByXpathExplict(prop.getProperty("enter.admin.privileges.xpath"),Description);
		
dropdownSelection(prop.getProperty("click.module.dropdown.choose.access.xpath"),modulename);





clickByXpathExplict(prop.getProperty("click.selectall.checkbox.xpath"));
clickByXpathExplict(prop.getProperty("click.bank.submit.access.xpath"));

		Thread.sleep(6000);
		
		return new Userspage(driver, test);
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
	
	
	
	
	
	
	
}
