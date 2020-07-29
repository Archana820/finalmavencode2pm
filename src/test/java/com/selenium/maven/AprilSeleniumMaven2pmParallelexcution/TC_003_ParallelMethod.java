package com.selenium.maven.AprilSeleniumMaven2pmParallelexcution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

//create TestNG class and convert them

public class TC_003_ParallelMethod {
	
	WebDriver driver; 
  @Test
  public void test1() throws Exception 
  {
	  System.out.println("I am inside test1..." + Thread.currentThread().getId());
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  driver.quit();
  }
  @Test
  public void test2() throws Exception 
  {
	  System.out.println("I am inside test2..." + Thread.currentThread().getId());
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.bestbuy.com");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  driver.quit();
  }
  
//  @Test
//  public void test3() throws Exception 
//  {
//	  System.out.println("I am inside test3..." + Thread.currentThread().getId());
//	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
//	  driver = new ChromeDriver();
//	  driver.get("https://www.google.com");
//	  driver.manage().window().maximize();
//	  Thread.sleep(3000);
//	  driver.quit();
//  }
  
//  @AfterClass
//  public void close()
//  {
//  driver.quit();
//  }
   
}
