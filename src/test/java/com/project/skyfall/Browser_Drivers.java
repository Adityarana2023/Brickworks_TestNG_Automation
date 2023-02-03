package com.project.skyfall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Drivers {

	public static void main(String[] args) {
	//WebDriverManager.chromedriver().setup();
	System.setProperty("Webdriver.Chrome.Driver","C:\\Users\\AdityaRana\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://google.com");
	System.out.println(driver.getTitle());
	

	}

}
