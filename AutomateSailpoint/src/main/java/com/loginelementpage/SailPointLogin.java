package com.loginelementpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.sailpoint.testBase.TestBase;


public class SailPointLogin extends TestBase{
	public String uName;
	public String uPwd;
	@FindBy(id="loginForm:accountId")
	public WebElement uid;
	
	@FindBy(id="loginForm:password")
	public WebElement pwd;
	
	@FindBy(id="loginForm:loginButton")
	public WebElement loginButton; 

  
      public boolean login(String userName,String userPwd) {
 
       uid.sendKeys(userName);
       pwd.sendKeys(userPwd);
       loginButton.click();
       return true ;
	}
      
	}
	 
	 
	
	
	
	
	
	
	
	

