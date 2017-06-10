package com.learningservices.pages;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import com.learningservices.utils.Log;
//import com.learningservices.utils.WaitUtil;

/**
 * @author rachit.d
 *
 */
public class K2uxBookPage extends LoadableComponent<K2uxBookPage> {

	/** The is page loaded. */

	private boolean isPageLoaded;

	/** The driver. */
	private WebDriver driver;

	@FindBy(css = ".rr-logo-button")
	public static WebElement backtobookshelf;

	@FindBy(css = "#menu-item-0")
	public static WebElement tableofcontent;

	@FindBy(css = "#sideBarClose")
	public static WebElement closetableofcontent_glossary;

	@FindBy(css = "#menu-item-1")
	public static WebElement glossary;

//	@FindBy(css = "#sideBarClose")
//	public static WebElement closeglossary;

	@FindBy(css = "#settingsBtn")
	public static WebElement settings;

	@FindBy(css = ".nav-prev-small")
	public static WebElement previouspage;

	@FindBy(css = ".nav-next-small")
	public static WebElement nextpage;

	@FindBy(css = "#page-number")
	public static WebElement pagenumber;

	@FindBy(xpath = "//input[@class = 'bookPageNumber ng-pristine ng-valid ng-valid-maxlength ng-not-empty ng-touched']")
	public static WebElement classicPageNumber;

	@FindBy(css = "#onlineIndicatorLabel")
	public static WebElement onlineindicator;

	@FindBy(css = ".menu-item.printMenuItem")
	public static WebElement printthispage;

	@FindBy(css = ".menu-item.bookInfoMenuItem")
	public static WebElement bookinfo;

	@FindBy(xpath = "html/body/app/div/div/book-component/rr-book-info-modal/div/div/div/div[1]/button")
	public static WebElement closeBookinfo;

	@FindBy(css = ".menu-item.fontSettingsMenuItem")
	public static WebElement fontsetting;

	@FindBy(xpath = ".//*[@id='text-size-modal']/div/div/div[1]/button")
	public static WebElement closefontsetting;

	@FindBy(xpath = ".//*[@id='text-size-modal']/div/div/div[2]/div[2]/button[1]")
	public static WebElement textSizeSmall;

	@FindBy(xpath = ".//*[@id='text-size-modal']/div/div/div[2]/div[2]/button[2]")
	public static WebElement textSizeMedium;

	@FindBy(xpath = ".//*[@id='text-size-modal']/div/div/div[2]/div[2]/button[3]")
	public static WebElement textSizeLarge;

	@FindBy(css = ".isbn-details")
	public static WebElement isbn;

	@FindBy(xpath = "//button[@class = 'nav-next-small']")
	public static WebElement nextpagebutton;

	@FindBy(xpath = "//button[@class = 'nav-next-small disabled']")
	public static WebElement disablednextpagebutton;

	@FindBy(xpath = "//button[@class = 'nav-prev-small']")
	public static WebElement previouspagebutton;

	@FindBy(xpath = "//button[@class = 'nav-prev-small disabled']")
	public static WebElement disabledpreviouspagebutton;

	@Override
	protected void load() {
		if (!isPageLoaded) {
			Log.fail("Book page did not open up.", driver);
		}
	}

	@Override
	protected void isLoaded() throws Error {
		try {
			if (pagenumber.isDisplayed()) {
				isPageLoaded = true;
				Log.message("Book page is displayed!", driver);
			} else {
				classicPageNumber.isDisplayed();
				isPageLoaded = true;
				Log.message("Book page is displayed!", driver);
			}
		} catch (Exception e1) {
			isPageLoaded = false;
			throw new Error();
		}

	}

	public K2uxBookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void click(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (element.isEnabled()) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='3px solid red'", element);
		executor.executeScript("arguments[0].click();", element);
		executor.executeScript("arguments[0].style.border=''", element);
		Log.message("Clicked on " + element, driver);
		}else{
			Log.message(element + " not found!");
		}
	}

	public void clear(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (element.isEnabled()) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='3px solid red'", element);
		element.clear();
		executor.executeScript("arguments[0].style.border=''", element);
		Log.message("Cleared " + element, driver);
		}else{
			Log.message(element + " not found!", driver);
		}
	}

	public void randomPageNumberInput() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Random r = new Random();
		int randomNumber = r.ints(1, 50, 100).findFirst().getAsInt();
		String page_num = String.valueOf(randomNumber);
		pagenumber.sendKeys(page_num);
		Log.message("Opening Page number: " + page_num);
	}

	public void verifyPageNumber() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String num1 = pagenumber.getAttribute("ng-model");
		String num = pagenumber.getText();
		if (num != null) {
			Log.message("The Book is on Page Number: " + num + num1);
		} else {
			Log.message("Cannot Get Page Number!");
		}

	}

	public void getBGColor(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (element.isDisplayed()) {
		String color = element.getCssValue("background-color");
		Log.message("The background color of " + element + " is " + color, driver);
		}else{
			Log.message(element + " not found!");
		}
	}

	public void getoutlinecolor(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (element.isDisplayed()) {
		String color = element.getCssValue("border-color");
		Log.message("The outline of " + element + " is of color " + color, driver);
		}else{
			Log.message(element + " not found!");
		}
	}

	public void verify(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (element.isDisplayed()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].style.border='3px solid red'", element);
			Log.message(element + " is present!", driver);
			executor.executeScript("arguments[0].style.border=''", element);
		} else {
			Log.message(element + " is absent!", driver);
		}
	}

	public void verify(WebDriver driver, String tagname) throws InterruptedException {
		List<WebElement> elements = driver.findElements(By.tagName(tagname));
		int eleCount = elements.size();
		Log.message("Number of elements are: " + eleCount);
	}

	public void sendKeys(WebDriver driver, WebElement element, String str) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='3px solid red'", element);
		element.sendKeys(str);
		executor.executeScript("arguments[0].style.border=''", element);
		Log.message("Sending String " + str + " to " + element, driver);
	}

	public void press_enter(WebDriver driver, WebElement element) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='3px solid red'", element);
		element.sendKeys(Keys.RETURN);
		executor.executeScript("arguments[0].style.border=''", element);
		Log.message("Pressed Enter On element: " + element, driver);
		Thread.sleep(10000);
	}

	public void hover(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		Log.message("Hovering On " + element, driver);
	}

	public void fontSize(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String fontsize = element.getCssValue("font-size");
		Log.message("Font Size is: " + fontsize, driver);

	}

	public static void switchToNewTabAndBack(WebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Log.message("Switched to new Tab!");
		String str = driver.getTitle();
		Log.message("Title of Page (new Tab) is: " + str);
		driver.close();
		Log.message("Closed the new Tab!");
		driver.switchTo().window(tabs.get(0));
		Log.message("Switched to old Tab!");
	}
	
	public static void switchToNewTabAndBackandVerifyPrint(WebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Log.message("Switched to new Tab!");
		String str = driver.getTitle();
		Log.message("Title of Page (new Tab) is: " + str);
		if (driver.findElement(By.cssSelector("#printBtn")).isDisplayed()) {
			Log.message("Print Button is present!", driver);
		} else {
			Log.message("Print Button is absent!", driver);
		}
		driver.close();
		Log.message("Closed the new Tab!");
		driver.switchTo().window(tabs.get(0));
		Log.message("Switched to old Tab!");
	}

	public static void zoom(WebDriver driver, double zoom) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom = '" + zoom + "'"); // 1.5 represents  150%
		Log.message("Zoomed to " + zoom * 100 + " percent!");
	}

}

