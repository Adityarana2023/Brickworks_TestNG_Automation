package com.project.skyfall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SkyfallQAAzure {
	public static void main(String[] args) {
		
	}
	public static WebDriver driver;
	
	public void seleniumWait() {
	
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"Drivers\\chromedrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup(); 
		
		// these patch code for chrome version confliction 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		
		
		WebDriver driver = new ChromeDriver();
		 driver.get("google.com");
		 
		
		
		
	}

}
