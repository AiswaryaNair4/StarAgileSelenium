package com.OHRM.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class ReadFromExcel {
	
	public XSSFWorkbook wb;
	@DataProvider(name="excelData")
	
	//Function to read the test data values
	public Object[][] readTestData() {
		
		//Path of test data
		String path = System.getProperty("user.dir")+"//TestData//LoginData.xlsx";
		
		File f1 = new File(path);
		FileInputStream fs;
		Object data[][] = null;
		
		try {
			fs = new FileInputStream(f1);
			wb = new XSSFWorkbook(fs);
			
			//Number of Rows
			int rows = wb.getSheet("login").getPhysicalNumberOfRows();
			//Number of Columns
			int cells = wb.getSheet("login").getRow(0).getPhysicalNumberOfCells();
			
			//Creating array of same size as test data
			data = new Object[rows-1][cells];
			
			//Read data from test data
			for(int i = 1; i<rows; i++) {
				
				for(int j = 0; j<cells; j++) {
						data[i-1][j] = wb.getSheet("login").getRow(i).getCell(j).getStringCellValue();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}

}
