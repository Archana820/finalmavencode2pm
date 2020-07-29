package webTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Table2 {

	public static String month;
	public static WebDriver driver;
	static Actions a ; 

		public static void main(String[] args) throws InterruptedException 
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
				ChromeOptions option = new ChromeOptions();
				option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
				option.addArguments("--disable-notifications");
				
				driver=new ChromeDriver(option);
				driver.manage().window().maximize();
				driver.get("https://www.redbus.in/");
				driver.findElement(By.id("onward_cal")).click();
				
				String myDate = "25-Nov 2020";
				String[] strarr = myDate.split("-");
				//String[] strarr=(myDate.split(" ")[0]).split("-");
				String startDate = strarr[0];
				String startMonth = strarr[1];
				
				getMonth(startMonth);
				Thread.sleep(2000);
				getDate(startDate);

			}
			
			public static void getDate(String sDate) 
			{
				List<WebElement> tr_collection = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr"));
				for(WebElement trElement: tr_collection)
				{
					List<WebElement> td_collection = trElement.findElements(By.tagName("td"));
					for( WebElement tdElement : td_collection)
					{
						System.out.println(tdElement.getText());
						if(tdElement.getText().equals(sDate))
							a  = new Actions(driver);
						a.click(tdElement).perform();
					}
				}
				
			}
			
			public static void getMonth(String sMonth)
			{
				month = driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[1]/td[2]")).getText();
				if(!month.equals(sMonth))
					driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[1]/td/button[contains(text(),'>')]")).click();
				
				getMonth(sMonth);	
			}
			
			
		}


