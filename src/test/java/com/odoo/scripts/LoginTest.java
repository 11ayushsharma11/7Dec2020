package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;

public class LoginTest extends BaseAbstractTest {
	
	@Test
	public void login()
	{
		ExcelUtilities excelUtilities = new ExcelUtilities(GenericLib.directory+"/testData/Odoodata.xlsx");
		String[] data = excelUtilities.readData("Sheet1", "validLogin_ID");
		loginFeature.login(data[1], data[2]);
		loginFeature.verifyLogin(data[1]);
	}

}