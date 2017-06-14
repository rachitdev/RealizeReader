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
/**
 * @author rachit.d
 *
 */
@Listeners(EmailReport.class)
public class K2uxBookshelf extends BrowserDriver {
	
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
			
	@Test(enabled = true, priority = 3, description = "TC ID 277575, 277576, 277577, 277580, 277581, 277582, 277583, 277584")
	public void verifyRRLogo() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277575
		Log.message("Starting Test Case with tc_ID : 277575");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277576
		Log.message("Starting Test Case with tc_ID : 277576");
		login.bookscount();
		login.select_random_book();
		book.verify(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277577
		Log.message("Starting Test Case with tc_ID : 277577");
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.message("Back to Bookshelf!");
		login.bookscount();
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277580
		Log.message("Starting Test Case with tc_ID : 277580");
		login.isTextPresent("download book");
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277581
		Log.message("Starting Test Case with tc_ID : 277581");
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277582
		Log.message("Starting Test Case with tc_ID : 277582");
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		login.isTextPresent("Thakur");
		book.click(driver, K2uxLoginPage.k2avatarButton);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277583
		Log.message("Starting Test Case with tc_ID : 277583");
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.about);//click about button
		book.click(driver, K2uxLoginPage.legalNotice);//click legal notice
		Thread.sleep(3000);
		K2uxBookPage.switchToNewTabAndBack(driver);
		book.click(driver, K2uxLoginPage.privacyPolicy);//click privacy policy
		Thread.sleep(3000);
		K2uxBookPage.switchToNewTabAndBack(driver);
		book.click(driver, K2uxLoginPage.support);
		Thread.sleep(3000);
		K2uxBookPage.switchToNewTabAndBack(driver);
		book.click(driver, K2uxLoginPage.permissions);//clicked permissions
		Thread.sleep(3000);
		K2uxBookPage.switchToNewTabAndBack(driver);
		book.click(driver, K2uxLoginPage.closeAbout);
		Log.testCaseResult();
		Log.endTestCase();	
		// tc_ID :277584
		Log.message("Starting Test Case with tc_ID : 277584");
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		login.isTextPresent("Sign Out");
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = true, priority = 4, description = "TC ID 277578")
	public void noBooks() throws InterruptedException {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_13", "LoginCredentials");
		// tc_ID :277578
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277578");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.isTextPresent("There are no books on your shelf.");
		//login.bookscount();
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
}
