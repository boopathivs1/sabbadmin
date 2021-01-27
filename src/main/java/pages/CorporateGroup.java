package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CorporateGroup extends ProjectWrapp{
	public  CorporateGroup(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}

	public Userspage createCorporateGroup(String groupid,String Groupname,String country) throws InterruptedException{
		locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.createnewgroup.button.xpath"));
		
		enterByXpathExplict(prop.getProperty("enter.admin.groupcode.xpath"), groupid);
		enterByXpathExplict(prop.getProperty("enter.groupdesc.xpath"),Groupname);
		dropdownSelection(prop.getProperty("dropdown.country.group.xpath"),country);
		
//		dropdownSelectionindex(prop.getProperty("dropdown.country.group.xpath"),country,2);
		clickByXpathExplict(prop.getProperty("admin.creategroup.button.xpath"));
		
		
		
		
		return new Userspage(driver, test);
	}
	
	public Userspage AjmancreateCorporateGroup(String groupid,String Groupname,String country) throws InterruptedException{
		locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.createnewgroup.button.xpath"));
		
		enterByXpathExplict(prop.getProperty("enter.admin.groupcode.xpath"), groupid);
		enterByXpathExplict(prop.getProperty("enter.groupdesc.xpath"),Groupname);
		dropdownSelection(prop.getProperty("ajman.dropdown.country.group.xpath"),country);
		
//		dropdownSelectionindex(prop.getProperty("dropdown.country.group.xpath"),country,2);
		clickByXpathExplict(prop.getProperty("admin.creategroup.button.xpath"));
		
		
		
		
		return new Userspage(driver, test);
	}
	
	public CorporateGroup filterCorporateGroup(String groupID,String groupname) throws InterruptedException{

		locateFrame("icanvas");
		
		dropdownSelection(prop.getProperty("access.searchby.xpath"),"Group ID");
		
				dropdownSelection(prop.getProperty("access.searchstatus.xpath"),"Active");
				
				enterByXpathExplict(prop.getProperty("enter.accesssearch.template.xpath"),groupID);
				clickByXpathExplict(prop.getProperty("access.clickfilter.button.xpath"));
				
		//		VerifyElementPresent("(.//h4[text()='"+groupname+"']//following::button[@id='btnedit'])[1]","Corporate group has created","Corporatae group has not created");
				
				
		
		return this;
	}
	
	
	public CorporatePage viewCorporateGroup(String groupname) throws InterruptedException{
clickByXpathExplict("(.//h4[text()='"+groupname+"']//following::button/span[text()='View Corporates'])[1]");
defaultcontent();
	return new CorporatePage(driver, test);
	}	
	
	
	
	
	public CorporateGroup filterCorporateGroupEditbutton(String groupname) throws InterruptedException{

	
	clickByXpathExplict("(.//h4[text()='"+groupname+"']//following::button[@id='btnedit'])[1]");

	return this;
}
	
	public CorporateGroup filterCorporateGroupViewCorporate(String groupname) throws InterruptedException{

		
	clickByXpathExplict("(.//h4[text()='"+groupname+"']//following::span[text()='View Corporates'])[1]");

	return this;
}
	
	
	
	


	public CorporateGroup verifyGroupNotPresent(String groupname) throws InterruptedException{


Boolean a=VerifyElementpresentreturn(prop.getProperty("transaction.cutoff.verify.xpath"));

if(a){
reportStep("Group has not deleted Sucessfully","FAIL");	
}

else{
	reportStep("Group has deleted Sucessfully","PASS");	
}
	


//		VerifyElementnotPresent("(.//h4[text()='"+groupname+"']//following::button[@id='btnedit'])[1]","Group has deleted Successfully","Group has not deleted successfully");
		

	return this;
}
	
	public Userspage editCorporateGroup(String groupid,String Groupname,String country,String filelocation) throws InterruptedException{
	//	locateFrame("icanvas");

	//	clickByXpathExplict(prop.getProperty("click.createnewgroup.button.xpath"));
		
	//	enterByXpathExplict(prop.getProperty("enter.admin.groupcode.xpath"), groupid);
		enterByXpathExplict(prop.getProperty("enter.groupdesc.xpath"),Groupname);
Thread.sleep(3000);
dropdownSelection(prop.getProperty("dropdown.country.group.xpath"),country);
//dropdownSelectionindex(prop.getProperty("dropdown.country.group.xpath"),country,2);

		fileUploadByXpathExplict(".//span[contains(@class,'fileinput-button')]//input[@id='fileupload']",filelocation);
		clickByXpathExplict(".//button[@id='btnUpdate']");
			
		return new Userspage(driver, test);
	}
	
	public Userspage AjmaneditCorporateGroup(String groupid,String Groupname,String country,String filelocation) throws InterruptedException{
		//	locateFrame("icanvas");

		//	clickByXpathExplict(prop.getProperty("click.createnewgroup.button.xpath"));
			
		//	enterByXpathExplict(prop.getProperty("enter.admin.groupcode.xpath"), groupid);
			enterByXpathExplict(prop.getProperty("enter.groupdesc.xpath"),Groupname);
	Thread.sleep(3000);
	dropdownSelection(prop.getProperty("ajman.dropdown.country.group.xpath"),country);
	//dropdownSelectionindex(prop.getProperty("dropdown.country.group.xpath"),country,2);

			fileUploadByXpathExplict(".//span[contains(@class,'fileinput-button')]//input[@id='fileupload']",filelocation);
			clickByXpathExplict(".//button[@id='btnUpdate']");
				
			return new Userspage(driver, test);
		}
	
	public Userspage deleteCorporateGroup() throws InterruptedException{
		clickByXpathExplict(prop.getProperty("delete.admin.corp.button.xpath"));
		clickByXpathExplict(prop.getProperty("users.yes.button.xpath"));

		return new Userspage(driver, test);
	
	
	
	}	
}
