package com.SFDC.page;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPage {

	public static WebDriver driver=null;

	public void Login(String sheet)throws Exception {
		   
	    System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    /*File src = new File("E:\\Selenium\\workspace\\SFDC\\src\\main\\resources\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);*/
		XSSFSheet sheet1 = wb.getSheet(sheet);
		driver.get("https://test.salesforce.com");
		String username = sheet1.getRow(1).getCell(0).getStringCellValue();
		//System.out.println("Data from sheet" +username);
		driver.findElement(By.id("username")).sendKeys(username);
	    String password = sheet1.getRow(1).getCell(1).getStringCellValue();
	    driver.findElement(By.id("password")).sendKeys(password);
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("//input[@id='Login']")).click();
	    Thread.sleep(10000);
	    	
	    if(driver.findElement(By.xpath("//*[@id='home_Tab']/a")).getText().contains("Home"))
	    {
	    	System.out.println("Login Successful");
	    }
	    else
	    {
	    	Assert.fail("Login unsuccessful");
	    }
	   
	}
	
}
