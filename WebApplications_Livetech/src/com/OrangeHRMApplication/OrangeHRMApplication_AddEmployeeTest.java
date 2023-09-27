package com.OrangeHRMApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class OrangeHRMApplication_AddEmployeeTest extends BaseTest {
	
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
		
	@Test(priority=2,description="Validating HomePage")
	public void validatingHomePageTest() throws IOException
	{
		
		String expected_OrangeHRMApplicationHomePageURL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		System.out.println(" The expected Home Page URL is: "+expected_OrangeHRMApplicationHomePageURL);
		
		String actual_OrangeHRMApplicationHomePageURL=driver.getCurrentUrl();
		System.out.println(" The actual Home Page is: "+actual_OrangeHRMApplicationHomePageURL);
		
		if(actual_OrangeHRMApplicationHomePageURL.equals(expected_OrangeHRMApplicationHomePageURL))
		{
			System.out.println(" Successfully navigated to home page: PASS");
			Cell resultCell=row.createCell(2);
			resultCell.setCellValue(" Test result: Pass ");
		}
		else
		{
			System.out.println(" Failed to navigate to home page: Fail");
			Cell resultCell=row.createCell(2);
			resultCell.setCellValue(" Test result: Fail ");
		}
	
		FileOutputStream loginTestData_Result=new FileOutputStream("./src/com/TestData_Result_File/SingleDimentionData.xlsx");
		loginTestData_WorkBook.write(loginTestData_Result);
		loginTestData_Result.close();		
	}
	
	@Test(priority=3,description="Validating PIM")
	public void pimTest()
	{
		By pimProperty=By.id(properties.getProperty("orangeHRMApplicationHomePage_PIMProperty"));
		WebElement pimMenu=driver.findElement(pimProperty);
		
		Actions pimAction=new Actions(driver);
		pimAction.moveToElement(pimMenu).build().perform();	
	}
	
	@Test(priority=4,description="Validating AddEmployee")
	public void addEmployeeTest() throws IOException, InterruptedException
	{
		addEmployeeProperty=By.id(properties.getProperty("orangeHRMApplicationHomePage_AddEmployeeProperty"));
		addEmployee=driver.findElement(addEmployeeProperty);
		addEmployee.click();
		
		FileInputStream addEmployeeTestData_File=new FileInputStream("./src/com/TestDataFile/AddEmployeeTestData.xlsx");
		XSSFWorkbook addEmployeeTestData_WorkBook= new XSSFWorkbook(addEmployeeTestData_File);
		XSSFSheet addEmployeeTestData_Sheet=addEmployeeTestData_WorkBook.getSheet("Sheet1");
		
		int rowCount=addEmployeeTestData_Sheet.getLastRowNum();
		int cellCount=addEmployeeTestData_Sheet.getRow(0).getLastCellNum();
		
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++)
		{
			Row addEmployeeRow=addEmployeeTestData_Sheet.getRow(rowIndex);
			Cell addEmployeeFirstNameCell=addEmployeeRow.getCell(0);
			String firstNameTestData=addEmployeeFirstNameCell.getStringCellValue();
			System.out.println("First name is: "+firstNameTestData);
			
			By firstNameProperty=By.id(properties.getProperty("orangeHRMApplicationHomePage_AddEmployeeFirstNameProperty"));
			WebElement firstName=driver.findElement(firstNameProperty);
			firstName.sendKeys(firstNameTestData);
			
			Cell addEmployeeMiddleNameCell=addEmployeeRow.getCell(1);
			String middleNameTestData=addEmployeeMiddleNameCell.getStringCellValue();
			System.out.println("Middle Name is: "+middleNameTestData);
			
			Actions keyboardActions=new Actions(driver);
			
			keyboardActions.sendKeys(Keys.TAB).build().perform();
			keyboardActions.sendKeys(middleNameTestData).build().perform();
			
			Cell addEmployeeLastNameCell=addEmployeeRow.getCell(2);
			String lastNameTestData=addEmployeeLastNameCell.getStringCellValue();
			System.out.println("Last Name is: "+lastNameTestData);
			
			System.out.println("********************************************************");
			
			keyboardActions.sendKeys(Keys.TAB).build().perform();
			keyboardActions.sendKeys(lastNameTestData);
			
			keyboardActions.sendKeys(Keys.TAB).build().perform();
			
			By employeeIDProperty=By.name(properties.getProperty("orangeHRMApplicationHomePage_AddEmployeeID"));
			WebElement employeeID=driver.findElement(employeeIDProperty);
			String expected_EmployeeID=employeeID.getAttribute("value");
			
			Cell employeeIdCell=addEmployeeRow.createCell(3);
			employeeIdCell.setCellValue(expected_EmployeeID);
			
			keyboardActions.sendKeys(Keys.TAB).build().perform();
			
			keyboardActions.sendKeys(Keys.ENTER).build().perform();
			
			java.lang.Runtime.getRuntime().exec("E:\\MyWorkSpace\\WebApplications_Livetech\\src\\com\\TestDataFile\\FileUpload.exe");
			
			Thread.sleep(10000);	
			
			By saveButtonProperty=By.id(properties.getProperty("orangeHRMApplicationHomePage_AddEmployeeSaveButton"));
			WebElement saveButton=driver.findElement(saveButtonProperty);
			saveButton.click();
			
			By photographProperty=By.id(properties.getProperty("PhotographProperty"));
			WebElement employeePhotograph=driver.findElement(photographProperty);
			
			Boolean flag=employeePhotograph.isDisplayed();
			
			if(flag)
			{
				System.out.println(" OrangeHRM Application Employee Photograph Uploaded Successfully - Pass");
			}
			else
			{
				System.out.println(" OrangeHRM Application Employee Photograph Upload FAILED - FAIL");
			}
			
			By addEmployeeProperty=By.id(properties.getProperty("orangeHRMApplicationHomePage_AddEmployeeProperty"));
			WebElement addEmployee=driver.findElement(addEmployeeProperty);
			addEmployee.click();	
			
		FileOutputStream file=new FileOutputStream("./src/com/TestData_Result_File/AddEmployeeTestData.xlsx");
		addEmployeeTestData_WorkBook.write(file);
		file.close();
	
		}
				
	}
	
	@Test(priority=5,description="Validating LogOut")
	public void logOutTest()
	{
	By welComProperty=By.id(properties.getProperty("orangeHRMApplicationHomePagePageWelcomeAdminProperty"));
	WebElement welComeAdmin=driver.findElement(welComProperty);
	welComeAdmin.click();

	By logOutProperty=By.xpath(properties.getProperty("orangeHRMApplicationLogOutProperty"));
	WebElement logOut=driver.findElement(logOutProperty);
	logOut.click();

	}
		
	}
	
	


