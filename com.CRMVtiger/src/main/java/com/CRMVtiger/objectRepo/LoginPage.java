package com.CRMVtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	/* Identification or Initialization of Elements */
	@FindBy(name ="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name ="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id ="submitButton")
	private WebElement submitButton;
	
	/* Usage */
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getSubmitButton() {
		return submitButton;
	}

	/* Bussiness Method*/
	public void loginToApp(String username , String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitButton.click();
	}
}
