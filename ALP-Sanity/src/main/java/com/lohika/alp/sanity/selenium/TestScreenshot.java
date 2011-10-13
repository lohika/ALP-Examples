package com.lohika.alp.sanity.selenium;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lohika.alp.sanity.utils.Environment;
import com.lohika.alp.selenium.AlpWebDriverFactory;
import com.lohika.alp.selenium.log.LogElementsSeleniumFactory;
import com.lohika.alp.selenium.log.LogElementsSeleniumFactoryJAXB;

public class TestScreenshot {

	public WebDriver wbd;
	public Logger lg;
	public LogElementsSeleniumFactory logElements;

	@Parameters({ "browser", "platform" })
	@BeforeClass(alwaysRun = true)
	public void before(String browser, String platform)
			throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities(browser, "",
				Platform.valueOf(platform));
		wbd = AlpWebDriverFactory.getDriver(Environment.getHubURL(), cap);

		lg = Logger.getLogger(getClass().toString());

		logElements = new LogElementsSeleniumFactoryJAXB();

	}

	@Test(groups = { "primary.2" }, dependsOnGroups = { "primary" })
	//@Test(groups = { "test" })
	public void test() {
		wbd.get(Environment.getGet());

		lg.info(logElements.screenshot(wbd, "Some Text"));

	}

	@AfterClass(alwaysRun = true)
	public void after() {
		wbd.close();
	}
}
