package com.lohika.alp.howto.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lohika.alp.selenium.log.LogDescription;
import com.lohika.alp.utils.Environment;

/**
 * 
 * @author Anton Smorodsky
 * 
 *         According Selenium best practises to write clean and easy supported
 *         tests need to model AUT as hierarchy of PageObjects . Also good idea
 *         not insert hole page content in to one single object , usually inside
 *         some certain test you work only with part of page. For more detailed
 *         info need to read http://code.google.com/p/selenium/wiki/PageObjects
 * 
 * 
 */

// This certain class represent objects on page related to login to facebook
public class LoginBlock {

	// @LogDescription annotation is ALP mechanism allowing to define what 'name' will be 
	// displayed in ALP log for this WebElement . 'type' param define icon displayed within this step 
	@LogDescription(name = "User's E-mail", type = "edit")
	// @FindBy annotation is Selenium mechanism declaring how to search certain WebElement within page 
	@FindBy(id = "email")
	private WebElement login_name;

	@LogDescription(name = "User's password", type = "edit")
	@FindBy(id = "pass")
	private WebElement login_pass;

	@LogDescription(name = "Login Button", type = "button")
	@FindBy(className = "uiButtonConfirm")
	private WebElement login_btn_label;

	// this method provide login functionality by getting credentials data from Environment class
	// and made actual login . Boolean param controls if correct credentials or fault should be taken . To cover positiv and negative cases. 
	public void madeLogin(boolean positiv) {
		if (positiv) {
			login_name.sendKeys(Environment.getUsername());
			login_pass.sendKeys(Environment.getPass());
		} else {
			login_name.sendKeys(Environment.getUsernameWrong());
			login_pass.sendKeys(Environment.getPassWrong());
		}
		login_btn_label.click();
	}
}
