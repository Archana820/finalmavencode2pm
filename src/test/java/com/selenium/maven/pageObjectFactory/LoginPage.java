package com.selenium.maven.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//locators
		@FindBy(linkText="Sign in") public WebElement signIn;
		@FindBy(id="email") public WebElement customerEmail;
		@FindBy(id="passwd") public WebElement customerPassword;
		@FindBy(xpath="//p[@class='submit']//span[1]") public WebElement submitButton;
		@FindBy(xpath="//li[contains(text(),'Authentication failed.')]") public WebElement loginError;
		
		public LoginPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		public void customerLogin() throws Exception
		{
			signIn.click();
			Thread.sleep(3000);
			customerEmail.sendKeys("1testselenium123@gmail.com");
			customerPassword.sendKeys("password");
			submitButton.click();
		}
		
		public String getCustomerVerification()
		{
			return loginError.getText();
		}
		

	}
