package com.rapidapi.automation.sandbox;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rapidapi.automation.sandbox.config.EnvConfig;
import com.rapidapi.automation.sandbox.web.driver.Driver;

public abstract class AbstractGUITestCase {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	@BeforeClass
	public static void setUp() throws Exception{
		
		if(driver != null){
			driver.quit();
			driver = null;
		}
		
		Driver.killWebdrivers();
		
		try{
			driver = Driver.getWebDriver();
		}catch(Exception e){
			System.out.println("Failed to initiate WebDriver");
			e.printStackTrace();
			throw e;
		}
		wait = new WebDriverWait(driver, 10);
	}
	
	@AfterClass
	public static void tearDown() throws Exception{
		driver.quit();
		driver = null;
		Driver.killWebdrivers();
	}
	
	protected void browseToUrl(String url) {
		System.out.println("Browsing to URL: " + url);
		driver.get(url);
	}
}
