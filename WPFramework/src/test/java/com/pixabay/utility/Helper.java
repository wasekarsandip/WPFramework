package com.pixabay.utility;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	public static String captureScreenshot(WebDriver driver) 
	{
		TakesScreenshot tc=(TakesScreenshot)driver; 
		File src=tc.getScreenshotAs(OutputType.FILE);

		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/pixabay-"+Helper.getCurrentDateTime()+".png";
		try
		{
			File destination = new File(screenshotPath);
			FileHandler.copy(src,destination);
		}
		catch (IOException e) 
		{
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		System.out.println("screenshot capture");
		return screenshotPath;
	}
	public static String getCurrentDateTime() 
	{
		DateFormat customeformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date cureentDate=new Date();
		return customeformat.format(cureentDate);
	}
}
