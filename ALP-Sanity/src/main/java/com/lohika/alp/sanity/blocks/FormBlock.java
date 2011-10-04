package com.lohika.alp.sanity.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormBlock {

	public WebElement book;

	@FindBy(name = "email")
	public WebElement textbox;

}
