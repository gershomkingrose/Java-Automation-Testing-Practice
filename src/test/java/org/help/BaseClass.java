package org.help;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
	public static  WebDriver driver;
	public static  Actions action;

	
	public static void LaunchBrowser() {
     	driver = new ChromeDriver();	 
		}
	public static void OpenApp(String link) {
		driver.get(link);
		}
	public static void MaximaizeWindow() {
		driver.manage().window().maximize();	
		}
	public static void AppTitle() {
		String title = driver.getTitle();	
		System.out.println(title);
		}
	public static void GetUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		}
	public static void SendUserValue(WebElement a,String value) {
		a.sendKeys(value);
		
	}
	
	public static void ClickEvent(WebElement a) {
		a.click();
	}
	public static void Action() {
		 action = new Actions(driver);
			}
	public static void MoveTo(WebElement a) {
      action.moveToElement(a).perform();;
	}
	
	public static String  DataDriven( String link,String s,int r, int c) throws IOException {
	File xl = new File(link);
		
		FileInputStream readinput = new FileInputStream(xl);
		
		Workbook accessxl = new XSSFWorkbook(readinput);
		
		Sheet sheet = accessxl.getSheet(s);
		
		Row row = sheet.getRow(r);
		
        Cell cell = row.getCell(c);
        String value= "";
        
        if(cell.getCellType()==1) {
        	 value = cell.getStringCellValue();
        	System.out.println(value);
        	
        }
        else if(DateUtil.isCellDateFormatted(cell)){
        	Date dateCellValue = cell.getDateCellValue();
       SimpleDateFormat date = new SimpleDateFormat();
        value = date.format(dateCellValue);
       System.out.println(value);
       
        }
        else {
        	double numericCellValue = cell.getNumericCellValue();
        	long l = (long)numericCellValue;
        	 value = String.valueOf(l);
        	System.out.println(value);
        	
        }
        return value;
	}
	
}
