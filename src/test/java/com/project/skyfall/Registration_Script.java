package com.project.skyfall;



import java.sql.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
		public class Registration_Script {
			
		@Test
		public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		WebDriver d = new ChromeDriver(options);
		d.manage().window().maximize();
			
		d.get("http://ces-skyfall-qa.herokuapp.com/login");
		d.findElement(By.cssSelector("a[class='nav-link'] span")).click();
		Thread.sleep(2000);
		d.findElement(By.name("name")).sendKeys("Aditya Rana");
		Thread.sleep(2000);
		d.findElement(By.xpath("(//input[@placeholder='Email'])[2]")).sendKeys("aditya"+generateTimeStamp ()+"@xperate.com");
		Thread.sleep(2000);
		d.findElement(By.name("company")).sendKeys("Xperate System");
		Thread.sleep(2000);
		d.findElement(By.name("phone")).sendKeys("9854564652");
		Thread.sleep(2000);
		d.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("Aditya@123456");
		Thread.sleep(2000);
		d.findElement(By.xpath("(//input[@placeholder='Confirm Password'])[1]")).sendKeys("Aditya@123456");
		Thread.sleep(500);
		d.findElement(By.xpath("(//*[name()='svg'][@class='custom-icon icon-tabler icon-tabler-eye-off'])[2]")).click();
		Thread.sleep(500);
		d.findElement(By.xpath("(//*[name()='svg'][@class='custom-icon icon-tabler icon-tabler-eye-off'])[2]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//button[normalize-space()='Create An Account'])[1]")).click();
		Thread.sleep(2000);
		d.quit();
		}
		
		public static String generateTimeStamp () {

			Date date = new Date(5);
			return date.toString().replace(" ", "_").replace(": ", "_");

		
		}
		}