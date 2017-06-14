/**
 * 
 */
package com.learningservices.testscripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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

/**
 * @author rachit.d
 *
 */

@Listeners(EmailReport.class)
public class K2uxMenuBar extends BrowserDriver {

	@BeforeClass()
	public void driverInitialize(){
		getWebDriver().get(applicationUrl);
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
	}
	
	@BeforeMethod()
	public void waitForElements(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterClass()
	public void driverQuit() throws InterruptedException{driver.quit();}
	
	@Test(enabled = true, priority = 7, description = "TC ID 277589, 277590, 277591, 277592, 277593, 277594, 277595, 277596, 277597, 277600, 277602, 277603 287969, 287970")
	public void verifyToggle() throws InterruptedException  {
		// tc_ID :277589
		Log.message("Starting Test Case with tc_ID : 277589");
		K2uxBookPage book = new K2uxBookPage(driver);
		K2uxLoginPage login = new K2uxLoginPage(driver);
		book.verify(driver, K2uxLoginPage.toggle);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277590
		Log.message("Starting Test Case with tc_ID : 277590");
		book.verify(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277591
		Log.message("Starting Test Case with tc_ID : 277591");
		login.select_random_book();
		book.verify(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxLoginPage.toggle);
		Thread.sleep(3000);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277592
		Log.message("Starting Test Case with tc_ID : 277592");
		login.select_random_book();
		book.verify(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.verify(driver, K2uxBookPage.printthispage);
		book.verify(driver, K2uxBookPage.bookinfo);
		book.verify(driver, K2uxBookPage.fontsetting);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277593
		Log.message("Starting Test Case with tc_ID : 277593");
		login.clickPrintableBook();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxBookPage.printthispage);
		book.click(driver, K2uxBookPage.printthispage);
		K2uxBookPage.switchToNewTabAndBackandVerifyPrint(driver);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277594
		Log.message("Starting Test Case with tc_ID : 277594");
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxBookPage.bookinfo);
		book.click(driver, K2uxBookPage.bookinfo);
		book.verify(driver, K2uxBookPage.isbn);
		book.click(driver, K2uxBookPage.closeBookinfo);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277595
		Log.message("Starting Test Case with tc_ID : 277595");
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.fontsetting);
		book.click(driver, K2uxBookPage.textSizeMedium);
		book.click(driver, K2uxBookPage.closefontsetting);
		book.fontSize(driver, driver.findElement(By.tagName("p")));
		book.click(driver, K2uxBookPage.fontsetting);
		book.click(driver, K2uxBookPage.textSizeLarge);
		book.click(driver, K2uxBookPage.closefontsetting);
		book.fontSize(driver, driver.findElement(By.tagName("p")));
		book.click(driver, K2uxBookPage.fontsetting);
		book.click(driver, K2uxBookPage.textSizeSmall);
		book.click(driver, K2uxBookPage.closefontsetting);
		book.fontSize(driver, driver.findElement(By.tagName("p")));
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277596
		Log.message("Starting Test Case with tc_ID : 277596");
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277597
		Log.message("Starting Test Case with tc_ID : 277597");
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277600
		Log.message("Starting Test Case with tc_ID : 277600");
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.hover(driver, K2uxBookPage.printthispage);
		book.getBGColor(driver, K2uxBookPage.printthispage);
		book.hover(driver, K2uxBookPage.bookinfo);
		book.getBGColor(driver, K2uxBookPage.bookinfo);
		book.hover(driver, K2uxBookPage.fontsetting);
		book.getBGColor(driver, K2uxBookPage.fontsetting);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277602
		Log.message("Starting Test Case with tc_ID : 277602");
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277603
		Log.message("Starting Test Case with tc_ID : 277603");
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :287969
		Log.message("Starting Test Case with tc_ID : 287969");
		login.clickPrintableBook();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxBookPage.printthispage);
		book.click(driver, K2uxBookPage.printthispage);
		K2uxBookPage.switchToNewTabAndBackandVerifyPrint(driver);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :287970
		Log.message("Starting Test Case with tc_ID : 287970");
		login.clickNonPrintableBook();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxBookPage.printthispage);
		book.click(driver, K2uxBookPage.printthispage);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
	}
		
}