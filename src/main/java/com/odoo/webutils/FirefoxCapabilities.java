package com.odoo.webutils;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxCapabilities {
	
	public static FirefoxOptions getFirefoxCapabilities(String headless)
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setJavascriptEnabled(true);
		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		boolean hless = Boolean.parseBoolean(headless);
		firefoxOptions.setHeadless(hless);
		
		firefoxOptions.merge(desiredCapabilities);
		
		return firefoxOptions;
		
	}

}