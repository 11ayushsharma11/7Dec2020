package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.LoginSteps;

public class LoginFeature {
	
	WebDriver driver;
	public LoginSteps loginSteps;
	
	public LoginFeature(WebDriver d)
	{
		driver = d;
		loginSteps = new LoginSteps(driver);
	}
	
	public void login(String emailId, String password)
	{
		System.out.println(emailId);
		loginSteps.enterEmailId(emailId);
		loginSteps.enterPassword(password);
		loginSteps.clickLoginButton();
	}
	
	public void verifyLogin(String expected)
	{
		loginSteps.verify(expected);
	}

}
