package com.odoo.scripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.odoo.features.LoginFeature;
import com.odoo.generic.Driver;
import com.odoo.webutils.MyTestListener;

public class BaseAbstractTest {
	
	public EventFiringWebDriver eventFiringWebDriver;
	public LoginFeature loginFeature;
	
	@BeforeClass
	public void setup()
	{
		WebDriver driver = Driver.getDriver();
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(new MyTestListener());
		loginFeature = new LoginFeature(eventFiringWebDriver);
				
		eventFiringWebDriver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void preCondition()
	{
		eventFiringWebDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		eventFiringWebDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = System.getProperty("url");
		eventFiringWebDriver.get(url);
	}

}
