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
import com.learningservices.pages.web.NoteBookPage;
import com.learningservices.utils.BrowserDriver;
import com.learningservices.utils.EmailReport;

/**
 * @author rachit.d
 *
 */
abstract@Listeners(EmailReport.class)
public class SelectionByBookID extends BrowserDriver {

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
	
	@Test(enabled = true, description = "Testing multiple books")
	public void SelectBookProgrammatically() throws InterruptedException, Exception  {
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		login.autoLogin("tc_15");
		login.selectbookByID(driver, "18VV9Q6D7AH");
		book.verify(driver, NoteBookPage.goTOField);
		Thread.sleep(2000);
	
	}
	
}
