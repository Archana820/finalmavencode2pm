package excelOperations;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataManagementWithDataProvidersNG {
	
	//this testng class will fail and show "Data provider mismatch".to overcome from data provider we can 
	//try datamanagementwithhashtable
  
	 @Test(dataProvider = "getData")
	  public void f(String Runmode, String Col1, String Col2, String Col3) 
	  {
		  
	  }

	  @DataProvider
	  public Object[][] getData() throws Exception 
	  {
		  
		    ExcelAPI_01_Base e = new ExcelAPI_01_Base("C:\\Selenium_Practice_17\\AprilSeleniumMaven2pm\\ExcelData\\SuiteA.xlsx");
			String sheetName = "Data";
			String testCaseName = "LoginTest";
			
			int testStartRowNum=0;
			while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
			{
				testStartRowNum++;
			}
			System.out.println("Test Start from row :- " + testStartRowNum);
			
			int colStartRowNum = testStartRowNum + 1;
			int dataStartRowNum = testStartRowNum + 2;
			
			
			//calculate row of Data
			int rows = 0;
			while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
			{
				rows++;
			}
			System.out.println("Total rows are :- " + rows);
			
			
			//calculate columns count
			int cols = 0;
			while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
			{
				cols++;
			}
			System.out.println("Total columns Count is : "+ cols);

			
			//Read the data
			int dataRow=0;
			Object[][] data= new Object[rows][cols];
			
			for(int rNum= dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
			{
				for(int cNum=0;cNum<cols;cNum++)
				{
					//System.out.println(e.getCellData(sheetName, cNum, rNum));
					data[dataRow][cNum]=e.getCellData(sheetName, cNum, rNum);
				}
				dataRow++;
			}
		  
		return data;
	  }
	  
	  
	}

