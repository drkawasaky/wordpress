package com.rapidapi.automation.sandbox.web.pages;

import org.openqa.selenium.WebDriver;

import com.rapidapi.automation.sandbox.web.PageElement;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public ReaderPage loginToAccount(String userName, String password) {
		PageElement emailAddressInputField = new PageElement(driver, "Email Address Input Field", "//input[@id='usernameOrEmail']");
		PageElement continueButton = new PageElement(driver, "Continue Button", "//button[text()='Continue']");
		PageElement passwordInputField = new PageElement(driver, "Password Input Field", "//input[@id='password']");
		PageElement loginButton = new PageElement(driver, "Log In Button", "//button[text()='Log In']");
		
		emailAddressInputField.writeToPageElement(userName);
		continueButton.clickOnPageElement();
		passwordInputField.writeToPageElement(password);
		loginButton.clickOnPageElement();
		
		return new ReaderPage(driver);
	}

}
