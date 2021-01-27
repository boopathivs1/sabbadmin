package wrappers;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.DataInputProvider;
import utils.Dataproviders;

public class ProjectWrapp extends GenericWrappers{
//browerstack
	public String dataSheetName;
	public static final String USERNAME = "boopathiv2";
	 public static final String AUTOMATE_KEY = "ip9DgQrFVYNDS6g7AzAp";
	 public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	public String browserName;
	
	
	@BeforeSuite(groups={"common"})
	public void beforeSuite() throws IOException{
		//del();
		String os = System.getProperty("os.name").toLowerCase();
		startResult();
	}

	
    
	
	@BeforeTest(groups={"common"})
	public void beforeTest(){
		loadObjects();
	}
/*
@Parameters({"Browser"})
@BeforeMethod(groups={"common"})
public void beforeMethods(String Browser) throws IOException{
	test = startTestCase(testCaseName, testDescription);
			test.assignCategory(category);
			test.assignAuthor(authors);
		invokeApp(Browser);
	
	}	
*/
	
	
	/*
	
	//browserstack
		 
	 @BeforeMethod(groups={"common"})
	 @Parameters({"os","os_version","Browser","Version"})

	 public void openSTM(String os ,String osver, String browser,String version) throws Exception {
	
	//	 public void beforeMethods(String os ,String osver, String browser,String version) throws IOException{
		 	test = startTestCase(testCaseName, testDescription);
		 			test.assignCategory(category);
		 			test.assignAuthor(authors);
		 		
		 			
		 			 DesiredCapabilities capability = new DesiredCapabilities();
		 			 capability.setCapability("os", os);
		 			 capability.setCapability("os_version", osver);
		 			 capability.setCapability("browserstack.selenium_version", "3.141.59");
		 			 capability.setCapability("project", "login");
		 			 capability.setCapability("build", "test");
		 			 //capability.setPlatform(Platform.WIN10);
		 			 capability.setCapability("browser", browser);
		 			 capability.setCapability("browser_version", version);
		 			 capability.setVersion(version);
		 			 capability.setCapability("browserstack.debug", "true");
		 			
		 			 
		 			 
		 			 // Creatng URL object
		 			 URL browserStackUrl = new URL(URL);
		 			 // Create object of driver. We execute scripts remotely. So we use RemoteWebDriver
		 			 //There are many constructors to remotewebdriver
		 			                //To pass URL object and Capabilities object, use the below mentioned constructor
		 			                //RemoteWebDriver(URL remoteAddress, Capabilities desiredCapabilities)
		 			 driver = new RemoteWebDriver (browserStackUrl, capability);
		 			 //Implicit wait for 30 seconds
		 			 // to open url
		 	//		 driver.get("https://www.softwaretestingmaterial.com");

		 			url2=environment+sUrl;
		   			driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
		 			driver.get(url2);
		   			Thread.sleep(4000);
		 			
		   			driver.get(url2);
		   			
		   			Thread.sleep(10000);

		   			driver.get(url2);
//		 			invokeApp(browser);
		 	
		 	}	

	 
	 */
	 	
		@BeforeMethod(groups={"common"})
	public void beforeMethods() throws IOException{
			test = startTestCase(testCaseName, testDescription);
			test.assignCategory(category);
			test.assignAuthor(authors);
		invokeApp(browserName);
		
		loginfoStart(testCaseName, testDescription);


		}
	
		

	@AfterSuite(groups={"common"})
	public void afterSuite() throws Exception{

		endResult();
	
		//zip();
	}

	@AfterTest(groups={"common"})
	public void afterTest(){
		unloadObjects();
	}
	
	
	
	@AfterMethod(groups={"common"})
	public void afterMethod() throws InterruptedException{
		endTestcase();
	closeAllBrowsers();		
	}
	
	
	
	@DataProvider(name="fetch")
	public Object[][] getDataExcel() throws IOException{
	return Dataproviders.geta("./data/"+dataSheetName+".xlsx",testKeyword);	
//		return Dataproviders.geta("./data/"+SheetName+".xlsx",testKeyword);	

		

	}	
	
public void logout(Boolean status,String usertype) throws InterruptedException{
	
	if(status&&usertype.equalsIgnoreCase("CIBUser")){
	Thread.sleep(2000);
	defaultcontent();
	clickByXpathExplict(prop.getProperty("Click.Logout.xpath"));
//doubleclickByXpathExplict(prop.getProperty("Click.Logout.xpath"));	
Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("Click.Logout.yesButton.xpath"));	
	}
else if(status&&usertype.equalsIgnoreCase("CIBAdmin")){
	Thread.sleep(2000);
	defaultcontent();
	clickByXpathExplict(prop.getProperty("cibadmin.logout.profile.xpath"));
//doubleclickByXpathExplict(prop.getProperty("Click.Logout.xpath"));	
Thread.sleep(2000);
	clickByXpathExplict(prop.getProperty("cibadmin.logoutbutton.profile.xpath"));	
	}
	
	
}
	
	
	}