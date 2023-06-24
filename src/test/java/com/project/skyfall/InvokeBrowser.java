package com.project.skyfall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InvokeBrowser {
	public static WebDriver driver;
	
		public static void main(String[] args) {
			
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriver driver=new ChromeDriver(opt);
			driver.get("https://www.google.com");
			System.out.println(driver.getTitle());
			//driver.quit();
			
			
		
	}

}
