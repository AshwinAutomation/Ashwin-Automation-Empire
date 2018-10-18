package com.sailpoint.testBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.qameta.allure.Attachment;

public class SailpointListner extends TestListenerAdapter{
	  @Attachment
	    public byte[] captureScreenshot(WebDriver d) {
	        return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
	    }
	    @Override
	    public void onTestFailure(ITestResult tr) {
	        Object webDriverAttribute = tr.getTestContext().getAttribute("WebDriver");
	        if (webDriverAttribute instanceof WebDriver) {
	            System.out.println("Screesnshot captured for test case:" + tr.getMethod().getMethodName());
	            captureScreenshot((WebDriver) webDriverAttribute);
	        }
	    }
	    
	    @Override
	    public void onTestSuccess(ITestResult tr) {
	        Object webDriverAttribute = tr.getTestContext().getAttribute("WebDriver");
	        if (webDriverAttribute instanceof WebDriver) {
	            System.out.println("Screesnshot captured for test case:" + tr.getMethod().getMethodName());
	            captureScreenshot((WebDriver) webDriverAttribute);
	        }
	    }
}
