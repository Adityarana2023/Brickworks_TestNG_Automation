package com.project.skyfall;

import java.io.IOException;
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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.brickworks.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brickworks_Website {
	
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
	driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (50));
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (50));
	
	//invoke the webapp url :-->
	
	//driver.get("https://ces-skyfall-eu-uk-sou-qa-manager.azurewebsites.net/login");
	driver.get("https://ces-skyfall-qa-manager.azurewebsites.net/login");
	//driver.get("https://ces-skyfall-stage.herokuapp.com/login");
	//driver.get("https://ces-skyfall-qa.herokuapp.com/login");
	//driver.get("https://app.stage.brickworks.dev/login");
	//driver.get("https://app.brickworks.live/login");
	
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test (priority = 1,enabled=true)
public void TS001_VerifyProductNamePageTitle() {
		
	//get the actual value of the title
	
	String ActualTitle = driver.getTitle();
	
	String ExpectedProductNamePageTitle = "Brickworks Site Manager";
	
	//compare the actual title with the expected title
	Assert.assertEquals(ActualTitle, ExpectedProductNamePageTitle);
	//if (getTitle.equals(ActualTitle));
	{
	System.out.println( "Test Passed") ;
	}
	 
	{
	System.out.println( "Test Failed" );
	}
	
	
	//driver.quit();
	
}
	@Test(priority = 2,enabled=true)
	public void TS002_ValidUserLogin(){

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
		
		//driver.quit();
	}
	@Test (priority = 33,enabled=false)
	public void TS003_InValidUserLogin() {
		WebElement textbx_Email =
				driver.findElement(By.name("email"));
				textbx_Email.sendKeys("aditya1@xperate.com");
				driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (15));
			// Password is set
				driver.findElement(By.name("password")).sendKeys("Aditya@123456");
				driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (15));
			// Click on login and another way of doing
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/form/div[4]/button")).click();
				driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (25));
				
//String actualWarningMessage = driver.findElement(By.xpath("//div[@class='form-group alert errorMsg']"));
//String expectedWarningMessage = "The combination of Email and Password is incorrect.";
//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),("The combination of Email and Password is incorrect")); 
				
				driver.quit();
				
	}

		
	@Test (priority = 3,enabled=true)
	public void TS004_searchMetMap() throws InterruptedException {
	//Pinned First Checkbox
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (30));
	
	//driver.findElement(By.xpath("//label[@class='form-checkbox']//span")).click();
	//Search for map to map selection page
	
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[1]/input")).sendKeys("mets");
	//driver.findElement(By.xpath("//div[@class='search-field']")).sendKeys("mets");
	//Click on the map i.e. mets
	Thread.sleep(3000);
	
	driver.findElement(By.className("map-selection-item")).click();
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (30));
	//close Chrome driver
	Thread.sleep(5000);
	
	
	//driver.quit();
	}
	@Test (priority = 7,enabled=true)
	public void TS005_CreateMarkerLocation() throws InterruptedException {
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (40));
		//right click on the map
				Thread.sleep(6000);
				Actions a1 = new Actions(driver);
				a1.contextClick(driver.findElement(By.xpath("//canvas[@class='mapboxgl-canvas']"))).perform();
				driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (30));
				
				//Initialize and wait till element(link) became clickable - timeout in 10 seconds
				WebElement displayMarkerPopup = new WebDriverWait(driver, Duration.ofSeconds(20))
				        .until(ExpectedConditions.elementToBeClickable(By.xpath("//canvas[@class='mapboxgl-canvas']")));
				// Print the first result
				System.out.println(displayMarkerPopup.getText());
								
				//Create for marker of location
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='content-row'][1]")).click();
				//driver.findElement(By.xpath("//*[@id=\"map\"]/div[4]/div[2]/div/div[2]/button")).click();
				
				//enter location name
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Loc Name");
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
				//Click on related notes
				Thread.sleep(3000);
				//driver.findElement(By.className("form-multi-select-selection-tags")).click();
				driver.findElement(By.xpath("//div /input[@class='form-multi-select-search']")).click();
				driver.findElement(By.xpath("(//div[@class='form-multi-select-options'])[1]")).click();
				driver.findElement(By.xpath("//div[@class='form-group']")).click();
				//click on submit
				Thread.sleep(3000);
				//driver.findElement(By.className("btn-primary")).click();
				driver.findElement(By.xpath("//button[text()='Save']")).click();
				Thread.sleep(4000);
				
		//driver.quit();
	}
	@Test (priority = 6,enabled=true)
	public void TS006_EditLocation() throws InterruptedException {
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (30));
		// Find the element to edit

		driver.findElement(By.xpath("(//div[@class='item-card-header'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div /span[@class='icon-link'])[1]")).click();
		Thread.sleep(3000);
		
		// Clear the current value and enter a new value
		driver.findElement(By.xpath("//input[@placeholder='Location Name']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Location Name']")).sendKeys("Location Title");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@class='form-control']")).clear();
		driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Location Desc.");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(3000);
			
		//driver.findElement(By.xpath("((//span[@class='icon-link'])[2]")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("(//div /select[@class='form-select'])[1]")).click();
		//Thread.sleep(3000);
		
		//WebElement we = driver.findElement(By.className("form-select"));
		//Select s = new Select(we);
		//s.selectByIndex(1);
		//driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("(//div /span[@class='icon-link'])[3]")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("(//div[@class='form-multi-select form-multi-select-selection-tags'])[1]")).click();
		//driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		//Thread.sleep(3000);
		//For Collapse Card  
		driver.findElement(By.xpath("(//div[@class='item-card-header'])[1]")).click();
	}
	
	
	
	@Test (priority = 5,enabled=true)
	public void TS007_AddLocationLeftSideBar() throws InterruptedException
	{
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (30));
		//driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle btn-icon-only']"));
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a //span[text()='Add Location']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Loc Name1");
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
		//Click on related notes
		Thread.sleep(3000);
		//driver.findElement(By.className("form-multi-select-selection-tags")).click();
		driver.findElement(By.xpath("//div /input[@class='form-multi-select-search']")).click();
		driver.findElement(By.xpath("(//div[@class='form-multi-select-options'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='form-group']")).click();
		//click on submit
		Thread.sleep(3000);
		//driver.findElement(By.className("btn-primary")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(4000);
		
	}
	@Test(priority = 8,enabled=true)
	public void TS008_deleteLocation() throws InterruptedException{
		driver.findElement(By.xpath("//div[@class=\"show-section\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 9,enabled=true)
	public void TS009_UserLogOut() throws InterruptedException{
	//System.out.println("User is able to LogOut");
	driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']//*[name()='svg']")).click();
	 Thread.sleep(5000);
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	
	driver.findElement(By.xpath("//span[text()='Log Out']")).click();
	 Thread.sleep(5000);
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));
	
	
	driver.quit();
	}
	
	@AfterMethod
	public void Aftermethod(ITestResult result) throws IOException
	{
		if (ITestResult.FAILURE==result.getStatus()) 
		{
			Utilities.TakingScreenshot(driver, result.getName());
		}
	}
		

	
	
}
