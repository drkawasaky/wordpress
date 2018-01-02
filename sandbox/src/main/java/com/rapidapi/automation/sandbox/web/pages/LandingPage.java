package com.rapidapi.automation.sandbox.web.pages;

import org.openqa.selenium.WebDriver;

import com.rapidapi.automation.sandbox.config.Log;
import com.rapidapi.automation.sandbox.web.PageElement;

public class LandingPage extends AbstractPage {

	public LandingPage(WebDriver driver) {
		super(driver);
		Log.info("WordPress landing page opened");
	}
	
	public LoginPage getLoginPage() {
		PageElement loginLink = new PageElement(driver, "Log In link", "//a[@id='navbar-login-link']");
		loginLink.clickOnPageElement();
		return new LoginPage(driver);
	}

}
