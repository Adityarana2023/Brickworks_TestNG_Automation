package com.brickworks.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login extends BaseClass1{
	WebDriver driver;
	@Test
	public void main() 
	{
		System.out.println("Login");
		//correct username and correct password
		driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("aditya@xperate.com");
		driver.findElement(By.xpath("//div[@class='login-form']//input[@placeholder='Password']")).sendKeys("Aditya@123456");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Login Success");
	}

}
