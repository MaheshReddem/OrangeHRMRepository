package com.HeaderLinksTsrtc;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HeaderLinksTsrtc extends BaseTest {
	
	@Test
	public void headerLinks_Test() throws IOException
	{
		
		By headerBlockProperty=By.className("menu-wrap");
		WebElement headerBlock=driver.findElement(headerBlockProperty);
		
		By headerBlockLinksProperty=By.tagName("a");
		List<WebElement>headerBlockLinks=headerBlock.findElements(headerBlockLinksProperty);
		
		int headerBlocksLinksCount=headerBlockLinks.size();
		System.out.println(" Number of links in the header block are: "+headerBlocksLinksCount);
		System.out.println();
		
		for(int listIndex=0;listIndex<=headerBlocksLinksCount;listIndex++)
		{
			
			String headerBlocksLinksName=headerBlockLinks.get(listIndex).getText();
			System.out.println(" The current in test is: "+headerBlocksLinksName);
			
			String expected_HeaderBlockLinkURLAddress=headerBlockLinks.get(listIndex).getAttribute("href");
			System.out.println(" The expected URL address is: "+expected_HeaderBlockLinkURLAddress);
			
			headerBlockLinks.get(listIndex).click();
			
			File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot,new File("E:\\MyWorkSpace\\WebApplications_Livetech\\ScreenShots"+listIndex+".png"));
			
			String actual_HeaderBlockLinkURLAddress=driver.getCurrentUrl();
			System.out.println(" The expected URL address is: "+actual_HeaderBlockLinkURLAddress);
			
			if(actual_HeaderBlockLinkURLAddress.equals(expected_HeaderBlockLinkURLAddress))
			{
				System.out.println(" ***Successfully Navigated to expected webpage *** ");
			}
			else
			{
				System.out.print(" ***Failed to Navigate to expected webpage *** ");
			}
			System.out.println();
			
			driver.navigate().back();
			
			headerBlock=driver.findElement(headerBlockProperty);
			headerBlockLinks=headerBlock.findElements(headerBlockLinksProperty);
		}
	}

}
