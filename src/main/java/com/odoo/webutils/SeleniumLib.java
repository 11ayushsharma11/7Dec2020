package com.odoo.webutils;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumLib {
	
	WebDriver driver;
	
	public SeleniumLib(WebDriver d)
	{
		driver = d;
	}
	
	public void scrollIntoView(WebElement element)
	{
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		String javascriptCode = "arguments[0].scrollIntoView(true)";
		javascriptExecutor.executeScript(javascriptCode, element);
	}
	
	public void jsClick(WebElement element)
	{
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		String javascriptCode = "arguments[0].click()";
		javascriptExecutor.executeScript(javascriptCode, element);
	}
	
	public void seJsAttribute(WebElement element, String value)
	{
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		String javascriptCode = "arguments[0].setAttribute('value',"+value+"'')";
		javascriptExecutor.executeScript(javascriptCode, element);
	}
	
	public int getRandomNumber()
	{
		Random random = new Random();
		int value = random.nextInt(1000);
		return value;
	}
	
	public void sleep(int seconds)
	{
		long milliSeconds = seconds*1000;
		try
		{
			Thread.sleep(milliSeconds);
		}
		catch(InterruptedException iex)
		{
			iex.printStackTrace();
		}
	}
	
	public WebElement explicitWaitForElementPresence(int seconds, String xpath)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
		WebElement element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		return element;
	}
	
	public WebElement explicitWaitForElementVisible(int seconds, String xpath)
	{
		WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
		WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element;
	}

}
