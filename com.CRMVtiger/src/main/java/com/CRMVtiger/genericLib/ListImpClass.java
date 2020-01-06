package com.CRMVtiger.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListImpClass implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String CurrentDate = new Date().toString().replace(":", "_").replace(" ", "_");
		
		String FailedTestName = result.getMethod().getMethodName();
		
		System.out.println("==Fail==>"+FailedTestName);
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.driver);
		
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		
		File dstFile = new File("./screenshot/"+FailedTestName+"_"+CurrentDate+".png");
		try {
			FileUtils.copyFile(srcFile, dstFile);
		}
		catch  (IOException e )
		{
			
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}
