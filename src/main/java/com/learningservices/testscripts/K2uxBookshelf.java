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
public class K2uxBookshelf extends BrowserDriver {
	
	@BeforeClass()
	public void driverInitialize(){
		getWebDriver().get(applicationUrl);
	}
	
	@AfterClass()
	public void driverQuit(){
		driver.quit();
	}
			
	@Test(enabled = true, priority = 1, description = "TC ID 277575, 277576, 277577")
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
		// tc_ID :277576
		Log.message("Starting Test Case with tc_ID : 277576");
		login.bookscount();
		//login.bookOneClick();
		login.select_random_book();
		Thread.sleep(7000);
		book.verify(driver, K2uxBookPage.backtobookshelf);
		// tc_ID :277577
		Log.message("Starting Test Case with tc_ID : 277577");
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.message("Back to Bookshelf!");
		login.bookscount();
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = true, priority = 2, description = "TC ID 277578")
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
		login.bookscount();
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = true, priority = 3, description = "TC ID 277580")
	public void noDownload() throws InterruptedException {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277580
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277580");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.isTextPresent("download book");
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = true, priority = 4, description = "TC ID 277581")
	public void verifyK2Avatar() throws InterruptedException {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277581
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277581");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = true, priority = 5, description = "TC ID 277582")
	public void verifyName() throws InterruptedException {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277582
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277582");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		login.isTextPresent("Thakur");
		//login.getK2uxBGcolor();
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = true, priority = 6, description = "TC ID 277583")
	public void aboutRR() throws InterruptedException {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277583
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277583");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
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
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = true, priority = 7, description = "TC ID 277584")
	public void verifyLogout() throws InterruptedException {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277584
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277584");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		book.verify(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		login.isTextPresent("Sign Out");
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
}
