package com.project.skyfall;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Annotation {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is Before Suite Annotation");
	}
	@BeforeTest
		public void start(){
		System.out.println("This is Before Test Annotation");
	}

	@BeforeClass
	public void beforeClass(){
		System.out.println("This is Before Class Annotation");
	}
	
	@BeforeMethod
	public static void beforeMethod(){
		
		
		System.out.println("This is Before Method Annotation");
		
		
	}
	
	@Test(priority = 1,enabled=true)
	public void LoginTest(){
		
		System.out.println("User is able to login");
	}
	@Test(priority = 2,enabled=false)
	public void ValidLoginCredentials()
	{
		System.out.println("User is able to valid login credential");
	}
	@Test(priority = 3,enabled=true)
	public void MapSelectionPage()
	{
		System.out.println("Map selection page visibility");
	}
	@Test(priority = 4,enabled=true)
	public void RegistrationTest(){
		System.out.println("User is getting registered");
	}
	
	@AfterMethod
	public void UserLogOut(){
		System.out.println("User is able to logout");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("This is After Class Annotation");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("This is After Test Annotation");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("This is After Suite Annotation");
	}
}
