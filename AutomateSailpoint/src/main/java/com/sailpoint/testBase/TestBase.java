package com.sailpoint.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class TestBase {
	public static WebDriver driver = null;
	public static Properties prop = null;
	public static String projectLocation = System.getProperty("user.dir");

	
	public static void initialization() {
		try {
			prop = new Properties();
			File file = new File(
					"E:\\Automation Empire\\AutomateSailpoint\\src\\main\\java\\com\\sailpoint\\config\\sailpoint.properties");
			FileInputStream fi = new FileInputStream(file);
			prop.load(fi);
			
			File file2 = new File(
					"E:\\AutomationWorld\\AutomateSailpoint\\src\\main\\java\\com\\properties\\allure.properties");
			FileInputStream fi2 = new FileInputStream(file2);
			prop.load(fi2);
			Reporter.log("prop file load successfully");
			System.out.println("prop file load successfully");

		} catch (Exception e) {
			Reporter.log(e.getMessage());
			System.out.println(e.toString());
		}
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./DriverRoom/chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		

	}
	@BeforeSuite
	public static void lunchURL() {
		initialization();
		driver.get(prop.getProperty("url"));
		Reporter.log("Title of the application : " + driver.getTitle());
	}
	@Attachment(value = "Screenshot of {0}", type = "image/png")
	public byte[] saveScreenshot(String name, WebDriver driver) {
		return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
 
	public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
		iHookCallBack.runTestMethod(iTestResult);
		if (iTestResult.getThrowable() != null) {
			this.saveScreenshot(iTestResult.getName(), driver);
		}
	}
}
