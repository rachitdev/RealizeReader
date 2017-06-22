/**
 * 
 */
package com.learningservices.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.learningservices.pages.K2uxBookPage;
import com.learningservices.pages.K2uxLoginPage;
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
	
	@SuppressWarnings("static-access")
	@AfterClass()
	public void driverQuit() throws InterruptedException{
		K2uxBookPage book = new K2uxBookPage(driver);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		driver.quit();
	}
	
	@Test(enabled = true, priority = 5, description = "TC ID 284512, 284513, 284514, 284515, 284516, 284517")
	public static void verifybooknavigationbuttons() throws InterruptedException, Exception  {
		K2uxLoginPage login = new K2uxLoginPage(driver);
		login.autoLogin("tc_01");
		login.clickBookOne();
		K2uxPreviousNextButton.testStepsOfverifybooknavigationbuttons();
	}
	
	@SuppressWarnings("static-access")
	public static void testStepsOfverifybooknavigationbuttons() throws InterruptedException, IOException{
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		Log.message("Starting Test Case with tc_ID : 284514");
		// tc_ID :284514
		book.verify(driver, K2uxBookPage.disabledpreviouspagebutton);
		book.verifyPageNumber();//the book is on page number 1
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284512");
		// tc_ID :284512
		book.clear(driver, K2uxBookPage.pagenumber);
		book.sendKeys(driver, K2uxBookPage.pagenumber, "2"); // the book is on page number 2
		book.press_enter(driver, K2uxBookPage.pagenumber);
		Thread.sleep(5000);
		book.click(driver, K2uxBookPage.nextpagebutton); // the book is on page number 3
		Thread.sleep(5000);
		book.verifyPageNumber();
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284513");
		// tc_ID : 284513
		book.click(driver, K2uxBookPage.previouspagebutton); //the book is on page number 2
		Thread.sleep(5000);
		book.verifyPageNumber();
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284515");
		// tc_ID : 284515
		book.click(driver, K2uxBookPage.pagenumber);
		book.clear(driver, K2uxBookPage.pagenumber);
		book.sendKeys(driver, K2uxBookPage.pagenumber, "490");
		book.press_enter(driver, K2uxBookPage.pagenumber);
		Thread.sleep(5000);
		book.verify(driver, K2uxBookPage.disablednextpagebutton);
		Log.testCaseResult();
		Log.endTestCase();	
		Log.message("Starting Test Case with tc_ID : 284516");
		// tc_ID : 284516
		book.clear(driver, K2uxBookPage.pagenumber);
		book.randomPageNumberInput();
		book.press_enter(driver, K2uxBookPage.pagenumber);
		book.verifyPageNumber();
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();
		Log.message("Starting Test Case with tc_ID : 284517");
		// tc_ID : 284517
		login.clickBookOne();
		book.setBrowserSize(driver, 800, 567);
		book.randomPageNumberNGInput();
		book.verify(driver, K2uxBookPage.nextpagebutton_ng);
		book.click(driver, K2uxBookPage.nextpagebutton_ng);
		book.verify(driver, K2uxBookPage.previouspagebutton_ng);
		driver.manage().window().maximize();
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();
	}
}
