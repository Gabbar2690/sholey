package com.CRMVtiger.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.CRMVtiger.objectRepo.HomePage;
import com.CRMVtiger.objectRepo.LoginPage;

@Listeners(com.CRMVtiger.genericLib.ListImpClass.class)
public class BaseClass {
	
	public static WebDriver driver;
	public FileLib flib=new FileLib();
	/**
	 * Used to open browser
	 * @throws Throwable
	 */
	@BeforeClass
	public void openBrowserBC() throws Throwable{

		/*Get the browser from properties file*/
		String BROWSER = flib.getPropertyKeyValue("browser");
		
		/*Open the given browser*/
		driver=null;
		if(BROWSER.equals("firefox")) 
			driver=new FirefoxDriver();
		else if(BROWSER.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

			driver=new ChromeDriver();
		}else if(BROWSER.equals("ie"))
			driver=new InternetExplorerDriver();
	}
	/**
	 * used to login in to the application
	 * @throws Throwable
	 */
	@BeforeMethod
	public void loginBM() throws Throwable{
		  
			/*Get the login data from properties file*/
			String URL=flib.getPropertyKeyValue("url");
			String USERNAME=flib.getPropertyKeyValue("username");
			String PASSWORD=flib.getPropertyKeyValue("password");
			
		/*Goto login page*/
		driver.get(URL);
		driver.manage().window().maximize();
		WebDriverCommonUtil.waitForPageToLoad();
		
		/* create an object Login POM Class*/
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApp(USERNAME, PASSWORD);
		//lp.getSubmitButton().click();
		
		
	}
	/**
	 * Used to logout from the application
	 * @throws InterruptedException
	 */
	
	@AfterMethod
	public void logoutAM() throws InterruptedException{
		 
		 /*Perform actions to goto logout*/		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		//hp.getUserImg();
		WebDriverCommonUtil.Action(hp.getUserImg());
		/*Click on logout*/
		WebDriverCommonUtil.waitForElementPresent(hp.getSignoutLink());
		hp.getSignoutLink().click();
		
	}
	/**
	 * Used to close the browser
	 */
	@AfterClass
	public void closeBrowserAC() {
		/*Close the driver*/
		driver.quit();
	}
	

}
