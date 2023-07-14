package skyfallSmokeTest;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.brickworks.qa.utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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


public class SkyFallRegressionScript {

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
		reports.setSystemInfo("Browser", "Chrome V.113");

		// configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Regression Test Suit Report");
		htmlReporter.config().setReportName("Skyfall Automation Smoke Test Summary Reports");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");


	}

	@SuppressWarnings("deprecation")
	@Test (priority = 1,enabled=true)
	public void LaunchBrowserAndOpenURL()
	{
		//create test
		test = reports.createTest("TS001_Launch the browser and open the URL for the QA env. on Azure");
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

		//--------->> QA ENVIRONMENT <<--------- AZURE INSTANCES
		//driver.get("https://ces-skyfall-qa-manager.azurewebsites.net");
		//--------->> QA2 ENVIRONMENT <<--------- AZURE INSTANCES
		//driver.get("https://ces-skyfall-qa2.azurewebsites.net");
		//--------->> STAGE ENVIRONMENT <<--------- AZURE INSTANCES
		driver.get("https://app.stage.brickworks.dev/login");
		//--------->> PRODUCTION ENVIRONMENT <<--------- AZURE INSTANCES
		//driver.get("https://ces-skyfall-prod.azurewebsites.net/");

		//driver.get("https://ces-skyfall-qa.herokuapp.com");
		//driver.get("https://ces-skyfall-qa2.azurewebsites.net");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//

	}
	@Test (priority = 2,enabled=true)
	public void VerifyProductNamePageTitle()
	{
		//create test
		test = reports.createTest("TS002_Verify Product Name Page Title");
		//Assert.assertTrue(false); // test failed

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
	@Test (priority = 3,enabled=true)
	public void ValidUserLogin()
	{
		//create test
		test = reports.createTest("TS003_Valid User Login");
		//Assert.assertTrue(true); // test Pass
		WebElement textbx_Email =
				driver.findElement(By.name("email"));
		//textbx_Email.sendKeys("aditya.xperate@gmail.com");
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
	@Test (priority = 0,enabled=false)
	public void totalCountLink() {
		//create test
		test = reports.createTest("TS044_Verify Total No. Of Links Map");
		Assert.assertTrue(true); // test Pass
		// Find all the link elements on the page
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));


		// Get the total number of links
		int linkCount = links.size();

		// Print the total number of links
		System.out.println("Total number of links: " + linkCount);

		// Close the browser
	}
	@Test (priority = 4,enabled=true)
	public void InValidUserLogin()
	{
		//create test
		test = reports.createTest("TS004_In Valid User Login");
		throw new SkipException("skipping this test case with exception..");

	}
	@Test (priority = 5,enabled=true)
	public void VerifySearchMetsMap() throws InterruptedException
	{
		//create test
		test = reports.createTest("TS005_Verify Search Mets Map");
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
		// load the map
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("map-selection-item")));
		driver.findElement(By.xpath("(//div /button[@id='fullScreenMode'])[1]")).click();
		Thread.sleep(500);

		//driver.quit();
	}
	@Test (priority = 6,enabled=true)
	public void AddLocationLeftSideBar() throws InterruptedException
	{
		//create test
		test = reports.createTest("TS006_Add Location Card Successfully without Marker");
		Assert.assertTrue(true); // test Pass
		driver.manage().timeouts ().pageLoadTimeout (Duration.ofSeconds (30));
		driver.findElement(By.xpath("(//button[@id='fullScreenMode'])[1]"));
		Thread.sleep(500);
		//driver.findElement(By.xpath("(//div[@class='search-section']//button[@type='button']")).click();

		//Old UI for button dropdown
		//driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		//Thread.sleep(3000);

		//New UIfor button dropdown
		driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle btn-icon-only add-new-item-button']")).click();

		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a //span[text()='Add Location']")).click();
		driver.findElement(By.xpath("(//a[@class='dropdown-item add-new-item'])[1]")).click();

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
		test = reports.createTest("TS007_Edit Location Card Successfully without Marker");
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
	@Test(priority = 8,enabled=true)
	public void deleteLocation() throws  InterruptedException{
		if (Thread.interrupted())  // Clears interrupted status!
			throw new InterruptedException();

		//Delete Location Card marker from map
		test = reports.createTest("TS008_Delete Location Card Successfully");
		//Assert.assertTrue(true); // test Pass

		driver.findElement(By.xpath("(//div[@class='show-section'])[1]")).click();
		//driver.findElement(By.xpath("//div[@id='location_647e0604cae35d1ce3a84fff']//div[@class='item-name'][normalize-space()='Create Location Marker']")).click();

		System.out.println("click on the card");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//button[@class='btn btn-undefined btn-light btn-danger btn-icon-only'])[1]")).click();
		driver.findElement(By.xpath("//span [@class='action delete'])[1]")).click();
		System.out.println("click on delete button");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		//driver.findElement(By.xpath("//button[text()=' Yes ']")).click();
		driver.findElement(By.xpath("//div /button [@class='btn btn-primary']")).click();
		System.out.println("click on yes button");
		Thread.sleep(3000);
	}

	@Test (priority = 13,enabled=true)
	public void CreateMarkerLocation() throws InterruptedException {
		//create test
		test = reports.createTest("TS013_Create Location Marker Successfully");
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
		//driver.findElement(By.xpath("//div[@class='content-row'][1]")).click();
		//driver.findElement(By.xpath("//button[normalize-space()='New Location']")).click();
		driver.findElement(By.xpath("(//button[normalize-space()='New Location'])[1]")).click();

		//enter location name
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Create Location Marker");
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
	@Test (priority = 9,enabled=true)
	public void AddNotesCard() throws InterruptedException {
		//create test
		test = reports.createTest("TS009_Add Notes Functionality");
		//Assert.assertTrue(true); // test Pass
		//driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle btn-icon-only']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle btn-icon-only add-new-item-button']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a //span[text()='Add Note']")).click();
		driver.findElement(By.xpath("(//a[@class='dropdown-item add-new-item'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys("New Notes");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='content']")).sendKeys("New Notes Desc");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[@class='icon-link']")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.cssSelector(".form-multi-select.form-multi-select-selection-tags")).click();
		driver.findElement(By.xpath("//div /input[@class='form-multi-select-search']")).click();
		driver.findElement(By.xpath("(//div[@class='form-multi-select-options'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='form-group']")).click();

		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[text()='Peter W Winer']")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[text()='Sam Simmons']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.className("form-select")).click();
		//driver.findElement(By.xpath("//button[@class='btn btn-secondary']"))
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
	}
	@Test (priority = 10,enabled=true)
	public void DeleteNoteCard() {
		//Delete Note Card
		test = reports.createTest("TS010_Delete Notes Functionality");
		Assert.assertTrue(true); // test Pass

	}
	@Test (priority = 11,enabled=true)
	public void AddIncidentsCard() throws InterruptedException {
		//create test
		test = reports.createTest("TS011_Add Incidents Functionality");
		//Assert.assertTrue(true); // test Pass

		//+ icon
		driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle btn-icon-only add-new-item-button']")).click();
		Thread.sleep(3000);


		//add incident
		driver.findElement(By.xpath("(//a[@class='dropdown-item add-new-item'])[3]")).click();
		Thread.sleep(3000);

		//incident name
		driver.findElement(By.cssSelector("input[placeholder='Incident Name']")).sendKeys("New incident");
		Thread.sleep(3000);

		//incident description
		driver.findElement(By.cssSelector("textarea")).sendKeys("New incident");
		Thread.sleep(3000);
		System.out.println("related item");		
		//assignees
		driver.findElement(By.className("form-multi-select")).click();
		Thread.sleep(3000);

		//Peter W Winer
		driver.findElement(By.xpath("//div[text()='Peter W Winer']")).click();
		Thread.sleep(3000);

		//Sam Simmons
		driver.findElement(By.xpath("//div[text()='Sam Simmons']")).click();
		Thread.sleep(3000);

		//assignees
		driver.findElement(By.xpath("//label[contains(.,'Assignees')]")).click();
		Thread.sleep(3000);
		System.out.println("assignees");
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//select[@class='form-select']")).click();
		Thread.sleep(3000);
		//related items	
		//Select dm = new Select(driver.findElement(By.className("form-select")));
		Select dm = new Select(driver.findElement(By.className("//select[@class='form-select'])[1]")));
		Thread.sleep(3000);
		//select option by index from dropdown menu 
		dm.selectByIndex(3);
		Thread.sleep(3000);
		System.out.println("related item");
		Thread.sleep(3000);		
		//save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		System.out.println("incident");


	}
	@Test (priority = 12,enabled=true)
	public void DeleteIncidentsCard() {
		//create test
		test = reports.createTest("TS012_Delete Incidents Functionality");
		//Assert.assertTrue(true); // test Pass
	}
	@Test (priority = 14,enabled=true)
	public void CreateMarkerNotes() throws InterruptedException {
		//create test
		test = reports.createTest("TS014_Create Notes Marker Successfully");
		//Assert.assertTrue(true); // test Pass

		Actions action = new Actions(driver);

		WebElement link = driver.findElement(By.xpath("//canvas[@class='mapboxgl-canvas']"));
		action.contextClick(link).perform();
		//	action.moveToElement(driver.findElemennt By.xpath("//canvas[@class='mapboxgl-canvas']")));
		//	action.contextClick(link).build().perform();
		System.out.println("right click");
		Thread.sleep(5000);

		//add note
		//driver.findElement(By.xpath("(//div[@class='content-row'])[2]")).click();
		driver.findElement(By.xpath("(//button[normalize-space()='New Note'])[1]")).click();
		Thread.sleep(3000);
		System.out.println("Add note");

		//note name
		driver.findElement(By.cssSelector("input[placeholder='Note Name']")).sendKeys("New note");
		Thread.sleep(3000);

		//note description
		driver.findElement(By.cssSelector("textarea")).sendKeys("New note");
		Thread.sleep(3000);
		//								
		//attachments
		//driver.findElement(By.cssSelector("span[class='icon-link']")).click();
		//Thread.sleep(3000);
		//								
		//assignees
		driver.findElement(By.className("form-multi-select")).click();
		Thread.sleep(3000);

		//Peter W Winer
		driver.findElement(By.xpath("//div[text()='Peter W Winer']")).click();
		Thread.sleep(3000);

		//Sam Simmons
		driver.findElement(By.xpath("//div[text()='Sam Simmons']")).click();
		Thread.sleep(3000);

		//assignees
		driver.findElement(By.cssSelector(".form-multi-select.form-multi-select-selection-tags")).click();
		Thread.sleep(3000);

		//related items	
		Select dm = new Select(driver.findElement(By.cssSelector(".form-select")));
		Thread.sleep(3000);
		//select option by index from dropdown menu 
		dm.selectByIndex(3);
		Thread.sleep(3000);

		//save
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		Thread.sleep(3000);
	}
	@Test (priority = 15,enabled=true)
	public void CreateMarkerIncidents() throws InterruptedException {
		//create test
		test = reports.createTest("TS015_Create Incidents Marker Successfully");
		//Assert.assertTrue(true); // test Pass
		Actions action = new Actions(driver);

		WebElement link = driver.findElement(By.xpath("//canvas[@class='mapboxgl-canvas']"));
		action.contextClick(link).perform();
		//		action.moveToElement(driver.findElement(By.xpath("//canvas[@class='mapboxgl-canvas']")));
		//		action.contextClick(link).build().perform();
		System.out.println("right click");
		Thread.sleep(5000);

		//add location
		//driver.findElement(By.xpath("(//div[@class='content-row'])[3]")).click();
		driver.findElement(By.xpath("(//button[normalize-space()='New Incident'])[1]")).click();
		Thread.sleep(3000);
		System.out.println("Add incident");

		//incident name
		driver.findElement(By.cssSelector("input[placeholder='Incident Name']")).sendKeys("New incident");
		Thread.sleep(3000);

		//incident description
		driver.findElement(By.cssSelector("textarea")).sendKeys("New incident");
		Thread.sleep(3000);
		System.out.println("related item");		
		//assignees
		driver.findElement(By.className("form-multi-select")).click();
		Thread.sleep(3000);

		//Peter W Winer
		driver.findElement(By.xpath("//div[text()='Peter W Winer']")).click();
		Thread.sleep(3000);

		//Sam Simmons
		driver.findElement(By.xpath("//div[text()='Sam Simmons']")).click();
		Thread.sleep(3000);

		//assignees
		driver.findElement(By.xpath("//label[contains(.,'Assignees')]")).click();
		Thread.sleep(3000);
		System.out.println("assignees");
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//select[@class='form-select']")).click();
		Thread.sleep(3000);
		//related items	
		Select dm = new Select(driver.findElement(By.className("form-select")));

		Thread.sleep(3000);
		//select option by index from dropdown menu 
		dm.selectByIndex(3);
		Thread.sleep(3000);
		System.out.println("related item");
		Thread.sleep(3000);		
		//save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
	}
	@Test(priority = 16,enabled=true)
	public void UserLogOut() throws InterruptedException{


		//create test
		test = reports.createTest("TS016_User LogOut from the WebApp");
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
	{try {
		if (ITestResult.FAILURE==result.getStatus()) 
		{
			Utilities.TakingScreenshot(driver, result.getName());
		}
	}catch(Exception ex) {
		System.out.println(ex);
	}
	}
	public void takescreenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot)driver);

		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+screenshotname+" .png");
		FileUtils.copyFile(src, dest);
	}


	@AfterTest
	public void tearDown()
	{
		reports.flush();

	}
}


