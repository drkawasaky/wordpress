package com.rapidapi.automation.sandbox.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
		while(time < stopTime){
			time = System.currentTimeMillis();
		}
	}
	
	public void refreshPage() {
		
		System.out.println("Refreshing the page");
		driver.navigate().refresh();		
	}

	public void browseBack() {

		System.out.println("Navigating back");
		driver.navigate().back();		
	}
	
	public Boolean isAjaxCompleted() {
		try {
			System.out.println("Waiting for AJAX to complete loading");
			webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
			return true;
		}catch (TimeoutException e) {
			System.out.println("Attempt to load AJAX failed after " + timeOutInSeconds + " seconds");
			return false;
		}
	}
}
