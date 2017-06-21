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
	public void testMultipleBooks() throws InterruptedException, Exception  {
		K2uxLoginPage login = new K2uxLoginPage(driver);
		K2uxBookPage book = new K2uxBookPage(driver);
		login.autoLogin("tc_01");
		//Iterator logic to iterate through first 10 books.
		for (int i=1;i<=10;i++)
		{      
		Serializable itr = String.valueOf(i);
		Serializable bid = "BID_" + itr;
		Log.message("The xpath to be accessed has an id: "+bid);
		//Starting logic to access xpath from excel sheet.
		HashMap<String, String> bookData = DataUtils.testBookbyID(bid, "BookSelection");
		String book_xpath = bookData.get("Book_Xpath");
		if (book_xpath != null && driver.findElement(By.xpath(book_xpath)).isEnabled())
			{
		bookElement = driver.findElement(By.xpath(book_xpath));
		Log.message("Found "+ bookElement +" to click and open the book!");
		//Logic to find xpath from excel sheet ends.
		book.click(driver, bookElement);
		book.verify(driver, K2uxBookPage.disabledpreviouspagebutton);
		book.click(driver, K2uxBookPage.backtobookshelf);
		Log.testCaseResult();
		Log.endTestCase();
			}if (book_xpath == null){
		Log.message(bookElement +" not found," + " Or Serialization Failed!");
		//Serialization failed.
		Log.testCaseResult();
		Log.endTestCase();
									}
		}
		book.click(driver, K2uxLoginPage.k2avatarButton);
		book.click(driver, K2uxLoginPage.signout);
		Log.testCaseResult();
		Log.endTestCase();	
	}
}
