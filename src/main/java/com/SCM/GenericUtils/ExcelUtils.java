package com.SCM.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcelUtils {

	/**
	 * this method is use to read the data from excel
	 * @author Prasad
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetName, int row, int cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
	
	/**
	 * This method is used to get total row count
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable 
	{
		FileInputStream fis =new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;	
	}
	
	public void writeDataIntoExcel(String sheetName, int row, int cell, String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		//for writing new data into excel
		//sh.getRow(row).getCell(cell).setCellValue(data);
		//for adding the data into existing file
		FileOutputStream fout= new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fout);
		wb.close();	
	}
	
	public HashMap<String, String> writeMultipleData(String sheetName) throws Throwable
	{
		//JavaUtils jlib = new JavaUtils();
		//if we want to use random number the use above
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
        HashMap<String, String> map = new HashMap<String, String>();   //empty
		
		for (int i = 0; i <=count; i++) {
			
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	public void clearWriteMultipleData(WebDriver driver, String sheetName) throws Throwable
	{
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\AdminRetaildata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i <=count; i++) 
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		for(Entry<String, String> set:map.entrySet())
		{
			WebElement editText = driver.findElement(By.name(set.getKey()));
			editText.clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
		}
	}
	
	public Object[][] getMultiplesetOfData(String sheetName) throws Throwable
	{
		FileInputStream fi= new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowcount = sh.getPhysicalNumberOfRows();
		int cellcount =sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowcount][cellcount];
		
		for (int i = 0; i < rowcount; i++) 
		{
			for (int j = 0; j < cellcount; j++) 
			{
				obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
}
