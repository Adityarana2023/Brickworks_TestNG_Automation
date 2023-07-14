package com.TestCasesScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowserAndOpenURL {
public static WebDriver driver;
	
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
		//driver.get("https://ces-skyfall-qa-manager.azurewebsites.net/login");
		//driver.get("https://ces-skyfall-stage.herokuapp.com/login");
		//driver.get("https://ces-skyfall-qa.herokuapp.com/login");
		//driver.get("https://app.stage.brickworks.dev/login");
		driver.get("https://ces-skyfall-wes-us-stage.azurewebsites.net/login");
		//driver.get("https://app.brickworks.live/login");

	}}
