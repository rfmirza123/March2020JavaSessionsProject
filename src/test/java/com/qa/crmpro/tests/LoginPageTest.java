package com.qa.crmpro.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.utils.Constants;

public class LoginPageTest {
		WebDriver driver;
		LoginPage loginPage;

		BasePage basePage;				//create Object to call init_driver from BasePage.  Launch Browser, enter url and  execute test cases
		
		@BeforeTest
		public void setUp(){
			basePage = new BasePage();
			driver  = basePage.init_driver("chrome");
			loginPage = new LoginPage(driver);			
	}
		
		@Test(priority = 2)
		public void verifyLoginPageTitleTest(){
			String title = loginPage.getLoginPageTitle();
			System.out.println("My login page title is :" + title);
			Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login title not matching");
		}
		
		@Test(priority = 1)
		public void verifySignUpLinkTest(){
			loginPage.verifySignUpLink();	
			Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed");
		}
		
		@Test(priority = 3)
		public void loginTest(){
			loginPage.doLogin("batchautomation", "Test@12345");
			
		}

		@AfterTest
		public void tearDown(){
			driver.quit();
		}
	
}
