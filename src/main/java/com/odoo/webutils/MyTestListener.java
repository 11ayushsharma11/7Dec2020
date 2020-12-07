package com.odoo.webutils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;

public class MyTestListener implements ITestListener, WebDriverEventListener{
	
	private static int executionCount=0, skipCount=0, failCount=0, passCount=0;
	public static Logger logger;
	private long startTime, stopTime, totalTime;
	private String platformName, browserName, headless;

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		logger.info("Finding Element with Locator " + by);
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		
		stopTime = System.currentTimeMillis();
		totalTime = (stopTime - startTime)/1000;
		
		logger.info("Suite Execution Ends!");
		logger.info("Total time taken in execution "+totalTime);
		
		logger.info("Total Number of Script Executed " + executionCount);
		logger.info("Total Number of Script passed " + passCount);
		logger.info("Total Number of Script failed " + failCount);
		logger.info("Total Number of Script skipped " + skipCount);
		
		RemoteWebDriver driver = (RemoteWebDriver)Driver.getDriver();
		Capabilities capabilities = driver.getCapabilities();
		String broswerVersion = capabilities.getBrowserVersion();
		
		Properties properties = new Properties();
		
		try
		{
			File file = new File(GenericLib.directory+"/Properties/environmentProperties.properties");
			properties.setProperty("browserName", browserName);
			properties.setProperty("broswerVersion", broswerVersion);
			properties.setProperty("platformName", platformName);
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			properties.store(fileOutputStream, "Enviroment-Properties");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		driver.close();
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		startTime = System.currentTimeMillis();
		
		System.setProperty("htmlpath", GenericLib.directory+"/Reports/htmlReports");
		System.setProperty("logpath", GenericLib.directory+"/Reports/logReports");
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String date = simpleDateformat.format(new Date());
		System.setProperty("timestamp", date);
		
		logger = Logger.getLogger(MyTestListener.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Suite Execution Starts!");
		
		platformName = System.getProperty("platform");
		browserName = System.getProperty("browser");
		headless = System.getProperty("headless");
		
		logger.info(browserName+ " launched in "+platformName+" platform and headless: "+headless);
		
		WebDriver driver = BrowserFactory.lauchBrowser(platformName, browserName, headless);
		Driver.setDriver(driver);
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		
		failCount++;
		logger.error(arg0.getName()+" Script Failed!");
		TakesScreenshot takesScreenshot = (TakesScreenshot)Driver.getDriver();
		try
		{
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File destination = new File(GenericLib.directory+"/Screenshots/"+arg0.getName()+".png");
			Files.copy(source, destination);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		skipCount++;
		logger.warn(arg0.getName()+" Script Skipped!");
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		executionCount++;
		logger.info(arg0.getName()+" Execution Starts!");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
		passCount++;
		logger.info(arg0.getName()+" Script passed!");
		
	}
	
	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		
		logger.fatal(throwable.getMessage());
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
}
