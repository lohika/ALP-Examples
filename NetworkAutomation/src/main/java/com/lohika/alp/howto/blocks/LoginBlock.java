package com.lohika.alp.howto.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.lohika.alp.selenium.log.LogDescription;
import com.lohika.alp.utils.Environment;


public class LoginBlock {


	@LogDescription(name = "login_name", type = "edit")
	@FindBy(className="login_name")
	private WebElement login_name;
    
	@LogDescription(name = "User's password", type = "edit")
	@FindBy (className = "login_password")
	private WebElement login_pass;
	
	@LogDescription (name = "Login Button", type = "button")
	@FindBy (className = "button")
	private WebElement login_btn_label;
	
	
	
	   public void madeLogin() {
		   login_name.sendKeys(Environment.getUsername());
		   login_pass.sendKeys(Environment.getPass());
		   login_btn_label.click();		   
	   }
	}

