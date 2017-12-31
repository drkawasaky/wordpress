package com.rapidapi.automation.sandbox.config;

import java.io.IOException;
import java.util.Properties;


public class PropertyLoader {

	private static final String PROP_FILE = "/application.properties";
    
    private PropertyLoader() {}

	public static String loadProperty(String name) {
		
		Properties props = new Properties();
		String value = "";
		
		try {
			props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
	
	public static void main(String[] args) throws Exception {
		
		String websiteUrl = PropertyLoader.loadProperty("site.url");
		System.out.println(websiteUrl);
	}
}
