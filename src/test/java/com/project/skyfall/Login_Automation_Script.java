package com.project.skyfall;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class Login_Automation_Script {

	
	@SuppressWarnings("deprecation")
	@Test
	
	public static void main(String[] args) 

	{
	
		WebDriver driver = new ChromeDriver();
		System.setProperty("Webdriver.Chrome.Driver","C:\\Users\\AdityaRana\\driver\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new EdgeDriver();
	    //System.setProperty("Webdriver.Edge.Driver","C:\\Users\\AdityaRana\\driver\\chromedriver_win32\\msedgedriver.exe");
		
		driver.get("https://ces-skyfall-qa.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

// Find user name and set usernameC:\Users\AdityaRana\Selenium12-17dec\driver\chromedriver_win32
	
		WebElement textbx_Email =
		driver.findElement(By.name("email"));
	textbx_Email.sendKeys("aditya@xperate.com");
	
// Password is set
	driver.findElement(By.name("password")).sendKeys("Aditya@123456");
	
// Click on login button
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/form/div[4]/button")).click();	
// Search by map - "mets"	
	WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div[2]/div/div/div[2]/div[3]/input"));
		
	searchbox .sendKeys("mets" + Keys.ENTER);
		
		
// Click on thumb nail 	image of "mets"	
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div[3]/div[1]/div/div/div/div/div[1]/img")).click();
		driver.quit();
	}

}
