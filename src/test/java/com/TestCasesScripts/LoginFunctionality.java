package com.TestCasesScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginFunctionality extends LaunchBrowserAndOpenURL {

	public static WebDriver driver;

			
	
	@Test
	
	public void ValidUserLogin() {
		
			//create test
			//test = reports.createTest("TS003_Valid User Login");
			//Assert.assertTrue(true); // test Pass
			WebElement textbx_Email =
					driver.findElement(By.name("email"));
			//textbx_Email.sendKeys("aditya.xperate@gmail.com");
			textbx_Email.sendKeys("aditya@xperate.com");
			driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
			// Password is set
			driver.findElement(By.name("password")).sendKeys("Aditya@123456");
			driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
			// Click on login and another way of doing
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/form/div[4]/button")).click();
			driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));

			//driver.quit();
		}

	}


