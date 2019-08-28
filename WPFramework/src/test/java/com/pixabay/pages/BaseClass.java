package com.pixabay.pages;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pixabay.utility.BrowserFactory;
import com.pixabay.utility.ConfigDataProvider;
import com.pixabay.utility.ExcelDataProvider;
import com.pixabay.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ConfigDataProvider config;
	public ExcelDataProvider excel;
	public ExtentTest logger;
	public ExtentReports report;


	@BeforeSuite
	public void setUpSuite() 
	{
		config=new ConfigDataProvider();
		excel=new ExcelDataProvider();

		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/pixabay"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getApplicationUrl());
		System.out.println("Title is "+driver.getTitle());
		System.out.println("my first name is "+config.getDataFromConfig());
	}

	@AfterClass
	public void tearDown() 
	{
		BrowserFactory.quitApplication(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			logger.fail("Test fail",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());	
		System.out.println("Login Test FAILURE");
		}
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.pass("Test pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			System.out.println("Login Test SUCCESS");

		}
		else if(result.getStatus()==ITestResult.SKIP) 
		{
			logger.skip("Test skip",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());	
			System.out.println("Login Test SKIP");

		}
		report.flush();
		Reporter.log("Test completed and Report generated",true);
	}
}
