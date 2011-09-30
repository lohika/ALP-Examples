package com.lohika.alp.demo.flash.tests;

import org.testng.annotations.Test;

import com.lohika.alp.demo.flash.tools.FlashWebDriver;

public class WorkWithYoutube {

	public FlashWebDriver driver;

	@Test
	public void test_youtube() throws InterruptedException {
		driver = new FlashWebDriver("pauseVideo");
		driver.initYoutube();
		driver.FlexExecuter("playVideo", "", true);
		driver.FlexExecuter("mute", "", true);
		driver.close();
	}

}
