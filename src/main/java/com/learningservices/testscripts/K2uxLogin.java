/**
 * 
 */
package com.learningservices.testscripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.learningservices.pages.K2uxBookPage;
import com.learningservices.pages.K2uxLoginPage;
import com.learningservices.utils.BrowserDriver;
import com.learningservices.utils.DataUtils;
import com.learningservices.utils.EmailReport;
import com.learningservices.utils.Log;

@Listeners(EmailReport.class)
public class K2uxLogin extends BrowserDriver {
	
	@BeforeClass()
	public void driverInitialize(){
		getWebDriver().get(applicationUrl);
	}
	
	@BeforeMethod()
	public void waitForElements(){
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	@AfterClass()
	public void driverQuit(){
		driver.quit();
	}
	
	@SuppressWarnings("static-access")
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
			login.enterPassword(password);
			book.click(driver, K2uxLoginPage.loginButton);
			book.click(driver, K2uxLoginPage.k2avatarButton);
			book.verify(driver, K2uxLoginPage.about);			
			book.verify(driver, K2uxLoginPage.signout);
			book.click(driver, K2uxLoginPage.signout);
			book.verify(driver, K2uxLoginPage.loginButton);
			Log.testCaseResult();
			Log.endTestCase();
	}

	@SuppressWarnings("static-access")
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
			login.enterPassword(password);
			book.click(driver, K2uxLoginPage.loginButton); //login complete.
			book.verify(driver, K2uxLoginPage.k2avatarButton);
			login.clickBookOne();
			book.verify(driver, K2uxLoginPage.k2avatarButton);
			//verification of avatar on different page starts.
			book.verify(driver, K2uxBookPage.pagenumber);
			book.clear(driver, K2uxBookPage.pagenumber);
			book.randomPageNumberInput();
			book.press_enter(driver, K2uxBookPage.pagenumber);
			book.verify(driver, K2uxLoginPage.k2avatarButton);
			//verification of avatar on different page ends.
			//verification of avatar on different page starts.
			book.clear(driver, K2uxBookPage.pagenumber);
			book.randomPageNumberInput();
			book.press_enter(driver, K2uxBookPage.pagenumber);
			book.verify(driver, K2uxLoginPage.k2avatarButton);
			//verification of avatar on different page ends.
			//verification of avatar on different page starts.
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
