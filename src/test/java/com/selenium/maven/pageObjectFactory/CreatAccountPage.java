package com.selenium.maven.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatAccountPage {
	
	//Locator
	@FindBy(linkText="Sign in") public WebElement signIn;
	@FindBy(id="email_create") public WebElement createEmail;
	@FindBy(xpath="//*[@id=\"SubmitCreate\"]/span") public WebElement submitCreate;
	//@FindBy(xpath="//*[@id=\"create_account_error\"]/ol/li") public WebElement errorMsg;
	
	@FindBy(name="id_gender") public WebElement gender;
	@FindBy(id="customer_firstname") public WebElement firstname;
	@FindBy(id="customer_lastname") public WebElement lastname;
	@FindBy(id="email") public WebElement custEmail;
	@FindBy(id="passwd") public WebElement custPassword;
	@FindBy(id="address1") public WebElement address;
	@FindBy(id="city") public WebElement city;
	@FindBy(id="id_state") public WebElement state;
	@FindBy(id="postcode") public WebElement postcode;
	@FindBy(id="id_country") public WebElement country;
	@FindBy(id="phone_mobile") public WebElement mobile;
	@FindBy(id="alias") public WebElement addressAlias;
	@FindBy(xpath="//*[@id=\"submitAccount\"]/span") public WebElement registerButton;
	
	
	
	public CreatAccountPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void createLogin() throws Exception
	{
		signIn.click();
		Thread.sleep(3000);
		createEmail.sendKeys("14testselenium123@gmail.com");
		submitCreate.click();
		Thread.sleep(3000);
				
	}
	
	public void personalInfo() throws Exception
	{
		gender.click();
		Thread.sleep(3000);
		firstname.sendKeys("test");
		lastname.sendKeys("selenium");
		custEmail.sendKeys("");
		//Thread.sleep(3000);
		custPassword.sendKeys("password");
		address.sendKeys("city center");
		city.sendKeys("city111");
		state.sendKeys("Alaska");
		postcode.sendKeys("12345");
		country.sendKeys("United States");
		mobile.sendKeys("098989898");
		Thread.sleep(3000);
		addressAlias.sendKeys(" new city");
		//Thread.sleep(3000);
		registerButton.click();
	}
	
//	public String getRegisteredEmail()
//	{
//		return errorMsg.getText();
//	}

}
