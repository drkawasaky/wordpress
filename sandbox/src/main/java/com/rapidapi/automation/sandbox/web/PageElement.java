package com.rapidapi.automation.sandbox.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageElement {

	private String description;
	private String xPath;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public String getxPath() {
		return xPath;
	}

	public void setxPath(String xPath) {
		this.xPath = xPath;
	}
	
	private WebElement getWebElement() {
		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getxPath())));
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
