/**
 * 
 */
package com.learningservices.testscripts;

import java.util.HashMap;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learningservices.pages.K2uxBookPage;
import com.learningservices.pages.K2uxLoginPage;
import com.learningservices.utils.BrowserDriver;
import com.learningservices.utils.DataUtils;
import com.learningservices.utils.Log;

//import com.learningservices.utils.WebDriverFactory;

public class K2uxLogin extends BrowserDriver {
	
	@BeforeClass()
	public void driverInitialize(){
		getWebDriver().get(applicationUrl);
	}
	
	@AfterClass()
	public void driverQuit(){
		driver.quit();
	}
	
	@Test(priority = 1, description = "Verify that the Student with K-2 UX flavor sees the same name and avatar", testName = "Login to k2ux application")
	
	public void loginK2User() throws Exception {
			HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
			// tc_ID :291532
			Log.message("Starting Test Case with tc_ID : 291532");
			K2uxLoginPage login = new K2uxLoginPage(driver);
			K2uxBookPage book = new K2uxBookPage(driver);
			String username = userData.get("Username");
			String password = userData.get("Password");
			login.enterUsername(username);
			Log.message("Entered username "+ username, driver);
			login.enterPassword(password);
			Log.message("Entered password "+ password, driver);
			book.click(driver, K2uxLoginPage.loginButton);
			book.click(driver, K2uxLoginPage.k2avatarButton);
			book.verify(driver, K2uxLoginPage.about);			
			book.verify(driver, K2uxLoginPage.signout);
			book.click(driver, K2uxLoginPage.signout);
			book.verify(driver, K2uxLoginPage.loginButton);
			Log.testCaseResult();
			Log.endTestCase();
	}

	@Test(priority = 2, description = "Verify that the Student with K2UX flavor sees his name and avatar in all pages of books while online")
	public void avatarVerification() throws Exception {
			HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
			driver.navigate().refresh();
			// tc_ID : 291533
			Log.message("Starting Test Case with tc_ID : 291533");
			K2uxLoginPage login = new K2uxLoginPage(driver);
			K2uxBookPage book = new K2uxBookPage(driver);
			String username = userData.get("Username");
			String password = userData.get("Password");
			login.enterUsername(username);
			Log.message("Entered username "+ username, driver);
			login.enterPassword(password);
			Log.message("Entered password "+ password, driver);
			book.click(driver, K2uxLoginPage.loginButton); //login complete.
			book.verify(driver, K2uxLoginPage.k2avatarButton); //K2UX Avatar is present.
			login.bookscount(); //Number of books present on the bookshelf.
			login.clickBookOne();
			Thread.sleep(10000);
			//login.select_random_book(); //randomly a book is selected.
			book.verify(driver, K2uxLoginPage.k2avatarButton);
			//verification of avatar on different page starts.
			book.click(driver, K2uxBookPage.pagenumber);
			book.clear(driver, K2uxBookPage.pagenumber);
			book.randomPageNumberInput();
			book.press_enter(driver, K2uxBookPage.pagenumber);
			book.verify(driver, K2uxLoginPage.k2avatarButton);
			//verification of avatar on different page ends.
			//verification of avatar on different page starts.
			book.click(driver, K2uxBookPage.pagenumber);
			book.clear(driver, K2uxBookPage.pagenumber);
			book.randomPageNumberInput();
			book.press_enter(driver, K2uxBookPage.pagenumber);
			book.verify(driver, K2uxLoginPage.k2avatarButton);
			//verification of avatar on different page ends.
			//verification of avatar on different page starts.
			book.click(driver, K2uxBookPage.pagenumber);
			book.clear(driver, K2uxBookPage.pagenumber);
			book.randomPageNumberInput();
			book.press_enter(driver, K2uxBookPage.pagenumber);
			book.verify(driver, K2uxLoginPage.k2avatarButton);
			//verification of avatar on different page ends.
			book.click(driver, K2uxLoginPage.k2avatarButton);
			book.click(driver, K2uxLoginPage.signout);
			Log.testCaseResult();
			Log.endTestCase();		
	}
}
