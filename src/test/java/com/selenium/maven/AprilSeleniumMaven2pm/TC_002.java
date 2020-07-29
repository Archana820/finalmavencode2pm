package com.selenium.maven.AprilSeleniumMaven2pm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TC_002 {
	 @BeforeMethod
	 public void startProcess() {
		  System.out.println("startProcess");
	  }
	  @Test
	  public void amazon() {
		  System.out.println("amazon");
	  }
	  @AfterMethod
	  public void endProcess() {
		  System.out.println("endProcess");
	  }

}
