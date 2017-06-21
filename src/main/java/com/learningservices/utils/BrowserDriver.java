package com.learningservices.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * BrowserDriver class used to get a app driver instance, depends on the
 * user requirement in terms of browser. 
 * All the test scripts will extend this class to get the browser driver instance.
 *
 * @since May 2017
 */
public abstract class BrowserDriver {

    enum DriverType {
        Firefox, IE, Chrome, Safari
    }

    // Define objects
    protected static WebDriver driver;

    // Initialize objects
    protected PropertyReader propertyReader = new PropertyReader();

    // Define variables
    protected String applicationUrl = propertyReader.readApplicationFile("hubURL");

    /**
    * Will read the property file e.g. config.properties for property "browerName".
    * Based on read value it will setup the driver of appropriate browser.
    * If it is unable to match read property with defined options then it will 
    * default to FireFox browser
    */
    @BeforeClass
    public void setUp() {
        String driverType = propertyReader.readApplicationFile("browserName");

        if (DriverType.Firefox.toString().equals(driverType)) {
            System.setProperty("webdriver.gecko.driver", 
                              (propertyReader.getFilePath() + "//drivers//win//firefox.exe"));
            driver = new FirefoxDriver();
        } else if (DriverType.IE.toString().equals(driverType)) {
            System.setProperty("webdriver.ie.driver", 
                              (propertyReader.getFilePath() + "//drivers//win//IEDriver.exe"));
            driver = new InternetExplorerDriver();
        } else if (DriverType.Safari.toString().equals(driverType)) {
            driver = new SafariDriver();
        } else if (DriverType.Chrome.toString().equals(driverType)) {
            System.setProperty("webdriver.chrome.driver", 
                              (propertyReader.getFilePath() + "//drivers//win//chromedriver.exe"));
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        // Maximize window
        driver.manage().window().maximize();

        // Delete cookies
        driver.manage().deleteAllCookies();
    }

    /**
     * Will quit the browser.
     */
    @AfterClass
    public void afterMainMethod() {
        driver.quit();
    }

    /**
     * Will return the WebDriver.
     */
    public WebDriver getWebDriver() {
        return driver;
    }
}