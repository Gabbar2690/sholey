package com.CRMVtiger;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.CRMVtiger.genericLib.BaseClass;
import com.CRMVtiger.genericLib.WebDriverCommonUtil;
import com.CRMVtiger.objectRepo.ContactPage;
import com.CRMVtiger.objectRepo.HomePage;
/**
 * 
 * @author Kaps
 *
 */
@Listeners(com.CRMVtiger.genericLib.ListImpClass.class)
public class Contact_EditBtnAction_EditPageTest extends BaseClass {
	
	@Test 
	public void contact_EditBtnAction_EditPageTest() throws Throwable
	{
		//step 1 -click on contact link
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
			hp.getContactLink().click();
		
		//step 2 -verify contact page
			String expPage = "Contacts";
			String actPage = driver.getTitle();
			boolean stat =(actPage.contains(expPage));
			Assert.assertEquals(stat, true);
			Reporter.log("Contact Page open ==Pass", true);
			
		//Step 3 -Navigate to Create Contact */
			ContactPage cp = PageFactory.initElements(driver, ContactPage.class);
			WebDriverCommonUtil.waitForElementPresent(cp.getCreateContactlogo());
					cp.getCreateContactlogo().click();
					
		//step 4 -create one contact
			String FirstName = flib.getExcelData("Sheet1", 12, 2);
			String LastName =  flib.getExcelData("Sheet1", 12, 3);
			
			cp.createContact(FirstName, LastName);
			
		//Step 5 -click on contact link
			hp.getContactLink().click();
			
		//step 6- click on recently added conatct edit button
			cp.getEditBtn().click();
			
		//Step 7 - Verify Edit page
			String expRes = "Contact Information";
			String actRes = cp.getEditPageText().getText();
			boolean stat1 =(actRes.contains(expRes));
			Assert.assertEquals(stat1, true);
			Reporter.log("Edit Page open ==>pass", true);
	}

}
