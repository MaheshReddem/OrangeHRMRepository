package com.TestNG_OHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest_MultiDimension_TestData extends BaseTest {
	
	@Test(priority=1)
	public void logIn_Test() throws IOException
	{
		FileInputStream excelFile=new FileInputStream("./src/com/TestDataFile/OHRM_MultiDimension_TestData.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(excelFile);
		XSSFSheet sheet=workBook.getSheet("Sheet1");
		
		FileInputStream propertiesFile=new FileInputStream("./src/com/Config/OrangeHRMApplication.properties");
		Properties properties=new Properties();
		properties.load(propertiesFile);
		
		int lastRowNumber=sheet.getLastRowNum();
		System.out.println("The OrangeHRMLoginTestDataSheet last row Num is :-" +lastRowNumber);
		System.out.println(); 
		
		int lastCellNum=sheet.getRow(0).getLastCellNum();
		System.out.println(" The OrangeHRMLoginTestDataSheet last cell Num is :- " +lastCellNum);
		System.out.println();
		
		for(int index=1;index<=lastRowNumber;index++)
		{
			Row row=sheet.getRow(index);
			Cell rowOfCell=row.getCell(0);
			
			String userNameTestData=rowOfCell.getStringCellValue();
			
			System.out.println(" The UserName test data From excel is: " +userNameTestData);
			
			By userNameProperty= By.id(properties.getProperty("orangeHRMApplicationLoginPageUserNameProperty"));
			WebElement userName =driver.findElement(userNameProperty);
			userName.sendKeys(userNameTestData);
			
			Row passwordRow=sheet.getRow(index);
			Cell passwordRowOfCell1=passwordRow.getCell(1);
			String passwordTestData=passwordRowOfCell1.getStringCellValue();
			
			System.out.println("The Password test data From excel is:-" +passwordTestData);
			
			By passwordProperty =By.id(properties.getProperty("orangeHRMApplicationLoginPagePasswordProperty"));	
			WebElement password= driver.findElement(passwordProperty);
			password.sendKeys(passwordTestData);
			 
			   
			By LoginButtonProperty = By.id(properties.getProperty("orangeHRMApplicationLoginPageLoginButton"));
			WebElement Login =driver.findElement(LoginButtonProperty);
			Login.click();
			
			
			String expected_OrangeHRMHomePageURL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
			System.out.println(" The expected URL is: "+expected_OrangeHRMHomePageURL);
			Cell newRowOfCell2=row.createCell(2);
			newRowOfCell2.setCellValue(expected_OrangeHRMHomePageURL);
			
			String CurrentURL =driver.getCurrentUrl();
			String actual_OrangeHRMHomePageURL=CurrentURL;
			System.out.println(" The actual URL is: "+actual_OrangeHRMHomePageURL);
			Cell newRowOfCell3=row.createCell(3);
			newRowOfCell3.setCellValue(actual_OrangeHRMHomePageURL);
			
			
			if (actual_OrangeHRMHomePageURL.equals(expected_OrangeHRMHomePageURL))
			   {
				   System.out.println("Successfully Navigated to the HomePage:- PASS");
				   Cell resultRowOfCell=row.createCell(4);
				   resultRowOfCell.setCellValue("Test result: PASS");
				   By OrangeHRM_HoomepageWelcomeAdminProperty=By.id(properties.getProperty("orangeHRMApplicationHomePagePageWelcomeAdminProperty"));
				   WebElement OrangeHRM_Homepage_WelcomeAdmin=driver.findElement(OrangeHRM_HoomepageWelcomeAdminProperty);

				   OrangeHRM_Homepage_WelcomeAdmin.click();

				   By OrangeHRM_Homepage_LogoutProperty=By.linkText(properties.getProperty("orangeHRMApplicationLogoutLinkProperty"));

				   WebElement Logout =driver.findElement(OrangeHRM_Homepage_LogoutProperty);
				   Logout.click();
				   
			   }
			   else 
			   {
				   System.out.println("Failed to Navigate to the HomePage:- FAIL");
				   Cell resultRowOfCell=row.createCell(4);
				   resultRowOfCell.setCellValue("Test result: FAIL");
			   
			   }
			  
			   System.out.println();
		
		FileOutputStream outputstream=new FileOutputStream("./src/com/TestData_Result_File/OHRM_MultiDimension_TestData.xlsx");
		workBook.write(outputstream);
		outputstream.close();
			   
				
				
				
			   				
		}
	}
						
}
		
		
		
				
			
			
			
				
		
			
			
		
	


