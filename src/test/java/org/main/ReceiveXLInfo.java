package org.main;

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

import io.opentelemetry.sdk.metrics.data.Data;

public class ReceiveXLInfo {
	
	public static void main(String[] args) throws IOException {
		
		File xl = new File("C:\\Users\\Win11\\eclipse-workspace\\Testing\\xl sheet\\demo.xlsx");
		
		FileInputStream readinput = new FileInputStream(xl);
		
		Workbook accessxl = new XSSFWorkbook(readinput);
		
		Sheet sheet = accessxl.getSheet("sheet1");
		
		Row row = sheet.getRow(1);
		
        Cell cell = row.getCell(3);
        
        if(cell.getCellType()==1) {
        	String stringCellValue = cell.getStringCellValue();
        	System.out.println(stringCellValue);
        	
        }
        else if(DateUtil.isCellDateFormatted(cell)){
        	Date dateCellValue = cell.getDateCellValue();
       SimpleDateFormat date = new SimpleDateFormat();
       String format = date.format(dateCellValue);
       System.out.println(format);
       
        }
        else {
        	double numericCellValue = cell.getNumericCellValue();
        	long l = (long)numericCellValue;
        	String valueOf = String.valueOf(l);
        	System.out.println(valueOf);
        	
        }
        
        
        
//        System.out.println(cell);
//        
//        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
//		System.out.println("Number of Rows in xl - > " + physicalNumberOfRows);
//		
//		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
//		System.out.println("Number of Cells in xl - > "+ physicalNumberOfCells);
	}
	
	
	
}
