package com.lohika.alp.sanity.selenium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.lohika.alp.sanity.blocks.FormBlock;
import com.lohika.alp.sanity.utils.Environment;
import com.lohika.alp.selenium.AlpPageFactory;
import com.lohika.alp.selenium.AlpWebDriverFactory;

public class TestForms {

	private WebDriver wbd;
	private FormBlock fb;

	@Parameters({ "browser", "platform" })
	@BeforeClass(alwaysRun = true)
	public void before(String browser, String platform)
			throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities(browser, "",
				Platform.valueOf(platform));
		wbd = AlpWebDriverFactory.getDriver(Environment.getEnv(), cap);

		fb = AlpPageFactory.initElements(wbd, FormBlock.class);
	}

	@Test(groups = { "primary.2" }, dependsOnGroups = { "primary" })
	//@Test(groups = { "test" })
	public void test() {
		wbd.get(Environment.getforms1());
		fb.book.findElement(
				By.xpath("/html/body/form/fieldset/select/option[4]")).click();

		Assert.assertTrue(fb.book.findElement(
				By.xpath("/html/body/form/fieldset/select/option[4]"))
				.isSelected());

		wbd.get(Environment.getforms2());

		Assert.assertEquals((Object) fb.textbox.getAttribute("id"),
				(Object) "email", "Value not equal to expected");
		fb.textbox.sendKeys("ALP Framework");
		fb.textbox.submit();
		@SuppressWarnings("unused")
		Point pt = fb.textbox.getLocation();

		@SuppressWarnings("unused")
		Dimension dm = fb.textbox.getSize();

		fb.textbox.isDisplayed();

		fb.textbox.isEnabled();

	}

	@AfterClass(alwaysRun = true)
	public void after() {
		wbd.close();
	}
}
