package com.OrangeHRMApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EmployeeListTest extends BaseTest{
	
	XSSFWorkbook loginTestData_WorkBook;
	Row row;
	Properties properties;
	By addEmployeeProperty;
	WebElement addEmployee;
	
	@Test(priority=1,description=" validating LogIn Funcationality ")
	public void loginTest() throws IOException
	{
		FileInputStream loginTestData_File=new FileInputStream("./src/com/TestDataFile/SingleDimentionData.xlsx");
		loginTestData_WorkBook= new XSSFWorkbook(loginTestData_File);
		XSSFSheet loginTestData_Sheet=loginTestData_WorkBook.getSheet("Sheet1");
		
		FileInputStream propertiesFile=new FileInputStream("./src/com/Config/OrangeHRMApplication.properties");
		properties=new Properties();
		properties.load(propertiesFile);
		
		row=loginTestData_Sheet.getRow(1);
		Cell userNameCell=row.getCell(0);
		String userNameTestData=userNameCell.getStringCellValue();
		System.out.println(" User Name is: "+userNameTestData);
		
		Cell passwordCell=row.getCell(1);
		String passwordTestData=passwordCell.getStringCellValue();
		System.out.println(" Password is: "+passwordTestData);
		
		By userNameProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPageUserNameProperty"));
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(userNameTestData);
		
		By passwordProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPagePasswordProperty"));
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		
		By logInButtonProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPageLoginButton"));
		WebElement login=driver.findElement(logInButtonProperty);
		login.click();
	} 
	
	@Test(priority=2,description="Validating PIM")
	public void pimTest()
	{
		By pimProperty=By.id(properties.getProperty("orangeHRMApplicationHomePage_PIMProperty"));
		WebElement pimMenu=driver.findElement(pimProperty);
		
		Actions pimAction=new Actions(driver);
		pimAction.moveToElement(pimMenu).build().perform();	
	}
	
	@Test(priority=3,description="Validating Employee List")
	public void employeeList() throws IOException
	{
		By employeeListProperty=By.id(properties.getProperty("orangeHRMApplicationHomePage_EmployeeListProperty"));
		WebElement employeeList=driver.findElement(employeeListProperty);
		employeeList.click();
		
		By orangeHRMApplication_EmployeeListTableProperty=By.id(properties.getProperty("orangeHRMApplication_EmployeeListTable"));
		WebElement EmployeeListTable=driver.findElement(orangeHRMApplication_EmployeeListTableProperty);
		
		FileInputStream employeeList_File=new FileInputStream("./src/com/TestData_Result_File/EmployeeList.xlsx");
		XSSFWorkbook employeeList_WorkBook=new XSSFWorkbook(employeeList_File);
		XSSFSheet employeeList_Sheet=employeeList_WorkBook.getSheet("Sheet1");
		
//		By headerFirstRowFirstCellProperty=By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[2]");
//		
//		By headerLastRowOfLastCellProperty=By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[37]/td[5]");
		
		for(int rowIndex=1;rowIndex<=37;rowIndex++)
		{
			Row newRow=employeeList_Sheet.createRow(rowIndex);
		
		for(int rowOfCellIndex=2;rowOfCellIndex<=5;rowOfCellIndex++)
		{
			Cell newRowOfCell=newRow.createCell(rowOfCellIndex-2);
			By employeeNamesProperty=By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr["+rowIndex+"]/td["+rowOfCellIndex+"]");
			WebElement employeeNames=driver.findElement(employeeNamesProperty);
			
			String employeeNamesText=employeeNames.getText();
			System.out.println("Employee Names are: "+employeeNamesText+" | ");
			
			newRowOfCell.setCellValue(employeeNamesText);
			
			FileOutputStream headerCellsOutPut=new FileOutputStream("./src/com/TestData_Result_File/EmployeeList.xlsx");
			employeeList_WorkBook.write(headerCellsOutPut);
			headerCellsOutPut.close();
		}
	}	
			
}
	
	@Test(priority=4,description="Validating LogOut")
	public void logoutTest()
	{
		By welComProperty=By.id(properties.getProperty("orangeHRMApplicationHomePagePageWelcomeAdminProperty"));
		WebElement welComeAdmin=driver.findElement(welComProperty);
		welComeAdmin.click();

		By logOutProperty=By.xpath(properties.getProperty("orangeHRMApplicationLogOutProperty"));
		WebElement logOut=driver.findElement(logOutProperty);
		logOut.click();
	}
	

}
