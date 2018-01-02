package com.rapidapi.automation.sandbox.web.pages;

import org.openqa.selenium.WebDriver;

import com.rapidapi.automation.sandbox.config.Log;

public class ReaderPage extends AbstractPage {

	public ReaderPage(WebDriver driver) {
		super(driver);
		Log.info("Reader page opened");
	}

}
