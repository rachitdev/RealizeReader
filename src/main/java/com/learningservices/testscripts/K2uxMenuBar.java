/**
 * 
 */
package com.learningservices.testscripts;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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
		
	}
	
	@BeforeMethod()
	public void waitForElements(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("static-access")
	@Test(enabled = true, priority = 7, description = "TC ID 277589, 277590, 277591, 277592, 277593, 277594, 277595, 277596, 277597, 277600, 277602, 287969, 287970")
	public void verifyToggle() throws InterruptedException, IOException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		// tc_ID :277589
		Log.message("Starting Test Case with tc_ID : 277589");
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
		// tc_ID :277598
		Log.message("Starting Test Case with tc_ID : 277598");
		book.click(driver, K2uxLoginPage.toggle);
		book.setBrowserSize(driver, 800, 576);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		driver.manage().window().maximize();
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277601
		Log.message("Starting Test Case with tc_ID : 277601");
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.setBrowserSize(driver, 800, 767);
		book.verify(driver, K2uxBookPage.printthispage);
		book.verify(driver, K2uxBookPage.bookinfo);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		driver.manage().window().maximize();
		Log.testCaseResult();
		Log.endTestCase();	
		book.click(driver, K2uxBookPage.backtobookshelf);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		driver.navigate().refresh();
	}
	
	@Test(enabled = true, priority = 8, description = "TC ID 277603")
	public void verifyLongNameTruncation() throws InterruptedException, IOException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_14", "LoginCredentials");
		driver.navigate().refresh();
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		String fName = K2uxLoginPage.k2avatarButton.getText();
		Log.message("The First Name is: " + fName, driver);
		if (fName != "RealizeReaderELUXLongFirstLastName" ){
			Log.message("The First Name got Truncated on Avatar!", driver);
		}else {
			Log.message("The First Name is not Truncated on Avatar!", driver);
		}
		Log.testCaseResult();
		Log.endTestCase();	
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		driver.quit();
		}
	
}