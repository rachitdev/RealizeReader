/**
 * 
 */
package com.learningservices.testscripts;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.learningservices.pages.K2uxBookPage;
import com.learningservices.pages.K2uxLoginPage;
import com.learningservices.utils.BrowserDriver;
import com.learningservices.utils.EmailReport;
import com.learningservices.utils.Log;

/**
 * @author rachit.d
 *
 */

@Listeners(EmailReport.class)
public class K2uxTopMenu extends BrowserDriver {

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
	
	@SuppressWarnings("static-access")
	@Test(enabled = true, priority = 6, description = "TC ID 284518, 284519, 284520, 284521, 284522,"
			+ " 284523, 284524, 284526, 284527, 284528, 284529, 284530")
	public void verifyTopMenu() throws InterruptedException  {
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		login.autoLogin("tc_01");
		login.select_random_book();
		Log.message("Starting Test Case with tc_ID : 284518");
		// tc_ID :284518
		book.verify(driver, K2uxBookPage.tableofcontent);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284519");
		// tc_ID :284519
		book.verify(driver, K2uxBookPage.glossary);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284520");
		// tc_ID : 284520
		book.click(driver, K2uxBookPage.tableofcontent);
		book.getBGColor(driver, K2uxBookPage.tableofcontent);
		book.getoutlinecolor(driver, K2uxBookPage.tableofcontent);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284521");
		// tc_ID : 284521
		book.click(driver, K2uxBookPage.glossary);
		book.getBGColor(driver, K2uxBookPage.glossary);
		book.getoutlinecolor(driver, K2uxBookPage.glossary);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284522");
		// tc_ID : 284522
		book.fontSize(driver, K2uxBookPage.tableofcontent);
		book.hover(driver, K2uxBookPage.tableofcontent);
		book.fontSize(driver, K2uxBookPage.tableofcontent);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284523");
		// tc_ID : 284523
		book.fontSize(driver, K2uxBookPage.glossary);
		book.hover(driver, K2uxBookPage.glossary);
		book.fontSize(driver, K2uxBookPage.glossary);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284524");
		// tc_ID : 284524
		K2uxBookPage.zoom(driver, 1.5);
		book.verify(driver, K2uxBookPage.tableofcontent);
		book.verify(driver, K2uxBookPage.glossary);
		K2uxBookPage.zoom(driver, 1.0);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284526");
		// tc_ID : 284526
		book.click(driver, K2uxBookPage.tableofcontent);
		book.verify(driver, "a");
		Log.message("The above mentioned elements refer to the elements in " + K2uxBookPage.tableofcontent);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284527");
		// tc_ID : 284527
		book.click(driver, K2uxBookPage.tableofcontent);
		login.isTextPresent("1");
		login.isTextPresent("2");
		login.isTextPresent("3");
		login.isTextPresent("Introduction");
		Log.testCaseResult();
		Log.endTestCase();	
//		Log.message("Starting Test Case with tc_ID : 284528");
//		 //tc_ID : 284528
//    	book.click(driver, K2uxBookPage.backtobookshelf);
//    	book.verify(driver, K2uxLoginPage.k2avatarButton);
//		login.bookscount();
//		login.clickBookOne();
//		book.click(driver, K2uxBookPage.tableofcontent);
//		book.click(driver, K2uxLoginPage.bookOne_copyright);
//		Thread.sleep(5000);
//		login.isTextPresent("ISBN: 0133794741");
//		book.click(driver, K2uxLoginPage.bookOne_tothestudent);
//		Thread.sleep(5000);
//		login.isTextPresent("A Last Word...");
//		book.click(driver, K2uxLoginPage.bookOne_totheinstructor);
//		Thread.sleep(5000);
//		login.isTextPresent("Development Across the Life Span");
//		book.click(driver, K2uxLoginPage.bookOne_ancillaries);
//		Thread.sleep(5000);
//		login.isTextPresent("www.pearsonhighered.com");
//		Log.testCaseResult();
//		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284530");
		// tc_ID : 284530
		book.click(driver, K2uxBookPage.glossary);
		book.verify(driver, K2uxLoginPage.bookOne_glossary_header);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284529");
		// tc_ID : 284529
		book.click(driver, K2uxBookPage.tableofcontent);
		book.verify(driver, K2uxBookPage.closetableofcontent_glossary);
		K2uxBookPage.closetableofcontent_glossary.click();
		Log.message("Clicked on Element: " + K2uxBookPage.closetableofcontent_glossary);
		book.click(driver, K2uxBookPage.backtobookshelf);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
}


