package com.valentine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class SecondTCVerifyIfButtonAddCartAddAllItems {

    String homePage  = "http://awful-valentine.com/";

    private WebDriver driver;

    @Test
    public void testAddToCartSecondItem (){
        System.setProperty("webdriver.chrome.driver", "//home//likewise-open//LVIVSOFT//spolyakov//chromedriver");
        driver = new ChromeDriver();
        driver.get(homePage);

        String expectedPrice = driver.findElement(By.cssSelector(".special-item [href*='old-together'] img+span")).getText();
        String expectedName = driver.findElement(By.cssSelector("#special-items > div:nth-child(2) > h4 > a")).getText();
        expectedName.substring(expectedName.indexOf(""));
        expectedPrice = expectedPrice.substring(expectedPrice.indexOf("$") + 1).trim();

        waitFor(1000);
        driver.findElement(By.cssSelector("[href='#et-offer-post-27']")).click();
        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));

        String actualName = driver.findElement(By.cssSelector("#et-offer-post-27 > div > h2")).getText();
        actualName.substring(actualName.indexOf(""));
        Assert.assertEquals(expectedName, actualName, "Name don't match");

        String actualPrice = driver.findElement(By.cssSelector("[id='fancybox-content'] form span")).getText();
        actualPrice = actualPrice.substring(actualPrice.indexOf("$") + 1).trim();
        //System.out.println("Expected Price " + expectedPrice + "\nActual price " + actualPrice);
        Assert.assertEquals(expectedPrice, actualPrice, "Price don't match");

    }
    @Test(dependsOnMethods = "testAddToCartSecondItem")
    public void afterPopupOpensCartPage() {
        waitFor(3000);


    }

    @Test(dependsOnMethods = "afterPopupOpensCartPage")
    public void testContinueShopping() {

        waitFor(1000);
        driver.findElement(By.cssSelector(".Cart66CartContinueShopping")).click();
        Assert.assertEquals(driver.getCurrentUrl(), homePage, "Redirect to incorrect page.");
    }

    @Test(dependsOnMethods = "afterPopupOpensCartPage")
    public void CartPage() {
        waitFor(3000);
        driver.findElement(By.id("addToCart_5_2")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://awful-valentine.com/store/cart/",
                "Incorrect URL after click on 'Add to Cart' button");
    }

    @AfterClass (dependsOnMethods = "CartPage")
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

