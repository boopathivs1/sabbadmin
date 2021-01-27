package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class StandingPageInstruction extends ProjectWrapp{
	public  StandingPageInstruction(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
			this.test = test;
		//	if(!verifyTitle("Corporate Customer Banking  ")){
			//	reportStep("This is not Corporate Customer Banking", "FAIL");
		//	}
		}

	
	

	
	
	
	public OtP_Page fillSIPayLaterToPayNow(String transfermodeSelection,String foryouacc,String currencytype,String amount,String frequency,String RepeatSkipcount) throws InterruptedException{
		Thread.sleep(6000);		
		enterByXpathExplict(prop.getProperty("Si.forAcc.xpath"),foryouacc);
Thread.sleep(6000);
dropdownSelection(prop.getProperty("currency.SI.Xpath"),currencytype);
Thread.sleep(6000);
String amt= amount;   
amt = amt.replaceAll("[^a-zA-Z0-9]", " ");  

String amtvalue = amt.replaceAll("\\s", "");

enterByXpathExplict(prop.getProperty("SI.enteramount.xpath"),amtvalue);
Thread.sleep(6000);
if("Pay Now".equalsIgnoreCase(transfermodeSelection)){

clickByXpathExplict(prop.getProperty("si.select.transfer.mode.xpath"));

}
else if("Pay Later".equalsIgnoreCase(transfermodeSelection)){
//enterByXpathExplict(prop.getProperty("si.forbeneficiary.enter.xpath"),"test");
clickByXpathExplict(prop.getProperty("si.select.transfer.Paylatermode.xpath"));
clickByXpathExplict(prop.getProperty("click.calendaricon.xpath"));

Thread.sleep(4000);
//clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
//clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));

//SIpayDate=getAttributesxpath("payment.dateattribute.return.verify.xpath","value");

SIpayDate=getAttributesxpath(prop.getProperty("payment.dateattribute.return.verify.xpath"),"value");



}

else if("RepeatUpdate".equalsIgnoreCase(transfermodeSelection)){
	//enterByXpathExplict(prop.getProperty("si.forbeneficiary.enter.xpath"),"test");
	clickByXpathExplict(prop.getProperty("si.click.repeat.button.xpath"));
	clickByXpathExplict(prop.getProperty("click.calendaricon.xpath"));


//	clickByXpathExplict(prop.getProperty("select.twentyyear.xpath"));
	//clickByXpathExplict(prop.getProperty("select.calendar.month.xpath"));
	Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("select.calendar.days.xpath"));
	Thread.sleep(6000);
dropdownSelection(prop.getProperty("si.frequency.selection.xpath"),frequency);
	Thread.sleep(6000);
enterByXpathExplict(prop.getProperty("numberoftimes.si.xpath"),RepeatSkipcount);


SIpayDate=getAttributesxpath(prop.getProperty("si.repeat.update.xpath"),"value");


	}

else if("RepeatToSKIP".equalsIgnoreCase(transfermodeSelection)){
//	enterByXpathExplict(prop.getProperty("si.forbeneficiary.enter.xpath"),foryouacc);
	clickByXpathExplict(prop.getProperty("si.click.repeat.button.xpath"));

	SkippedCount=getAttributesxpath(prop.getProperty("numberoftimes.si.xpath"),"value");

	
	
	clickByXpathExplict(prop.getProperty("si.repeat.skip.xpath"));
		
enterByXpathExplict(prop.getProperty("numberoftimes.si.xpath"),RepeatSkipcount);
Thread.sleep(4000);

//SIpayDate=getAttributesxpath("payment.dateattribute.return.verify.xpath","value");


	}


clickByXpathExplict(prop.getProperty("click.si.update.button.xpath"));



return new OtP_Page(driver, test);
	}

	
	
	
	
	
	public StandingPageInstruction SIfilter(String fromcomp,String fromacc,String transfertype) throws InterruptedException{
		Thread.sleep(3000);
		locateFrame("icanvas");
		Thread.sleep(6000);

		dropdownSelection(prop.getProperty("click.fromcompany.xpath"),fromcomp);
		Thread.sleep(15000);

		dropdownSelection(prop.getProperty("click.fromAcc.xpath"),fromacc);
		Thread.sleep(15000);
		dropdownSelection(prop.getProperty("standinstruction.transfertype.xpath"),transfertype);
		Thread.sleep(4000);

clickByXpathExplict(prop.getProperty("tag.filter.xpath"));
Thread.sleep(15000);

return this;
	}

	
	
	
	
	
	public StandingPageInstruction editStandIntrction(String transmode) throws InterruptedException{
	
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"'])["+i+"]");
	if(a){
		Thread.sleep(6000);
		SIrefnumer=ReturnXpathtext("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong)["+i+"]");

		clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong/following::button[@id='dropdownMenu1'])["+i+"]");
Thread.sleep(4000);

clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong/following::button[@id='dropdownMenu1']//following::ul//a)["+i+"]");


//clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='124812X571452643']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");
		pageScroll400();
		Thread.sleep(4000);
	
		break;
}
else {
	int c=i+1;
	reportStep("trying to find account number in another page number", "INFO");
	clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(4000);
}

		}
	
	return this;
}
	
	
	
public OtP_Page PayLaterToPayNow(String transmode) throws InterruptedException{
		
		for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");
//reportStep("Reference number has present in this page", "INFO");
if(a){
	reportStep("Reference number  has diplaying in this page", "FAIL");
	break;
}
else {
	int c=i+1;
	reportStep("+"+SIrefnumer+" has not  diplaying in this page", "PASS");
	reportStep("trying to find account number in another page number", "INFO");
	boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
	if(b){
		Thread.sleep(6000);

		clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
	Thread.sleep(6000);
	}
	else {
		reportStep("Reference number has not diplaying in this page", "PASS");
		break;
	}
}
}
		return new OtP_Page(driver, test);
}

public OtP_Page PayLaterUpdate(String transmode,String TransmodeVerify,String foraccval,String amountval) throws InterruptedException{
	
	pageScroll400();
	Thread.sleep(4000);

	for(int i=1;i<100;i++){
//boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])["+i+"]");
		
		boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"'])");

//		reportStep("Reference number has present in this page", "PASS");
if(a){
reportStep("Reference number  has diplaying in this page", "PASS");
//verifyTextByXpathExplicitwait("(.//span[text()='Payment Date']//following::span[2])["+i+"]",SIpayDate);

VerifyElementPresent("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"'])","Pay Later option has been displaying for this reference number","Pay Later option has not been displaying for this reference number");


clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
Thread.sleep(4000);

clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");

Thread.sleep(8000);

verifybyAttributesxpath(prop.getProperty("si.foracc.attributeval.xpath"),foraccval,"value");

String amt= amountval;   
amt = amt.replaceAll("[^a-zA-Z0-9]", " ");  

String amtvalue = amt.replaceAll("\\s", "");

verifybyAttributesxpath(prop.getProperty("si.amount.attributeval.xpath"),amtvalue,"value");




break;
}
else {
int c=i+1;
reportStep("+accno+"+ "  has not  diplaying in this page", "PASS");
reportStep("trying to find account number in another page number", "INFO");
boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
if(b){
clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
Thread.sleep(4000);
}
else {
	reportStep("Reference number has not diplaying in this page", "FAIL");
	break;
}
}
}
	return new OtP_Page(driver, test);

}


public OtP_Page repeatToSkip(String transmode) throws InterruptedException{

	for(int i=1;i<100;i++){
boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");
reportStep("Reference number has present in this page", "PASS");
if(a){
reportStep("Reference number  has diplaying in this page", "PASS");
verifyTextByXpathExplicitwait("(.//span[text()='Payment Date']//following::span[2])["+i+"]",SIpayDate);
//verifyTextByXpathExplicitwait("(.//span[text()='Payment Date']//following::strong[3])["+i+"]",TransmodeVerify);
break;
}
else {
int c=i+1;
reportStep("+accno+"+ "  has not  diplaying in this page", "PASS");
reportStep("trying to find account number in another page number", "INFO");
boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
if(b){
clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
Thread.sleep(4000);
}
else {
	reportStep("Beneficiary Account number has not diplaying in this page", "PASS");
	break;
}
}
}
	return new OtP_Page(driver, test);

}


public OtP_Page skipVerify(String transmode,String foraccval,String amountval,String Skipcount,String transferskipmode) throws InterruptedException{
	
	pageScroll400();
	Thread.sleep(4000);
	
	for(int i=1;i<100;i++){
//boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])["+i+"]");

		boolean a=VerifyElementpresentreturn("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"'])");

//		reportStep("Reference number has present in this page", "PASS");
if(a){
reportStep("Reference number  has diplaying in this page", "PASS");
//verifyTextByXpathExplicitwait("(.//span[text()='Payment Date']//following::span[2])["+i+"]",SIpayDate);

VerifyElementPresent("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"'])","Pay Later option has been displaying for this reference number","Pay Later option has not been displaying for this reference number");


clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1'])[1]");
Thread.sleep(4000);

clickByXpathExplict("(.//p[strong='"+transmode+"']//following::span[text()='Reference Number:']/following::strong[text()='"+SIrefnumer+"']/following::button[@id='dropdownMenu1']//following::ul//a)[1]");

Thread.sleep(8000);

//verifybyAttributesxpath(prop.getProperty("si.foracc.attributeval.xpath"),foraccval,"value");


String amt= amountval;   
amt = amt.replaceAll("[^a-zA-Z0-9]", " ");  

String amtvalue = amt.replaceAll("\\s", "");

//verifybyAttributesxpath(prop.getProperty("si.amount.attributeval.xpath"),amtvalue,"value");


clickByXpathExplict(prop.getProperty("si.click.repeat.button.xpath"));



String repeatcount=getAttributesxpath(prop.getProperty("numberoftimes.si.xpath"),"value");

if(transferskipmode.equalsIgnoreCase("Skip")){
	
	
	
comparevalues(SkippedCount,repeatcount,"Repeat/Skip count has updated","Repeat/Skip count has not been updated");
}
else if (transferskipmode.equalsIgnoreCase("Repeat")) {
	
	String skipnumber= Skipcount;   
	skipnumber = skipnumber.replaceAll("[^a-zA-Z0-9]", " ");  

	String skipno =skipnumber.replaceAll("\\s", "");

	verifytextmatches(skipno,repeatcount);


}

break;
}
else {
int c=i+1;
//reportStep("+accno+"+ "  has not  diplaying in this page", "PASS");
reportStep("trying to find account number in another page number", "INFO");
boolean b=VerifyElementpresentreturn(".//ul[@class='pagination']//a[text()='"+c+"']");
if(b){
clickByXpathExplict(".//ul[@class='pagination']//a[text()='"+c+"']");
Thread.sleep(4000);
}
else {
	reportStep("Reference number  has not diplaying in this page", "FAIL");
	break;
}
}
}
	return new OtP_Page(driver, test);

}



}

