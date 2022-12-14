package com.automationtesting.externaldatareadConcept;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeTest {
	static Properties pr;
	static WebDriver driver;
	public static void readproperties() throws IOException {
	String project_location=System.getProperty("user.dir");
	BufferedReader reader =new BufferedReader(new FileReader(project_location+"\\TestData.properties"));
	pr=new Properties();
	pr.load(reader);
	}
	public static void takeScreenImage(String imgname) throws IOException {
		 File source_location=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String project_location=System.getProperty("user.dir");
		 File destination_location=new File(project_location+"\\Project pictuers"+ imgname + ".jpg");
		 FileUtils.copyFile(source_location,destination_location);
	 }
public static void setup(String url) throws IOException {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	driver.get(url);
	takeScreenImage("launch");
}
public static void login_letcodeApplication(String username,String password ) throws IOException {
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
	takeScreenImage("homepage");
}
public static void teardown() throws InterruptedException, IOException {
	Thread.sleep(5000);
	driver.close();

}

public static void main(String[] args) throws IOException, InterruptedException {
	readproperties();
	String page_url=pr.getProperty("URL");
	String username=pr.getProperty("username");
	String password=pr.getProperty("password");
	setup(page_url);
	login_letcodeApplication(username,password);
	teardown();
}
}
