package com.rapidapi.automation.sandbox.web.pages;

import org.openqa.selenium.WebDriver;

import com.rapidapi.automation.sandbox.config.Log;
import com.rapidapi.automation.sandbox.web.PageElement;

public class SitePageEditorPage extends AbstractPage {

	public SitePageEditorPage(WebDriver driver) {
		super(driver);
		Log.info("New Site Page editor opened");
	}
	
	public void createNewSitePage(String title, String body) {
		PageElement titleTextArea = new PageElement(driver, "Title for new site page", "//div[@class='editor-title']/textarea");
		PageElement bodyTextArea = new PageElement(driver, "Content for new site page", "//body[@id='tinymce']");
		titleTextArea.writeToPageElement(title);
		switchToFrameByXpath("//iframe[contains(@id,'tinymce')]");
		bodyTextArea.writeToPageElement(body);
		switchToMainFrame();
	}

}
