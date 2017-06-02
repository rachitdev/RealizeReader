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

/**
 * @author rachit.d
 *
 */
public class K2uxLogin2 extends BrowserDriver {
	
	@BeforeClass()
	public void driverInitialize(){
		getWebDriver().get(applicationUrl);
	}
	
	@AfterClass()
	public void driverQuit(){
		driver.quit();
	}
	
	@Test(priority = 1, description = "Verify that the Student with Classic-UX flavor sees the Classic UI in all pages of books while online.")
	public void avatarVerificationClassicUser() throws Exception {
			HashMap<String, String> userData = DataUtils.testDatabyID("tc_11", "LoginCredentials");
			// tc_ID : 284510
			Log.message("Starting Test Case with tc_ID : 284510");
			K2uxLoginPage login = new K2uxLoginPage(driver);
			K2uxBookPage book = new K2uxBookPage(driver);
			String username = userData.get("Username");
			String password = userData.get("Password");
			login.enterUsername(username);
			Log.message("Entered username "+ username, driver);
			login.enterPassword(password);
			Log.message("Entered password "+ password, driver);
			book.click(driver, K2uxLoginPage.loginButton); //login complete.
			Thread.sleep(6000);
			//login.verifyk2avatar(); //K2UX Avatar is present.
			login.bookscount(); //Number of books present on the bookshelf.
			login.clickBookOne();
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
			Log.testCaseResult();
			Log.endTestCase();
	}
}
