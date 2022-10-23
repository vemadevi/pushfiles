package com.automationtesting.testngconcpt;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngAnnotation {
	@BeforeTest
	public void Launchbrowser() {
		System.out.println("Launch browser");
		}
	@BeforeClass
		public void Launchurl() {
			System.out.println("Launchurl");
		}
	@BeforeMethod
		public void Login() {
			System.out.println("Login");
		}
	@Test
		public void addemploy() {
			System.out.println("add employ");	
		}
	@Test
		public void deleteemploy() {
			System.out.println("delete employ");	
		}
	@AfterMethod
		public void Logout() {
			System.out.println("Logout");
		}
	@AfterClass
		public void teardown() {
			System.out.println("closebrowser");
}
	@AfterTest
		public void producereport() {
			System.out.println("producereport");
}
}