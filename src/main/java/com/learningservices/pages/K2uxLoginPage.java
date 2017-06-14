package com.learningservices.pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import com.learningservices.utils.Log;
import com.learningservices.utils.WaitUtil;

public class K2uxLoginPage extends LoadableComponent<K2uxLoginPage> {

	/** The is page loaded. */

	private boolean isPageLoaded;

	/** The driver. */
	private WebDriver driver;

	@FindBy(id = "username")
	public static WebElement username;

	@FindBy(id = "password")
	public static WebElement password;

	@FindBy(css = "#sign_in")
	public static WebElement loginButton;

	@FindBy(css = "#control-panel-items")
	public static WebElement avatarButton;

	@FindBy(xpath = "//button[@class = 'avatar-div']") // .avatar-div
	public static WebElement k2avatarButton;

	@FindBy(xpath = "//*[@id='logoutButton']")
	public static WebElement signout;

	@FindBy(xpath = "//a[contains(.,'About')][@role = 'button']")
	public static WebElement about;

	@FindBy(xpath = "//*[@id='about-modal']/div/div/div[1]/button")
	public static WebElement closeAbout;

	@FindBy(xpath = "//a[@href = 'https://media.pearsoncmg.com/cmg/NexText/about/legalnotice/index.html']")
	public static WebElement legalNotice;

	@FindBy(xpath = "//a[@href = 'https://pearson.com/privacy/learning-services-privacy-policy.html']")
	public static WebElement privacyPolicy;

	@FindBy(xpath = "//a[@href = 'https://pearsonnacommunity.force.com/support/s/']")
	public static WebElement support;

	@FindBy(xpath = "//a[@href = 'https://media.pearsoncmg.com/cmg/NexText/about/permissions/index.html']")
	public static WebElement permissions;

	@FindBy(xpath = "//img[@csp-src = 'https://content.stg-openclass.com/eps/pearson-reader/api/item/4041ba39-ab8a-44de-ab2b-4ec79c4562a1/1/file/images/cover_thumbnail.jpg']")
	public static WebElement bookOne;

	@FindBy(xpath = "//*[contains(text(), 'Copyright')]")
	public static WebElement bookOne_copyright;
	
	@FindBy(xpath = "//*[contains(text(), 'To the Student')]")
	public static WebElement bookOne_tothestudent;
	
	@FindBy(xpath = "//*[contains(text(), 'To the Instructor')]")
	public static WebElement bookOne_totheinstructor;
	
	@FindBy(xpath = "//*[contains(text(), 'An Introduction to')]")
	public static WebElement bookOne_anintro;
	
	@FindBy(xpath = "//*[contains(text(), 'Ancillaries')]")
	public static WebElement bookOne_ancillaries;
	
	@FindBy(xpath = "//h2[@class = 'sidebar-menu-item-header']")
	public static WebElement bookOne_glossary_header;
	
	@FindBy(xpath = ".//*[@id='grid-view']/div/div[1]/div/div[2]/a/img")
	public static WebElement classicBookOne;

	@FindBy(css = ".big_logo")
	public static WebElement K2Logo;

	@FindBy(css = "#settingsBtn")
	public static WebElement toggle;

	@FindBy(css = "#onlineIndicatorLabel")
	public static WebElement onlineIndicator;

	@FindBy(xpath = "//img[@csp-src = 'http://content.stg-openclass.com/eps/pearson-reader/api/item/8d6d367c-dc83-47cc-8709-24053820b57c/1/file/2/112375-coverjpg']")
	public static WebElement printable_book;

	@FindBy(xpath = "//img[@csp-src = 'https://content.stg-openclass.com/eps/pearson-reader/api/item/e4013832-b5fb-4690-a984-b4070b833696/3/file/cover_thumbnail.jpg']")
	public static WebElement nonPrintable_book;

	@Override
	protected void load() {
		if (!isPageLoaded) {
			Log.fail("Login page did not open up.", driver);
		}
	}

	@Override
	protected void isLoaded() throws Error {
		try {
			WaitUtil.waitForTheElementVisible(driver, 5, By.id("username"));
			isPageLoaded = true;
			Log.message("Login page is displayed!", driver);
		} catch (Exception e1) {
			isPageLoaded = false;
			throw new Error();
		}

	}

	public K2uxLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String usrname) {
		username.sendKeys(usrname);
		Log.message("Entered username is: " + usrname, driver);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
		Log.message("Entered Password is: " + pwd, driver);
	}

	public void verifyTitle() {
		String str = driver.getTitle();
		Log.message("Title of Page is: " + str);
	}

	public void clickBookOne() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='3px solid red'", bookOne);
		executor.executeScript("arguments[0].click();", bookOne);
		if (K2uxBookPage.nextpagebutton.isEnabled()) {
			Log.message("Next Page button is present, First book is open!", driver);
		} else {
			Log.message("Next Page button is absent, book not loaded!", driver);
		}
	}

	public void clickPrintableBook() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", printable_book);
		Thread.sleep(5000);
		executor.executeScript("arguments[0].style.border='3px solid red'", printable_book);
		executor.executeScript("arguments[0].click();", printable_book);
		if (K2uxBookPage.nextpagebutton.isEnabled()) {
			Log.message("Next Page button is present, book is open!", driver);
		} else {
			Log.message("Next Page button is absent, book is not open!", driver);
		}
	}

	public void clickNonPrintableBook() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", nonPrintable_book);
		Thread.sleep(5000);
		executor.executeScript("arguments[0].style.border='3px solid red'", nonPrintable_book);
		executor.executeScript("arguments[0].click();", nonPrintable_book);
		if (K2uxBookPage.nextpagebutton.isEnabled()) {
			Log.message("Next Page button is present, book is open!", driver);
		} else {
			Log.message("Next Page button is absent, book is not open!", driver);
		}
	}

	public void bookscount() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (bookOne.isEnabled()){
		List<WebElement> numberofbooks = driver.findElements(By.tagName("img"));
		int booksCount = numberofbooks.size();
		Log.message("Number of Books are: " + booksCount);
		}
	}

	public void select_random_book() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (bookOne.isEnabled()){
		List<WebElement> books = driver.findElements(By.tagName("img"));
		Random r = new Random();
		int randomBook = r.nextInt(books.size());
		// Getting a random book that is between 0 and (list's size)-1
		Log.message("The book to be opened has the number on bookshelf: " + randomBook);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", books.get(randomBook));
		Thread.sleep(10000);
		executor.executeScript("arguments[0].style.border='3px solid red'", books.get(randomBook));
		boolean bool = books.get(randomBook).isDisplayed();
		Log.message("Random Book condition to be clickable is: " + bool);
	
		if (!bool) {
			executor.executeScript("arguments[0].scrollIntoView(true);", printable_book);
			Thread.sleep(5000);
			executor.executeScript("arguments[0].style.border='3px solid red'", printable_book);
			executor.executeScript("arguments[0].click();", printable_book);
			Log.message("Opening printable book!");
			if (K2uxBookPage.nextpagebutton.isEnabled()) {
				Log.message("Next Page button is present, book is open!", driver);
			} else {
				Log.message("Next Page button is absent, book is not open!", driver);
			}
		} else {
			executor.executeScript("arguments[0].click();", books.get(randomBook));
			// Clicking on the random book in the list of bookshelf.
			Log.message("Opening the above mentioned book!");
			if (K2uxBookPage.nextpagebutton.isEnabled()) {
				Log.message("Next Page button is present, book is open!", driver);
			} else {
				Log.message("Next Page button is absent, book is not open!", driver);
			}
		}
		}
		}
	

	public boolean isTextPresent(String text) {
		try {
			boolean b = driver.getPageSource().contains(text);
			Log.message(text + " (text is present here!)");
			return b;
		} catch (Exception e) {
			Log.message(text + " (text is not present here!)");
			return false;
		}
	}

}
