package com.selenium.maven.AprilSeleniumMaven2pm;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TC_002_2_extentReport extends Sel03DriverBaseDynamic{
	@BeforeMethod
	public void startProcess() throws Exception {
		init();
		test = report.startTest("TC_002_2_extentReport");
		test.log(LogStatus.INFO, "Initilizing Properties files....");
		launchBrowser("chromebrowser");
		test.log(LogStatus.PASS, "Launched the browser : - " + p.getProperty("chromebrowser"));
		navigateUrl("amazonurl"); 
		test.log(LogStatus.FAIL, "Navigated to url : - " + childInstance.getProperty("amazonurl"));
	  }
	  @Test
	  public void amazon() throws Exception {
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
	  @AfterMethod
	  public void endProcess() {
		  if(driver!=null)
			  driver.quit();
		  if(report!=null)
		  report.endTest(test);
		  report.flush();
	  }

}
