package com.odoo.webutils;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeCapabilities {
	
	public static EdgeOptions getEdgeCapabilities(String headless)
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setJavascriptEnabled(true);
		
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setCapability("headless", headless);
		edgeOptions.merge(desiredCapabilities);
		
		return edgeOptions;
	}

}
