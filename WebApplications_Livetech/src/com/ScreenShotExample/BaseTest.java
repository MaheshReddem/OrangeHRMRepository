package com.ScreenShotExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
	
	WebDriver driver;
	String applicationURLAddress;
	
	@BeforeTest
	public void applicationLaunchTest()
	{
		System.setProperty("webdriver.chrome.driver", ".\\Driverfiles\\chromedriver.exe");
		driver=new ChromeDriver();
		
		applicationURLAddress="https://www.tsrtconline.in/oprs-web/";
		driver.get(applicationURLAddress);
		
		System.out.println("**********Successfully opened the application**********");
	}
	
	@AfterTest
	public void applicationClose()
	{
		driver.close();
		
		System.out.println("**********Successfully closed the application**********");
	}
	
	@Test
	public void test()
	{
		
	}


}
