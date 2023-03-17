package com.brickworks.qa.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public  void initializeBrowserAndOpenApplicationURL (String browserName) {
		
		if (browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
			
		}
			else if (browserName.equals("edge")) {
				
			}
			driver = new EdgeDriver();
		
	driver.manage().window().maximize();
	driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (10));
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	
	driver.get("https://ces-skyfall-qa.herokuapp.com/login");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return;
}
}