package com.project.skyfall;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenChromeBrowser {
	
		
	
public static WebDriver driver;

		
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void start() {
	
		WebDriverManager.chromedriver().setup();
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (50));
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (50));
	
		driver.get("https://ces-skyfall-qa-manager.azurewebsites.net/login");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
		public void UserLoginBrickworks() {
		WebElement textbx_Email =
				driver.findElement(By.name("email"));
				textbx_Email.sendKeys("aditya@xperate.com");
				driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
			// Password is set
				driver.findElement(By.name("password")).sendKeys("Aditya@123456");
				driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
			// Click on login and another way of doing
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/form/div[4]/button")).click();
				driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
				
			//driver.close();
			driver.quit();
	}

}
