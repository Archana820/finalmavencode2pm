package com.selenium.maven.AprilSeleniumMaven2pm;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert extends BaseTestRunThruXML {
  @BeforeMethod
  @Parameters("browser")
	public void beforeMethod(String bType) throws Exception 
	{
		init();
		launchBrowser(bType);
		navigateUrl("amazonurl");
	}
	
	@Test
	public void test()
	{
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String expectedLink = "Customer Servic";
		//1..//hard assert
		//Assert.assertEquals(actualLink, expectedLink);//OR
		//Assert.assertTrue(actualLink.equals(expectedLink), "Both links are not equal..");
		
		//2......//soft assert
		SoftAssert s = new SoftAssert();
		//s.assertEquals(actualLink, expectedLink);//OR
		s.assertTrue(expectedLink.equals(actualLink), "Both links are not equal...");


    	s.assertTrue(true, "error1");
		
		s.assertTrue(false, "error2");
		
		//due to below hard assert i cant continue below other soft assert->s.assertTrue(true, "error3");
		Assert.assertEquals(actualLink, expectedLink);
		
		s.assertTrue(true, "error3");
		
		s.assertTrue(false, "error4");
		
		driver.findElement(By.linkText("Customer Service")).click();
		//with 2nd condition or soft assert below line will execute
		s.assertAll();
		
	}
}
