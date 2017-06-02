/**
 * 
 */
package com.learningservices.testscripts;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learningservices.pages.K2uxBookPage;
import com.learningservices.pages.K2uxLoginPage;
import com.learningservices.utils.BrowserActions;
import com.learningservices.utils.BrowserDriver;
import com.learningservices.utils.DataUtils;
import com.learningservices.utils.Log;

/**
 * @author rachit.d
 *
 */
public class K2uxMenuBar extends BrowserDriver {

	@BeforeClass()
	public void driverInitialize(){
		getWebDriver().get(applicationUrl);
	}
	
	@AfterClass()
	public void driverQuit(){
		driver.quit();
	}
	
	@Test(enabled = false, priority = 1, description = "TC ID 277589")
	public void verifyToggle() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277589
		Log.message("Starting Test Case with tc_ID : 277589");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		book.verify(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 2, description = "TC ID 277590")
	public void clickToggle() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277590
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277590");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		book.verify(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxLoginPage.toggle);
		//book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 3, description = "TC ID 277591")
	public void bookAndToggle() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277591
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277591");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.select_random_book();
		book.verify(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxLoginPage.toggle);
		Thread.sleep(3000);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 4, description = "TC ID 277592")
	public void verifyMenuItems() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277592
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277592");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.select_random_book();
		book.verify(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.verify(driver, K2uxBookPage.printthispage);
		book.verify(driver, K2uxBookPage.bookinfo);
		book.verify(driver, K2uxBookPage.fontsetting);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 5, description = "TC ID 277593")
	public void verifyprint() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277593
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277593");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.clickPrintableBook();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxBookPage.printthispage);
		book.click(driver, K2uxBookPage.printthispage);
		BrowserActions.switchToNewTabAndBack(driver);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 6, description = "TC ID 277594")
	public void verifybookinfo() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277594
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277594");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxBookPage.bookinfo);
		book.click(driver, K2uxBookPage.bookinfo);
		book.verify(driver, K2uxBookPage.isbn);
		book.click(driver, K2uxBookPage.closeBookinfo);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 7, description = "TC ID 277595")
	public void verifyfontsetting() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277595
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277595");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
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
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	

	@Test(enabled = false, priority = 8, description = "TC ID 277596")
	public void verifydisabldedofflineaccess() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277596
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277596");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 9, description = "TC ID 277597")
	public void verifytogglewithbook() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277597
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277597");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 10, description = "TC ID 277600")
	public void verifyBGColorInMenuItems() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277600
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277600");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
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
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 11, description = "TC ID 277602")
	public void verifytogglewithbookandbookshelf() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :277602
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277602");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		login.select_random_book();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxLoginPage.onlineIndicator);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = false, priority = 12, description = "TC ID 277603")
	public void verifytruncatedlongname() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_14", "LoginCredentials");
		// tc_ID :277603
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 277603");
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
	
	@Test(enabled = false, priority = 13, description = "TC ID 287969")
	public void verifyprintablebook() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :287969
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 287969");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.clickPrintableBook();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxBookPage.printthispage);
		book.click(driver, K2uxBookPage.printthispage);
		BrowserActions.switchToNewTabAndBack(driver);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
	@Test(enabled = true, priority = 14, description = "TC ID 287970")
	public void verifynonprintablebook() throws InterruptedException  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		// tc_ID :287970
		driver.navigate().refresh();
		Log.message("Starting Test Case with tc_ID : 287970");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		login.clickNonPrintableBook();
		book.click(driver, K2uxLoginPage.toggle);
		book.verify(driver, K2uxBookPage.printthispage);
		book.click(driver, K2uxBookPage.printthispage);
		book.click(driver, K2uxLoginPage.toggle);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
	
}