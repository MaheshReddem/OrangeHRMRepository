package com.ExcelOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class excel_ReadAndWrite {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("./src/com/TestDataFile/SingleDimentionData.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(file);
		XSSFSheet sheet=workBook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		Cell rowOfCell=row.getCell(0);
		String userNameTestData=rowOfCell.getStringCellValue();
		
		Cell rowOfCell1=row.getCell(1);
		String passwordTestData=rowOfCell1.getStringCellValue();
		
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String applicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(applicationURLAddress);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
//		String userNameTestData="Mahesh20";
		By userNameProperty=By.id("txtUsername");
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(userNameTestData);
		
//		String passwordTestData="Mahesh@20";
		By passwordProperty=By.id("txtPassword");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		
		By logInButtonProperty=By.id("btnLogin");
		WebElement logInButton=driver.findElement(logInButtonProperty);
		logInButton.click();
		
		String expected_WelcomeAdminText="Admin";
		System.out.println(" The expected text of the OrangeHRM home page is: "+expected_WelcomeAdminText);
		
		By welcomeAdminProperty=By.id("welcome");
		WebElement welcomeAdmin=driver.findElement(welcomeAdminProperty);
		String actual_WelcomeAdminText=welcomeAdmin.getText();
		System.out.println(" The actual text of the OrangeHRM home page is: "+actual_WelcomeAdminText);
		
		if(actual_WelcomeAdminText.contains(expected_WelcomeAdminText))
		{
			System.out.println(" Successfully navigated to the home page: PASS");
			Cell rowOfCell2=row.createCell(2);
			rowOfCell2.setCellValue("Successfully navigated to the home page: PASS");
		}
		else
		{
			System.out.println(" Failed to navigate to the home page: FAIL ");
			Cell rowOfCell2=row.createCell(2);
			rowOfCell2.setCellValue(" Failed to navigate to the home page: FAIL ");
		}
		
		FileOutputStream testDataResult=new FileOutputStream("./src/com/TestData_Result_File/SingleDimentionData.xlsx");
		workBook.write(testDataResult);
		testDataResult.close();
		
		System.out.println(" excel_ReadAndWrite script successfully executed");
			
	}

}
