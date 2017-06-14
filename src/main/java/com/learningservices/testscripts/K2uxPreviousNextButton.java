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
import com.learningservices.utils.DataUtils;
import com.learningservices.utils.EmailReport;
import com.learningservices.utils.Log;
import com.learningservices.utils.BrowserDriver;

/**
 * @author rachit.d
 *
 */

@Listeners(EmailReport.class)
public class K2uxPreviousNextButton extends BrowserDriver {

	@BeforeClass()
	public void driverInitialize(){
		getWebDriver().get(applicationUrl);
	}
	
	@BeforeMethod()
	public void waitForElements(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterClass()
	public void driverQuit(){
		driver.quit();
	}
	
	@Test(enabled = true, priority = 5, description = "TC ID 284512, 284513, 284514, 284515, 284516  ")
	public void verifybooknavigationbuttons() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.clickBookOne();
		Log.message("Starting Test Case with tc_ID : 284514");
		// tc_ID :284514
		book.verify(driver, K2uxBookPage.disabledpreviouspagebutton);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284512");
		// tc_ID :284512
		book.click(driver, K2uxBookPage.nextpagebutton);
		Thread.sleep(10000);
		book.verifyPageNumber();
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284513");
		// tc_ID : 284513
		book.click(driver, K2uxBookPage.previouspagebutton);
		Thread.sleep(10000);
		book.verifyPageNumber();
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284515");
		// tc_ID : 284515
		book.click(driver, K2uxBookPage.pagenumber);
		book.clear(driver, K2uxBookPage.pagenumber);
		book.sendKeys(driver, K2uxBookPage.pagenumber, "490");
		book.press_enter(driver, K2uxBookPage.pagenumber);
		Thread.sleep(10000);
		book.verify(driver, K2uxBookPage.disablednextpagebutton);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284516");
		// tc_ID : 284516
		book.clear(driver, K2uxBookPage.pagenumber);
		book.randomPageNumberInput();
		book.press_enter(driver, K2uxBookPage.pagenumber);
		Thread.sleep(5000);
		book.verifyPageNumber();
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
}
