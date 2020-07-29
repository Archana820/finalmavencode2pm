package com.selenium.maven.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateLogin {
	
	WebDriver driver;
 
  @BeforeMethod
  public void startProcess() 
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://automationpractice.com/index.php");
	  }
  
  @Test
  public void CreatePage() throws Exception {
	  
	  CreatAccountPage CreatePage = new CreatAccountPage(driver);
	  CreatePage.createLogin();
	  //Assert.assertEquals(CreatePage.getRegisteredEmail(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
	  CreatePage.personalInfo();
	  
	  
  }
  

  @AfterMethod
  public void afterMethod() {
  }

}
