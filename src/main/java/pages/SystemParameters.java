package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SystemParameters extends ProjectWrapp{
	public SystemParameters(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
	
	public Userspage updatePassword(String pwdminilength,String pwdmaxlenght,String forcepwd,String lockdays){
	
		clickByXpathExplict(prop.getProperty("click.pwd.policy.xpath"));
		locateFrame("icanvas");
		enterByXpathExplict(prop.getProperty("enter.minilength.pwd.xpath"),pwdminilength);
		enterByXpathExplict(prop.getProperty("enter.maxlength.pwd.xpath"),pwdmaxlenght);
		enterByXpathExplict(prop.getProperty("enter.force.pwd.xpath"),forcepwd);
		
		enterByXpathExplict(prop.getProperty("enter.lockdays.xpath"),lockdays);
		
		
		clickByXpathExplict(prop.getProperty("click.savebutton.pwd.xpath"));

		defaultcontent();
	return new Userspage(driver, test);
	}

	
	
	
	
	
	public SystemParameters clicktransconfig(){
		clickByXpathExplict(prop.getProperty("click.transconfig.xpath"));

	
	return this;
	
	}


	public SystemParameters clickdepartmentmaster(){
		clickByXpathExplict(prop.getProperty("Click.departmentmaster.xpath"));

	
	return this;
	
	}
	
	public SystemParameters clickerrorManage(){
		clickByXpathExplict(prop.getProperty("click.errormanagement.link.xpath"));

	
	return this;
	
	}
		
	public SystemParameters createerrorManage(){
		locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.newdepartlink.xpath"));

	
	return this;
	
	}	
	
	
	public SystemParameters editerrorMessage(String ibmessage,String ibarabic,String coremessage,String coreArabic){
		
		enterByXpathExplict(prop.getProperty("enter.ibmessage.xpath"),ibmessage);
		enterByXpathExplict(prop.getProperty("enter.ibarabic.xpath"), ibarabic);
		enterByXpathExplict(prop.getProperty("enter.coremesage.xpath"), coremessage);
		enterByXpathExplict(prop.getProperty("enter.coremesagearabic.xpath"),coreArabic);
		
		
		
		clickByXpathExplict(prop.getProperty("click.update.error.xpath"));
			defaultcontent();
			return this;
	
			}	
	public SystemParameters deleteerrorMessage(){
		clickByXpathExplict(prop.getProperty("click.delete.error.button.xpath"));
		clickByXpathExplict(prop.getProperty("click.admin.depart.delete.yes.xpath"));
		
	
		
	
	return this;
	}
	
	public SystemParameters createerrorMessage(String inputcode,String ibmessage,String ibarabic,String coremessage,String coreArabic){
	
		enterByXpathExplict(prop.getProperty("enter.errorcode.xpath"),inputcode);
		enterByXpathExplict(prop.getProperty("enter.ibmessage.xpath"),ibmessage);
		enterByXpathExplict(prop.getProperty("enter.ibarabic.xpath"), ibarabic);
		enterByXpathExplict(prop.getProperty("enter.coremesage.xpath"), coremessage);
		enterByXpathExplict(prop.getProperty("enter.coremesagearabic.xpath"),coreArabic);
		
		
		
		clickByXpathExplict(prop.getProperty("click.errorcreate.button.xpath"));
			defaultcontent();
			return this;
	
			}	

	
	
	public SystemParameters filterTransconfig(String transactionname,String searchKeyword) throws InterruptedException{
		locateFrame("icanvas");

		dropdownSelection(prop.getProperty("select.usersearch.xpath"),transactionname);
		enterByXpathExplict(prop.getProperty("enter.inputsearchkeyword.xpath"),searchKeyword);
		
		

		clickByXpathExplict(prop.getProperty("click.filter.bankusers.search.xpath"));
		
		
			return this;
		}

	
	
public SystemParameters clicktransname(String transactionname){
clickByXpathExplict("(.//h4[text()='"+transactionname+"']//following::button)[1]");			

return this;
}



public SystemParameters limitSearch(String limitid,String transname) throws InterruptedException{


	enterByXpathExplict(prop.getProperty("enter.search.translimit.xpath"), limitid);

	dropdownSelection(prop.getProperty("select.trans.limit.xpath"),transname);


	clickByXpathExplict(prop.getProperty("click.filter.search.limit.xpath"));



return this;
}

public SystemParameters clicklimit(String limitid) throws InterruptedException{
	clickByXpathExplict("(.//td[contains(text(),'"+limitid+"')]//following::button)[1]");
return this;
}




public SystemParameters verifylimitnotPresent(String limitid) throws InterruptedException{
	
	Boolean a=VerifyElementpresentreturn("(.//td[contains(text(),'"+limitid+"')]//following::button)[1]");

if(a){
	reportStep("limit has not deleted","FAIL");
}else{
	reportStep("limit has deleted","PASS");	
}
	
	return this;
}
public SystemParameters updatelimitwithDate(String limitid,String perlimitamount,String dailylimit) throws InterruptedException{
	clickByXpathExplict("(.//td[contains(text(),'"+limitid+"')]//following::button)[1]");

	
	
	
enterByXpathExplict(prop.getProperty("enter.pertranslimit.xpath"),perlimitamount);
enterByXpathExplict(prop.getProperty("enter.daily.limit.xpath"),dailylimit);

clickByXpathExplict(prop.getProperty("click.ajman.firstcal.xpath"));



selectYearMonth();

clickByXpathExplict(prop.getProperty("ajman.limit.day.cal.xpath"));





clickByXpathExplict(prop.getProperty("click.ajman.seccal.xpath"));

selectYearMonth();



clickByXpathExplict(prop.getProperty("ajman.limit.daynext.cal.xpath"));

	clickByXpathExplict(prop.getProperty("click.limit.update.xpath"));
	verifyPageSource("Duplicate Record","Duplicate Record Exist Message has dispalying");

return this;
}

public void selectYearMonth(){
	clickByXpathExplict(prop.getProperty("ajman.enter.year.cal.xpath"));

	clickByXpathExplict(prop.getProperty("ajman.enter.month.cal.xpath"));

	

}






public SystemParameters updatelimit(String limitid,String perlimitamount,String dailylimit) throws InterruptedException{
	clickByXpathExplict("(.//td[contains(text(),'"+limitid+"')]//following::button)[1]");

enterByXpathExplict(prop.getProperty("enter.pertranslimit.xpath"),perlimitamount);
enterByXpathExplict(prop.getProperty("enter.daily.limit.xpath"),dailylimit);

	clickByXpathExplict(prop.getProperty("click.limit.update.xpath"));
	verifyPageSource("Duplicate Record","Duplicate Record Exist Message has dispalying");

return this;
}


public SystemParameters deletelimit(String limitid) throws InterruptedException{
	clickByXpathExplict("(.//td[contains(text(),'"+limitid+"')]//following::button)[2]");

	clickByXpathExplict(prop.getProperty("delete.bankaccess.yes.rights.xpath"));
return this;
}




public SystemParameters limitCatSelection(String groupid,String Corpid) throws InterruptedException{
	
	clickByXpathExplict(prop.getProperty("click.createlimit.button.xpath"));

	dropdownSelection(prop.getProperty("select.groupid.limit.choosen.xpath"),groupid);
	
	dropdownSelectionindex(prop.getProperty("select.corpid.limit.xapth"),Corpid, 2);
	
	
return this;
}




public SystemParameters limitOthersCatSelection(String Country) throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.createlimit.button.xpath"));

	clickByXpathExplict(prop.getProperty("click.other.translimit.xpath"));

	dropdownSelection(prop.getProperty("others.country.choosen.xpath"),Country);
	
	
	
return this;
}

public SystemParameters ajmanlimitOthersCatSelection(String Country) throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.createlimit.button.xpath"));

	
	
	clickByXpathExplict(prop.getProperty("channels.ajman.dd.xpath"));
	
dropdownSelection(prop.getProperty("channels.ajman.dd.xpath"),"WEB");


	clickByXpathExplict(prop.getProperty("click.other.translimit.xpath"));

	dropdownSelection(prop.getProperty("others.country.choosen.xpath"),Country);
	
	
	
return this;
}
public SystemParameters ajmanlimitOthersCatSelection_channel(String Country,String channel) throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.createlimit.button.xpath"));

	
	
	clickByXpathExplict(prop.getProperty("channels.ajman.dd.xpath"));
	
dropdownSelection(prop.getProperty("channels.ajman.dd.xpath"),channel);


	clickByXpathExplict(prop.getProperty("click.other.translimit.xpath"));

	dropdownSelection(prop.getProperty("others.country.choosen.xpath"),Country);
	
	
	
return this;
}

public SystemParameters ajmanGrouplimitCatSelection_channel(String channel,String groupid,String Corpid, String LimitID) throws InterruptedException{
	clickByXpathExplict(prop.getProperty("click.createlimit.button.xpath"));

	
	
	clickByXpathExplict(prop.getProperty("channels.ajman.dd.xpath"));
	
dropdownSelection(prop.getProperty("channels.ajman.dd.xpath"),channel);
dropdownSelection(prop.getProperty("select.groupid.limit.choosen.xpath"),groupid);

dropdownSelectionindex(prop.getProperty("select.corpid.limit.xapth"),Corpid, 2);
enterByXpathExplict(prop.getProperty("enter.geocode.xpath"),LimitID);


		
return this;
}
public SystemParameters GrouplimitFillForm(String transCurrency,String perlimitAmount,String LimitCurrency,String dailyLimitAmount) throws InterruptedException{

	scrolltoelementJs(prop.getProperty("select.translimit.currency.choose.xpath"));
dropdownSelection(prop.getProperty("select.translimit.currency.choose.xpath"),transCurrency);
enterByXpathExplict(prop.getProperty("enter.pertranslimit.xpath"),perlimitAmount);
clickByXpathExplict(prop.getProperty("fromdate.limit.xpath"));

clickByXpathExplict(prop.getProperty("fromdate.select.limit.xpath"));

clickByXpathExplict(prop.getProperty("todate.limit.xpath"));

clickByXpathExplict(prop.getProperty("todate.select.limit.xpath"));
dropdownSelectionindex(prop.getProperty("daily.limit.currency.xapth"),LimitCurrency,2);
enterByXpathExplict(prop.getProperty("enter.daily.limit.xpath"),dailyLimitAmount);
clickByXpathExplict(prop.getProperty("click.translimit.create.button.xpath"));


verifyPageSource("Duplicate Record","Duplicate Record Exist Message has dispalying");


return this;
}



public SystemParameters ajmanGrouplimitFillForm(String transCurrency,String perlimitAmount,String LimitCurrency,String dailyLimitAmount) throws InterruptedException{

	scrolltoelementJs(prop.getProperty("select.translimit.currency.choose.xpath"));
dropdownSelection(prop.getProperty("select.translimit.currency.choose.xpath"),transCurrency);
enterByXpathExplict(prop.getProperty("enter.pertranslimit.xpath"),perlimitAmount);

clickByXpathExplict(prop.getProperty("fromdate.limit.xpath"));
clickByXpathExplict(prop.getProperty("click.holiday.form.year.xpath"));
clickByXpathExplict(prop.getProperty("click.holiday.form.year.month.xpath"));

clickByXpathExplict(prop.getProperty("fromdate.select.limit.xpath"));

//clickByXpathExplict(prop.getProperty("todate.limit.xpath"));

//clickByXpathExplict(prop.getProperty("todate.select.limit.xpath"));
dropdownSelectionindex(prop.getProperty("daily.limit.currency.xapth"),LimitCurrency,2);
enterByXpathExplict(prop.getProperty("enter.daily.limit.xpath"),dailyLimitAmount);
clickByXpathExplict(prop.getProperty("click.translimit.create.button.xpath"));


verifyPageSource("Duplicate Record","Duplicate Record Exist Message has dispalying");


return this;
}



public SystemParameters ajmanGrouplimitForm(String transCurrency,String perlimitAmount,String LimitCurrency,String dailyLimitAmount) throws InterruptedException{

	
	
	
	scrolltoelementJs(prop.getProperty("select.translimit.currency.choose.xpath"));
dropdownSelection(prop.getProperty("select.translimit.currency.choose.xpath"),transCurrency);
enterByXpathExplict(prop.getProperty("enter.pertranslimit.xpath"),perlimitAmount);

clickByXpathExplict(prop.getProperty("fromdate.limit.xpath"));
clickByXpathExplict(prop.getProperty("click.holiday.form.year.xpath"));
clickByXpathExplict(prop.getProperty("click.holiday.form.year.month.xpath"));

clickByXpathExplict(prop.getProperty("fromdate.select.limit.xpath"));

//clickByXpathExplict(prop.getProperty("todate.limit.xpath"));

//clickByXpathExplict(prop.getProperty("todate.select.limit.xpath"));
dropdownSelectionindex(prop.getProperty("daily.limit.currency.xapth"),LimitCurrency,2);
enterByXpathExplict(prop.getProperty("enter.daily.limit.xpath"),dailyLimitAmount);
clickByXpathExplict(prop.getProperty("click.translimit.create.button.xpath"));


verifyPageSource("Duplicate Record","Duplicate Record Exist Message has dispalying");


return this;
}

public SystemParameters entergeolimitCode(String geocode){
enterByXpathExplict(prop.getProperty("enter.geocode.xpath"),geocode);
return this;	
}




public SystemParameters ajmanCreateGeographylimitFillForm(String transCurrency,String perlimitAmount,String LimitCurrency,String dailyLimitAmount) throws InterruptedException{

	scrolltoelementJs(prop.getProperty("select.translimit.currency.choose.xpath"));
dropdownSelection(prop.getProperty("select.translimit.currency.choose.xpath"),transCurrency);
enterByXpathExplict(prop.getProperty("enter.pertranslimit.xpath"),perlimitAmount);

clickByXpathExplict(prop.getProperty("fromdate.limit.xpath"));
clickByXpathExplict(prop.getProperty("click.holiday.form.year.xpath"));
clickByXpathExplict(prop.getProperty("click.holiday.form.year.month.xpath"));

clickByXpathExplict(prop.getProperty("fromdate.select.limit.xpath"));

//clickByXpathExplict(prop.getProperty("todate.limit.xpath"));

//clickByXpathExplict(prop.getProperty("todate.select.limit.xpath"));
dropdownSelectionindex(prop.getProperty("daily.limit.currency.xapth"),LimitCurrency,2);
enterByXpathExplict(prop.getProperty("enter.daily.limit.xpath"),dailyLimitAmount);
clickByXpathExplict(prop.getProperty("click.translimit.create.button.xpath"));


verifyPageSource("Duplicate Record","Duplicate Record Exist Message has dispalying");


return this;
}



public SystemParameters clickwindownext(){
	clickByXpathExplict(prop.getProperty("click.windowtime.next.button.xpath"));

return this;
}


public SystemParameters clickeditholidayicon(){
	clickByXpathExplict(prop.getProperty("click.holiday.edit.button.xpath"));

return this;
}

public SystemParameters submiteditFormHoliday(String desc,String date,Boolean dateEnableStatus) throws InterruptedException{
String regdate=regvalue(date);

enterByXpathExplict(prop.getProperty("enter.holiday.desc.xpath"), desc);
clickByXpathExplict(prop.getProperty("click.holiday.calendar.xpath"));

if(dateEnableStatus){
holidayDateyear();
}
clickByXpathExplict("(.//button[text()='"+regdate+"'][contains(@class,'day')])[1]");



	clickByXpathExplict(prop.getProperty("click.holiday.editupdate.button.xpath"));
	verifyPageSource("Duplicate Record","Duplicate Record Exist Message has dispalying");

return this;
}

public SystemParameters submitdeleteFormHoliday(){
	clickByXpathExplict(prop.getProperty("click.holiday.delete.button.xpath"));
	clickByXpathExplict(prop.getProperty("Click.Logout.yesButton.xpath"));

	
return this;
}



public SystemParameters fillholidayform(String desc,String date,Boolean enablestatus) throws InterruptedException{
	String regdate=regvalue(date);
	clickByXpathExplict(prop.getProperty("click.holiday.new.xpath"));
	
enterByXpathExplict(prop.getProperty("enter.holiday.desc.xpath"), desc);


clickByXpathExplict(prop.getProperty("click.holiday.calendar.xpath"));

//clickByXpathExplict("(.//button[text()='"+regdate+"'])[1]");


if(enablestatus){
	holidayDateyear();
}




clickByXpathExplict("(.//button[text()='"+regdate+"'][contains(@class,'day')])[1]");

//clickByXpathExplict(prop.getProperty("click.holiday.day.selectone.xpath"));

clickByXpathExplict(prop.getProperty("click.holiday.create.button.xpath"));

verifyPageSource("Duplicate Record","Duplicate Record Exist Message has dispalying");


return this;
}



public void holidayDateyear(){
	clickByXpathExplict(prop.getProperty("click.holiday.form.year.xpath"));
	clickByXpathExplict(prop.getProperty("click.holiday.form.year.month.xpath"));
}




	public SystemParameters fillTransname(String transactionname,String fromtime,String ToTime,String fromTimeindex,String totimeindex) throws InterruptedException{
	
	
	

clickByXpathExplict("(.//h4[text()='"+transactionname+"']//following::button)[1]");			



		clickByXpathExplict(prop.getProperty("click.calendar.fromcal.xpath"));
//clickByXpathExplict(prop.getProperty("click.calendar.fromtime.xpath"));

clickByXpathExplict("(.//table[@role='grid']//td)["+fromTimeindex+"]");

clickByXpathExplict(prop.getProperty("click.calendar.tocal.xpath"));
//clickByXpathExplict(prop.getProperty("click.calendar.totime.xpath"));
//clickByXpathExplict("(.//table[@role='grid']//td)[26]");
clickByXpathExplict("(.//table[@role='grid']//td)["+totimeindex+"]");

		
//			enterByXpathExplict(prop.getProperty("windowtime.from.xpath"),fromtime);
	//		enterByXpathExplict(prop.getProperty("windowtime.to.xpath"),ToTime);

	clickByXpathExplict(prop.getProperty("windowtiming.create.button.xpath"));
	
	
	return this;
		
	
	}
	public SystemParameters filtererror(String roleid,String status,String searchenable,String searchKeyword) throws InterruptedException{
		locateFrame("icanvas");

		dropdownSelection(prop.getProperty("select.usersearch.xpath"),"IB Code");
		dropdownSelection(prop.getProperty("select.usersearchStatus.xpath"),status);
		if(searchenable.equalsIgnoreCase("true")){
		enterByXpathExplict(prop.getProperty("enter.inputsearchkeyword.xpath"),searchKeyword);
		}
		
		

		clickByXpathExplict(prop.getProperty("click.filter.bankusers.search.xpath"));
		
		
			return this;
		}
	
	
	
	public SystemParameters verifyerrorPresent(String errorcpde) throws InterruptedException{
		
		Boolean a=driver.getPageSource().contains(errorcpde);
		
		
		if(a){
			reportStep("Error code has been created","PASS");
		}

		else {
			reportStep("Error code has not been created","FAIL");
		}
		
		defaultcontent();
	return this;
	}
	
	public SystemParameters verifyerrornotPresent(String errorcode) throws InterruptedException{
		
		Boolean a=VerifyElementpresentreturn(".//h4[text()='"+errorcode+"']");
		
		
		if(a){
			reportStep("Error code has Exist","FAIL");
		}

		else {
			reportStep("Error code has not Exist","PASS");
		}
		
		defaultcontent();
	return this;
	}	
	
	
	
	public SystemParameters clickediterror(String errorcode) throws InterruptedException{
		
		locateFrame("icanvas");

			
			
	clickByXpathExplict(".//h4[text()='"+errorcode+"']//following::button[@id='btnedit']");
	
	return this;
	}
	public SystemParameters filterdepartmentMaster(String roleid,String status,String searchenable,String searchKeyword) throws InterruptedException{
		locateFrame("icanvas");

		dropdownSelection(prop.getProperty("select.usersearch.xpath"),"ID");
		dropdownSelection(prop.getProperty("select.usersearchStatus.xpath"),status);
		if(searchenable.equalsIgnoreCase("true")){
		enterByXpathExplict(prop.getProperty("enter.inputsearchkeyword.xpath"),searchKeyword);
		}
		
		

		clickByXpathExplict(prop.getProperty("click.filter.bankusers.search.xpath"));
		
			return this;
		}
		
	
	public SystemParameters filterdepartmentMasterid(String departid) throws InterruptedException{
		clickByXpathExplict("(.//h4[text()='"+departid+"']//following::button)[1]");
	
	
	return this;
	}	

	
	
	public SystemParameters verifyDeleteMasterid(String departdesc) throws InterruptedException{
	//	clickByXpathExplict("(.//h4[text()='"+departid+"']//following::button)[1]");
		Boolean a=driver.getPageSource().contains(departdesc);
		
		//Boolean a=VerifyElementpresentreturn(prop.getProperty("transaction.cutoff.verify.xpath"));
		booleanResult(a, "Department has not been deleted");	
	
	return this;
	}	

	
	
	public SystemParameters createDepartmentMaster(String roleid,String status,String searchenable,String searchKeyword) throws InterruptedException{
		locateFrame("icanvas");

		dropdownSelection(prop.getProperty("select.usersearch.xpath"),"DepartmentID");
		dropdownSelection(prop.getProperty("select.usersearchStatus.xpath"),status);
		if(searchenable.equalsIgnoreCase("true")){
		enterByXpathExplict(prop.getProperty("enter.inputsearchkeyword.xpath"),searchKeyword);
		}
		
		

		clickByXpathExplict(prop.getProperty("click.filter.bankusers.search.xpath"));
		
			return this;
		}
		
	
	public SystemParameters createDepartment(String departcode,String departaddress,String departdesc,String country,String city,String postalcode,String searchkeyword) throws InterruptedException{
		locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.newdepartlink.xpath"));
		enterByXpathExplict(prop.getProperty("enter.departcode.xpath"),departcode);
		enterByXpathExplict(prop.getProperty("enter.departaddress.xpath"),departaddress);
		enterByXpathExplict(prop.getProperty("enter.departdesc.xpath"),departdesc);

		dropdownSelection(prop.getProperty("enter.departcountry.xpath"),country);
		dropdownSelection(prop.getProperty("enter.departcity.xpath"),city);
		

		
//		if(searchenable.equalsIgnoreCase("true")){
//		enterByXpathExplict(prop.getProperty("enter.departpostalcode.xpath"),searchkeyword);
//		}
String poscode=regvalue(postalcode);
	enterByXpathExplict(prop.getProperty("enter.departpostalcode.xpath"),poscode);
		
		
		clickByXpathExplict(prop.getProperty("click.departcreate.button.xpath"));

	
		
		
		
defaultcontent();
		
			return this;
		}
	public SystemParameters updateDepartment(String departcode,String departaddress,String departdesc,String country,String city,String postalcode,String searchkeyword) throws InterruptedException{
		//locateFrame("icanvas");

		//clickByXpathExplict(prop.getProperty("click.newdepartlink.xpath"));
		//enterByXpathExplict(prop.getProperty("enter.departcode.xpath"),departcode);
		enterByXpathExplict(prop.getProperty("enter.departaddress.xpath"),departaddress);
		enterByXpathExplict(prop.getProperty("enter.departdesc.xpath"),departdesc);

		dropdownSelection(prop.getProperty("enter.departcountry.xpath"),country);
		dropdownSelection(prop.getProperty("enter.departcity.xpath"),city);
		

		
//		if(searchenable.equalsIgnoreCase("true")){
//		enterByXpathExplict(prop.getProperty("enter.departpostalcode.xpath"),searchkeyword);
//		}
String poscode=regvalue(postalcode);
	enterByXpathExplict(prop.getProperty("enter.departpostalcode.xpath"),poscode);
		
		
		clickByXpathExplict(prop.getProperty("click.admin.depart.update.xpath"));

			
		
defaultcontent();
		
			return this;
		}

	


	
	
	
	
	
	public SystemParameters deleteDepartment() throws InterruptedException{
		
		clickByXpathExplict(prop.getProperty("click.del.depart.xpath"));

		clickByXpathExplict(prop.getProperty("click.admin.depart.delete.yes.xpath"));
				return this;
		}	
	
			
	public SaabCorporateRequestPage  clicksaabCorporateRequestPage(){
		defaultcontent();
		
		clickByXpathExplict(prop.getProperty("click.saabCorporate.AdminRequest.page.xpath"));

		return new SaabCorporateRequestPage(driver, test);
		}
	
	
	
	
	
}
