package com.qa.crmpro.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.utils.Constants;

public class HomePageTest {
	
		WebDriver driver;
	
		BasePage basePage;				//create Object to call init_driver from BasePage.  Launch Browser, enter url and  execute test cases
		LoginPage loginPage;
		HomePage homePage;
		
		@BeforeTest
		public void setUp(){
			basePage = new BasePage();
			driver  = basePage.init_driver("chrome");
			loginPage = new LoginPage(driver);	
			homePage = loginPage.doLogin("batchautomation", "Test@12345");
			//homePage = new HomePage.getLoggedInUser();
		}
			
		@Test(priority=1)
		public void verifyHomePageTitle(){
			String title = homePage.getHomePageTitle();
			System.out.println("Home Page title is : " +  title);
			Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "home Page Title is not Matching...");
		}	
		
		@Test(priority=2)
			public void verifyHomePageHeader(){
				String header = homePage.getHomePageHeaderText();
				System.out.println("Home Page Header is : " + header );
				Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "Home Page Header is not matching");
		}
		
		@Test(priority=3)
		public void verifyLoggedInUserTest(){
			String LoggedInUser = homePage.getLoggedInUser();
			System.out.println("Logged in User is :" + LoggedInUser );
			Assert.assertEquals(LoggedInUser, Constants.HOME_PAGE_LOGGEDINUSER, "Logged in User not matching");			
		}
		
		@Test(priority = 4)
		public void verifySignUpLinkTest(){
			loginPage.verifySignUpLink();	
			Assert.assertTrue(loginPage.verifySignUpLink(), "sign up link is not displayed");
			
		}
					
		@AfterTest	
		public void tearDown(){
			driver.quit();
		}
}
	