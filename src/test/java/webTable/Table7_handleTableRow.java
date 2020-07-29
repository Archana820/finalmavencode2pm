package webTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table7_handleTableRow {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> tr_collection = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("table rows" +tr_collection.size());
		for(WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.tagName("td"));
			for(WebElement td_Element : td_collection)
			{
				if(td_Element.getText().contains("Alfreds Futterkiste"))
				System.out.println(td_Element.getText());
			}
		}
		

	}

}
