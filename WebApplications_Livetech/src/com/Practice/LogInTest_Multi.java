package com.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogInTest_Multi extends BaseTestOHRM {
	
	WebElement userName;
	WebElement password;
	
	@Test
	public void orangeHRMLoginTestExcel() throws IOException, InterruptedException
	{
		FileInputStream orangeHRMTestDataExcel=new FileInputStream("./src/com/TestDataFile/OHRM_MultiDimension_TestData.xlsx");
		XSSFWorkbook orangeHRMTestDataWorkbook=new XSSFWorkbook(orangeHRMTestDataExcel);
		XSSFSheet orangeHRMTestDataSheet=orangeHRMTestDataWorkbook.getSheet("Sheet1");
		
		FileInputStream propertiesFile=new FileInputStream("./src/com/Config/OrangeHRMApplication.properties");
		Properties properties=new Properties();
		properties.load(propertiesFile);
		
		int rowCount=orangeHRMTestDataSheet.getLastRowNum();
		int rowOfCellCount=orangeHRMTestDataSheet.getRow(0).getLastCellNum();
		
		System.out.println("Total rows: "+rowCount);
		System.out.println(" Total row of cells: "+rowOfCellCount);
		
		
		
		//for(int rowIndex=1;rowIndex<=rowCount;rowIndex++)
		//{
			
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++)
			//for(int rowOfCellIndex=0;rowOfCellIndex<=rowOfCellCount;rowOfCellIndex++)
			{
				Row newRow=orangeHRMTestDataSheet.getRow(rowIndex);
				
				Cell newRowOfCell=newRow.getCell(0);
				String userNameTestData=newRowOfCell.getStringCellValue();
				
				By userNameProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPageUserNameProperty"));
				userName=driver.findElement(userNameProperty);
				userName.sendKeys(userNameTestData);
				
				Cell newRowOfCell1=newRow.getCell(1);
				String passwordTestData=newRowOfCell1.getStringCellValue();
				
				By passwordProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPagePasswordProperty"));
				password=driver.findElement(passwordProperty);
				password.sendKeys(passwordTestData);
				
				By logInButtonProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPageLoginButton"));
				WebElement logInButton=driver.findElement(logInButtonProperty);
				logInButton.click();
				
			
				String expected_HomePageURL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
				System.out.println(" Expected URL is: "+expected_HomePageURL);
				Cell newRowOfCell2=newRow.createCell(2);
				newRowOfCell2.setCellValue(expected_HomePageURL);
				
				String actual_HomePageURL=driver.getCurrentUrl();
				System.out.println(" Actual URL is: "+actual_HomePageURL);
				Cell newRowOfCell3=newRow.createCell(3);
				newRowOfCell3.setCellValue(actual_HomePageURL);
				
				if(actual_HomePageURL.equals(expected_HomePageURL))
				{
		
					System.out.println(" Successfully navigated to OHRM HomePage: PASS ");
					Cell newRowOfCell4=newRow.createCell(4);
					newRowOfCell4.setCellValue(" Successfully navigated to OHRM HomePage: PASS ");
					
					By welComeAdminProperty=By.id(properties.getProperty("orangeHRMApplicationHomePagePageWelcomeAdminProperty"));
					WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
					welComeAdmin.click();
					
					By logOutProperty=By.xpath(properties.getProperty("orangeHRMApplicationProperty"));
					WebElement logOut=driver.findElement(logOutProperty);
					logOut.click();
					
				}
				else
				{
					System.out.println(" Failed to navigate to OHRM HomePage: FAIL ");
					Cell newRowOfCell4=newRow.createCell(4);
					newRowOfCell4.setCellValue(" Failed to navigate to OHRM HomePage: FAIL ");
					
				}
			
				
			FileOutputStream orangeHRMTestResults=new FileOutputStream("./src/com/TestData_Result_File/OHRM_MultiDimension_TestData.xlsx");
			orangeHRMTestDataWorkbook.write(orangeHRMTestResults);
			orangeHRMTestResults.close();
				
								
			}
			
			
		}
		
		
		
	}
	
	
	
	


