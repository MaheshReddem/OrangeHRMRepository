package com.Synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class implicitWaitExample extends BaseTest{
	
	public void implicitWait_LogOutElement_Test()
	{
		String userNameTestData="Mahesh20";
		By userNameProperty=By.id("txtUsername");
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(userNameTestData);
		
		String passwordTestData="Mahesh@20";
		By passwordProperty=By.id("txtPassword");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		
		By loginButtonProperty=By.id("btnLogin");
		WebElement loginButton=driver.findElement(loginButtonProperty);
		loginButton.click();
		
		By welcomeAdminProperty=By.id("welcome");
		WebElement welcomeAdmin=driver.findElement(welcomeAdminProperty);
		welcomeAdmin.click();
		
		By logoutProperty=By.linkText("Logout");
		
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutProperty));
		WebElement logout=driver.findElement(logoutProperty);
		
		logout.click();
	}
	
	public static void main(String[] args) {
		implicitWaitExample webdriverwait=new implicitWaitExample();
		webdriverwait.applicationLaunch();
		webdriverwait.implicitWait_LogOutElement_Test();
//		webdriverwait.close();
		
	}

}
