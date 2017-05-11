package com.valentine.test;


import com.valentine.app.AwfulValentine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThirdTCAddToCartAllItems {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        AwfulValentine.openHomePage();

        driver.findElement(By.cssSelector("[href='#et-offer-post-30']")).click();
        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));

    }

    @Test
    public void testContinueShoppingButtonRedirectsToHomePage() {
        driver.findElement(By.id("continueShopping")).click();
        waitFor(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/");

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

