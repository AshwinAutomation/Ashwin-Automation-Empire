package com.sailpoint.execution;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.loginelementpage.SailPointLogin;
import com.sailpoint.testBase.TestBase;

public class LoginTest extends TestBase {


	public void sailPointLoginTest() {

		SailPointLogin login = PageFactory.initElements(driver, SailPointLogin.class);
		System.out.println(" inside test class");
		login.uName = prop.getProperty("username");
		login.uPwd = prop.getProperty("password");
		boolean result = login.login(login.uName, login.uPwd);
		Assert.assertTrue(result, "Login successfully and homepage should Display");
		login.saveScreenshot("sailpoint DashBoard ", driver);
	}
}
