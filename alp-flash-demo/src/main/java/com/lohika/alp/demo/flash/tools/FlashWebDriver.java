package com.lohika.alp.demo.flash.tools;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlashWebDriver {

	private FirefoxDriver driver;
	private DataStorage dst;
	private Integer timeout;
	private String flashElement;
	private String checkFunction;
	private Logger lg;

	public FlashWebDriver() {
		lg = Logger.getLogger(getClass().toString());
		dst = new DataStorage();
		driver = new FirefoxDriver();
		timeout = 10;
		flashElement = "";
		checkFunction = "";
	}

	public FlashWebDriver(String func_name) throws InterruptedException {
		lg = Logger.getLogger(getClass().toString());
		dst = new DataStorage();
		driver = new FirefoxDriver();
		timeout = 10;
		flashElement = "movie_player";
		checkFunction = func_name;
		driver.get(dst.getEnv2());
		Thread.sleep(1000);

	}

	public void initYoutube() throws InterruptedException {

		WebElement video = driver.findElementByClassName("video-short-title");
		WebElement video_link = video.findElement(By.tagName("a"));
		video_link.click();
		waitFor(flashElement, checkFunction, "");
	}

	private void waitFor(String elementID, String func_name, String param)
			throws InterruptedException {
		int cnt = 0;
		boolean noElement = true;
		while (cnt < timeout && noElement) {
			try {
				FlexExecuter(func_name, param, false);
				noElement = false;
			} catch (Exception e) {
				Thread.sleep(1000);
				cnt++;
			}
		}

		if (noElement)
			throw new NoSuchElementException();
	}

	public FlashWebDriver(String elementID, String func_name)
			throws InterruptedException {
		dst = new DataStorage();
		driver = new FirefoxDriver();
		timeout = 30;
		driver.get(dst.getEnv1());
		flashElement = elementID;
		checkFunction = func_name;
		lg = Logger.getLogger(flashElement);
		waitFor(flashElement, checkFunction, "0");
	}

	public Object FlexExecuter(String funcName, String param, boolean logEvent) {

		if (logEvent)
			lg.info("Execute function - '" + funcName + "' for <"
					+ flashElement + "> element");

		return ((JavascriptExecutor) driver)
				.executeScript("document.getElementById('" + flashElement
						+ "')." + funcName + "(" + param + ")");
	}

	public void close() {
		driver.close();
	}
}
