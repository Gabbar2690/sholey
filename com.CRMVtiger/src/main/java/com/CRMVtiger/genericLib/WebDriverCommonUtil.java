package com.CRMVtiger.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRMVtiger.genericLib.BaseClass;

public class WebDriverCommonUtil {
	
	public static void waitForPageToLoad() {
		BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	 
	public static void waitForElementPresent(WebElement element){
		WebDriverWait wait = new WebDriverWait(BaseClass.driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public void select(WebElement element , String data) {
		Select sel = new Select (element);
		sel.selectByVisibleText(data);		
	}

	public void Select (WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);		
	}
	
	public static  void Action (WebElement element) {
			Actions act = new Actions (BaseClass.driver);
			act.moveToElement(element).perform();
	}

}

