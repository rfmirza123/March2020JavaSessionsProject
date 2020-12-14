package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qa.crmpro.base.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	
	//By header = By.xpath("//td[@class='headertext'][1]");	
	//By header = By.xpath("//td[@class='logo_text']");	
	//By header = By.xpath("//h1[@id='pm_modal_title']");			
		By header = By.cssSelector("td.logo_text");		
		By accountName = By.xpath("//td[@class='headertext'][1]");			
	//By accountName = By.cssSelector(.headertext);
			
	public HomePage (WebDriver driver){
	this.driver = driver;
	}
public String getHomePageTitle() {	
	return driver.getTitle();
	}	
	
	public String getHomePageHeaderText() {
			if(driver.findElement(header).isDisplayed()) {
			return driver.findElement(header).getText();
	}	
		return null;
	}	
	
	public String getLoggedInUser() {
		if(driver.findElement(accountName).isDisplayed()) {
			System.out.println("Account Name is : " + accountName);	
			return driver.findElement(accountName).getText();		
	}	
		return null;
	}
	
	public void clickOnContacts(){
		driver.findElement(By.xpath("//a[@title='Contacts']"));
	}	
	
	}	
	
	
//	public HomePage (WebDriver driver){
//		this.driver = driver;
//	}
//	
//	public String getHomePageTitle() {	
//		return driver.getTitle();
//	}	
	
//	public String getUserName() {	
//		return driver.getTitle();
//	}
	
//	public String getLoggedInUser() {
//		if(driver.findElement(username).isDisplayed()){
//			return driver.findElement(username).getText();
//		}	
//		return null;
//	}
	

