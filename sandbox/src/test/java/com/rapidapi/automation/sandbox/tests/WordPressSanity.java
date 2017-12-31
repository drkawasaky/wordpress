package com.rapidapi.automation.sandbox.tests;

import org.junit.Test;

import com.rapidapi.automation.sandbox.AbstractTestCase;
import com.rapidapi.automation.sandbox.web.pages.LoginPage;
import com.rapidapi.automation.sandbox.web.pages.MySitePage;

public class WordPressSanity extends AbstractTestCase{

	@Test
	public void loginToWordPress() {
		driver.get("http://www.wordpress.com");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getLoginPage();
		loginPage.loginToAccount("telranenglish", "TREnglish");
		loginPage.waitInMiliSeconds(5000);
	}
	
	@Test
	public void addSitePage() {
		MySitePage mySitePae = new MySitePage(driver);
		mySitePae.getMySitePage();
		mySitePae.waitInMiliSeconds(5000);
	}
}
