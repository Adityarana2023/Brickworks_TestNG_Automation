package skyfallSmokeTest;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.brickworks.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

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
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class SkyFallSmokeScript {

	public static WebDriver driver;


	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentSparkReporter("ExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		// add environment details

		reports.setSystemInfo("Machine", "Aditya-PC");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("QA Team", "Aditya Rana");
		reports.setSystemInfo("Browser", "Chrome V.112");

		// configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Skyfall Automation Smoke Test Summary Reports");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");


	}


	@SuppressWarnings("deprecation")
	@Test (priority = 1,enabled=true)
	public void LaunchBrowserAndOpenURL()
	{
		//create test
		test = reports.createTest("Launch the browser and open the URL for the QA env. on Azure");
		//Assert.assertTrue(true); // test passed

		//
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

		driver.get("https://ces-skyfall-qa-manager.azurewebsites.net/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//

	}
	@Test (priority = 2,enabled=true)
	public void VerifyProductNamePageTitle()
	{
		//create test
		test = reports.createTest("Verify Product Name Page Title");
		//Assert.assertTrue(false); // test failed

		//get the actual value of the title

		String ActualTitle = driver.getTitle();

		String ExpectedProductNamePageTitle = "Brickworks Site Manager11";

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
	@Test (priority = 3,enabled=true)
	public void ValidUserLogin()
	{
		//create test
		test = reports.createTest("Valid User Login");
		//Assert.assertTrue(true); // test Pass
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
	@Test (priority = 4,enabled=true)
	public void InValidUserLogin()
	{
		//create test
		test = reports.createTest("In Valid User Login");
		throw new SkipException("skipping this test case with exception..");
		
	}
	@Test (priority = 5,enabled=true)
	public void VerifySearchMetsMap() throws InterruptedException
	{
		//create test
		test = reports.createTest("Verify Search Mets Map");
		Assert.assertTrue(true); // test Pass
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
	@Test (priority = 6,enabled=true)
	public void AddLocationLeftSideBar() throws InterruptedException
	{
		//create test
		test = reports.createTest("Add Location Card Successfully without Marker");
		Assert.assertTrue(true); // test Pass
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

		//driver.quit();
	}
	@Test (priority = 7,enabled=true)
	public void EditLocation() throws InterruptedException {
		//create test
		test = reports.createTest("Edit Location Card Successfully without Marker");
		//Assert.assertTrue(true); // test Pass

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
	}
	@Test (priority = 8,enabled=true)
	public void CreateMarkerLocation() throws InterruptedException {
		//create test
		test = reports.createTest("Create Location Marker Successfully");
		//Assert.assertTrue(true); // test Pass

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
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Emergency 1");
		//enter location description
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("textarea[name='content']")).sendKeys("Exit Gate No.2");
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
	@Test(priority = 9,enabled=true)
	public void deleteLocation() throws InterruptedException{

		//create test
		test = reports.createTest("Delete Location Marker Successfully from left sidebar");
		//Assert.assertTrue(true); // test Pass


		driver.findElement(By.xpath("//div[@class=\"show-section\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(3000);
	}
	@Test(priority = 10,enabled=true)
	public void UserLogOut() throws InterruptedException{


		//create test
		test = reports.createTest("User LogOut from the WebApp");
		//Assert.assertTrue(true); // test Pass

		//System.out.println("User is able to LogOut");
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']//*[name()='svg']")).click();
		Thread.sleep(5000);
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));

		driver.findElement(By.xpath("//span[text()='Log Out']")).click();
		Thread.sleep(5000);
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (5));


		driver.quit();
	}





	// this is a global method for test results
	@AfterMethod
	public void getTestResult(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
			 
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{

			test.log(Status.PASS,MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
			test.log(Status.PASS, "Test passed successfully!");
			//test.pass(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{

			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.YELLOW));
		}
	}
	
	public void Aftermethods(ITestResult result) throws IOException
	{
		if (ITestResult.FAILURE==result.getStatus()) 
		{
			Utilities.TakingScreenshot(driver, result.getName());
		}
	}
		

	@AfterTest
	public void tearDown()
	{
		reports.flush();

	}
}