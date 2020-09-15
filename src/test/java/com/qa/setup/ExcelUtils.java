package com.qa.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static Object[][] readExcelData(String sheetname) throws IOException
	{
		String dir = System.getProperty("user.dir");
		String path = dir + File.separator + "customer_registration.xlsx";
		FileInputStream fis = new FileInputStream(path);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetname);
		Object [][] readdata = new Object [1][6];
		for(int i = 0; i<1;i++)
		{
			XSSFRow row = sh.getRow(i + 1);
			for(int j =0;j<6;j++)
			{
				XSSFCell cell = row.getCell(j);
				DataFormatter df = new DataFormatter();
				readdata[i][j] = df.formatCellValue(cell);
				System.out.println(readdata[i][j] + " " );
			
		}
		
		
	}
		
		return readdata;
	}
}
	

