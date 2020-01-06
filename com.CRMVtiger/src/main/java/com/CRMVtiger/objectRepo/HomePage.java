package com.CRMVtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement ContactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement UserImg;

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignoutLink;

	public WebElement getContactLink() {
		return ContactLink;
	}
	
	public WebElement getUserImg() {
		return UserImg;
	}

	public WebElement getSignoutLink() {
		return SignoutLink;
	}

}
