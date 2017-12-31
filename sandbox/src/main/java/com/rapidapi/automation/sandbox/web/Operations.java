package com.rapidapi.automation.sandbox.web;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Operations {

	private static long timeOutInSeconds = 30;
	private WebDriver driver;
	private WebDriverWait webDriverWait;
	
	public Operations(WebDriver driver) {
		super();
		this.driver = driver;
		this.webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
	}
	
	public void clickOnPageElement(PageElement element){
		
		int maxNumOfTries = 3;
		
		for(int i = 0; i < maxNumOfTries; i++){
			
			try {
				WebElement webElement = driver.findElement(By.xpath(element.getxPath()));
				System.out.println("Element " + element.getDescription() + " found on page");
				webElement.click();
				System.out.println("Element " + element.getDescription() + " was clicked");
				break;
			}
			catch (Exception e) {
				if (i < maxNumOfTries) {
					System.out.println("Click on element " + element.getDescription() + " failed. Trying again... ");
					waitInMiliSeconds(2000);
				}
				else {
					System.out.println("Click on element " + element.getDescription() + " failed after three etempts");
					throw e;
				}
			}
		}
	}
	
	public String getPageElementText(PageElement element){
		waitForElementVisibility(element);
		WebElement webElement = driver.findElement(By.xpath(element.getxPath()));
		return webElement.getText();
	}
	
	public void waitInMiliSeconds(long miliSeconds){
		
		long time = System.currentTimeMillis();
		long stopTime = time + miliSeconds;
		while(time < stopTime){
			time = System.currentTimeMillis();
		}
	}
	
	public void waitForElementVisibility(PageElement element) {
		
		System.out.println("Waiting for " + element.getDescription() + " to be visible");
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element.getxPath())));
	}

	public void waitForElementInvisibility(PageElement element) {
		
		System.out.println("Waiting for " + element.getDescription() + " to be Invisible");
		webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element.getxPath())));
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
