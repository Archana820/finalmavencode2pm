package excelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataByColoumnName {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("C:\\Selenium_Practice_17\\AprilSeleniumMaven2pm\\ExcelData\\testdata.xlsx");
		FileOutputStream fos=null;
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("login");
		XSSFRow row=sheet.getRow(0);
		XSSFCell cell=null;
        
		int colnum=-1;
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("Result"))
			colnum++;
		}
		
		row=sheet.getRow(4);
		cell=row.getCell(colnum);
		//cell=row.getCell(4);//set value for column and comment for loop
		cell.setCellValue("User3");
		
		fos=new FileOutputStream("C:\\Selenium_Practice_17\\AprilSeleniumMaven2pm\\ExcelData\\testdata.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
