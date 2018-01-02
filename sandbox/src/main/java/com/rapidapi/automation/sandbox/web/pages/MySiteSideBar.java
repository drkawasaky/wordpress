package com.rapidapi.automation.sandbox.web.pages;

import org.openqa.selenium.WebDriver;

import com.rapidapi.automation.sandbox.web.PageElement;

public class MySiteSideBar extends AbstractPage {

	public MySiteSideBar(WebDriver driver) {
		super(driver);
	}
	
	public SitePageEditorPage addNewSitePage() {
		PageElement addSitePageButton = new PageElement(driver, "Site Pages Add button", "//li/a[contains(., 'Site Pages')]/../a[text()='Add']");
		addSitePageButton.clickOnPageElement();
		return new SitePageEditorPage(driver);
	}

}
