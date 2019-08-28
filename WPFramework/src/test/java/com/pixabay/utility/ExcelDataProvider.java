package com.pixabay.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	public 	ExcelDataProvider ()
	{

		try {
			File src=new File("./TestData/Data.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		}
		catch (Exception e)
		{
			System.out.println("unable to load excel file"+e.getMessage());	
		}
	}
	public String getStingData(int sheetIndex,int rowNum ,int columnNum) 
	{
		return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(columnNum).getStringCellValue();
	}
	
	public String getStingData(String sheetName,int rowNum ,int columnNum) 
	{
		return wb.getSheet(sheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
	}
	
	public double getNumericData(int sheetIndex,int rowNum ,int columnNum) 
	{
		return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(columnNum).getNumericCellValue();
	}
}
