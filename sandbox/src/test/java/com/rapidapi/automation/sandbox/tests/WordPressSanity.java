package com.rapidapi.automation.sandbox.tests;

import org.junit.Test;

import com.rapidapi.automation.sandbox.AbstractGUITestCase;
import com.rapidapi.automation.sandbox.web.pages.LandingPage;
import com.rapidapi.automation.sandbox.web.pages.LoginPage;
import com.rapidapi.automation.sandbox.web.pages.MySitePage;
import com.rapidapi.automation.sandbox.web.pages.MySiteSideBar;
import com.rapidapi.automation.sandbox.web.pages.PageHeader;
import com.rapidapi.automation.sandbox.web.pages.ReaderPage;
import com.rapidapi.automation.sandbox.web.pages.SitePageEditorPage;

public class WordPressSanity extends AbstractGUITestCase{

	@Test
	public void createNewSitePage() {
		driver.get("http://www.wordpress.com");
		
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = landingPage.getLoginPage();
		ReaderPage readerPage = loginPage.loginToAccount("telranenglish", "TREnglish");
		readerPage.waitInMiliSeconds(5000);
		
		PageHeader pageHeader = new PageHeader(driver);
		MySitePage mySitePae = pageHeader.getMySitePage();
		mySitePae.waitInMiliSeconds(5000);
		
		MySiteSideBar mySiteSideBar = new MySiteSideBar(driver);
		SitePageEditorPage sitePageEditorPage = mySiteSideBar.addNewSitePage();
		sitePageEditorPage.createNewSitePage("All About Evolution", "Charles Darwin's Theory of Natural Selection.");
		sitePageEditorPage.waitInMiliSeconds(5000);
	}
}
