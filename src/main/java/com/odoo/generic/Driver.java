package com.odoo.generic;

import org.openqa.selenium.WebDriver;

public class Driver {
	
	private static WebDriver driver;
	
	public static void setDriver(WebDriver d)
	{
		driver = d;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}

}
