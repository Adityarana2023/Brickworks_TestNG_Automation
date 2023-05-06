package com.brickworks.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.brickworks.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;
	public Properties prop; // this is a global properties for all environment.
	
	public Base() {
		prop = new Properties();
		File propFile = new File (System.getProperty("user.dir")+"\\src\\main\\java\\com\\brickworks\\qa\\config\\config.properties");
	try {
		FileInputStream fis = new FileInputStream (propFile);
		prop.load(fis);
	} catch (Throwable e) {
		e.printStackTrace();
	}
		
	}
	
	@SuppressWarnings("deprecation")
	public  WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
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



driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (20));
driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));

			
	driver.manage().window().maximize();
	driver.manage().timeouts ().implicitlyWait (Duration.ofSeconds (Utilities.IMPLICIT_WAIT_TIME));
	driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (Utilities.PAGE_LOAD_TIME));
	
	//driver.get("https://ces-skyfall-qa.herokuapp.com/login");
	driver.get(prop.getProperty("testurl"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;}

	public void tearDown() {
		driver.close();
		System.out.println("tearDown successfull");
	
	
	}
}