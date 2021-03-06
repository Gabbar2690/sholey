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
public class Contact_EditBox_Edit_Save_VerifyChangesTest extends BaseClass {

	
	@Test 
	public void contact_EditBox_Edit_Save_VerifyChangesTest() throws Throwable
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
			
		//Step 3 -Navigate to Create Contact 
			ContactPage cp = PageFactory.initElements(driver, ContactPage.class);
			WebDriverCommonUtil.waitForElementPresent(cp.getCreateContactlogo());
			cp.getCreateContactlogo().click();
					
		//step 4 -create one contact
			String FirstName = flib.getExcelData("Sheet1", 15, 2);
			String LastName =  flib.getExcelData("Sheet1", 15, 3);
			String MobileNum =  flib.getExcelData("Sheet1", 15, 4);
			cp.createContact(FirstName, LastName);
			
		//Step 5 -click on contact link
			hp.getContactLink().click();
			
		// Step 6 - Click on name to navigate edit page
			cp.getRecentAddedNameLink().click();
		
		// Step 7 - verification of edit page
			String expRes = "Contact Information";
			String actRes = cp.getEditPageText().getText();
			boolean stat1 =(actRes.contains(expRes));
			Assert.assertEquals(stat1, true);
			Reporter.log("Edit Page open ==>pass", true);
			
		// Step 8 - In EditPage mobli
			WebDriverCommonUtil.waitForElementPresent(cp.getMobileEdtArea());
			WebDriverCommonUtil.Action(cp.getMobileEdtArea());
			cp.getContactInfoEditBtn().click();
			//cp.getMobileNumEdt().click();
			cp.getMobileNumEdt().clear();
			cp.getMobileNumEdt().sendKeys(MobileNum);
			
		// Step 9 - click on last name save button
			cp.getLastNameAreaSaveBtn().click();
			
		// Step 10 - Verification of No changes in edit page
			hp.getContactLink().click();
			String expMobNum = cp.getRecentAddedLastNameLink().getText();
			String actMobNum = MobileNum;
			Assert.assertEquals(expMobNum, actMobNum);
			Reporter.log("Last name not change, Verify No Changes in contact Successful==Pass", true);
	}
}
