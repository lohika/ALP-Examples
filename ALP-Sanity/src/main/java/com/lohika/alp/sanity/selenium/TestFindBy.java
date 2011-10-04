package com.lohika.alp.sanity.selenium;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lohika.alp.sanity.blocks.FindByBlock;
import com.lohika.alp.sanity.utils.Environment;
import com.lohika.alp.selenium.AlpPageFactory;
import com.lohika.alp.selenium.AlpWebDriverFactory;

public class TestFindBy {

	private WebDriver wbd;
	private Logger lg;
	private FindByBlock fbb;

	@Parameters({ "browser", "platform" })
	@BeforeClass(alwaysRun = true)
	public void before(String browser, String platform)
			throws MalformedURLException {
		lg = Logger.getLogger(getClass().toString());
		DesiredCapabilities cap = new DesiredCapabilities(browser, "",
				Platform.valueOf(platform));
		wbd = AlpWebDriverFactory.getDriver(Environment.getEnv(), cap);

		fbb = AlpPageFactory.initElements(wbd, FindByBlock.class);
	}

	@Test(groups = { "primary.2" }, dependsOnGroups = { "primary" })
	public void test() {
		wbd.get(Environment.getInputcheckboxes());

		lg.info("Object found by ID returned text =" + fbb.getByidText());

		lg.info("Object found by ID returned text =" + fbb.getBytagText());

		String str = fbb.getByxpathText();

		Assert.assertEquals((Object) str, (Object) "19 or under",
				"xpath don't work");

		lg.info("Object found by XPath returned correct text");
	}

	@AfterClass(alwaysRun = true)
	public void after() {
		wbd.close();
	}
}
