package com.lohika.alp.sanity.selenium;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lohika.alp.sanity.utils.Environment;
import com.lohika.alp.selenium.AlpWebDriverFactory;
import com.lohika.alp.selenium.log.LoggingWebDriver;

public class TestDriverCapabilities {

	private WebDriver wbd;
	private Logger lg;

	@Parameters({ "browser", "platform" })
	@BeforeClass(alwaysRun = true)
	public void before(String browser, String platform)
			throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities(browser, "5.0",
				Platform.valueOf(platform));

		wbd = AlpWebDriverFactory.getDriver(Environment.getEnv(), cap);
		lg = Logger.getLogger(getClass().toString());
	}

	@Test(groups = { "primary.2" }, dependsOnGroups = { "primary" })
	//@Test(groups = { "test" })
	public void test() {

		wbd.get(Environment.getGet());

		Capabilities cp1 = ((LoggingWebDriver) wbd).getCapabilities();

		Map<String, ?> map1 = cp1.asMap();

		Iterator<?> i = map1.entrySet().iterator();

		while (i.hasNext()) {

			@SuppressWarnings("rawtypes")
			Map.Entry me = (Map.Entry) i.next();

			lg.info(me.getKey() + " : " + me.getValue());
		}
	}

	@AfterClass(alwaysRun = true)
	public void after() {
		wbd.close();
	}

}
