package com.selenium.maven.AprilSeleniumMaven2pm;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManagerRunThruXML extends BaseTestRunThruXML
{
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			Date dt =  new Date();
			String reportFilePath = dt.toString().replace(':', '_').replace(' ', '_')+".html";
			extent = new ExtentReports(projectpath + "//HTMLReports//" + reportFilePath);
			extent.loadConfig(new File(projectpath + "extentreportconfig.xml"));
			extent.addSystemInfo("Selenium Launguage", "3.141.59").addSystemInfo("Instance", parentInstance.getProperty("env"));
		}
		
		
		return extent;
		
	}

}
