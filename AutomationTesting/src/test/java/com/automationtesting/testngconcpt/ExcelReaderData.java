package com.automationtesting.testngconcpt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReaderData {
	
@Test
	public void countofRowsCells() throws IOException {
		FileInputStream fi=new FileInputStream("C:\\Users\\User\\Desktop\\Testdata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sh=workbook.getSheet("logindata");
		int rowcount=sh.getLastRowNum();
		short cellvalue =sh.getRow(1).getLastCellNum();
		System.out.println("Row count is"+ rowcount);
		System.out.println("Cloumn count is"+ cellvalue);
}
@Test
public void ReadexcelData() throws IOException {
	FileInputStream fi=new FileInputStream("C:\\Users\\User\\Desktop\\Testdata.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet sh=wb.getSheet("logindata");
	String username= sh.getRow(2).getCell(0).getStringCellValue();
	String password= sh.getRow(2).getCell(1).getStringCellValue();
	System.out.println("usrname is::"+username);
	System.out.println("pasword is::"+password);
}




}


