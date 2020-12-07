package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.odoo.pageobjects.LoginPage;

public class LoginSteps {
	
	public WebDriver driver;
	public LoginPage loginPage;
	
	public LoginSteps(WebDriver d)
	{
		driver = d;
		loginPage = new LoginPage();
	}
	
	public void enterEmailId(String emailId)
	{
		driver.findElement(By.xpath(loginPage.emailXpath)).sendKeys(emailId);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(By.xpath(loginPage.passwordXpath)).sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(By.xpath(loginPage.loginButtonXpath)).click();;
	}
	
	public void verify(String expected)
	{
		driver.findElement(By.xpath(loginPage.CRMIconXpath));
		WebElement element = driver.findElement(By.xpath(loginPage.userNameOnHomepage));
		Assert.assertEquals(element.getText(), expected);
		System.out.println("Login verified successfully!");
	}

}
