package com.qagroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeStarter {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "//Users//Serhiy//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.com.ua");
		
		driver.findElement(By.name("q")).sendKeys("Hello World!");
		
		driver.findElement(By.name("btnG")).click();
		
		driver.close();
	}
}
