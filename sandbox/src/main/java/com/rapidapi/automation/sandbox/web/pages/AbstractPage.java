package com.rapidapi.automation.sandbox.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rapidapi.automation.sandbox.config.Log;


public abstract class AbstractPage {

	protected int timeOutInSeconds = 30;
	protected WebDriver driver;
	protected WebDriverWait webDriverWait;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
	}
	
	public void waitInMiliSeconds(long miliSeconds){
		
		long time = System.currentTimeMillis();
		long stopTime = time + miliSeconds;
		Log.info("Waiting for " + miliSeconds/1000 + " seconds");
		while(time < stopTime){
			time = System.currentTimeMillis();
		}
	}
	
	public void refreshPage() {
		
		Log.info("Refreshing the page");
		driver.navigate().refresh();		
	}

	public void browseBack() {

		Log.info("Navigating back");
		driver.navigate().back();		
	}
	
	public Boolean isAjaxCompleted() {
		try {
			Log.info("Waiting for AJAX to complete loading");
			webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
			return true;
		}catch (TimeoutException e) {
			Log.info("Attempt to load AJAX failed after " + timeOutInSeconds + " seconds");
			return false;
		}
	}
	
	public void switchToFrameByXpath(String xPath) {
		try {
			driver.switchTo().frame(driver.findElement(By.xpath(xPath)));
			Log.info("Switching to frame with xPath: " + xPath);
		} catch (NoSuchFrameException e) {
			Log.error("Frame with the xPath: " + xPath + " not found");
			throw e;
		}
	}
	
	public void switchToMainFrame() {
		
		try {
			driver.switchTo().defaultContent();
			Log.info("Switching to main frame");
		} catch (NoSuchFrameException e) {
			Log.error("Failed to switch to main frame");
			throw e;
		}
	}
}
