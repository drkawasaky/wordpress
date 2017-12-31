package com.rapidapi.automation.sandbox.web;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		while(time < stopTime){
			time = System.currentTimeMillis();
		}
	}
	
	private WebElement getWebElement() {
		
		try {
			WebElement element =  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getxPath())));
			for(int i = 0; i < 3; i++) {
				if(element.isEnabled()) {
					return element;
				}			
				waitInMiliSeconds(1000);
			}
		}catch (NoSuchElementException e) {
			System.out.println("Page Element " + getDescription() + " not found");
		}
		return null;
	}
	
	public void clickOnPageElement(){
		WebElement webElement = getWebElement();
		webElement.click();
	}

	public void writeToPageElement(String value){
		WebElement webElement = getWebElement();
		webElement.click();
		webElement.clear();
		webElement.sendKeys(value);
	}
	
	public String getPageElementText(){
		WebElement webElement = getWebElement();
		return webElement.getText();
	}
	
	
}
