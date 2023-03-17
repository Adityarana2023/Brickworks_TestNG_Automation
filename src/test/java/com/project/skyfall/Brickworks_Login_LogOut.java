package com.project.skyfall;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Brickworks_Login_LogOut {
	//@BeforeMethod <-> @Test <-> @AfterMethod ==> This is a combination

	@BeforeMethod
	public void UserRegisteration(){
	System.out.println("User is getting registered");

	}

	@Test
	public void UserLogin(){
	System.out.println("User is able to Login");

	}

	@AfterMethod
	public void UserLogOut(){
	System.out.println("User is able to LogOut");

	}
	

}
