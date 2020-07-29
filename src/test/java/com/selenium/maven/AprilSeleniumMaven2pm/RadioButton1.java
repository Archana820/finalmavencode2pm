package com.selenium.maven.AprilSeleniumMaven2pm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class RadioButton1 extends Sel03DriverBaseDynamic
{

	@BeforeMethod
	
	  public void beforeMethod() throws Exception 
	  {
		
		  init();
		  test=report.startTest("RadioButton1");
		  test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
		  
		  launchBrowser("chromebrowser");
		  test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
		  
		  navigateUrl("radiourl");
		  test.log(LogStatus.PASS, "Navigated to url : " + childInstance.getProperty("radiourl"));
	  }
	
	
	@Test
	public void radioButton() throws Exception
	{
		Thread.sleep(3000);
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }
	
}
