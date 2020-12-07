package com.odoo.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver lauchBrowser(String platformName, String browserName, String headless)
	{
		WebDriver driver = null;
		
		if(platformName.equalsIgnoreCase("windows"))
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = ChromeCapabilities.getChromeCapabilities(headless);
				driver = new ChromeDriver(chromeOptions);
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = FirefoxCapabilities.getFirefoxCapabilities(headless);
				driver = new FirefoxDriver(firefoxOptions);
			}
			else if(browserName.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeOptions = EdgeCapabilities.getEdgeCapabilities(headless);
				driver = new EdgeDriver(edgeOptions);
			}
		}
		
		return driver;
	}

}
