package com.learningservices.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

/** The Class WaitUtil. */
public class WaitUtil {

    /** Wait for the element visible.
     *
     * @param driver the driver
     * @param timeUnits the time units
     * @param webElementName the web element name
     * @return true, if successful */
    public static boolean waitForTheElementVisible(WebDriver driver, int timeUnits, By webElementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeUnits);
            wait.until(ExpectedConditions.visibilityOfElementLocated(webElementName));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Wait for the element invisibility.
     *
     * @param driver the driver
     * @param timeUnits the time units
     * @param webElementName the web element name */
    public static void waitForTheElementInvisibility(WebDriver driver, int timeUnits, By webElementName) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeUnits, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(webElementName));
    }

    /** Wait for Element to be enabled.
     *
     * @param driver the driver
     * @param locator the locator
     * @param timeout the timeout
     * @return the boolean */
    public static Boolean waitForIsEnabled(WebDriver driver, By locator, Integer... timeout) {
        try {
            waitForElement(driver, ExpectedConditions.elementToBeClickable(locator), (timeout.length > 0 ? timeout[0]
                    : null));
            return true;
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
    }

    /** Wait for element.
     *
     * @param driver the driver
     * @param condition the condition
     * @param timeout the timeout */
    public static void waitForElement(WebDriver driver, ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 10;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    /** Fluent wait.
     *
     * @param driver the driver
     * @param locator the locator
     * @return the web element */
    public static WebElement fluentWait(WebDriver driver, final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(120, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return foo;
    };

    /** Wait for is element enabled.
     *
     * @param driver the driver
     * @param element the element
     * @return true, if successful */
    public static boolean waitForIsElementEnabled(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

        boolean foo = wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                return element.isEnabled();
            }
        });
        return foo;
    };

    /** Wait for is text present.
     *
     * @param driver the driver
     * @param text the text
     * @param timeout the timeout
     * @return the boolean */
    public static Boolean waitForIsTextPresent(WebDriver driver, String text, Integer... timeout) {
        try {
            waitForCondition(driver, ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text),
                    (timeout.length > 0 ? timeout[0] : null));
            return true;
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
    }

    /** Wait for condition.
     *
     * @param driver the driver
     * @param condition the condition
     * @param timeout the timeout */
    public static void waitForCondition(WebDriver driver, ExpectedCondition<Boolean> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 10;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    /** Nap.
     *
     * @param seconds the seconds */
    public static void nap(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /** Wait for overlay.
     *
     * @param driver the driver
     * @param bgDisableOverlay the bg disable overlay */
    public static void waitForCATSpinner(WebDriver driver, By bgDisableOverlay) {
        try {
            WaitUtil.waitForTheElementVisible(driver, 10, bgDisableOverlay);
            WaitUtil.waitForTheElementInvisibility(driver, 120, bgDisableOverlay);
        } catch (Exception e) {
            return;
        }
    }

    /** Wait for alert to present.
     *
     * @param driver the driver */
    public static void waitForAlertToPresent(WebDriver driver) {
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            return;
        }
    }

    /** Wait for the element to be enabled.
     *
     * @param timeUnits the time units
     * @param webElementName the web element name */
    public static void waitForTheElementToBeEnabled(WebDriver driver, int timeUnits, By webElementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeUnits);
        wait.until(ExpectedConditions.elementToBeClickable(webElementName));
    }
}