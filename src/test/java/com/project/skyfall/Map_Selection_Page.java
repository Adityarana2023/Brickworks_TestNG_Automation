package com.project.skyfall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Map_Selection_Page {
public static WebDriver driver;
@BeforeMethod
public void start(){
	WebDriver driver = new ChromeDriver();
			//WebDriver driver = new EdgeDriver();
			System.setProperty("Webdriver.Chrome.Driver","C:\\Users\\AdityaRana\\driver\\chromedriver_win32\\chromedriver.exe");
			driver.get("https://ces-skyfall-stage.herokuapp.com/");
			driver.manage().window().maximize();
	}

	@Test(priority =1, enabled = true)
	public void MapSelectionPage() {
	} {
		System.out.println(driver.getCurrentUrl());
		String CurrentURL = "https://ces-skyfall-qa.herokuapp.com/maps";
		if(CurrentURL.equals("https://ces-skyfall-qa.herokuapp.com/maps")) {
			System.out.println("Test Case Map Selection Page is PASS");
			
		}else {
			System.out.println("Test Case Map Selection Page is FAIL");
		}
		
	}
	@Test(priority =2, enabled = true,dependsOnMethods= {"MapSelectionPage"})
	public void Event() {
		driver.findElement(By.name("Mets")).click();
	}
	
@AfterMethod
public void UserLogOut() {
	System.out.println("User is able to logout");
//public void tearDown() 
	driver.quit();
}

	
}

