package com.lohika.alp.howto.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lohika.alp.howto.blocks.LoginBlock;
import com.lohika.alp.howto.blocks.NavigationItems;
import com.lohika.alp.selenium.AlpPageFactory;
import com.lohika.alp.selenium.AlpWebDriverFactory;
import com.lohika.alp.utils.Environment;

public class LoginPositive {

	// WebDriver object used to actual interaction with browser. More detailed info you can find at 
	// http://code.google.com/p/selenium/wiki/GettingStarted
	private WebDriver drv;

	// This is our helper class that allow us to interact with controls on page that responsible for login.
	private LoginBlock loginblock;

	// This our helper class allowing detect controls that should appear after succesfull login 
	private NavigationItems nav_items;

	// @BeforeClass section used to initialize all infrastructure that we need to execute the test . 
	// Such code organization allow us divide preparation failures from actual test failures . 
	@BeforeClass(alwaysRun = true)
	public void initClass() throws MalformedURLException {

		// WebDriver class have range of children that represents drivers for actual browsers. 
		//DesiredCapabilities class allow us to define within which exactly browser we perform our activities. 
		DesiredCapabilities cap = DesiredCapabilities.firefox();

		// This capability will allow us save screenshot to ALP log when some test action will fails 
		cap.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

		/***
		 * AlpWebDriverFactory class in addition to creation WebDriver object
		 * also initialize backend that perform logging to ALP reporter without
		 * any additional lines of code . So after such init you just call
		 * "WebElement.click()" and ALP framework automatically write line to
		 * log that explain what element and what action happens. First param of
		 * static getDriver() function should contain link to SeleniumServer.jar
		 * in form "http://<server_name>:4444/wd/hub" , second should represent
		 * DesiredCapabilities class with all requirements for browser.
		 */
		drv = AlpWebDriverFactory.getDriver(Environment.getServerURL(), cap);

		// Invoking AUT (ApplicationUnderTest) within just invoked browser.
		drv.get(Environment.getAUTLink());

		/**
		 * This second part of ALP Framework "magic" that allow us transfer
		 * logging responsibility to ALP Framework. We already wrap WebDriver
		 * object here we will wrap PageObject. AlpPageFactory will find all
		 * WebElements within given class and setup logging settings according
		 * annotations of WebElements (see details within LoginBlock class ).
		 * All page objects that want to use ALP logging facilities need to be
		 * initialized in such way.
		 */
		loginblock = AlpPageFactory.initElements(drv, LoginBlock.class);

		/**
		 * Good example of benefits of "lazy" WebElements creation . At point of
		 * time when AlpPageFactory initialize this PageObject it physically
		 * don't exists on page (it will appear only after
		 * loginblock,madeLogin(true) will be executed ) , but we won't get any
		 * exceptions here.
		 */

		nav_items = AlpPageFactory.initElements(drv, NavigationItems.class);
	}

	// Test itself . Because of smart code organizing and ALP , Selenium and TestNG usage test is short and simple . 
	@Test(groups = "test")
	public void testLogin() throws InterruptedException {
		// We just say "Made positiv login " and it is PageObject responsibility to find controls (WebElement objects), correct credentials
		// made login and log all this actions .
		loginblock.madeLogin(true);

		// Detecting if navigation items actually appear on page  
		nav_items.isBlockAppear();

	}

	// Final stage where we just closing browser.
	@AfterClass(alwaysRun = true)
	public void onFinish() {
		drv.close();
	}

}
