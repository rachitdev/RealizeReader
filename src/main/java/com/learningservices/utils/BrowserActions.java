package com.learningservices.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import com.learningservices.utils.Log;

/** The Class BrowserActions. */
public class BrowserActions {

    /** Enter the text into the WebElement.
     *
     * @param inputTxt the input txt
     * @param element the element */
    public static void type(String inputTxt, WebElement element) {
        Log.event("Clearing InputText Box..");
        element.clear();
        Log.event("Sending Key as: " + inputTxt);
        element.sendKeys(inputTxt);
    }
    /** Enter the text into the WebElement without clearing previous text.
    *
    * @param inputTxt the input txt
    * @param element the element */
    public static void typeInTextBox(String inputTxt, WebElement element) {
    		Log.event("Sending Key as: " + inputTxt);
	        element.sendKeys(inputTxt);
		
	}


    /** Type.
     *
     * @param driver the driver
     * @param inputTxt the input txt
     * @param elementBy the element by
     * @param isClearTextBox the is clear text box */
    public static void type(WebDriver driver, String inputTxt, By elementBy) {
        WaitUtil.waitForIsEnabled(driver, elementBy, 60);
        WebElement element = find(driver, elementBy);
        Log.event("Sending Key as: " + StringEscapeUtils.escapeHtml4(inputTxt));
        try {
            element.clear();
            element.sendKeys(inputTxt);
        } catch (Exception e) {
            element.sendKeys(inputTxt);
        }
    }

    /** Moves to the Element.
     *
     * @param element the element */
    public static void moveTo(WebDriver driver, WebElement element) {
        Actions builder = new Actions(driver);
        Log.event("Move to the Element: " + element.toString());
        builder.moveToElement(element).build().perform();
    }

    /** Clicks on the Element.
     *
     * @param locator the locator */
    public static void click(WebDriver driver, By locator, String locatorName) {
        try {
            Log.event("Clicking on element: " + locatorName);
            WaitUtil.waitForIsEnabled(driver, locator, 30);
            find(driver, locator).click();
        } catch (Exception e) {
            if (e.getMessage().contains("not clickable")) {
                int y = driver.manage().window().getPosition().getY();
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                int startY = 0;
                while (startY < y) {
                    System.out.println("y---" + startY);
                    jsx.executeScript("window.scrollBy(0," + startY + ")", "");
                    try {
                        find(driver, locator).click();
                    } catch (Exception e2) {
                        startY += 150;
                    }
                }
            } else {
                throw new NoSuchElementException("Unable to find -" + locator);
            }
        }
        WaitUtil.waitForCATSpinner(driver, By.cssSelector(".overlayPage"));
    }

    /** Click by js.
     *
     * @param driver the driver
     * @param locator
     * @param locatorName the locator name */
    public static void clickByJS(WebDriver driver, By locator, String locatorName) {
        Log.event("Clicking on element: " + locatorName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
    }

    /** Click by js.
     *
     * @param driver the driver
     * @param element the element
     * @param locatorName the locator name */
    public static void clickByJS(WebDriver driver, WebElement element, String locatorName) {
        Log.event("Clicking on element: " + locatorName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /** Click.
     *
     * @param driver the driver
     * @param element the element
     * @param elementName the element name */
    public static void click(WebDriver driver, WebElement element, String elementName) {
        try {
            for (int attempt = 1; attempt <= 30; attempt++) {
                try {
                    if (element.isEnabled()) {
                        break;
                    }
                } catch (Exception e) {
                    WaitUtil.nap(1);
                }
            }
            Log.event("Clicking on element: " + elementName);
            element.click();
            Log.message("Clicked on element: " + elementName);
        } catch (Exception e) {
            if (e.getMessage().contains("not clickable")) {
                int y = driver.manage().window().getPosition().getY();
                JavascriptExecutor jsx = (JavascriptExecutor) driver;
                int startY = 0;
                while (startY < y) {
                    jsx.executeScript("window.scrollBy(0," + startY + ")", "");
                    try {
                        element.click();
                    } catch (Exception e2) {
                        startY += 150;
                    }
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        WaitUtil.waitForCATSpinner(driver, By.cssSelector(".overlayPage"));
    }

    /** Click.
     *
     * @param driver the driver
     * @param element the element
     * @param elementName the element name
     * @param waitForSpinner the wait for spinner */
    public static void click(WebDriver driver, WebElement element, String elementName, boolean waitForSpinner) {
        Log.event("Clicking on element: " + elementName);
        WaitUtil.waitForIsElementEnabled(driver, element);
        element.click();
        Log.message("Clicked on element: " + elementName);
        if (waitForSpinner) {
            WaitUtil.waitForCATSpinner(driver, By.cssSelector(".overlayPage"));
        }
    }

    /** Finds the Element in the page.
     *
     * @param locator the locator
     * @return the web element */
    public static WebElement find(WebDriver driver, By locator) {
        Log.event("Finding on element: " + locator.toString());
        return driver.findElement(locator);
    }

    /** Go to.
     *
     * @param url the url */
    public static void goTo(WebDriver driver, String url) {
        Log.event("Getting Url: " + url);
        driver.get(url);
    }

    /** Gets the current url.
     *
     * @param driver the driver
     * @return the current url */
    public static String getCurrentUrl(WebDriver driver) {
        Log.event("Getting Current Url: " + driver.getCurrentUrl().toString());
        return driver.getCurrentUrl();
    }

    /** Gets the options.
     *
     * @param listLocator the list locator
     * @return the options */
    public static ArrayList<String> getOptions(WebDriver driver, By listLocator) {
        ArrayList<String> optionsList = new ArrayList<String>();
        Select selector = new Select(find(driver, listLocator));

        for (WebElement elt : selector.getOptions()) {
            optionsList.add(elt.getText());
        }

        return optionsList;
    }

    /** Select by value.
     *
     * @param optionValue the option value
     * @param dropdownLocator the dropdown locator */
    public static void selectByValue(WebDriver driver, String optionValue, By dropdownLocator) {
        Select dropdown = new Select(find(driver, dropdownLocator));
        Log.event("Selecting option from dropdown by value: " + optionValue);
        dropdown.selectByValue(optionValue);
    }

    /** Select by option text.
     *
     * @param optionText the option text
     * @param dropdownLocator the dropdown locator */
    public static void selectByOptionText(WebDriver driver, String optionText, By dropdownLocator) {
        Select dropdown = new Select(find(driver, dropdownLocator));
        Log.event("Selecting option from dropdown by visible text: " + optionText);
        dropdown.selectByVisibleText(optionText);
    }

    /** Select by option text.
     *
     * @param driver the driver
     * @param optionText the option text
     * @param dropdownElement the dropdown element */
    public static void selectByOptionText(WebDriver driver, String optionText, WebElement dropdownElement) {
        Select dropdown = new Select(dropdownElement);
        Log.event("Selecting option from dropdown by visible text: " + optionText);
        dropdown.selectByVisibleText(optionText);
    }

    /** Select file upload.
     *
     * @param filePath the file path
     * @param screenShot the screen shot
     * @throws Exception the exception */
    public static void selectFileUpload(WebDriver driver, String filePath, By fileElementBy) {
        RemoteWebElement fileupload = (RemoteWebElement) ((RemoteWebDriver) driver).findElement(fileElementBy);
        if (fileupload.isDisplayed()) {
            File file = new File(filePath);
            file.toURI();
            ((RemoteWebElement) fileupload).setFileDetector(new LocalFileDetector());
            Log.event("Sending File Path Key as: " + filePath.toString());
            fileupload.sendKeys(file.getAbsolutePath());
        }
    }

    /** Scroll element into view.
     *
     * @param driver the driver
     * @param locator the locator */
    public static void scrollElementIntoView(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    /** Scroll element into view.
     *
     * @param driver the driver
     * @param element the element */
    public static void scrollElementIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /** Switch to frame. */
    public static void switchToFrame(WebDriver driver, String... frameName) {
        if (frameName.length == 0) {
            driver.switchTo().frame("frame");
        } else {
            driver.switchTo().frame(frameName[0]);
        }
    }

    /** Switch to main content. */
    public static void switchToMainContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    /** Scroll.
     *
     * @param driver the driver */
    public static void scroll(WebDriver driver) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,150)", "");
    }
    
    public static void scroll(WebDriver driver, String pixel) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0," + pixel + ")", "");
        Log.message("scrolled!@#@$" + pixel);
    }

    /** Scroll up.
     *
     * @param driver the driver */
    public static void scrollUp(WebDriver driver) {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,-300)", "");
    }

    /** Go back.
     *
     * @param driver the driver */
    public static void goBack(WebDriver driver) {
        Log.event("Clicking on Back button in browser");
        driver.navigate().back();
    }


    
    
   
}
