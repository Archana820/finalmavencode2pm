package com.selenium.frames.switching;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameSwitching {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_chrome_driver_zip\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> list=driver.findElements(By.tagName("frame"));
		System.out.println(list.size());
		driver.switchTo().frame(driver.findElement(By.name("packageListFrame")));
		
//		driver.switchTo().frame(0);
//		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.name("packageFrame")));
//		driver.findElement(By.xpath("//span[contains(text(),'Selenium')]")).click();
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.name("classFrame")));
//		driver.findElement(By.xpath("//a[contains(text(),'DefaultSelenium')]")).click();

	}

}
