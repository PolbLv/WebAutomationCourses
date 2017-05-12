package com.valentine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FourthTCTypeComment {

    String homePage = "http://awful-valentine.com/";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "//home//likewise-open//LVIVSOFT//spolyakov//chromedriver");
        driver = new ChromeDriver();
        driver.get(homePage);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void openItemAndFillFields(){
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

        driver.findElement(By.cssSelector("#slides > div:nth-child(1) > div.featured-image")).click();
        //waitFor(1000);
        driver.findElement(By.id("author")).sendKeys("John");
        //waitFor(1000);
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        //waitFor(1000);
        driver.findElement(By.id("url")).sendKeys("www.comment.com");
        //waitFor(1000);
        driver.findElement((By.xpath("//*[@id='et-rating']/div/span/div[8]"))).click();
        //waitFor(1000);
        driver.findElement((By.id("comment"))).sendKeys("This is my first comment and I agitated =)))");
        //waitFor(1000);
        driver.findElement(By.id("submit")).click();
        //waitFor(3000);

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    private void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {

        }
    }
}


