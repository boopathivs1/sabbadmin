package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class CorporatePage extends ProjectWrapp{
	public CorporatePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	public CorporatePage newCorpButton() throws InterruptedException{
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.new.corporate.xpath"));

	return this;
	}		
	
	public CorporatePage fillCorpForm(String corpid) throws InterruptedException{
enterByXpathExplict(prop.getProperty("enter.corpid.xpath"),corpid);
		clickByXpathExplict(prop.getProperty("click.corpid.submit.xpath"));

	return this;
	}		
	
	public CorporatePage filterCorporateid(String corpIDName,String corpname) throws InterruptedException{

		locateFrame("icanvas");
		
		dropdownSelection(prop.getProperty("access.searchby.xpath"),"Corporate ID");
		
				dropdownSelection(prop.getProperty("access.searchstatus.xpath"),"Active");
				
				enterByXpathExplict(prop.getProperty("enter.accesssearch.template.xpath"),corpIDName);
				clickByXpathExplict(prop.getProperty("access.clickfilter.button.xpath"));	
		return this;
	}

	public CorporatePage verifyCorporateidPresent(String corpIDName,String corpname) throws InterruptedException{

	VerifyElementPresent("(.//h4[text()='"+corpname+"']//following::button[@id='btnedit'])[1]","Corporate ID has created","Corporatae ID has not created");
	return this;
}

	public CorporatePage verifyCoridPresent(String corpIDName) throws InterruptedException{

	VerifyElementPresent("(.//span[text()='"+corpIDName+"']//following::button[@id='btnedit'])[1]","Corporate ID has created","Corporatae ID has not created");
	return this;
}

	
	
	public CorporatePage verifyCorporateid_notPresent(String corpIDName,String corpname) throws InterruptedException{

		VerifyElementnotPresent("(.//h4[text()='"+corpname+"']//following::button[@id='btnedit'])[1]","Corporate ID has deleted successfully","Corporatae ID  has not deleted ");
	return this;
}
	
	public CorporatePage verify_Corpid_notPresent(String corpIDName,String corpname) throws InterruptedException{
VerifyElementnotAvailable("(.//h4[text()='"+corpname+"']//following::button[@id='btnedit'])[1]","Corp id has deleted", "Corp id has not deleted");

		
		return this;
}	
	
	
	
	public CorporatePage editCorporateName(String corpname) throws InterruptedException{
	
	clickByXpathExplict("(.//h4[text()='"+corpname+"']//following::button[@id='btnedit'])[1]");
	
			return this;
		}
	public Userspage AjmancorpFormSubmission(String corpidname,String corpname,String segment,String industry,String country,String channels,String address,String Manager,String loginsecuirty,String transactionSecurity) throws InterruptedException{
		enterByXpathExplict(prop.getProperty("enter.corpidname.form.xpath"),corpidname);
		dropdownSelection(prop.getProperty("click.segmentid.form.xpath"),segment);

		enterByXpathExplict(prop.getProperty("enter.desc.cust.form.xpath"),corpname);
//		dropdownSelection(prop.getProperty("select.industry.xpath"),industry);
//		clickByXpathExplict(prop.getProperty("select.industry.xpath"));
//		clickByXpathExplict("//ul[@class='chosen-results']//li[.='"+industry+"']");	
		dropdownSelectionindex(prop.getProperty("select.industry.xpath"),industry,3);
		dropdownSelection(prop.getProperty("select.cif.country.xpath"),country);
		//dropdownSelection(prop.getProperty("select.cif.channels.xpath"),channels);
		enterByXpathExplict(prop.getProperty("enter.address.cust.form.xpath"),address);
		
		dropdownSelection(prop.getProperty("select.cif.country.xpath"),country);
		scrolltoelementJs(prop.getProperty("select.ajman.manager.xpath"));	
		dropdownSelection(prop.getProperty("select.ajman.manager.xpath"),Manager);
		scrolltoelementJs(prop.getProperty("click.cust.checkbox.link.xpath"));	
		clickByXpathExplict(prop.getProperty("click.cust.checkbox.link.xpath"));				


		//dropdownSelection(prop.getProperty("select.log.secuirty.xpath"),loginsecuirty);
		//dropdownSelection(prop.getProperty("select.log.transsecuirty.xpath"),transactionSecurity);

		//dropdownSelectionindex(prop.getProperty("select.log.transsecuirty.xpath"),transactionSecurity,2);
		clickByXpathExplict(prop.getProperty("click.cif.create.button.xpath"));				
				
				
				
			return new Userspage(driver, test);
			}
	
	public Userspage corpFormSubmission(String corpidname,String corpname,String segment,String industry,String country,String channels,String loginsecuirty,String transactionSecurity) throws InterruptedException{
enterByXpathExplict(prop.getProperty("enter.corpidname.form.xpath"),corpidname);
dropdownSelection(prop.getProperty("click.segmentid.form.xpath"),segment);

enterByXpathExplict(prop.getProperty("enter.desc.cust.form.xpath"),corpname);
dropdownSelection(prop.getProperty("select.industry.xpath"),industry);
dropdownSelection(prop.getProperty("select.cif.country.xpath"),country);
dropdownSelection(prop.getProperty("select.cif.channels.xpath"),channels);
scrolltoelementJs(prop.getProperty("click.cust.checkbox.link.xpath"));	
clickByXpathExplict(prop.getProperty("click.cust.checkbox.link.xpath"));				

dropdownSelection(prop.getProperty("select.log.secuirty.xpath"),loginsecuirty);
//dropdownSelection(prop.getProperty("select.log.transsecuirty.xpath"),transactionSecurity);

dropdownSelectionindex(prop.getProperty("select.log.transsecuirty.xpath"),transactionSecurity,2);
clickByXpathExplict(prop.getProperty("click.cif.create.button.xpath"));				
		
		
		
	return new Userspage(driver, test);
	}		
		
	
	
		
	
	public Userspage editCorpFormSubmission(String segment,String industry,String country,String channels,String loginsecuirty,String transactionSecurity) throws InterruptedException{


dropdownSelection(prop.getProperty("select.industry.xpath"),"Large");
//dropdownSelection(prop.getProperty("select.cif.country.xpath"),country);
//dropdownSelection(prop.getProperty("select.cif.channels.xpath"),channels);
//clickByXpathExplict(prop.getProperty("click.cust.checkbox.link.xpath"));				
//
//dropdownSelection(prop.getProperty("select.log.secuirty.xpath"),loginsecuirty);
//dropdownSelection(prop.getProperty("select.log.transsecuirty.xpath"),transactionSecurity);
clickByXpathExplict(prop.getProperty("corp.update.button.xpath"));				
		
		
		
	return new Userspage(driver, test);
	}		
	
	public Userspage clickDeleteCorp(){
	
	clickByXpathExplict(prop.getProperty("corp.delete.button.xpath"));	
	clickByXpathExplict(prop.getProperty("click.delete.yesButton.xpath"));
	
	return new Userspage(driver, test);
	}		
	
	
	public CorporatePage filterCorporate(String CorporateName) throws InterruptedException{

		locateFrame("icanvas");
		
		dropdownSelection(prop.getProperty("access.searchby.xpath"),"Corporate Name");
		
				dropdownSelection(prop.getProperty("access.searchstatus.xpath"),"Active");
				
				enterByXpathExplict(prop.getProperty("enter.accesssearch.template.xpath"),CorporateName);
				clickByXpathExplict(prop.getProperty("access.clickfilter.button.xpath"));
				
				VerifyElementPresent("(.//h4[text()='"+CorporateName+"']//following::button[@id='btnedit'])[1]","Corporate  has created","Corporatae has not created");
				
				
		
		return this;
	}
	
	
	public CorporatePage clickEditcorporatebutton(String corpname) throws InterruptedException{

		
		clickByXpathExplict("(.//h4[text()='"+corpname+"']//following::button[@id='btnedit'])[1]");

		return this;
	}
	
public CorporateAccessRights clickViewAccessRights(String corpname) throws InterruptedException{

		
		clickByXpathExplict("(.//h4[text()='"+corpname+"']//following::button)[2]");

		return new CorporateAccessRights(driver, test);
	}
	
	
	public Userspage filleditcorpform(String segment,String industry) throws InterruptedException{

dropdownSelection(prop.getProperty("Corporate.segment.dropdown.xpath"),segment);		

dropdownSelection(prop.getProperty("Corporate.industry.dropdown.xpath"),industry);		

clickByXpathExplict(prop.getProperty("Corporate.edit.submit.seg.xpath"));
		return new Userspage(driver, test);
	}
	
	
		public CorporatePage clickcreateCorp(){
			clickByXpathExplict(prop.getProperty("click.newdepartlink.xpath"));
	
	
	
	
	return this;
		}
	
		
		public CorporatePage createCorpForm(String corpid){
	
			String corpnumber=regvalue(corpid);
enterByXpathExplict(prop.getProperty("enter.admin.corpid.xpath"),corpnumber);	
clickByXpathExplict(prop.getProperty("import.corp.admin.xpath"));

	

	return this;
		}
		
		
		
/*	
	locateFrame("icanvas");

	clickByXpathExplict(prop.getProperty("click.createnewgroup.button.xpath"));
	
	enterByXpathExplict(prop.getProperty("enter.admin.groupcode.xpath"), "test123a");
	enterByXpathExplict(prop.getProperty("enter.groupdesc.xpath"),"test123a");
	dropdownSelection(prop.getProperty("dropdown.country.group.xpath"),"India");
	clickByXpathExplict(prop.getProperty("admin.creategroup.button.xpath"));
	*/

	
	

}