package com.pixabay.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider() 
	{
		try {
			File src = new File("./Config/config.properties");
			FileInputStream fis =new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e)
		{
			System.out.println("unable to load config file"+e.getMessage());
		}
	}
	
	public String getDataFromConfig() 
	{
		return pro.getProperty("Firstname");
	}  
	public  String getBrowser() 
	{
		return pro.getProperty("Browser");
	}  
	public String getApplicationUrl() 
	{
		return  pro.getProperty("AplicationUrl");

	}  
}
