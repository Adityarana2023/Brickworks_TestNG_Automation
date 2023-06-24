package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	
	
	 public static WebDriver driver;
	 
	 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	      WebDriver driver = new ChromeDriver();
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
			
	      driver.get("http://www.google.com");
	      driver.quit();

	}

}
