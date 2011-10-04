package com.lohika.alp.sanity.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lohika.alp.selenium.log.LogDescription;

public class FindByBlock {

	@LogDescription(name = "RadioButton", type = "radiobutton")
	@FindBy(id = "lt20")
	private WebElement byid;

	@LogDescription(name = "RadioButton", type = "radiobutton")
	@FindBy(tagName = "label")
	private WebElement bytag;

	@LogDescription(name = "RadioButton", type = "radiobutton")
	@FindBy(xpath = "//div/label[@for='lt20']")
	private WebElement byxpath;

	public WebElement get_byid_webelement() {
		return byid;
	}

	public String getByidText() {
		return byid.getTagName();
	}

	public String getBytagText() {
		return bytag.getText();
	}

	public String getByxpathText() {
		return byxpath.getText();
	}
}
