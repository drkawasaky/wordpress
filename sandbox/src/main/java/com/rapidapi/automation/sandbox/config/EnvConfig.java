package com.rapidapi.automation.sandbox.config;

public interface EnvConfig {

	public static final String PROJECT_DIR = System.getProperty("user.dir");
	public static final String PROJECT_USER = System.getProperty("user.name");
	public static String browserType = PropertyLoader.loadProperty("browser.name");
	public static int webDriverImplicitWaitInSeconds = Integer.parseInt(PropertyLoader.loadProperty("browser.wait"));
	

}
