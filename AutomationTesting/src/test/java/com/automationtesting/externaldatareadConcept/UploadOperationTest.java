package com.automationtesting.externaldatareadConcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadOperationTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
		Thread.sleep(2000);
	WebElement upload_button=driver.findElement(By.xpath("//input[@id='uploadfile']"));
	JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();",upload_button);
		upload_button.sendKeys("G:\\testing videos\\morning text\\30 Sep Mor 7.30 AM");
        driver.close();
	}

}
