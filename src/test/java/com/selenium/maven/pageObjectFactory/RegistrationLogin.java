package com.selenium.maven.pageObjectFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationLogin 
{
	 public WebDriver driver;
  
  @BeforeMethod
  public void startProcess() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://automationpractice.com/index.php");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
  }
  
  @Test(enabled = false)
  public void login() throws Exception 
  {
	  LoginPage login = new LoginPage(driver);
	  login.customerLogin();
	  Assert.assertEquals(login.getCustomerVerification(), "Authentication failed."); 
  }
  
  @Test
  public void custRegistration() throws Exception
  {
	  CustomerRegistrationPage page = new CustomerRegistrationPage(driver);
	  page.customerRegistration();
  }
  
  
  @AfterMethod
  public void endProcess() 
  {
	  
  }

}
