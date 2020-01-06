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
public class Contact_SelectCheckBox_MassEdit_Test extends BaseClass {
	
	@Test 
	public void contact_SelectCheckBox_MassEdit_Test() throws Throwable
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
			WebDriverCommonUtil.waitForPageToLoad();
					
		//step 4 -create one contact
			String FirstName = flib.getExcelData("Sheet1", 4, 2);
			String LastName =  flib.getExcelData("Sheet1", 4, 3);
			String FirstName1 = flib.getExcelData("Sheet1", 5, 2);
			String LastName1 =  flib.getExcelData("Sheet1", 5, 3);
			String FirstName2 = flib.getExcelData("Sheet1", 6, 2);
			String LastName2 =  flib.getExcelData("Sheet1", 6, 3);
			
			cp.createContact(FirstName, LastName);
			cp.getCreateContactlogo().click();
			WebDriverCommonUtil.waitForPageToLoad();
			cp.createContact(FirstName1, LastName1);
			cp.getCreateContactlogo().click();
			WebDriverCommonUtil.waitForPageToLoad();
			cp.createContact(FirstName2, LastName2);
			
		//Step 5 -click on contact link
			hp.getContactLink().click();
			
		// Step 6 - Navigate to mass edit 
			WebDriverCommonUtil.waitForElementPresent(cp.getCheckBoxForAllSelect());
			cp.getCheckBoxForAllSelect().click();
			cp.getMassEditBtn().click();
			
		// Step 7 -Verification of mass edit page
			WebDriverCommonUtil.waitForElementPresent(cp.getMassEdtPageHead());
			String ExpEPage= cp.getMassEdtPageHead().getText();
			String ActEPage= "Mass Edit - Records Fields";
			Assert.assertEquals(ExpEPage, ActEPage);
			Reporter.log("Mass Edit Page Open ==> Pass",true);
			
			
			
			

}
}
