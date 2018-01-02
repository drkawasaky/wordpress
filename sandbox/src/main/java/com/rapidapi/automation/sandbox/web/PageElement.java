package com.rapidapi.automation.sandbox.web;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rapidapi.automation.sandbox.config.Log;

public class PageElement {

	String description;
	String xPath;
	private int timeOutInSeconds = 30;
	private WebDriverWait webDriverWait;
	
	public PageElement(WebDriver driver, String description, String xPath) {
		this.description = description;
		this.xPath = xPath;
		this.webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
	}

	public String getDescription() {
		return description;
	}

	public String getxPath() {
		return xPath;
	}
	
	private void waitInMiliSeconds(long miliSeconds){
		
		long time = System.currentTimeMillis();
		long stopTime = time + miliSeconds;
		Log.info("Waiting for " + miliSeconds/1000 + " seconds");
		while(time < stopTime){
			time = System.currentTimeMillis();
		}
	}
	
	private WebElement getWebElement() {
		Log.info("Identifying page element " + getDescription());
		try {
			WebElement element =  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getxPath())));
			for(int i = 0; i < 3; i++) {
				if(element.isEnabled()) {
					Log.info("Page element " + getDescription() + " found and available");
					return element;
				}			
				waitInMiliSeconds(1000);
			}
		}catch (NoSuchElementException e) {
			Log.error("Page Element " + getDescription() + " not found");
		}
		return null;
	}
	
	public void clickOnPageElement(){
		WebElement webElement = getWebElement();
		Log.info("Clicking on page element " + getDescription());
		webElement.click();
	}

	public void writeToPageElement(String value){
		WebElement webElement = getWebElement();
		Log.info("Writing to page element " + getDescription());
		webElement.click();
		webElement.clear();
		webElement.sendKeys(value);
	}
	
	public String getPageElementText(){
		WebElement webElement = getWebElement();
		Log.info("Reading text from page element " + getDescription());
		return webElement.getText();
	}
}
