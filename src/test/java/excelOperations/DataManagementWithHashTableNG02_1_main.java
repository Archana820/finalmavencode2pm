package excelOperations;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataManagementWithHashTableNG02_1_main 
{
	
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> data) 
  {
	  if(data.get("Runmode").equals("Y"))
		  System.out.println(data.get("Runmode") + " -----" + data.get("Browser") + " ---- " + data.get("UserName") + "----" + data.get("UserPassword"));
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	ExcelAPI_01_Base e = new ExcelAPI_01_Base("C:\\Selenium_Practice_17\\AprilSeleniumMaven2pm\\ExcelData\\SuiteA.xlsx");
	String sheetName = "Data";
	String testCaseName = "LoginTest";
	  
	return DataUtils02_Base_DM_HashTable.getTestData(e,sheetName, testCaseName);   
  }
  
  
}
