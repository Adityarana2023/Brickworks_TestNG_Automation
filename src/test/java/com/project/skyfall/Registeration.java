package com.project.skyfall;

import java.sql.Date;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.brickworks.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registeration {
public static WebDriver driver;
@Test
public void startRegistration() throws InterruptedException {
	
	
	WebDriverManager.chromedriver().setup();
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	DesiredCapabilities cp = new DesiredCapabilities();
	cp.setCapability(ChromeOptions.CAPABILITY, options);
	options.merge(cp);
	
	driver = new ChromeDriver(options); 
	
	driver.manage().window().maximize();
	driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (20));
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));

	
	driver.get("https://ces-skyfall-stage.herokuapp.com/login");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("a[class='nav-link'] span")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("name")).sendKeys("Aditya Rana");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@placeholder='Email'])[2]")).sendKeys(Utilities.generateEmailWithTimeStamp());
	Thread.sleep(2000);
	driver.findElement(By.name("company")).sendKeys("Xperate System");
	Thread.sleep(2000);
	driver.findElement(By.name("phone")).sendKeys("9971761302");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("Aditya123456");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@placeholder='Confirm Password'])[1]")).sendKeys("Aditya@123456");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//*[name()='svg'][@class='custom-icon icon-tabler icon-tabler-eye-off'])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//*[name()='svg'][@class='custom-icon icon-tabler icon-tabler-eye-off'])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[normalize-space()='Create An Account'])[1]")).click();
	driver.quit();
}

	

public static String generateTimeStamp () {

	Date date = new Date(5);
	return date.toString().replace(" ", "_").replace(": ", "_");


//public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
	//new WebDriverWait(driver, timeout).
	//until(ExpectedConditions.visibilityOf(element));
	//element.sendKeys(value);
}
//public static void clickOn(WebDriver driver, WebElement element, int timeout) {
//new WebDriverWait(driver, timeout).
//until(ExpectedConditions.elementToBeClickable(element));
//element.click();

}

