package com.lohika.alp.howto.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lohika.alp.selenium.AlpPageFactory;
import com.lohika.alp.selenium.AlpWebDriverFactory;
import com.lohika.alp.utils.Environment;
import com.lohika.alp.howto.blocks.PartitionBlock;



public class CreatePartition {

	private WebDriver drv;

	private PartitionBlock partitionblock;

	

	@BeforeClass(alwaysRun = true)
	public void initClass() throws MalformedURLException {

		DesiredCapabilities cap = DesiredCapabilities.firefox();

		cap.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

		drv = AlpWebDriverFactory.getDriver(Environment.getServerURL(), cap);

		drv.get(Environment.getAUTLink());

		partitionblock = AlpPageFactory.initElements(drv, PartitionBlock.class);


		
	}

	@Test(groups = "test")
	public void testCreatePartition() throws InterruptedException 
	{
		
		partitionblock.clickPartition();		
	}
}