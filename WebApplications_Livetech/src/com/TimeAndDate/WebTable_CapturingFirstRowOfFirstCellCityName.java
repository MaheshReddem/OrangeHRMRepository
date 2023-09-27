package com.TimeAndDate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_CapturingFirstRowOfFirstCellCityName extends BaseTest {
	
	String cityNameText;
	
	@Test(priority=1)
	public void capturingWebPageData() throws IOException
	{
		FileInputStream cityNamesDataExcel=new FileInputStream("./src/com/TestData_Result_File/CityNamesData.xlsx");
		XSSFWorkbook cityNamesWorkBook=new XSSFWorkbook(cityNamesDataExcel);
		XSSFSheet cityNamesSheet=cityNamesWorkBook.getSheet("Sheet1");
		
		//first row property
		By firstRowFirstCellCityNameProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]/a");
	
		//last row property
		By lastRowLastCellCityNameProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[35]/td[8]");
		
		//to go to every row
		for(int rowIndex=1;rowIndex<=36;rowIndex++)
		{
			Row newRow=cityNamesSheet.createRow(rowIndex-1);
			//to go to every row of row of cells
			for(int rowOfCellIndex=1;rowOfCellIndex<=8;rowOfCellIndex++)
			{
				Cell newRowOfCell=newRow.createCell(rowOfCellIndex-1);
				By cityNamesProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td["+rowOfCellIndex+"]");
	
				WebElement cityNames=driver.findElement(cityNamesProperty);
				String cityNamesText=cityNames.getText();
				
				System.out.print(cityNamesText+" | ");
				
				newRowOfCell.setCellValue(cityNamesText);
			}
			System.out.println();
			
			FileOutputStream cityNameDataOutPut=new FileOutputStream("./src/com/TestData_Result_File/CityNamesData.xlsx");
			cityNamesWorkBook.write(cityNameDataOutPut);
			cityNameDataOutPut.close();
			
		}
		
	}
	
}
