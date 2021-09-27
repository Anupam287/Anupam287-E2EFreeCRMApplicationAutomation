package com.crm.qa.Testutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.collections4.FactoryUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.crm.qa.base.BasePage;

public class TestUtil extends BasePage {

	public static long IMPLICIT_TIME_OUT = 20;;
	public static long PAGELOAD_TIME_OUT = 20;
	
	public static XSSFWorkbook book;
	public  static XSSFSheet sheet;
	
	public static String TESTDATA_SHEET_PATH= "E:\\Eclipse-workspace\\Java-Training\\"
			+ "E2EFreeCRMApplicationAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\CrmAutomationTD.xlsx";
	
	

	public void switchtoFrame() {

		driver.switchTo().frame("mainpanel");
	}

	public void switchtodefault() {

		driver.switchTo().defaultContent();
	}

	public static void clickOn(WebDriver driver, WebElement element, int timeout) {

		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	public  void elementClickByJS(WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static Object[][] getTestData()  {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book =new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet("contacts");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//System.out.println(sheet.getLastRowNum() + "--------" +
		//sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				//System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	

}
