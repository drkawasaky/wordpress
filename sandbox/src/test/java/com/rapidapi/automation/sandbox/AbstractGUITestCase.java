package com.rapidapi.automation.sandbox;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rapidapi.automation.sandbox.config.EnvConfig;
import com.rapidapi.automation.sandbox.config.Log;
import com.rapidapi.automation.sandbox.web.driver.Driver;

public abstract class AbstractGUITestCase {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	@BeforeClass
	public static void setUp() throws Exception{
		
		Driver.quitDriver();
		
		try{
			driver = Driver.getWebDriver();
		}catch(Exception e){
			Log.error("Failed to initiate WebDriver");
			e.printStackTrace();
			throw e;
		}
		wait = new WebDriverWait(driver, 10);
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		Driver.quitDriver();
	}
	
	protected void browseToUrl(String url) {
		Log.info("Browsing to URL: " + url);
		driver.get(url);
	}
}
