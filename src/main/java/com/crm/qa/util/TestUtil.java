package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.testbase.TestBase;

public class TestUtil extends TestBase {
	
	/*public static void main(String[] args)
	{
		DealsData();
					
	}*/

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	static FileInputStream file = null;
	public static Object [][] GetTestData()
	{
		
		try {
			file = new FileInputStream("C:\\Users\\ADMIN\\workspace\\sampleproject\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_Test Data1.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		sheet = book.getSheet("Contacts");
		Object object [][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++ )
		{
			for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++)
			{
				object[i][j] = sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		return object;
	}
	
	public static Object[] DealsData()
	{
	
		try {
			file = new FileInputStream("C:\\Users\\ADMIN\\workspace\\sampleproject\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_Test Data1.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		sheet = book.getSheet("Deals");
		Object object1[] = new Object[sheet.getLastRowNum()];
		for(int k = 0; k < sheet.getLastRowNum(); k++)
		{
			object1[k] = sheet.getRow(k+1).getCell(0).toString();
			System.out.println(object1[k]);
		}
		return object1;
	}
	
	public static void takeScreenshotAtEndOfTest()
	{
		String currentdir = System.getProperty("user.dir"); 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(currentdir+"\\Screeshots\\"+ System.currentTimeMillis()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
