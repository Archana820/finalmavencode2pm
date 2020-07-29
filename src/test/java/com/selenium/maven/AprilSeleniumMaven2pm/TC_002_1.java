package com.selenium.maven.AprilSeleniumMaven2pm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TC_002_1 extends Sel03DriverBaseDynamic{
	@BeforeMethod
	public void startProcess() throws Exception {
		init();
		launchBrowser("chromebrowser");
		navigateUrl("amazonurl");  
	  }
	  @Test
	  public void amazon() throws Exception {
		  selectOption("amazondropbox_id","books");
		  Thread.sleep(3000);
		  typeText("amazonsearchtext_id","Harry Potter");//id
		  Thread.sleep(3000);
		  clickElement("amazonsearchbutton_xpath");
		  Thread.sleep(3000);
			
	  }
	  @AfterMethod
	  public void endProcess() {
		  if(driver!=null)
			  driver.quit();
	  }

}
