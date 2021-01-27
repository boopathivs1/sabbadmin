package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrapp;

public class SabbLoginPage extends ProjectWrapp{
	public  SabbLoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
public SabbLoginPage enterPassword(String Password){
		enterByXpathExplict(prop.getProperty("Enter.Password.xpath"),Password);
		return this;
	}
	
	public SabbLoginPage clickSecureimage() throws InterruptedException{
		Thread.sleep(2000);
		clickByXpathExplict(prop.getProperty("Click.Secureimagesecoption.xpath"));
		return this;
	}
	public OtP_Page clickLoginButtonFinal() throws InterruptedException{
		
		
		clickByXpathwait(prop.getProperty("Click.loginButtonFinal.xpath"));

		Boolean a=VerifyElementpresentreturn(prop.getProperty("Enter.token.xpath"));

		if(!a){
			Boolean b=VerifyElementWARNreturn(prop.getProperty("previos.session.verify.xpath"));
			LogoutbooleanResult(b, "Your Previous Session is still active. Try after 5 minutes");	
		}
		
		
		Thread.sleep(3000);
		
		return new OtP_Page(driver,test);
	}
	
		
	public SabbLoginPage clickLoginButtonFail(){
		clickByXpathExplict(prop.getProperty("Click.loginButtonFinal.xpath"));
		return this;
	}		
		
			
	
	
	
			
			

}
