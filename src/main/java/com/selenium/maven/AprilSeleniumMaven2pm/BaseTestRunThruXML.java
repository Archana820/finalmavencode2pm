package com.selenium.maven.AprilSeleniumMaven2pm;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.selenium.ExtentManager;
//import com.selenium.ExtentReports;
//import com.selenium.ExtentTest;

public class BaseTestRunThruXML {
	
	public static WebDriver driver;
	public static FileInputStream fis;
	public static String projectpath=System.getProperty("user.dir");
	public static Properties p;
	public static Properties parentInstance;
	public static Properties childInstance;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectpath +"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectpath + "//environment.properties");
		parentInstance=new Properties();
		parentInstance.load(fis);
		String e = parentInstance.getProperty("env");
		System.out.println(e);
		
		fis=new FileInputStream(projectpath + "//" + e + ".properties");
		childInstance=new Properties();
		childInstance.load(fis);
		String url = childInstance.getProperty("amazonurl");
		System.out.println(url);
		
		fis=new FileInputStream(projectpath +"//or.properties");
		orProp=new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectpath + "//log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManagerRunThruXML.getInstance();
		
		
	}
	

	public static void launchBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
		 
		 ChromeOptions option = new ChromeOptions();
		 option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		 
		 option.addArguments("--disable-notifications");
		 driver=new ChromeDriver(option);
		 
			
		}else if(browser.equals("firefox"))
		{
		 System.setProperty("webdriver.gecko.driver","C:\\Selenium_chrome_driver_zip\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 
		 //Bellow code is for firefox profile browser
		 ProfilesIni p=new ProfilesIni();
		 FirefoxProfile profile=p.getProfile("juneFFprofilenew");
		 FirefoxOptions option=new FirefoxOptions();
		 option.setProfile(profile);
		 
		 option.addPreference("dom.webnotifications.enabled", false);
		 driver =new FirefoxDriver(option);
		}
			
		}
	
	public static void navigateUrl(String url)
	{
		//driver.get(url);//or
		driver.navigate().to(childInstance.getProperty(url));
	}
	
	/**
	 * @param locatorKey
	 */
	public static WebElement getElement(String locatorKey) {
		
		WebElement element=null;
		
		if(locatorKey.endsWith("_id")){
			element=driver.findElement(By.id(orProp.getProperty(locatorKey)));
			System.out.println(element);
		}else if(locatorKey.endsWith("_name")){
			element=driver.findElement(By.name(orProp.getProperty(locatorKey)));
			System.out.println(element);
		}else if(locatorKey.endsWith("_classname")){
			element=driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")){
			element=driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
			System.out.println(element);
		}else if(locatorKey.endsWith("_css")){
			element=driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")){
			element=driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")){
			element=driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}
		return element;
		
	}
	
	//below 3 locators are for text,dropdown and link or button click
	
	public static void clickElement(String locatorKey) {
		
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(locatorKey)).click();
				
	}


	public static void typeText(String locatorKey, String text) {
		
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.id(locatorKey)).sendKeys(text);
		
	}

	public static void selectOption(String locatorKey, String item) {
		
		getElement(locatorKey).sendKeys(item);
		//getElement(locatorKey).click();
		//driver.findElement(By.id(locatorKey)).sendKeys(item);
		
	}
	//****************************  Verifications  ***************************************
	public static boolean isElementEqual(String expectedLink) {
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
	}
	
	// ***************************  Reportings  ************************************************
	
	
		public static void reportSuccess(String passMsg) 
		{
			test.log(LogStatus.PASS, passMsg);
		}

		public static void reportFailure(String failMsg) throws Exception 
		{
			test.log(LogStatus.FAIL, failMsg);
			takesScreenshot();
		}
		
		public static void takesScreenshot() throws Exception 
		{
			
			Date dt=new Date();
			System.out.println(dt);
			String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrFile, new File(projectpath+"\\failurescreenshots\\"+dateFormat));
			test.log(LogStatus.INFO, "Screenshot --->" +test.addScreenCapture(projectpath+"\\failurescreenshots\\"+dateFormat));   
			
		}

}
