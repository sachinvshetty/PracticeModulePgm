package com.mascamo.dev.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class TestingExcelfile {

	public static XSSFSheet ExcelSheet;
	public static XSSFWorkbook Excelbook;
	public static XSSFCell cell;
	public static XSSFRow row;
	static String file_path = "C:\\Users\\s.nagaraja.setty\\Desktop\\naveen automation labs\\xpath\\TestRead.xlsx";
	static String sheet = "prc";
	public static int lastrownumber ;

	@Test(priority=0)
	public static void setExcel() {

		try {
			FileInputStream fs = new FileInputStream(file_path);
			Excelbook = new XSSFWorkbook(fs);
			ExcelSheet = Excelbook.getSheet(sheet);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority=1)
	public static String getcell(String Sheetname, int row, int column) {
		cell = ExcelSheet.getRow(row).getCell(column);
		String data = cell.getStringCellValue();
		return data;

	}
	@Test(priority=2)
	public static int getlastrownumber(String Sheetname) {
		 lastrownumber =ExcelSheet.getLastRowNum();
		return lastrownumber;

	}

	@Test(priority=2)
	public static  void BaseClass() {
		getlastrownumber(sheet);
		System.out.println(lastrownumber);
		for ( int i=0;i<=lastrownumber;i++) {
			for (int j=0;j<2;j++) {
			String data1=getcell(sheet,i,j);
				System.out.println(data1);
		}
			}
		
	}
}
	
	







