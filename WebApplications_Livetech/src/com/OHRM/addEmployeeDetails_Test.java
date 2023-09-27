package com.OHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addEmployeeDetails_Test extends BaseTest {
	
	public void LogInFunctionality()
	{
		String userNameTestData="Mahesh20";
		By userNameProperty=By.id("txtUsername");
		WebElement userName=driver.findElement(userNameProperty);
		userName.sendKeys(userNameTestData);
		
		String passwordTestData="Mahesh@20";
		By passwordProperty=By.id("txtPassword");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestData);
		
		By logInButtonProperty=By.id("btnLogin");
		WebElement logInButton=driver.findElement(logInButtonProperty);
		logInButton.click();	
		

	}
	
	public void pimMenu()
	{
		By pimMenuProperty=By.id("menu_pim_viewPimModule");
		WebElement pimMenu=driver.findElement(pimMenuProperty);
		
		Actions pimAct=new Actions(driver);
		pimAct.moveToElement(pimMenu).build().perform();
		
		By addEmployeeProperty=By.id("menu_pim_addEmployee");
		WebElement addEmployee=driver.findElement(addEmployeeProperty);
		addEmployee.click();	
	}
	
	public void addEmployeeDetails_Validation()
	{
		String expected_FirstName="Reddem";
		By firstNameProperty=By.id("firstName");
		WebElement firstName=driver.findElement(firstNameProperty);
		firstName.sendKeys(expected_FirstName);
		
		String expected_MiddleName="Mahesh";
		By middleNameProperty=By.id("middleName");
		WebElement middleName=driver.findElement(middleNameProperty);
		middleName.sendKeys(expected_MiddleName);
		
		String expected_LastName="Reddy";
		By lastNameProperty=By.id("lastName");
		WebElement lastName=driver.findElement(lastNameProperty);
		lastName.sendKeys(expected_LastName);
		
		By saveButtonProperty=By.id("btnSave");
		WebElement saveButton=driver.findElement(saveButtonProperty);
		saveButton.click();
	
		By get_FirstNameProperty=By.id("personal_txtEmpFirstName");
		WebElement get_FirstName=driver.findElement(get_FirstNameProperty);
		String actual_FirstName=get_FirstName.getAttribute("value");
		System.out.println(" Emp first name is: "+actual_FirstName);
		
		if(actual_FirstName.equals(expected_FirstName))
		{
			System.out.println(" First Name details matched: PASS");
		}
		else
		{
			System.out.println(" First Name details NOT matched: FAIL");
		}
		
		By get_MiddleNameProperty=By.id("personal_txtEmpMiddleName");
		WebElement get_MiddleName=driver.findElement(get_MiddleNameProperty);
		String actual_MiddleName=get_MiddleName.getAttribute("value");
		System.out.println(" Emp middle name is: "+actual_MiddleName);
		
		if(actual_MiddleName.equals(expected_MiddleName))
		{
			System.out.println(" Middle Name details matched: PASS");
		}
		else
		{
			System.out.println(" Middle Name details NOT matched: FAIL");
		}
		
		By get_LastNameProperty=By.id("personal_txtEmpLastName");
		WebElement get_LastName=driver.findElement(get_LastNameProperty);
		String actual_LastName=get_LastName.getAttribute("value");
		System.out.println(" Emp last name is: "+actual_LastName);
		
		if(actual_LastName.equals(expected_LastName))
		{
			System.out.println(" Last Name details matched: PASS");
		}
		else
		{
			System.out.println(" Last Name details NOT matched: FAIL");
		}
		
		By employeeIDProperty=By.id("personal_txtEmployeeId");
		WebElement empID=driver.findElement(employeeIDProperty);
		String employeeID=empID.getAttribute("value");
		System.out.println(" Emp ID is: "+employeeID);		
	}
	
	public void logout_Functionality() throws InterruptedException
	{
		By welcomeAdminProperty=By.id("welcome");
		WebElement welcomeAdmin=driver.findElement(welcomeAdminProperty);
		welcomeAdmin.click();
		
		By logoutProperty=By.linkText("Logout");
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutProperty));
		
		WebElement logout=driver.findElement(logoutProperty);
		logout.click();	
		
		Thread.sleep(3000);
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{
		addEmployeeDetails_Test addEmpDetails=new addEmployeeDetails_Test();
		addEmpDetails.applicationLaunch();
		addEmpDetails.LogInFunctionality();
		addEmpDetails.pimMenu();
		addEmpDetails.addEmployeeDetails_Validation();
		addEmpDetails.logout_Functionality();
		addEmpDetails.applicationClose();	
	}

	
	
	
	
	
	
	
	
	
	
}
