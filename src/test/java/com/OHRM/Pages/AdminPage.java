package com.OHRM.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	
	private WebDriver driver;
	
	//Initialize driver
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	private By menuList = By.xpath("//li[@class='oxd-main-menu-item-wrapper']");
	private By userNameTxt = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	private By searchButton = By.xpath("//button[@type='submit']");
	private By resetButton = By.xpath("//button[normalize-space()='Reset']");
	private By roleDrpdwn = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
	private By roleList = By.xpath("//div[@role='listbox']//div[@role='option']");
	private By statusDrpdwn = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
	private By totalRecords = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
	
	//Methods
	//Method to count and print all the left side menu options
	public int printLeftMenu() {		
		List<WebElement> leftMenu = driver.findElements(menuList);
		int count = leftMenu.size();
		System.out.println("All list in the menu: ");
		for(WebElement i: leftMenu) {
			System.out.println(i.getText());			
		}
		
		for(WebElement i: leftMenu) {
			if(i.getText().contains("Admin")) {
				i.click();
				break;
			}
		}
		return count;		
	}
	
	//Method to retrieve url of admin page
	public String getAdminURL() {
		return driver.getCurrentUrl();
	}
	
	//Method to perform search by user name
	public void searchByUserName(String userName) {
		driver.findElement(userNameTxt).sendKeys(userName);
	}
	
	//Method to perform search by user role
		public void searchByUserRole(String role) {
			driver.findElement(roleDrpdwn).click();
			List<WebElement> roleMenu = driver.findElements(roleList);
			for(WebElement i : roleMenu) {
				if(i.getText().contains(role)) {
					i.click();
					break;
				}
			}
		}
		
	//Method to perform search by user status
	public void searchByUserStatus(String status) {
		driver.findElement(statusDrpdwn).click();
		List<WebElement> statusMenu = driver.findElements(roleList);
		for(WebElement i : statusMenu) {
			if(i.getText().contains(status)) {
				i.click();
				break;
			}
		}
	}
		
	//Method to click search button
	public void clickSearch() {
		driver.findElement(searchButton).click();		
	}
	
	//Method to retrieve total records after search
	public String displayTotalRecords() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(totalRecords).getText();
	}
	
	//Method to refresh after search
	public void refreshPage() {
		driver.findElement(resetButton).click();
	}	

}
