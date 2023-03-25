package com.project.skyfall;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.brickworks.qa.base.Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brickworks_Login_LogOut extends Base{
	//@BeforeMethod <-> @Test <-> @AfterMethod ==> This is a combination
WebDriver driver;
	@BeforeMethod
	public void setup(){
		
		driver = initializeBrowserAndOpenApplicationURL("chrome");
		
		
		
		// Click on login and another way of doing
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/form/div[4]/button")).click();
			driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	
	
	
	}
	
	@Test (priority = 1,enabled=true)
	public void UserLogin(){
	System.out.println("User is able to Login");
	
	String browserName = "chrome";
	
	if (browserName.equals("chrome")) {
		
		driver = new ChromeDriver();
		
	}
		else if (browserName.equals("edge")) {
			
		}
		driver = new EdgeDriver();
	
	
System.out.println("User is getting login");
driver = new ChromeDriver();
WebDriverManager.chromedriver().setup();
System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
System.setProperty("webdriver.chrome.silentOutput", "true");

ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
DesiredCapabilities cp = new DesiredCapabilities();
cp.setCapability(ChromeOptions.CAPABILITY, options);
options.merge(cp);


driver.manage().window().maximize();
driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (20));
driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
WebElement textbx_Email =
		driver.findElement(By.name("email"));
		textbx_Email.sendKeys("aditya@xperate.com");
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	// Password is set
		driver.findElement(By.name("password")).sendKeys("Aditya@123456");
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	}
	
	@Test (priority = 2,enabled=true)
public void UserLogOut() throws InterruptedException {
	
	System.out.println("User is able to LogOut");
	driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']//*[name()='svg']")).click();
	 Thread.sleep(2000);
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	
	driver.findElement(By.xpath("//span[text()='Log Out']")).click();
	 Thread.sleep(2000);
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();

	}
	

}
