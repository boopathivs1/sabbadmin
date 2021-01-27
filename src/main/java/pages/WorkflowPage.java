package pages;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.DataLine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class WorkflowPage extends ProjectWrapp{
	public  WorkflowPage (RemoteWebDriver driver, ExtentTest test){
	this.driver = driver;
		this.test = test;
	//	if(!verifyTitle("Corporate Customer Banking  ")){
		//	reportStep("This is not Corporate Customer Banking", "FAIL");
	//	}
	}
	public RequestsStatus RequestoptionsFromDateline() throws InterruptedException{
		clickByXpathExplict("(.//nav[@class='singlelist']//li/a)[5]");
return new RequestsStatus(driver, test);
	}
	
	
	
	public WorkflowPage defaultContentFrame(){
		defaultcontent();
	
		return this;
	}
	
	
	public WorkflowPage clickRejectReasonMenu() throws InterruptedException{
		
		Thread.sleep(4000);

		clickByXpathExplict(prop.getProperty("click.reject.xpath"));

		
		return this;
	}
	
	public WorkflowPage createRejectReason(String Rejectcode,String Rejectdesc) throws InterruptedException{
		locateFrame("icanvas");

		clickByXpathExplict(prop.getProperty("click.create.dateline,reject.xpath"));
		enterByXpathExplict(prop.getProperty("enter.reject.code.xpath"),Rejectcode);
		enterByXpathExplict(prop.getProperty("enter.reject.desc.xpath"),Rejectdesc);	
		clickByXpathExplict(prop.getProperty("click.create.button.xpath"));
	
defaultcontent();
		
			return this;
		}

	
	public WorkflowPage filterRejectReason(String status,String searchenable,String searchKeyword) throws InterruptedException{
		locateFrame("icanvas");

		dropdownSelection(prop.getProperty("select.usersearch.xpath"),"Code");
		dropdownSelection(prop.getProperty("select.usersearchStatus.xpath"),status);
		if(searchenable.equalsIgnoreCase("true")){
		enterByXpathExplict(prop.getProperty("enter.inputsearchkeyword.xpath"),searchKeyword);
		}
		
		

		clickByXpathExplict(prop.getProperty("click.filter.bankusers.search.xpath"));
		
			return this;
		}
	
	public WorkflowPage verifyCreatedRejectReason(String Rejectcode) throws InterruptedException{
	
		clickByXpathExplict("(.//h4[text()='"+Rejectcode+"']//following::button)[1]");
		
	return this;
	}	
	
	
	public WorkflowPage editRejectreason(String description) throws InterruptedException{
	

		enterByXpathExplict(prop.getProperty("enter.reject.desc.xpath"),description);	
		clickByXpathExplict(prop.getProperty("click.reason.Update.xpath"));
defaultcontent();
return this;
		}
	
	public WorkflowPage DeleteRejectreason() throws InterruptedException{
			
		clickByXpathExplict(prop.getProperty("click.reason.delete.xpath"));
		clickByXpathExplict(prop.getProperty("click.reason.yes.xpath"));
defaultcontent();
return this;
		}
	
	
	
public WorkflowPage deleteRejectReason(String xpath,String validmsg,String errormsg){
	
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
	
	
	public SaabCorporateRequestPage  clicksaabCorporateRequestPage(){
		defaultcontent();
		
		clickByXpathExplict(prop.getProperty("click.saabCorporate.AdminRequest.page.xpath"));

		return new SaabCorporateRequestPage(driver, test);
		}
	
	
	
	
	public SummaryPage clickSummaryMenu() throws InterruptedException{
	
		Thread.sleep(4000);

		clickByXpathExplict(prop.getProperty("Click.Menu.summary.xpath"));

		
		return new SummaryPage(driver, test);
	}
	
	public DetailPage clickDetailMenu(){

		clickByXpathExplict(prop.getProperty("Click.Menu.Details.xpath"));
		return new DetailPage(driver, test);
	}	
	
	
	
	public StatementPage clickStatementMenu() throws InterruptedException{
		Thread.sleep(4000);
		clickByXpathExplict(prop.getProperty("Click.Menu.Statement.xpath"));
		return new StatementPage(driver, test);
	}	

		
	
	
	
	
	
	
	
	public WorkflowPage clickFilterButton(String FilterStatus) throws InterruptedException{
		locateFrame("icanvas");
		
		//FilterVerification(prop.getProperty("Click.RequestType.Value.Xpath"),prop.getProperty("Click.RequestStatus.Value.Xpath"),"DT-25941578","Accepted"); 
	clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
	clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestType.Value.Xpath"));	
		clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
clickByXpathExplict(prop.getProperty("Click.RequestStatus.Value.Xpath"));
		
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
	verifyTextByXpath(prop.getProperty("Filter.First.status.verifyxpath"),FilterStatus);
	//verifyTextMatchlistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),FilterStatus);
//  pageScroll400();
		verifyTextcontainslistByXpath(prop.getProperty("Filter.DepositReferno.xpath"),"DT-25973937");	
	verifyTextcontainslistByXpath(prop.getProperty("Filter.Requestnumber.Status.xpath"),"DT-25959228");	
		defaultcontent();
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public WorkflowPage clickFilterAuthorizeButton(String FilterStatus) throws InterruptedException{
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestType.Value.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestStatusPending.Value.Xpath"));
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
	List<String>refno=new ArrayList<>();
	List<WebElement>a=driver.findElements(By.xpath(".//ul[contains(@class,'dateline')]//a[contains(@class,'dtln-info')]"));

	//List<WebElement>a=driver.findElements(By.xpath(".//div[@class='row']/a"));
	for(int i=0;i<a.size();i++){
		String reference=a.get(i).getAttribute("onclick");
	

	refno.add(reference);
	}
	
	Thread.sleep(6000);
	for(int i=0;i<a.size();i++){
String onclickvalue=a.get(i).getAttribute("onclick");
			if(onclickvalue.contains("6999835")){


				int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
enterByXpathExplict(".//textarea[@id='comment']", "just testing");
enterByXpathExplict(".//input[@id='txtOTP']", "777777");
clickByXpathExplict(".//button[@id='btn2FAValidate']");				
			
			}
			
		}
		
		defaultcontent();
		return this;
	
	}
	
	
	public WorkflowPage clickFilterAuthorizeButtonReferencenum() throws InterruptedException{
		locateFrame("icanvas");
		clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestType.Value.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
		clickByXpathExplict(prop.getProperty("Click.RequestStatusPending.Value.Xpath"));
		clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
	//List<String>refno=new ArrayList<>();
		Thread.sleep(8000);
		verifyTextcontainslistByXpath(prop.getProperty("Filter.DepositReferno.xpath"),getrefnumer);
		
		List<String>a1=new ArrayList<String>();
		WebDriverWait wait= new WebDriverWait(driver, 30);
		List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
Thread.sleep(8000);
		for (WebElement webElement : element) {
		String cate=webElement.getText();

		a1.add(cate);
	}	


	for(int i=0;i<element.size();i++){
		Thread.sleep(4000);		
		String refnumber=element.get(i).getText();
			if(refnumber.contains(getrefnumer)){
			
		int j=i+1;
				clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
		enterByXpathExplict(".//textarea[@id='comment']", "just testing");
		enterByXpathExplict(".//input[@id='txtOTP']", "777777");
		clickByXpathExplict(".//button[@id='btn2FAValidate']");				
	break;
		}
			
	}
			

		defaultcontent();
return this;
	
	}

	
	
	
	
	
public WorkflowPage	acceptStatusVerify() throws InterruptedException{
	Thread.sleep(25000);
	clickByXpathExplict(prop.getProperty("click.Filter.xpath"));

	clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
	clickByXpathExplict(prop.getProperty("Click.RequestType.Value.Xpath"));
	clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
	clickByXpathExplict(prop.getProperty("Click.RequestStatus.Value.Xpath"));
	clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
verifyTextByXpath(prop.getProperty("Filter.First.status.verifyxpath"),"Accepted");
	verifyTextMatchlistByXpath(prop.getProperty("Filter.status.checkingAccepted.Status.xpath"),"Accepted");
pageScroll400();
	verifyTextcontainslistByXpath(prop.getProperty("Filter.DepositReferno.xpath"),getrefnumer);	
//verifyTextcontainslistByXpath(prop.getProperty("Filter.Requestnumber.Status.xpath"),"DT-25573937");	
	defaultcontent();
return this;
}
	
public WorkflowPage datelineAuthorizeReferencenum() throws InterruptedException{
	locateFrame("icanvas");
	clickByXpathExplict(prop.getProperty("click.Filter.xpath"));
	clickByXpathExplict(prop.getProperty("Click.RequestType.Xpath"));
	clickByXpathExplict(prop.getProperty("Click.RequestType.Value.Xpath"));
	clickByXpathExplict(prop.getProperty("Click.RequestStatus.Xpath"));
	clickByXpathExplict(prop.getProperty("Click.RequestStatusPending.Value.Xpath"));
	clickByXpathExplict(prop.getProperty("Filter.button.xpath"));
//List<String>refno=new ArrayList<>();
	Thread.sleep(8000);
	verifyTextcontainslistByXpath(prop.getProperty("Filter.DepositReferno.xpath"),getrefnumer);
	
	List<String>a1=new ArrayList<String>();
	WebDriverWait wait= new WebDriverWait(driver, 30);
	List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
Thread.sleep(8000);
	for (WebElement webElement : element) {
	String cate=webElement.getText();

	a1.add(cate);
}	


for(int i=0;i<element.size();i++){
	
	String refnumber=element.get(i).getText();
		if(refnumber.contains(getrefnumer)){
		
	int j=i+1;
			clickByXpathExplict("(.//a[text()='Authorize'])["+j+"]");				
	enterByXpathExplict(".//textarea[@id='comment']", "just testing");
	enterByXpathExplict(".//input[@id='txtOTP']", "777777");
	clickByXpathExplict(".//button[@id='btn2FAValidate']");				
break;
	}
		
}
		

return this;

}
	
	
	
	



public RequestsStatus AuthorizeReferencenum(String datelineReqType) throws InterruptedException{
locateFrame("icanvas");
//.//li[contains(text(),'New Deposit Request')]
//FilterVerification(prop.getProperty("Click.RequestType.Value.Xpath"),prop.getProperty("Click.RequestStatusPending.Value.Xpath"),getrefnumer,"Pending"); 

FilterVerification(datelineReqType,prop.getProperty("Click.RequestStatusPending.Value.Xpath"),"20200509T235154735","Pending"); 

List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
Thread.sleep(8000);
for (WebElement webElement : element) {
String cate=webElement.getText();

a1.add(cate);
}	


for(int i=0;i<element.size();i++){

String refnumber=element.get(i).getText();
	if(refnumber.contains("20200509T235154735")){
	
int j=i+1;
		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		Thread.sleep(15000);
		
		clickByXpathExplict(".//div[@id='autorization']//a[text()='Authorize']");	
		Thread.sleep(15000);

		enterByXpathExplict(".//textarea[@id='comment']", "just testing");
enterByXpathExplict(".//input[@id='txtOTP']", "777777");
clickByXpathExplict(".//button[@id='btn2FAValidate']");
Thread.sleep(15000);



FilterVerification(datelineReqType,prop.getProperty("Click.RequestStatus.Value.Xpath"),"SR-20200509T235154735","Accepted"); 


defaultcontent();


break;
}
	
}
	

return new RequestsStatus(driver, test);

}


public RequestsStatus verifyBuzz(String Requesttypevalue,String auth1,String auth2) throws Exception{
locateFrame("icanvas");

FilterVerification(Requesttypevalue,prop.getProperty("Click.RequestStatusPending.Value.Xpath"),getrefnumer,"Pending"); 


List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
Thread.sleep(8000);
for (WebElement webElement : element) {
String cate=webElement.getText();

a1.add(cate);
}	


for(int i=0;i<element.size();i++){

String refnumber=element.get(i).getText();
	if(refnumber.contains(getrefnumer)){
	
int j=i+1;
		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		Thread.sleep(10000);

	}}



clickByXpathExplict(prop.getProperty("click.viewhistory.xpath"));

pageScroll1400(prop.getProperty("click.buzzz.xpath"));




//verifyTextcontainslistandSetuserid(".//li[@class='list-group-item']/span",uName);


//selectedElementClick(".//li[@class='list-group-item']/span",".//a[text()='Buzz!']","sridhar05");

String userid1= auth1;
String userid2= auth2;


userid1 = userid1.replaceAll("[^a-zA-Z0-9]", " ");  
userid2 = userid2.replaceAll("[^a-zA-Z0-9]", " ");  


String userauth1 = userid1 .replaceAll("\\s", "");
String userauth2 = userid1 .replaceAll("\\s", "");


if(VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+userauth1+"']//a")){
	
	AuthUsername=userauth1;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+userauth1+"']//a");
}else if (VerifyElementpresentreturn(".//li[@class='list-group-item'][@title='"+userauth2+"']//a")) {

	AuthUsername=userauth2;
	clickByXpathExplict(".//li[@class='list-group-item'][@title='"+userauth2+"']//a");
}else{
	reportStep("Buzz value has not matched", "FAIL");
}



defaultcontent();
return new RequestsStatus(driver, test);
}
















public RequestsStatus AuthorizeReferenceno(String Requesttypevalue) throws InterruptedException{
locateFrame("icanvas");



FilterVerification(Requesttypevalue,prop.getProperty("Click.RequestStatusPending.Value.Xpath"),getrefnumer,"Pending"); 

List<String>a1=new ArrayList<String>();
WebDriverWait wait= new WebDriverWait(driver, 60);
Thread.sleep(3000);
List <WebElement>  element=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[contains(@class,'text-right')]//span[contains(@class,'text-info')]")));
Thread.sleep(8000);
for (WebElement webElement : element) {
String cate=webElement.getText();

a1.add(cate);
}	

for(int i=0;i<element.size();i++){

String refnumber=element.get(i).getText();
	if(refnumber.contains(getrefnumer)){
	
int j=i+1;
		clickByXpathExplict("(.//a[contains(@class,'dtln-info')]//h5[@class='dtln-title'])["+j+"]");
		Thread.sleep(10000);
		
		clickByXpathExplict(prop.getProperty("Click.authorize.button.xpath"));	
	//	Thread.sleep(4000);

		enterByXpathExplict(prop.getProperty("enter.comment.xpath"), "just testing");
enterByXpathExplict(prop.getProperty("enter.new.otp.xpath"), "777777");
clickByXpathExplict(prop.getProperty("click.submit.buttonotp.xpath"));
Thread.sleep(20000);



FilterVerification(Requesttypevalue,prop.getProperty("Click.RequestStatus.Value.Xpath"),getrefnumer,"Accepted"); 


defaultcontent();


break;
}
	
}
	

return new RequestsStatus(driver, test);

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
	
	
	
	

