package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class GenericLib {
	
	public static String directory = System.getProperty("user.dir");
	public static String os = System.getProperty("os.name");
	
	public void storeProperty(String filePath, String key, String value)
	{
		try
		{
			Properties properties = new Properties();
			File file = new File(filePath);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			properties.setProperty(key, value);
			properties.store(fileOutputStream, "Environment Properties");
			fileOutputStream.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public String getProperty(String filePath, String key)
	{
		try
		{
			Properties properties = new Properties();
			File file = new File(filePath);
			FileInputStream fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);
			String value = properties.getProperty(key);
			fileInputStream.close();
			return value;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return null;
	}

}
