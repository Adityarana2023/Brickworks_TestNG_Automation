package com.project.skyfall;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonHyperlinkCount {
	public static WebDriver driver;

	public static void main(String[] args) {
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
		
        
        // Navigate to Amazon.com homepage
        driver.get("https://www.amazon.com/");
        
        // Find all hyperlink elements using the anchor ('a') tag
        java.util.List<WebElement> hyperlinkElements = driver.findElements(By.tagName("a"));
        
        // Get the count of hyperlink elements
        int hyperlinkCount = hyperlinkElements.size();
        
        // Print the count of hyperlinks
        System.out.println("Total number of hyperlinks on Amazon.com: " + hyperlinkCount);
        
        // Close the WebDriver
        //driver.quit();
    }


	}


