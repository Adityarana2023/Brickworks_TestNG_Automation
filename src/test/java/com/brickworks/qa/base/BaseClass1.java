package com.brickworks.qa.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class BaseClass1 {
	WebDriver driver;
	@Before
	public void beforeMethod()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://ces-skyfall-qa-manager.azurewebsites.net/login");
		System.out.println("URL Open");
	}
	
	@After
	public void afterMethod()
	{
		driver.quit();
		System.out.println("End of the program");
	}
	
	
}
