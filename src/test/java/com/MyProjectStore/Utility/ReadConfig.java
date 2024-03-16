package com.MyProjectStore.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties p;
	
	public ReadConfig() {
		p = new Properties();
		
		try {
			p.load(new FileInputStream(Utility.propertyFilePath));
		} catch (Exception e) {
			
		} 
	}
	
	public String getBaseurl() {
		String value = p.getProperty("baseurl");
		 //To check value is null or not
		if(value != null)
			return value;
		else throw new RuntimeException("Url is not specified in config file");
	}
	public String getBrowser() {
		String value = p.getProperty("browser");
		
		if(value != null)
			return value;
		else throw new RuntimeException("Browser is not speicfied in config file");
	}
	
}
