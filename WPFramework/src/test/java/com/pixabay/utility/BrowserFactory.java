package com.pixabay.utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public  static WebDriver startApplication(WebDriver driver,String browsername,String applicationUrl) 
	{
		
		if(browsername.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			driver=new ChromeDriver(); 
		}
		
		else if(browsername.equals("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe.exe");
			driver=new FirefoxDriver(); 
		}
		
		else if(browsername.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver","./Driver/IEDriverServer.exe");
			driver=new InternetExplorerDriver(); 
		}
		
		else 
		{
			System.out.println("unable do not support this browser");	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(applicationUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		return driver;
	
	}	
	public static void quitApplication(WebDriver driver) 
	{
		driver.quit();
	}
}
