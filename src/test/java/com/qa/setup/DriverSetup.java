package com.qa.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
public static WebDriver driver;
	public static WebDriver createDriver()
	{
		System.setProperty("webdriver.chrome.driver", "./" + "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
			
	}
	   
}
