package com.selenium.maven.AprilSeleniumMaven2pm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TC_001 {
  @Test
  public void f() {
	  System.out.println("f");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforemethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("aftermethod");
  }

}
