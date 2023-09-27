package com.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CapturingWebTableDataToExcel extends BaseTestTimeAndDate {
	
	
	@Test
	public void capturingWebTableData() throws IOException
	{
		FileInputStream cityNamesDataExcel=new FileInputStream("./Datafiles/CityNamesData.xlsx");
		XSSFWorkbook cityNamesWorkBook=new XSSFWorkbook(cityNamesDataExcel);
		XSSFSheet cityNamesSheet=cityNamesWorkBook.getSheet("Sheet1");
		
		//to capture first row
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		By firstRowFirstCellProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]");
		
		//to go to last cell
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]
		By lastrowLastCellProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[8]");
		
		
		for(int rowIndex=1;rowIndex<=36;rowIndex++)
		{
			//to go to all the rows
			Row newRow=cityNamesSheet.createRow(rowIndex-1);
			
			//to go to every row of all the cells
			for(int rowOfCellIndex=1;rowOfCellIndex<=8;rowOfCellIndex++)
			{
				Cell newRowOfCell=newRow.createCell(rowOfCellIndex-1);
				
				By cityNamesProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td["+rowOfCellIndex+"]");
				WebElement cityNamesText=driver.findElement(cityNamesProperty);
				String cityNames=cityNamesText.getText();
				
				System.out.print(cityNames+" | ");
				
				newRowOfCell.setCellValue(cityNames);
			}
			System.out.println();
			
		FileOutputStream cityNameOutPutData=new FileOutputStream("./Datafiles/CityNamesData.xlsx");
		cityNamesWorkBook.write(cityNameOutPutData);
		cityNameOutPutData.close();
			
			
		}
		
		
	}

}
