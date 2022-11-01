package com.automationtesting.inheritance;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	@DataProvider(name="logindata")
	public Object[][] getUserData() {
		Object[][]data=new Object[2][2];
		data[0][0]="admin";
		data[0][1]="admin123";
		
		data[1][0]="Admin";
		data[1][1]="admin@123";
	
		return data;
	}
	@BeforeTest
  public void setup() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
}
	public void captureScreenShot(String imagename) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenimages"+imagename);
		FileUtils.copyFile(src, destination);
	}
	@AfterMethod
	public void afterTest(ITestResult Result) throws IOException {
		if(Result.getStatus()==ITestResult.FAILURE) {
			captureScreenShot(Result.getMethod().getMethodName()+".jpg");
		}
			else if (Result.getStatus()==ITestResult.SUCCESS) {
				System.out.println("TestCase"+Result.getMethod().getMethodName()+"pass");
				
			}
		
	}
	
	@AfterTest
  public void teardown() {
	  driver.close();
  }
}
