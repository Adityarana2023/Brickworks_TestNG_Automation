package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitializationBrowser {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(opt);
		driver.get("https://ces-skyfall-qa-manager.azurewebsites.net/login");
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
		driver.manage().window().maximize();
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
		System.out.println(driver.getTitle());
		Thread.sleep(500);
	}
		@Test
		public void login()
		{
		WebElement textbx_Email =
				driver.findElement(By.name("email"));
		textbx_Email.sendKeys("aditya@xperate.com");
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
		driver.findElement(By.name("password")).sendKeys("Aditya@123456");
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (20));
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div[2]/div/div[1]/div/form/div[4]/button")).click();
		
	
		}
		@Test
		public void totalCountLink() {
			
		// Find all the link elements on the page
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

        // Get the total number of links
        int linkCount = links.size();

        // Print the total number of links
        System.out.println("Total number of links: " + linkCount);

        // Close the browser
		driver.quit();
	}

}
