package com.lohika.alp.howto.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.lohika.alp.utils.Environment;

/**
 * @author "Anton Smorodsky"
 * 
 *         According Selenium best practises to write clean and easy supported
 *         tests need to model AUT as hierarchy of PageObjects . Also good idea
 *         not insert hole page content in to one single object , usually inside
 *         some certain test you work only with part of page. For more detailed
 *         info need to read http://code.google.com/p/selenium/wiki/PageObjects
 * 
 */

// This certain class represent elements that appear on page after user made succesfull login .
// Because it is demo project that check positive/negative cases of login only purpose of this class detect that user made 
// succesfull login . And it designed accordingly. 
public class NavigationItems {

	/**
	 * Because we won't do any action with this elements except detecting that
	 * they exists we don't need @LogDescription annotation.
	 * 
	 */

	@FindBy(className = "headerTinymanName")
	private WebElement header_username;

	/**
	 * Selenium backend use "lazy" initialization mechanism (the functionality
	 * works using dynamic proxies). This mean that actual detection of element
	 * on page will happens only when first method of object will be called . So
	 * just create WebElement is not enough to be sure that object exists on
	 * page. We need to call some method of object for this . Here we call
	 * getText() method to push 'real' object creation.
	 */
	public void isBlockAppear() {
		Assert.assertEquals((Object) header_username.getText(),
				(Object) Environment.getUsername_displayed());
	}
}
