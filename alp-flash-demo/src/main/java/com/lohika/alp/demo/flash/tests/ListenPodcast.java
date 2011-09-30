package com.lohika.alp.demo.flash.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lohika.alp.demo.flash.tools.FlashWebDriver;

public class ListenPodcast {

	public FlashWebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void before() throws InterruptedException {
		driver = new FlashWebDriver("Flexcaster", "selectFeed");
	}

	@Test(groups = "test")
	public void test_flex() throws InterruptedException {		
		driver.FlexExecuter("selectFeed", "2", true);
		Thread.sleep(1000);
		driver.FlexExecuter("showFeed", "", true);
		Thread.sleep(1000);
		driver.FlexExecuter("selectPodcast", "2", true);
		Thread.sleep(1000);
		driver.FlexExecuter("showPodcast", "", true);
		driver.close();
	}
}
