package com.lohika.alp.sanity.selenium;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAutomailing {

	private Logger log = Logger.getLogger(getClass().toString());

	@BeforeClass(alwaysRun = true)
	public void initClass() throws MalformedURLException {
		log.info("INIT method: first step");
	}

	@Test(groups = "automailing_test")
	public void testMethod1() throws InterruptedException {
		log.info("test method 1: first info");
		log.info("test method 1: second info");
	}

	@Test(groups = "automailing_test")
	public void testMethod2() throws Exception {
		log.info("test method 2: first info");
		log.warn("test method 2: first warn");
		throw new Exception("Hello");
	}

	@AfterClass(alwaysRun = true)
	public void onFinish() {
		log.info("finish test method");
	}
}
