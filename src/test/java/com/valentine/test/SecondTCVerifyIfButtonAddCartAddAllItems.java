package com.valentine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class SecondTCVerifyIfButtonAddCartAddAllItems {

    String homePage = "http://awful-valentine.com/";
    String expectedPrice;
    String expectedName;

    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void testAddToCartSecondItem() {
        System.setProperty("webdriver.chrome.driver", "//Users//Serhiy//ChromeDriver//chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 8);
        driver.get(homePage);

        expectedPrice = driver.findElement(By.cssSelector(".special-item [href*='old-together'] img+span")).getText();
        expectedName = driver.findElement(By.cssSelector("#special-items > div:nth-child(2) > h4 > a")).getText();
        expectedName = expectedName.substring(expectedName.indexOf(""));
        expectedPrice = expectedPrice.substring(expectedPrice.indexOf("$") + 1).trim();

        driver.findElement(By.cssSelector("[href='#et-offer-post-27']")).click();
        //WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));

        String actualName = driver.findElement(By.cssSelector("#et-offer-post-27 > div > h2")).getText();
        actualName.substring(actualName.indexOf(""));
        Assert.assertEquals(expectedName, actualName, "Name don't match");

        String actualPrice = driver.findElement(By.cssSelector("[id='fancybox-content'] form span")).getText();
        actualPrice = actualPrice.substring(actualPrice.indexOf("$") + 1).trim();
//      System.out.println("Expected Price " + expectedPrice + "\nActual price " + actualPrice);
//      System.out.println("Expected Name " + expectedName + "\nActual name " + actualName);
        Assert.assertEquals(expectedPrice, actualPrice, "Price don't match");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addToCart_5_2")));
    }


    @Test(dependsOnMethods = "testAddToCartSecondItem")
    public void CartPage() {
        try {

            driver.findElement(By.id("addToCart_5_2")).click();
            Assert.assertEquals(driver.getCurrentUrl(), homePage, "Incorrect URL after click on 'Add to Cart' button");

        } catch (Exception e) {
            System.out.println("ErrorButton add To Cart");
        }

        String actualNameInCart = driver.findElement(By.cssSelector("#viewCartTable > tbody > tr:nth-child(1) > td:nth-child(1)")).getText();
        String actualPriceInCart = driver.findElement(By.cssSelector("#viewCartTable > tbody > tr:nth-child(1) > td:nth-child(3)")).getText();
        actualNameInCart = actualNameInCart.substring(actualNameInCart.indexOf(""));
        actualPriceInCart = actualPriceInCart.substring(actualPriceInCart.indexOf("$") + 1);
//        System.out.println("Expected Price in Cart " + actualPriceInCart + "\nActual price " + expectedPrice);
//        System.out.println("Expected Name in Cart " + actualNameInCart + "\nActual Name " + expectedName);
        Assert.assertEquals(expectedName, actualNameInCart, "Incorrect name in Cart ");
        Assert.assertEquals(expectedPrice, actualPriceInCart, "Incorrect Price in Cart");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("continueShopping")));
    }

    @Test(dependsOnMethods = "CartPage")
    public void testContinueShopping() {


        driver.findElement(By.id("continueShopping")).click();
        Assert.assertEquals(driver.getCurrentUrl(), homePage, "Redirect to incorrect page.");
        Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}


