package com.LinksTesting;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderPracticeLinks {
	
public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String applicationURLAddress="https://www.tsrtconline.in/oprs-web/";
		driver.get(applicationURLAddress);
		
		driver.manage().window().maximize();
		
		By headerBlockProperty=By.className("menu-wrap");
		WebElement headerBlock=driver.findElement(headerBlockProperty);
		
		By headerBlockLinksProperty=By.tagName("a");
		List<WebElement>headerBlockLinks=headerBlock.findElements(headerBlockLinksProperty);
		
		int headerBlockLinksCount=headerBlockLinks.size();
		System.out.println(" The number of links in the header block are: "+headerBlockLinksCount);
		
		for(int listIndex=0;listIndex<headerBlockLinksCount;listIndex++)
		{
			String headerBlockLinksName=headerBlockLinks.get(listIndex).getText();
			System.out.println(listIndex+" "+headerBlockLinksName);
			
			String expected_HeaderBlockLinkURLAddress=headerBlockLinks.get(listIndex).getAttribute("href");
			System.out.println("The expected current URL address is: "+expected_HeaderBlockLinkURLAddress);
			
			headerBlockLinks.get(listIndex).click();
			
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("E:\\MyWorkSpace\\WebApplications_Livetech\\ScreenShots."+listIndex+".png"));
			
				
			
			String actual_WebPageTitle=driver.getTitle();
			System.out.println(" The actual webpage title is: "+actual_WebPageTitle);
			
			String actual_WebPageCurrentURLAddress=driver.getCurrentUrl();
			System.out.println(" The actual current URL address is: "+actual_WebPageCurrentURLAddress);
			
			if(actual_WebPageCurrentURLAddress.equals(expected_HeaderBlockLinkURLAddress));
			{
				System.out.println(" Successfully navigated to the expected WebPage: PASS");
						
				
			}
//			else
//			{
//				System.out.println(" Failed to navigate to the expected WebPage: FAIL");
//			}
//			
//			System.out.println();
			
			
			
			driver.navigate().back();
			
			headerBlock=driver.findElement(headerBlockProperty);
			headerBlockLinks=headerBlock.findElements(headerBlockLinksProperty);		
	
		}
			
		driver.quit();
}

}
