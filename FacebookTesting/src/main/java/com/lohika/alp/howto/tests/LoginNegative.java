package com.lohika.alp.howto.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lohika.alp.howto.blocks.LoginBlock;
import com.lohika.alp.howto.blocks.WrongCredentialsBlock;
import com.lohika.alp.selenium.AlpPageFactory;
import com.lohika.alp.selenium.AlpWebDriverFactory;
import com.lohika.alp.utils.Environment;

/**
 * 
 * @author "Anton Smorodsky"
 * 
 *         LoginNegative test is almost the same as LoginPositive , so please
 *         review LoginPositive for detailed explanations.
 */

public class LoginNegative {

	private WebDriver drv;
	private LoginBlock loginblock;
	private WrongCredentialsBlock wrongcredentailsblock;

	@BeforeClass(alwaysRun = true)
	public void initClass() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.firefox();

		cap.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

		drv = AlpWebDriverFactory.getDriver(Environment.getServerURL(), cap);

		drv.get(Environment.getAUTLink());

		loginblock = AlpPageFactory.initElements(drv, LoginBlock.class);
	}

	@Test(groups = "test")
	public void testLogin() throws InterruptedException {
		loginblock.madeLogin(false);
		wrongcredentailsblock = AlpPageFactory.initElements(drv,
				WrongCredentialsBlock.class);
		wrongcredentailsblock.isErrorMsg();

	}

	@AfterClass(alwaysRun = true)
	public void onFinish() {
		drv.close();
	}
}
