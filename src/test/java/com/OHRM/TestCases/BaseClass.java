package com.OHRM.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.OHRM.Pages.AdminPage;
import com.OHRM.Pages.LoginPage;

public class BaseClass {

	//Initialize
	public WebDriver driver;
	public LoginPage lp;
	public AdminPage ap;
	
	@BeforeTest
	public void browserSetUp() {
		//Creating chrome driver instance
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Launching application
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//Instance of Login and Admin Page
		lp = new LoginPage(driver);	
		ap = new AdminPage(driver);
		
	}
	
	@BeforeClass
	public void pageSetUp() {
		lp.login("Admin", "admin123");
	}
	

}
