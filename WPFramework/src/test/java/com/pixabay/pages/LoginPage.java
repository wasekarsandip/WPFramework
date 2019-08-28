package com.pixabay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;	
	}
	@FindBy(how =How.ID,using="id_username")  WebElement username;
	@FindBy(how=How.ID,using="id_password")  WebElement password;
	@FindBy(how=How.XPATH,using="//input[@value='Log in']") WebElement loginButton;
	
	public void loginToPixabay(String user,String pass) 
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}
}
