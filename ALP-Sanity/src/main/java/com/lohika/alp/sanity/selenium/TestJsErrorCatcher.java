package com.lohika.alp.sanity.selenium;

import java.net.MalformedURLException;
import java.util.ArrayList;

import com.lohika.alp.selenium.jscatcher.JsErrorCatcherConfiguration;
import com.lohika.alp.selenium.jscatcher.JsErrorCatcherException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lohika.alp.sanity.utils.Environment;
import com.lohika.alp.selenium.AlpWebDriverFactory;
import com.lohika.alp.selenium.jscatcher.FirefoxJsErrorCathcer;
import com.lohika.alp.selenium.jscatcher.JSErrorCatcher;

/**
 * 
 * @author "Dmitry Irzhov"
 * 
 *         TestJsErrorCatcher test shows how to use JsErrorCatcher and do sanity
 *         tests for .
 */

public class TestJsErrorCatcher {

	private WebDriver drv;
	private JSErrorCatcher jsErrCatcher;
	private Logger log = Logger.getLogger(getClass().toString());

	@BeforeClass(alwaysRun = true)
	public void initClass() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.firefox();

		cap.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

		drv = AlpWebDriverFactory.getDriver(Environment.getHubURL(), cap);
		
		jsErrCatcher = new FirefoxJsErrorCathcer(drv);

	}

    //@Test(groups = { "primary.2" }, dependsOnGroups = { "primary" })
	@Test(groups = {"test"})
	public void testJsExceptionAutoLogging() throws InterruptedException {
		drv.get(Environment.getJsCatcherEnv());
		
	}

    //@Test(groups = { "primary.2" }, dependsOnGroups = { "primary" })
	@Test(groups = {"test"})
	public void testJsExceptionManualy() throws InterruptedException, JsErrorCatcherException {
		// disable auto logging of js errors

        JsErrorCatcherConfiguration jsErrCatchConfig = new JsErrorCatcherConfiguration();

        jsErrCatchConfig.setJsErrorAutolog(true);

		drv.get(Environment.getJsCatcherEnv());
		
		// grab all js errors on current page
		ArrayList<String> errors = jsErrCatcher.getJsErrors();
		
		drv.findElement(By.linkText("Next")).click();

		errors.addAll(jsErrCatcher.getJsErrors());
		
		if (!errors.isEmpty())
		for (String error: errors) {
			Reporter.log(error);
			log.warn(error);
		}
	}

	@AfterClass(alwaysRun = true)
	public void onFinish() {
		drv.close();
	}
}
