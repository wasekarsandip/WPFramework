package com.pixabay.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.pixabay.pages.BaseClass;
import com.pixabay.pages.LoginPage;

public class LoginTestPixabay extends BaseClass {

	@Test
	public void loginApplication() 
	{
		logger=report.createTest("Login Test");
		
		LoginPage login = PageFactory.initElements(driver,LoginPage.class);
		
		login.loginToPixabay(excel.getStingData(0,0,0),excel.getStingData(0,0,1));

	}
}

