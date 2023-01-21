package com.login.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class Fileutility 
{

	static Properties property=null;
	public static void openpropertyFile(String filePath) throws Throwable
	{

		FileInputStream file = new FileInputStream(filePath);
		property=new Properties();
		property.load(file);
	}

	public static String getDataFromPropertyFile(String key)
	{
		return property.getProperty(key);
	}
}