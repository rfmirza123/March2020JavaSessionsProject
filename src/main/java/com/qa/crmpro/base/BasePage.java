package com.qa.crmpro.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	/**
	 * This method is use to intialize the driver on the basis of browser
	 * 
	 * @param browserName
	 * @return
	 */
	
		public WebDriver init_driver(String browserName) {	
			
			if(browserName.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver =new ChromeDriver();
		}
			else if(browserName.equalsIgnoreCase("firefox")){
				WebDriverManager.chromedriver().setup();
				driver =new FirefoxDriver();			
		}
			else if(browserName.equalsIgnoreCase("ie")){
				WebDriverManager.chromedriver().setup();
				driver =new InternetExplorerDriver();	
		}
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			
			driver.get("https://crmpro.com/");
			
			return driver;		
	}
		/**
		 * This method is used to initialize the properties from config.properties
		 *  file
		 * 
		 * @return prop
		 */
		public Properties init_prop(){
			prop = new Properties();								//Create an Object of Properties
					//Create FileInputStream to interact with confiq.properties file.  Delete initial value until \src/main\....and surrounr with try/Catch block
			try {
				FileInputStream ip = new FileInputStream("./src/main/java/com/qa/crmpro/config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {	
					e.printStackTrace();
			}
			
			return prop;			
		}
}
 