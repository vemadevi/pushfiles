package com.automationtesting.testngconcpt;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmLogin {
	WebDriver driver;
	SoftAssert assertion=new SoftAssert();
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	@BeforeClass
public void url() {
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}
@Test
public void login() {
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String actual_url=driver.getCurrentUrl();
	String expected_url="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
	assertion.assertEquals(actual_url, expected_url);
	System.out.println("logged in successfully");
	assertion.assertAll();
}
@Test
public void logout() {
	driver.findElement(By.cssSelector("p[class*=userdropdown]")).click();
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	WebElement loginlabel= driver.findElement(By.xpath("//h5"));
	assertion.assertTrue(loginlabel.isDisplayed());
	System.out.println("logged out successfully");
	assertion.assertAll();
}


@AfterClass
public void teardown() {
	
	driver.close();
}

}
