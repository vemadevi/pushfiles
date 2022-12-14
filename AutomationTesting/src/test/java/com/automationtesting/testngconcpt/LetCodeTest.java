package com.automationtesting.testngconcpt;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeTest {
	WebDriver driver;
	@BeforeTest
	public void launchbrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();	
	}
	@BeforeClass
public void url() {
	driver.get("https://letcode.in/signin");
}
	@BeforeMethod
public void login() {
	List<WebElement> toastmsg =driver.findElements(By.xpath("//div[@role='alertdialog']"));
if(toastmsg.size()>0) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@role='alertdialog']"))));
}
	driver.findElement(By.xpath("//a[text()='Log in']")).click();
	driver.findElement(By.name("email")).sendKeys("testingtraining@gmail.com");
	driver.findElement(By.name("password")).sendKeys("G@testing2022");
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
}
	@Test
public void coursecontent() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@role='alertdialog']"))));
	driver.findElement(By.xpath("//a[text()='Courses']")).click();
	String actual_url=driver.getCurrentUrl();
	String expected_url="https://letcode.in/courses";
	Assert.assertEquals(actual_url, expected_url);
}
	@Test
public void productmenu() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@role='alertdialog']"))));
	driver.findElement(By.xpath("//a[text()='Product']")).click();
	String actual_url=driver.getCurrentUrl();
	String expected_url="https://letcode.in/letxpath";
	Assert.assertEquals(actual_url, expected_url);
}
	@AfterMethod
public void logoff() {
	driver.findElement(By.xpath("//a[text()='Sign out']")).click();
}
	@AfterClass
public void teardown() throws InterruptedException {
	Thread.sleep(2000);	
	driver.close();
}
	@AfterTest
public void producerepot() {
	System.out.println("produce reports");
}
}
