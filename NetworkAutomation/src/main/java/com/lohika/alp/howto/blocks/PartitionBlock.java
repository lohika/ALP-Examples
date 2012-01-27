package com.lohika.alp.howto.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lohika.alp.selenium.log.LogDescription;

public class PartitionBlock {
	
	@LogDescription (name = "Admin Button", type = "button")
	@FindBy (id = "dijit_PopupMenuBarItem_4_text")
	private WebElement admin_btn_label;
	
	@LogDescription (name = "Security Button", type = "button")
	@FindBy (id = "dijit_MenuItem_116_text")
	private WebElement security_btn_label;
	
	public void clickPartition()
	{
		admin_btn_label.click();
		security_btn_label.click();
	}

}
