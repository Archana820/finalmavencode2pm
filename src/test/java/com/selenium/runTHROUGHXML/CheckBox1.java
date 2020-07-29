package com.selenium.runTHROUGHXML;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.maven.AprilSeleniumMaven2pm.BaseTestRunThruXML;

public class CheckBox1 extends BaseTestRunThruXML
{
  

	@BeforeMethod
    @Parameters("browser")
		  public void beforeMethod(String bType) throws Exception 
		  {
			  init();
			  test=report.startTest("CheckBox1");
			  test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
			  
			  launchBrowser(bType);
			  test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
			  
			  navigateUrl("checkboxurl");
			  test.log(LogStatus.PASS, "Navigated to url : " + childInstance.getProperty("checkboxurl"));
			
		  }
	  
	  
	  
	@Test
	public void checkboxTest() throws Exception
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		Thread.sleep(6000);
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			System.out.println(check.get(i).isSelected());
			Thread.sleep(6000);
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	 driver.quit();
  }

}
