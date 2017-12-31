package com.rapidapi.automation.sandbox.web.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.rapidapi.automation.sandbox.config.EnvConfig;

public class Driver {

	protected static WebDriver driver;;
	
	public static WebDriver getWebDriver(){
		
		if (driver == null) {
			switch(EnvConfig.browserType.toLowerCase()){
				case "chrome": default:
					driver = getChromeDriver();
					break;
				case "firefox":
					driver = getFirefoxDriver();
					break;
				case "ie":
					driver = getInternetExplorerDriver();
					break;
				case "edge":
					driver = getEdgeDriver();
					break;
			}
    		
    		driver.manage().timeouts().implicitlyWait(EnvConfig.webDriverImplicitWaitInSeconds, TimeUnit.SECONDS);
    		driver.manage().window().maximize(); 
		}
		return driver;
	}
	
	public static WebDriver getChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "resources" + File.separator + "webdrivers" + File.separator + "chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--start-maximized");
	    options.addArguments("--disable-web-security");
	    options.addArguments("--no-proxy-server");
	    driver = new ChromeDriver(options);
		return driver;
	}
	
	public static WebDriver getFirefoxDriver(){
		System.setProperty("webdriver.gecko.driver", "resources" + File.separator + "webdrivers" + File.separator + "geckodriver.exe");
		 driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver getInternetExplorerDriver(){
		System.setProperty("webdriver.ie.driver", "resources" + File.separator + "webdrivers" + File.separator + "IEDriverServer.exe");
		DesiredCapabilities ie = DesiredCapabilities.internetExplorer();
		ie.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		driver = new InternetExplorerDriver();
		return driver;
	}
	
	public static WebDriver getEdgeDriver(){
		System.setProperty("webdriver.ie.driver", "resources" + File.separator + "webdrivers" + File.separator + "MicrosoftWebDriver.exe");
		driver = new InternetExplorerDriver();
		return driver;
	}
	
    public static void quitDriver() throws Exception {
        if (driver != null) {
            driver.quit();
            driver = null;
            killWebdrivers();
        }
    }
    
	public static void killWebdrivers() throws Exception{
		
		String[] processesNames = {"chromedriver.exe", "geckodriver.exe", "MicrosoftWebDriver.exe", "IEDriverServer.exe"};

		for (String processName : processesNames) {			
			if (isProcessRunning(processName)) {
				killProcess(processName);
				System.out.println(processName + " WebDriver process was killed.");
			}
		}
	}
	
	private static boolean isProcessRunning(String serviceName) throws Exception {

		Process p = Runtime.getRuntime().exec("tasklist");
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;

		while ((line = reader.readLine()) != null) {
			if (line.contains(serviceName)) {
				return true;
			}
		}

		return false;
	}

	private static void killProcess(String serviceName) throws Exception {
		Runtime.getRuntime().exec("taskkill /F /IM " + serviceName);
	}
}