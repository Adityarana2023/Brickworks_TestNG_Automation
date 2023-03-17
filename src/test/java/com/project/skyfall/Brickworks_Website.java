package com.project.skyfall;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brickworks_Website {
	
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void start(){
	WebDriverManager.chromedriver().setup();
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	DesiredCapabilities cp = new DesiredCapabilities();
	cp.setCapability(ChromeOptions.CAPABILITY, options);
	options.merge(cp);
	
	
	driver = new ChromeDriver(options);
	
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

	@Test (priority = 2,enabled=true)
	public void searchMetMap() throws InterruptedException {
	//Pinned First Checkbox
		
	driver.findElement(By.xpath("//label[@class='form-checkbox']//span")).click();
		
		
	//search for map
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[contains(@class,'form-control')]")).sendKeys("mets");
	//Click on the map card i.e. mets
	Thread.sleep(2000);
	driver.findElement(By.className("map-selection-item")).click();
	
	//close Chrome driver
	Thread.sleep(3000);
	//driver.quit();
	}
	
	@Test(priority = 3,enabled=false)
	public void UserLogOut() throws InterruptedException{
	//System.out.println("User is able to LogOut");
	driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']//*[name()='svg']")).click();
	 Thread.sleep(2000);
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	
	driver.findElement(By.xpath("//span[text()='Log Out']")).click();
	 Thread.sleep(2000);
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	
	}

}
