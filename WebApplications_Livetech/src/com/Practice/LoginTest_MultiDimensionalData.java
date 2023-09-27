package com.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LoginTest_MultiDimensionalData extends BaseTestOHRM {
	
	@Test
	public void logInTest() throws IOException
	{
		FileInputStream orangeHRMTestDataExcel=new FileInputStream("E:\\MyWorkSpace\\WebApplications_Livetech\\src\\com\\TestDataFile\\OHRM_MultiDimension_TestData.xlsx");
		XSSFWorkbook orangeHRMTestDataWorkBook=new XSSFWorkbook(orangeHRMTestDataExcel);
		XSSFSheet orangeHRMTestDataSheet=orangeHRMTestDataWorkBook.getSheet("Sheet1");
		
		int rowCount=orangeHRMTestDataSheet.getLastRowNum();
		int rowOfCellCount=orangeHRMTestDataSheet.getRow(0).getLastCellNum();
		
		System.out.println("Total row: "+rowCount);
		System.out.println("Total row of cells: "+rowOfCellCount);
		
		
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++)
		{
			Row newRow=orangeHRMTestDataSheet.getRow(rowIndex);
			
			for(int rowOfCellIndex=0;rowOfCellIndex<=rowOfCellCount;rowOfCellCount++)
			{
				Cell newRowOfCell=newRow.getCell(0);
				String userNameTestData=newRowOfCell.getStringCellValue();
				
				By userNameProperty=By.id("/html/body/div[1]/div/div[2]/form/div[2]/input");
				WebElement userName=driver.findElement(userNameProperty);
				userName.sendKeys(userNameTestData);
				
				
				
				Cell newRowOfCell1=newRow.getCell(1);
				String passwordTestData=newRowOfCell1.getStringCellValue();
				
				By passwordProperty=By.id("txtPassword");
				WebElement password=driver.findElement(passwordProperty);
				password.sendKeys(passwordTestData);
				
				By logInButtonProperty=By.id("btnLogin");
				WebElement logInButton=driver.findElement(logInButtonProperty);
				logInButton.click();
				
				String expected_OHRMHomePage="Admin";
				
				By welComeAdminProperty=By.id("welcome");
				WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
				String actual_OHRMHomePage=welComeAdmin.getText();
				
			/*	
				if(actual_OHRMHomePage.equals(expected_OHRMHomePage))
				{
					System.out.println(" Successfully navigated to OHRM HomePage: PASS ");
					Cell newRowOfCell2=newRow.createCell(2);
					newRowOfCell2.setCellValue(" Successfully navigated to OHRM HomePage: PASS ");	
				}
				else
				{
					System.out.println(" Failed to navigate to OHRM HomePage: FAIL ");
					Cell newRowOfCell2=newRow.createCell(2);
					newRowOfCell2.setCellValue(" Failed to navigate to OHRM HomePage: FAIL ");
				}
				
				welComeAdmin.click();
				
				By logOutProperty=By.xpath("/html/body/div[1]/div[1]/div[1]/ul/li[3]/a");
				WebElement logOut=driver.findElement(logOutProperty);
				logOut.click();

				*/
//				userName.clear();
//				password.clear();
//				
//				
//				
//				FileOutputStream orangeHRMHomePageTestResults=new FileOutputStream("E:\\MyWorkSpace\\WebApplications_Livetech\\src\\com\\TestData_Result_File\\OHRM_MultiDimension_TestData.xlsx");
//				orangeHRMTestDataWorkBook.write(orangeHRMHomePageTestResults);
//				orangeHRMHomePageTestResults.close();
							
			}
				
			
		}
		
		
	}
	
	

}
