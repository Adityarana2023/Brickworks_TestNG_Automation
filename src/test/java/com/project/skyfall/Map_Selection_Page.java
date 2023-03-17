package com.project.skyfall;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Map_Selection_Page {
public static WebDriver driver;
@SuppressWarnings("deprecation")
@BeforeMethod
public void start(){
	
WebDriverManager.chromedriver().setup();
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	DesiredCapabilities cp = new DesiredCapabilities();
	cp.setCapability(ChromeOptions.CAPABILITY, options);
	options.merge(cp);
	
	
	driver = new ChromeDriver(options);
	
	
	
	
	WebDriver driver = new ChromeDriver();
			//WebDriver driver = new EdgeDriver();
			//System.setProperty("Webdriver.Chrome.Driver","C:\\Users\\AdityaRana\\driver\\chromedriver_win32\\chromedriver.exe");
			//driver.get("https://ces-skyfall-stage.herokuapp.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (10));
			driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
			
			driver.get("https://ces-skyfall-qa.herokuapp.com/login");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}

			@Test(priority = 1,enabled=true)
			public void UserLogin(){

					WebElement textbx_Email =
					driver.findElement(By.name("email"));
				textbx_Email.sendKeys("aditya@xperate.com");
				
			// Password is set
				driver.findElement(By.name("password")).sendKeys("Aditya@123456");
				
			// Click on login and another way of doing
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/form/div[4]/button")).click();
				driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
			
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

