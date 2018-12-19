package com.SFDC.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SFDC.page.LoginPage;

public class BaseTest extends LoginPage{
	
	@BeforeTest
	public static void DataSheetLoad(String SheetName) throws Exception{
		
		File src = new File("E:\\Selenium\\workspace\\SFDC\\src\\test\\resources\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet(SheetName);
		//Iterator<Column> rowIterator1 = sheet3.iterator();
	}
	
	@Test
	public static void SFDC_Login() throws Exception{
		LoginPage log= new LoginPage();
		log.Login("SFDC_QA_Cred");
	}

}
