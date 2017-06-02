package com.learningservices.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BrowserDriver {

	enum DriverType {
		Firefox, IE, Chrome, Safari
	}

	// Define objects
	protected WebDriver driver;

	// Initialize objects
	protected PropertyReader propertyReader = new PropertyReader();

	// Define variables
	protected String applicationUrl = propertyReader.readApplicationFile("hubURL");

	@BeforeClass
	public void setUp() {
		String driverType = propertyReader.readApplicationFile("browserName");

		if (DriverType.Firefox.toString().equals(driverType)) {
			System.setProperty("webdriver.gecko.driver",
					(propertyReader.getFilePath() + "//drivers//win//firefox.exe"));
			driver = new FirefoxDriver();
		}

		else if (DriverType.IE.toString().equals(driverType)) {
			System.setProperty("webdriver.ie.driver", (propertyReader.getFilePath() + "//drivers//win//IEDriver.exe"));
			driver = new InternetExplorerDriver();
		}
		else if (DriverType.Chrome.toString().equals(driverType)) {
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
	
	public WebDriver getWebDriver() {
		return driver;
	}

}