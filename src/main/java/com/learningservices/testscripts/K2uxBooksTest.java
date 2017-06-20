/**
 * 
 */
package com.learningservices.testscripts;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class K2uxBooksTest extends BrowserDriver {
	
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
	
	public static WebElement bookElement;
	
	@SuppressWarnings("static-access")
	@Test(enabled = true, description = "Testing multiple books")
	public void verifybooknavigationbuttons() throws InterruptedException, Exception  {
		HashMap<String, String> userData = DataUtils.testDatabyID("tc_01", "LoginCredentials");
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		String username = userData.get("Username");
		String password = userData.get("Password");
		login.enterUsername(username);
		login.enterPassword(password);
		book.click(driver, K2uxLoginPage.loginButton); //login complete.
		//Iterator logic to iterate through first 10 books.
		for (int i=1;i<=10;i++)
		{      
		String str = String.valueOf(i);
		Serializable bid = "BID_" + str;
		Log.message("The xpath to be accessed has an id: "+bid);
		//starting logic to access book from excel sheet.
		HashMap<String, String> bookData = DataUtils.testDatabyID((String) bid, "BookSelection");
		String book_xpath = bookData.get("Book_Xpath");
		if (driver.findElement(By.xpath(book_xpath)).isDisplayed()){
		bookElement = driver.findElement(By.xpath(book_xpath));
		Log.message("Found "+ bookElement +" to click on book!");
		}else{
		Log.message(bookElement +" not found!");
		}
		book.click(driver, bookElement);
		Thread.sleep(15000);
		book.verify(driver, K2uxBookPage.disabledpreviouspagebutton);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Thread.sleep(5000);
		}
	}
}
