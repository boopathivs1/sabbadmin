package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class setupPage extends ProjectWrapp{
	public  setupPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public AdminAccessRightsPage clickMasterMenu(){
		clickByXpathExplict(prop.getProperty("click.master.menu.xpath"));
		return new AdminAccessRightsPage(driver, test);
	}
	
	
	public setupPage MasterMenu(){
		clickByXpathExplict(prop.getProperty("click.master.menu.xpath"));
		return this;
	}
	
	
	

	public CorporateGroup clickCorporatesubMenu(){
		clickByXpathExplict(prop.getProperty("click.corporatesubmenu.xpath"));
		return new CorporateGroup(driver, test);
	}
	
	
	
	
	
	
	
	public MatrixPage clickMatrixmenu(){
		defaultcontent();
		clickByXpathExplict(prop.getProperty("click.admin.matrix.module.xpath"));
		return new MatrixPage(driver, test);
	}
	
	
	
}
