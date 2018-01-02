package com.rapidapi.automation.sandbox.web.pages;

import org.openqa.selenium.WebDriver;

import com.rapidapi.automation.sandbox.web.PageElement;

public class PageHeader extends AbstractPage {

	public PageHeader(WebDriver driver) {
		super(driver);
	}
	
	public MySitePage getMySitePage() {
		PageElement mySiteLink = new PageElement(driver, "My Site Header Link", "//header[@id='header']//span[text()='My Site']");
		mySiteLink.clickOnPageElement();
		return new MySitePage(driver);
	}
}
