package excelOperations;

public class DataManagement 
{

	public static void main(String[] args) throws Exception
	{
		//ExcelAPI_01_Base e = new ExcelAPI_01_Base("C:\\Users\\DELL\\Desktop\\SuiteA.xlsx");
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
		int col = 0;
		while(!e.getCellData(sheetName, col, colStartRowNum).equals(""))
		{
			col++;
		}
		System.out.println("Total columns Count is : "+ col);

		
		//Read the data
		for(int rNum= dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			for(int cNum=0;cNum<col;cNum++)
			{
				System.out.println(e.getCellData(sheetName, cNum, rNum));
			}
		}
		
	}

}
