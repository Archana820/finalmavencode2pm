package excelOperations;

public class ExcelOperations_01_1_main 
{

	public static void main(String[] args) throws Exception 
	{
		//ExcelAPI_01_ALL_R_W_Methods e1 = new ExcelAPI_01_ALL_R_W_Methods("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		ExcelAPI_01_Base e1 = new ExcelAPI_01_Base("C:\\Selenium_Practice_17\\AprilSeleniumMaven2pm\\ExcelData\\testdata.xlsx");
		System.out.println(e1.getRowCount("login"));
		
		System.out.println(e1.columnCount("login"));
		
		System.out.println(e1.getCellData("login", 1, 2));
		
		System.out.println(e1.getCellData("login", "UserName", 2));
		
		e1.setCellData("login", 4, 2, "failed");

	}

}
