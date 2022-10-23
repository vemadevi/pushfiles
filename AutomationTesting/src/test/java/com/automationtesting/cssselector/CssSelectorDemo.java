package com.automationtesting.cssselector;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectorDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://github.com/login");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#login_field")).sendKeys("vemadevi5959@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.js-password-field")).sendKeys("vema@234");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.label-link")).click();
		Thread.sleep(2000);
		driver.close();
		
	}
}
