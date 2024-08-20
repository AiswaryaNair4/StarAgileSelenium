package com.OHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass{
	
  @Test(priority=1)
  public void verifyTitle() {
	  String actTitle = lp.getAppTitle();
	  Assert.assertTrue(actTitle.contains("HRM"), "Fail : Title does not match!!");
	  System.out.println("Pass : Title matched!!");
  }
  
  @Test(priority=2)
  public void verifyLogin() {
	  String actURL = lp.getAppURL();
	  Assert.assertTrue(actURL.contains("dashboard"), "Login Fail : URL does not match!!");
	  System.out.println("Login Pass : URL matched!!");
  }
  
  
  
}
