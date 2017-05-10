package com.valentine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TCTwoVerifyIfyButtonMoreInfoWorks {

    private WebDriver driver;

    @Test
    public void testTheClickableButtonMoreInfo(){
        System.setProperty("webdriver.chrome.driver", "//home//likewise-open//LVIVSOFT//spolyakov//chromedriver");
        driver = new ChromeDriver();
        driver.get("http://awful-valentine.com/");

        driver.findElement(By.className("more-info")).click();

    }
}
