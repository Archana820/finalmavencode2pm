package com.selenium.maven.AprilSeleniumMaven2pm;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LinksTesting1 extends Sel03DriverBaseDynamic
{

	
	@BeforeMethod
	public void setup() throws Exception
	{
		  init();
		  test=report.startTest("LinksTesting1");
		  test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
		  
		  launchBrowser("chromebrowser");
		  test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
		  
		  navigateUrl("linktexturl");
		  test.log(LogStatus.PASS, "Navigated to url : " + childInstance.getProperty("linktexturl"));
	}
	
	
	
	
	@Test()
	public void linktesting1() throws Exception
	
	 {
		String expval="Google Images";
		//String expval="Gmail";
		
		driver.findElement(By.linkText("Images")).click();	
		Thread.sleep(6000);
		Reporter.log("Clicked on Images Link");
		String actval=driver.getTitle();
		System.out.println("actval");
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
