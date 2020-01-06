package com.CRMVtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {
	

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContactlogo;
	
	@FindBy(xpath="//img[@src='themes/softed/images/tbarImport.gif']")
	private WebElement ImportConactlogo;
	
	@FindBy (xpath="//table[@class='small']/tbody/tr/td/input[@value='Mass Edit']")
	private WebElement MassEditBtn;
	
	@FindBy(xpath="(//a[text()='edit'])[last()-1]")
	private WebElement EditBtn;
	
	@FindBy(name= "firstname")
	private WebElement FirstNameEdt;
	
	@FindBy(name= "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement SaveBtn;
	
	@FindBy(id="email")
	private WebElement EmailIdEdt;
	
	@FindBy (id="mouseArea_Mobile")
	private WebElement MobileEdtArea;
	
	public WebElement getMobileEdtArea() {
		return MobileEdtArea;
	}

	@FindBy  (id = "txtbox_Mobile")
	private WebElement MobileNumEdt;
	
	public WebElement getMobileNumEdt() {
		return MobileNumEdt;
	}

	@FindBy(xpath= "//span[@class='dvHeaderText']")
	private WebElement EditPageText;
	
	@FindBy(xpath= "(//a[@title='Contacts'])[last()-1]")
	private WebElement RecentAddedNameLink;
	
	@FindBy(xpath= "(//a[@title='Contacts'])[last()]")
	private WebElement RecentAddedLastNameLink;
	
	@FindBy(id= "mouseArea_Last Name")
	private WebElement LastNameArea;
	
	@FindBy(xpath= "(//a[@class='link'])[1]")
	private WebElement LastNameAreaEditBtn;
	
	@FindBy(id="txtbox_Last Name")
	private WebElement LastNameEditTextBox;

	@FindBy(xpath="(//a[text()='Cancel'])[2]")
	private WebElement LastNameAreaCancleBtn;
	
	@FindBy(xpath= "(//input[@class='crmbutton small save'])[2]")
	private WebElement LastNameAreaSaveBtn;
	
	@FindBy (id="selectCurrentPageRec")
	private WebElement CheckBoxForAllSelect;
	
	@FindBy (xpath="//td[@class='layerPopupHeading']")
	private WebElement MassEdtPageHead;
	
	@FindBy(xpath="//a[text()='Edit']")
	private WebElement contactInfoEditBtn;
	
	public WebElement getContactInfoEditBtn() {
		return contactInfoEditBtn;
	}

	public WebElement getMassEdtPageHead() {
		return MassEdtPageHead;
	}

	public WebElement getEmailIdEdt() {
		return EmailIdEdt;
	}
	
	public WebElement getCheckBoxForAllSelect() {
		return CheckBoxForAllSelect;
	}

	public WebElement getLastNameAreaSaveBtn() {
		return LastNameAreaSaveBtn;
	}

	public WebElement getRecentAddedLastNameLink() {
		return RecentAddedLastNameLink;
	}
	
	public WebElement getLastNameAreaCancleBtn() {
		return LastNameAreaCancleBtn;
	}

	public WebElement getLastNameEditTextBox() {
		return LastNameEditTextBox;
	}

	public WebElement getLastNameArea() {
		return LastNameArea;
	}

	public WebElement getLastNameAreaEditBtn() {
		return LastNameAreaEditBtn;
	}

	public WebElement getCreateContactlogo() {
		return CreateContactlogo;
	}

	public WebElement getImportConactlogo() {
		return ImportConactlogo;
	}

	public WebElement getMassEditBtn() {
		return MassEditBtn;
	}

	public WebElement getEditBtn() {
		return EditBtn;
	}

	public WebElement getFirstNameEdt() {
		return FirstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getEditPageText() {
		return EditPageText;
	}

	public WebElement getRecentAddedNameLink() {
		return RecentAddedNameLink;
	}
	
	public void createContact(String FirstName, String LastName)
	{
		FirstNameEdt.sendKeys(FirstName);
		LastNameEdt.sendKeys(LastName);
		SaveBtn.click();	
	}

	public void createContactWithemailId(String FirstName,String LastName, String EmailId )
	{
		FirstNameEdt.sendKeys(FirstName);
		LastNameEdt.sendKeys(LastName);
		EmailIdEdt.sendKeys(EmailId);
		SaveBtn.click();	
	}	
	
}
