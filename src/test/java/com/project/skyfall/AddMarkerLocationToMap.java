package com.project.skyfall;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddMarkerLocationToMap {

	public static WebDriver driver;
		

		@SuppressWarnings("deprecation")
		@BeforeTest
		public void start(){
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
		driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (20));
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
		
		driver.get("https://ces-skyfall-qa-manager.azurewebsites.net/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
		@Test(priority = 1,enabled=true)
		public void ValidUserLogin(){

			WebElement textbx_Email =
			driver.findElement(By.name("email"));
			textbx_Email.sendKeys("aditya@xperate.com");
			driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
		// Password is set
			driver.findElement(By.name("password")).sendKeys("Aditya@123456");
			driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
		// Click on login and another way of doing
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/form/div[4]/button")).click();
			driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
			
			//driver.quit();
}
		@Test (priority = 2,enabled=true)
		public void searchMetMap() throws InterruptedException {
		//Pinned First Checkbox
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
		
		driver.findElement(By.xpath("//label[@class='form-checkbox']//span")).click();
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='form-checkbox']//span")));
		//driver.findElement(By.id("checkbox")).click();
		// Print the first result
		System.out.println(firstResult.getText());
		
		
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
		//Search for map to map selection page
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@class,'form-control')]")).sendKeys("mets");
		//Click on the map i.e. mets
		Thread.sleep(2000);
		
		driver.findElement(By.className("map-selection-item")).click();
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (30));
		//close Chrome driver
		Thread.sleep(5000);
		
		
		//driver.quit();
}
		@Test (priority = 3,enabled=true)
		 public void addmarker() throws InterruptedException {
		
		//right click on map
		Thread.sleep(6000);
		Actions a1 = new Actions(driver);
		a1.contextClick(driver.findElement(By.xpath("//canvas[@class='mapboxgl-canvas']"))).perform();
		//dd new location
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='content-row'][1]")).click();
		//enter location name
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Location here");
		//enter location description
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("textarea[name='content']")).sendKeys("Location1 Description");
		//select ATM as location typeThread.sleep(3000);
		WebElement we = driver.findElement(By.className("form-select"));
		Select s = new Select(we);
		s.selectByIndex(1);
		//Click on related notes
		Thread.sleep(3000);
		driver.findElement(By.className("form-multi-select-selection-tags")).click();
		//select New UI noteThread.sleep(3000);driver.findElement(By.xpath("//div[text()=\"New UI note\"]")).click(); 
		//Click on related notes
		Thread.sleep(3000);
		driver.findElement(By.className("form-multi-select-selection-tags")).click();
		//click on submit
		Thread.sleep(3000);
		driver.findElement(By.className("btn-primary")).click();
		driver.quit();
}
}
