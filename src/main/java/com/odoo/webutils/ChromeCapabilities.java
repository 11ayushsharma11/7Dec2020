package com.odoo.webutils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeCapabilities {
	
	public static ChromeOptions getChromeCapabilities(String headless)
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setJavascriptEnabled(true);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		boolean hless = Boolean.parseBoolean(headless);
		chromeOptions.setHeadless(hless);
		
		chromeOptions.merge(desiredCapabilities);
		
		return chromeOptions;
		
	}

}
