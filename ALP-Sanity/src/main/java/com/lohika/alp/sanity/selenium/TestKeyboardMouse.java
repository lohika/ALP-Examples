package com.lohika.alp.sanity.selenium;

import java.net.MalformedURLException;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lohika.alp.sanity.blocks.FindByBlock;
import com.lohika.alp.sanity.utils.Environment;
import com.lohika.alp.selenium.AlpPageFactory;
import com.lohika.alp.selenium.AlpWebDriverFactory;
import com.lohika.alp.selenium.log.LoggingWebDriver;
import com.lohika.alp.selenium.log.LoggingWebElement;

public class TestKeyboardMouse {

	private WebDriver wbd;
	//private Logger lg;
	private FindByBlock fbb;

	@Parameters({ "browser", "platform" })
	@BeforeClass(alwaysRun = true)
	public void before(String browser, String platform)
			throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities(browser, "",
				Platform.valueOf(platform));

		wbd = AlpWebDriverFactory.getDriver(Environment.getHubURL(), cap);

		fbb = AlpPageFactory.initElements(wbd, FindByBlock.class);

		//lg = Logger.getLogger(getClass().toString());
	}

	@Test(groups = { "primary.2" }, dependsOnGroups = { "primary" })
	//@Test(groups = { "test" })
	public void test() {
		wbd.get(Environment.getInputcheckboxes());

		Keyboard kbd = ((LoggingWebDriver) wbd).getKeyboard();

		kbd.pressKey(Keys.F1);

		Mouse ms = ((LoggingWebDriver) wbd).getMouse();

        Coordinates cor1 = ((LoggingWebElement)((WrapsElement)fbb.get_byid_webelement()).getWrappedElement()).getCoordinates();

		ms.doubleClick(cor1);
	}

	@AfterClass(alwaysRun = true)
	public void after() {
		wbd.close();
	}

}
