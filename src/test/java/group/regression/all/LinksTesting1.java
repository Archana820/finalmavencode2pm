package group.regression.all;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.maven.AprilSeleniumMaven2pm.BaseTestRunThruXML;

public class LinksTesting1 extends BaseTestRunThruXML
{

	
	@BeforeMethod(groups = {"regression"})
	@Parameters("browser")
	public void setup(String bType) throws Exception
	{
		  init();
		  test=report.startTest("LinksTesting1");
		  test.log(LogStatus.INFO, "Initializing the Properties & configuration files......");
		  
		  launchBrowser(bType);
		  test.log(LogStatus.PASS, "Opened the Browser : " + p.getProperty("chromebrowser"));
		  
		  navigateUrl("linktexturl");
		  test.log(LogStatus.PASS, "Navigated to url : " + childInstance.getProperty("linktexturl"));
	}
	
	
	
	
	@Test(groups = {"regression"})
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
	
	@AfterMethod(groups = {"regression"})
	public void tearDown()
	{
		driver.quit();
	}

}
