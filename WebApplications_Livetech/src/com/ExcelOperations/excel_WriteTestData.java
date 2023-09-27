package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_WriteTestData {
	
	public static void main(String[] args) throws IOException {
		
		 FileInputStream file=new FileInputStream("./Datafiles/SingleDimentionData.xlsx");
		 XSSFWorkbook workBook=new XSSFWorkbook(file);
		 XSSFSheet sheet=workBook.getSheet("Sheet1");
		 Row row=sheet.createRow(0);
		 Cell rowOfCellHeading_userName=row.createCell(0);
		 rowOfCellHeading_userName.setCellValue("UserName");
		 Cell rowOfCellHeading_Password=row.createCell(1);
		 rowOfCellHeading_Password.setCellValue("Password");
		 
		 Row rowTestData=sheet.createRow(1);
		 Cell rowOfCell_UserName_TestData=rowTestData.createCell(0);
		 rowOfCell_UserName_TestData.setCellValue("Mahesh20");
		 
		 Cell rowOfCell_Password_TestData=rowTestData.createCell(1);
		 rowOfCell_Password_TestData.setCellValue("Mahesh@20");
		 
		 FileOutputStream outputstream=new FileOutputStream("./Datafiles/SingleDimentionData.xlsx");
		 workBook.write(outputstream);
		 outputstream.close();
		 
		 System.out.println(" File created successfully ");
		 
		
		
		
		
	}

}
