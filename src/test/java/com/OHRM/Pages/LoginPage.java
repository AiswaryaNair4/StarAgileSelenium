package com.OHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//Initialize driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	private By uName = By.name("username");
	private By pwd = By.name("password");
	private By loginBtn = By.xpath("//button[@type='submit']");	
	
	//Methods	
	public void login(String userName, String password) {
		driver.findElement(uName).sendKeys(userName);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(loginBtn).click();
	}
	
	public String getAppTitle() {
		return driver.getTitle();
	}
	
	public String getAppURL() {
		return driver.getCurrentUrl();
	}	

}
