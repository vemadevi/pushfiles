package com.automationtesting.webtablepractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePractice {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.get("https://letcode.in/table");
	WebElement attendance= driver.findElement(By.id("simpletable"));
	JavascriptExecutor js=((JavascriptExecutor) driver);
	js.executeScript("arguments[0].scrollIntoView();",attendance);
	List<WebElement>table_headers=attendance.findElements(By.tagName("th"));
	for(WebElement header:table_headers) {
		System.out.print(header.getText()+" || ");
	}
	driver.close();
}
}

