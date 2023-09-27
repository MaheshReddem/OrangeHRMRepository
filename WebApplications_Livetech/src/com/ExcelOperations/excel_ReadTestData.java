package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_ReadTestData {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("./Datafiles/SingleDimentionData.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(file);
		XSSFSheet sheet=workBook.getSheet("Sheet1");
		Row rows=sheet.getRow(1);
		Cell rowOfCellsUserName=rows.getCell(0);
		String userNameTestData=rowOfCellsUserName.getStringCellValue();
		
//		System.out.println(userNameTestData);
		
		Cell rowOfCellsPassword=rows.getCell(1);
		String passwordTestData=rowOfCellsPassword.getStringCellValue();
		
		System.out.println(userNameTestData+" "+passwordTestData);
				
	}

}
