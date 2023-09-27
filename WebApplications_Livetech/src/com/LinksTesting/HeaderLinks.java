package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderLinks {
	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driverfiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String applicationURLAddress="https://www.tsrtconline.in/oprs-web/";
		
		driver.get(applicationURLAddress);
		
		driver.manage().window().maximize();
		
		By headerBlockProperty=By.className("menu-wrap");
		WebElement headerElement=driver.findElement(headerBlockProperty);
		
		By headerBlockLinksProperty=By.tagName("a");
		List<WebElement>headerBlockLinks=headerElement.findElements(headerBlockLinksProperty);
		
		int headerBlockLinksCount=headerBlockLinks.size();
		System.out.println("The number of links in the header block is: "+headerBlockLinksCount);
		System.out.println();
		
		for(int linkIndex=0;linkIndex<headerBlockLinksCount;linkIndex++)
		{
			
			System.out.println("Link Count & Name: "+linkIndex+" "+headerBlockLinks.get(linkIndex).getText());
			headerBlockLinks.get(linkIndex).click();
			
			//verification of header block links
			
			String expected_HomePage_Title="Online Bus Ticket Booking | TSRTC Official Website | Telangana";
			
			String actual_HomePageTitle=driver.getTitle();
			System.out.println(actual_HomePageTitle);
			
			String expected_HomePage_URLAddress=" https://www.tsrtconline.in/oprs-web/guest/home.do?h=1";
			
			String headerBlock_HomePage_URL=driver.getCurrentUrl();
			System.out.println(headerBlock_HomePage_URL);
			
		}
		
		driver.navigate().back();
		
		WebElement headerBlockMenu=driver.findElement(headerBlockLinksProperty);
		headerBlockLinks=headerBlockMenu.findElements(headerBlockLinksProperty);

		driver.quit();
	
	}

}
