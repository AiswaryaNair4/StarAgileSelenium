package com.Scenario1;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.OHRM.Utility.ReadFromExcel;
import com.OHRM.Utility.Util;

public class OHRM_Scenario1 {
	
  @Test(dataProvider="excelData",dataProviderClass=ReadFromExcel.class)
  public void loginTest(String userName, String password) throws InterruptedException {
	  
	  //Opening Chrome browser
	  WebDriver driver = new ChromeDriver();
	  //Synchronization
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //Maximize Window
	  driver.manage().window().maximize();
	  //Launching Application
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  //Entering UserName
	  driver.findElement(By.name("username")).sendKeys(userName);
	  //Entering Password
	  driver.findElement(By.name("password")).sendKeys(password);
	  //Click on login button
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  Thread.sleep(1000);
	  //Take Screenshot
	  Util.createScreenshot(driver);
	  
	  //Validation
	  Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Fail");
	  System.out.println("Login Successfull");
	  
	  //Logout Code
	  driver.findElement(By.className("oxd-userdropdown-img")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  
	  
	  
  }
}
