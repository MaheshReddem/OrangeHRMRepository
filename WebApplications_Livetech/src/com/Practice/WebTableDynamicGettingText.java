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

import com.Practice.BaseTestTimeAndDate;

public class WebTableDynamicGettingText extends BaseTestTimeAndDate {
	
	@Test
	public void webTableDynamicGettingText() throws IOException
	{
//		FileInputStream cityNamesDataExcel=new FileInputStream("./Datafiles/CityNamesData.xlsx");
//		XSSFWorkbook cityNamesWorkBook=new XSSFWorkbook(cityNamesDataExcel);
//		XSSFSheet cityNamesSheet=cityNamesWorkBook.getSheet("Sheet2");
		
//		/html/body/div[5]/section[1]/div/section
		
		
		By webTableProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]");
		WebElement webTable=driver.findElement(webTableProperty);
		
		//to go to every row
		By webTableRowsProperty=By.tagName("tr");
		List<WebElement>webTableRows=driver.findElements(webTableRowsProperty);
		
		System.out.println(webTableRows.size());
		
		for(int rowIndex=0;rowIndex<=webTableRows.size();rowIndex++)
		{
			WebElement webTableRow=webTableRows.get(rowIndex);
//			Row newRow=cityNamesSheet.createRow(rowIndex);
			
			By webTableRowOfCellsProperty=By.tagName("td");
			List<WebElement>webTableRowofCells=driver.findElements(webTableRowOfCellsProperty);
			
			for(int rowOfCellIndex=0;rowOfCellIndex<webTableRowofCells.size();rowOfCellIndex++)
			{
//				Cell newRowOfCell=newRow.createCell(rowOfCellIndex);
				WebElement webTableRowOfCell=webTableRowofCells.get(rowOfCellIndex);
				
				String webTableCityNamesText=webTableRowOfCell.getText();
				
				
				System.out.print(webTableCityNamesText+" | ");
				
//				newRowOfCell.setCellValue("webTableCityNamesText");				
				
			}
			System.out.println();
			
//		FileOutputStream cityNamesOutPutData=new FileOutputStream("./Datafiles/CityNamesData.xlsx");
//		cityNamesWorkBook.write(cityNamesOutPutData);
//		cityNamesOutPutData.close();
			
			
		}
		
		
	}
	
	

}
