package com.TestNG_OHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LogInTest_OHRM extends BaseTest {
	
	Row row;
	XSSFWorkbook workBook;
	WebElement welcomeAdmin;
	FileInputStream propertiesFile;
	Properties properties;
	
		
	@Test(priority=1,description="Login functionality successfull")
	public void logInFunctionality_Test() throws IOException
	{
		FileInputStream file=new FileInputStream(".\\src\\com\\TestDataFile\\SingleDimentionData.xlsx");
		workBook=new XSSFWorkbook(file);
		XSSFSheet testDataSheet=workBook.getSheet("Sheet1");
		
		//identifying the properties file
		
		propertiesFile=new FileInputStream("./src/com/Config/OrangeHRMApplication.properties");
		properties=new Properties();
		properties.load(propertiesFile);
		
		
		row=testDataSheet.getRow(1);
		Cell rowOfCell=row.getCell(0);
		String userNameTestData=rowOfCell.getStringCellValue();
		
		Cell rowOfCell1=row.getCell(1);
		String passwordTestData=rowOfCell1.getStringCellValue();	
		

//		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
//		driver=new ChromeDriver();
//		
//		String applicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
//		driver.get(applicationURLAddress);
		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
//		String userNameTestData="Mahesh20";
		By userNameProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPageUserNameProperty"));
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(userNameTestData);
		
//		String passwordTestData="Mahesh@20";
		By passwordProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPagePasswordProperty"));
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		
		By logInButtonProperty=By.id(properties.getProperty("orangeHRMApplicationLoginPageLoginButton"));
		WebElement logInButton=driver.findElement(logInButtonProperty);
		logInButton.click();
		}
	
	@Test(priority=2,description="Validation of home page successfull")
	public void validationOfHomePage_Test()
	{
		String expected_WelcomeAdminText="Admin";
		System.out.println(" The expected text of the home page is: "+expected_WelcomeAdminText);
		
		By welcomeAdminProperty=By.id(properties.getProperty("orangeHRMApplicationHomePagePageWelcomeAdminProperty"));
		welcomeAdmin=driver.findElement(welcomeAdminProperty);
		String actual_WelcomeAdminText=welcomeAdmin.getText();
		System.out.println(" The actual text of the home page is "+actual_WelcomeAdminText);
		
		if(actual_WelcomeAdminText.contains(expected_WelcomeAdminText))
		{
			System.out.println(" Successfully navigated to the home page: PASS ");
			Cell rowOfCell2=row.createCell(2);
			rowOfCell2.setCellValue(" Successfully navigated to the home page: PASS ");
		}
		else
		{
			System.out.println(" Failed to navigated to the home page: FAIL ");
			Cell rowOfCell2=row.createCell(2);
			rowOfCell2.setCellValue(" Failed to navigated to the home page: FAIL ");
		}
		
	}
	
	@Test(priority=3,description="Logout successfull")
	public void logOutFunctionality_Test() throws IOException
	{
		
		welcomeAdmin.click();
		
		By logoutProperty=By.linkText(properties.getProperty("orangeHRMApplicationLogoutLinkProperty"));
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(welcomeAdmin));
		
		WebElement logout=driver.findElement(logoutProperty);
		logout.click();
		
		FileOutputStream testDataResult=new FileOutputStream(".\\src\\com\\TestData_Result_File\\SingleDimentionData.xlsx");
		workBook.write(testDataResult);
		testDataResult.close();
	}
		
	
}
