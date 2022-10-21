package com.automationtesting.jsedemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmLogin {
	static WebDriver driver;
	 public static void takeScreenImage(String imgname) throws IOException {
		 File source_location=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String project_location=System.getProperty("user.dir");
		 File destination_location=new File(project_location+"\\screenshotLocation"+ imgname + ".jpg");
		 FileUtils.copyFile(source_location,destination_location);
	 }
	
	 public static void setUp() throws InterruptedException, IOException {
		 WebDriverManager.chromedriver().setup();
	     driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 Thread.sleep(2000);
		 takeScreenImage("LaunchPage");
	 }
	
		 public static void Login_OrangeHrmApplication() throws InterruptedException, IOException  {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		 takeScreenImage("HomePage");
	
		
	}
		public static void verify_OrangeHrm_Login() throws IOException, InterruptedException {
			String expected_url = driver.getCurrentUrl();
			String actual_url="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		 if(expected_url.equals(actual_url)) {
			 System.out.println("OrangeHrm Successfully Logged in");
	
			 
		 }
		
	 }
		public static void logout_OrangeHrm() throws InterruptedException, IOException {
			driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			Thread.sleep(2000);
			 takeScreenImage("Home Page");
			
			}
		public static void verify_logout_OrangeHrm() {
			String expected_url = driver.getCurrentUrl();
			String actual_url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
			 if(expected_url.equals(actual_url)) {
				 System.out.println("OrangeHrm Successfully Logged out");
		}
	   }
		public static void tearDown() {
		driver.close();
		
		}
		public static void main(String[] args) throws IOException, InterruptedException {
			setUp();
			Login_OrangeHrmApplication();
			verify_OrangeHrm_Login();
			logout_OrangeHrm();
			verify_logout_OrangeHrm();
			tearDown();
		}
}






