package com.TimeAndDate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	WebDriver driver;
	String applicationURlAddress="https://www.timeanddate.com/worldclock/";
	
	@BeforeTest
	public void applicationLaunch()
	{

	System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");

	driver = new ChromeDriver();
	driver.get(applicationURlAddress);

	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	driver.manage().window().maximize();

	}
	
	@AfterTest
	public void applicationClose()
	{
	driver.close();
	}


}
