package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;

public class LoginPage extends BasePage {

		private WebDriver driver;						//for every login page class I will maintain a driver @28:46 so noone can access that.
	
		//1. By locators ---  OR (object Repository):	
		By username = By.name("username");
		By password = By.name("password");					//changed it to password from what I had: username.  Now entering correct Un & Pw on site
		By loginButton = By.xpath("//input[@class='btn btn-small']");
		By signUpLink = By.linkText("Selenium Jobs");
	
	
		//2. Create Constructor of page class:	
		public LoginPage(WebDriver driver){			
			this.driver = driver;
		}
		
		//3. Page ACTIONS
		public String getLoginPageTitle(){
			return driver.getTitle();			
		}
		
		public boolean verifySignUpLink(){
			return driver.findElement(signUpLink).isDisplayed();			
		}
		
		public HomePage doLogin(String username, String password){
			driver.findElement(this.username).sendKeys(username);
			driver.findElement(this.password).sendKeys(password);
			driver.findElement(loginButton).click();
			
			return new HomePage(driver);
}
}

