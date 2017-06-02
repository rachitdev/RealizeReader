/**
 * 
 */
package com.learningservices.testscripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

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
public class K2uxTopMenu extends BrowserDriver {

	@BeforeClass()
	public void driverInitialize(){
		getWebDriver().get(applicationUrl);
	}
	
	@AfterClass()
	public void driverQuit(){
		driver.quit();
	}
	
	@Test(enabled = true, priority = 1, description = "TC ID 284518,  ")
	public void verifyTopMenu() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.select_random_book();
		Log.message("Starting Test Case with tc_ID : 284518");
		// tc_ID :284518
		book.verify(driver, K2uxBookPage.tableofcontent);
		Log.message("Starting Test Case with tc_ID : 284519");
		// tc_ID :284519
		book.verify(driver, K2uxBookPage.glossary);
		Log.message("Starting Test Case with tc_ID : 284520");
		// tc_ID : 284520
		book.click(driver, K2uxBookPage.tableofcontent);
		book.getBGColor(driver, K2uxBookPage.tableofcontent);
		book.getoutlinecolor(driver, K2uxBookPage.tableofcontent);
		book.click(driver, K2uxBookPage.closetableofcontent);
		Log.message("Starting Test Case with tc_ID : 284521");
		// tc_ID : 284521
		book.click(driver, K2uxBookPage.glossary);
		book.getBGColor(driver, K2uxBookPage.glossary);
		book.getoutlinecolor(driver, K2uxBookPage.glossary);
		book.click(driver, K2uxBookPage.closeglossary);
		Log.message("Starting Test Case with tc_ID : 284522");
		// tc_ID : 284522
		book.fontSize(driver, K2uxBookPage.tableofcontent);
		book.hover(driver, K2uxBookPage.tableofcontent);
		book.fontSize(driver, K2uxBookPage.tableofcontent);
		Log.message("Starting Test Case with tc_ID : 284523");
		// tc_ID : 284523
		book.fontSize(driver, K2uxBookPage.glossary);
		book.hover(driver, K2uxBookPage.glossary);
		book.fontSize(driver, K2uxBookPage.glossary);
		Log.message("Starting Test Case with tc_ID : 284524");
		// tc_ID : 284524
		K2uxBookPage.zoom(driver, 1.5);
		book.verify(driver, K2uxBookPage.tableofcontent);
		book.verify(driver, K2uxBookPage.glossary);
		K2uxBookPage.zoom(driver, 1.0);
		Log.message("Starting Test Case with tc_ID : 284526");
		// tc_ID : 284526
		book.click(driver, K2uxBookPage.tableofcontent);
		book.verify(driver, "a");
		book.click(driver, K2uxBookPage.closetableofcontent);
		Log.message("Starting Test Case with tc_ID : 284527");
		// tc_ID : 284527
		book.click(driver, K2uxBookPage.tableofcontent);
		login.isTextPresent("1");
		login.isTextPresent("2");
		login.isTextPresent("3");
		login.isTextPresent("Introduction");
		book.click(driver, K2uxBookPage.closetableofcontent);
		Log.message("Starting Test Case with tc_ID : 284528");
		// tc_ID : 284528
		
		
		

		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
}
