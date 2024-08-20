package com.OHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseClass  {	
  //Test to print and count all left menu options 
  @Test(priority=1)
  public void testLeftMenu() {
	 int menuCount =  ap.printLeftMenu();
	 Assert.assertEquals(menuCount, 12);
	 System.out.println("Test Pass: The total count of left side menu = " + menuCount);
  }
  
 //Test to validate admin page 
  @Test(priority=2)
  public void validateAdminPage() {
	 String actURL = ap.getAdminURL();
	 Assert.assertTrue(actURL.contains("admin"), "Test Fail : Admin Page not opened!!");
	 System.out.println("Test Pass : Admin Page opened successfully!!");
  }
  
  //Test to search user by name 
  @Test(priority=3)
  public void searchByUserName() {
	 ap.searchByUserName("Admin");
	 ap.clickSearch();
	 String totRec = ap.displayTotalRecords();
	 System.out.println("Total records returned from user name search : "+totRec);
	 ap.refreshPage();	
  }
  
  //Test to search user by role 
  @Test(priority=4)
  public void searchByUserRole() {
	 ap.searchByUserRole("Admin");;
	 ap.clickSearch();
	 String totRec = ap.displayTotalRecords();
	 System.out.println("Total records returned from user role search : "+totRec);
	 ap.refreshPage();	
  }
  
  //Test to search user by status 
  @Test(priority=5)
  public void searchByUserStatus() {
	 ap.searchByUserStatus("Enabled");
	 ap.clickSearch();
	 String totRec = ap.displayTotalRecords();
	 System.out.println("Total records returned from user status search : "+totRec);
	 ap.refreshPage();	
  }
}
