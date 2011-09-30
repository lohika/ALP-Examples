package com.lohika.alp.howto.blocks;

import org.openqa.selenium.WebElement;

/**
 * 
 * @author "Anton Smorodsky"
 * 
 *         Read detailed explanation within NavigationItems class . This one the
 *         same with one difference - it used to detected LoginNegative case.
 * 
 */

public class WrongCredentialsBlock {

	private WebElement standard_error;

	private WebElement standard_explanation;

	public void isErrorMsg() {

		standard_error.getText();
		standard_explanation.getText();
	}

}
