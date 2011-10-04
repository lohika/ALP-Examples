package com.lohika.alp.sanity.selenium;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lohika.alp.sanity.utils.Environment;
import com.lohika.alp.selenium.AlpWebDriverFactory;

public class TestGet {

	public WebDriver wbd;
	public Logger lg;

	@Parameters({ "browser", "platform" })
	@BeforeClass(alwaysRun = true)
	public void before(String browser, String platform)
			throws MalformedURLException {
		lg = Logger.getLogger(getClass().toString());
		DesiredCapabilities cap = new DesiredCapabilities(browser, "",
				Platform.valueOf(platform));
		wbd = AlpWebDriverFactory.getDriver(Environment.getEnv(), cap);
	}

	//@Test(groups = { "test" })
	@Test(groups = { "primary" })
	public void test() {
		wbd.get(Environment.getGet());

		String str = wbd.getPageSource();

		lg.info(str);

		str = wbd.getWindowHandle();

		lg.info(str);

		str = wbd.getTitle();

		lg.info(str);

		wbd.get(Environment.getGet2());

		Navigation nv = wbd.navigate();

		nv.back();

		Assert.assertEquals((Object) wbd.getTitle(), (Object) "Google");

	}

	@AfterClass(alwaysRun = true)
	public void after() {
		wbd.close();
	}
}
