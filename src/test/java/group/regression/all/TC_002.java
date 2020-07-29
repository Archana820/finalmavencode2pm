package group.regression.all;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.maven.AprilSeleniumMaven2pm.BaseTestRunThruXML;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC_002 extends BaseTestRunThruXML{
	
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
	  {
		  init();
		  test=report.startTest("TC_002");
		  test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
		  
		  launchBrowser(bType);
		  test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
		  
		  navigateUrl("amazonurl");
		  test.log(LogStatus.PASS, "Navigated to url : " + childInstance.getProperty("amazonurl"));
	  }
  
  @Test(groups = {"regression","sanity"})
  public void amazon() throws Exception 
     {
		selectOption("amazondropbox_id","books");
		test.log(LogStatus.PASS, "Selected the option Books by using the locator :- " + orProp.getProperty("amazondropbox_id"));
		Thread.sleep(3000);
		typeText("amazonsearchtext_id","Harry Potter");//id
		test.log(LogStatus.PASS, "Entered the text Harry potter by using the locator :- " + orProp.getProperty("amzonsearchtext_id"));
		Thread.sleep(3000);
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.PASS, "Clicked on Search Button by using the locator : - " + orProp.getProperty("amazonsearchbutton_xpath"));
		Thread.sleep(3000);
				
	 }
  
  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess()
   {
	  if(driver!=null)
	  driver.quit();
	  if(report!=null)
	  report.endTest(test);
	  report.flush();
   }

}
