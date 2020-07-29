package com.selenium.maven.AprilSeleniumMaven2pmListenerInterface;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.selenium.maven.AprilSeleniumMaven2pm.Sel03DriverBaseDynamic;

public class ListenersInterface extends Sel03DriverBaseDynamic implements ITestListener{

	@Override
	public void onTestStart(ITestResult arg0) 
	{
		Reporter.log("Test started Running:" + arg0.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult obj1) 
	{
		if(obj1.isSuccess())
		{
			try 
			{
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File(projectpath+"//success//"+filePath+".png"));
			
				Reporter.log("<a href='" + projectpath+"//success//"+filePath+".png" + "'> <img src='" + projectpath+"//success//"+filePath+".png" + "' height='100' width='100'/> </a>");
				Reporter.log("Test has Success:" + obj1.getMethod().getMethodName());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		if(!result.isSuccess())
		{
			try 
			{
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File(projectpath+"//failure//"+filePath+".png"));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			Reporter.log("<a href='" + projectpath+"//failure//"+filePath+".png" + "'> <img src='" + projectpath+"//failure//"+filePath+".png" + "' height='100' width='100'/> </a>");
			Reporter.log("Test has Failed:" + result.getMethod().getMethodName());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Test is skipped:" + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
