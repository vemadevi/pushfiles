package com.automationtesting.webtablepractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo {
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
		List<WebElement>tablerows= driver.findElements(By.xpath("//table[@id='simpletable']//tr"));
		int rowcount=tablerows.size();
		System.out.println("Total row size::"+rowcount);
		if(rowcount==4) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
			
		}
			driver.close();
				
		}
		
		
	}


