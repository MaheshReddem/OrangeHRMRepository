package com.TestNG_OHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	
	WebDriver driver;
	String applicationURLAddress;
	
	@BeforeTest
	public void applicationLaunchTest()
	{
		
		System.setProperty("webdriver.chrome.driver","./Driverfiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		applicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(applicationURLAddress);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("********Successfully launched application********");
	}
	
	@AfterTest
	public void applicationCloseTest()
	{
		driver.close();
		
		System.out.println("********Successfully closed application********");
	}
	
	
}
