package com.valentine.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ThirdTCAddToCartAllItems {
    String homePage = "http://awful-valentine.com/";
    String cartPage = "http://awful-valentine.com/store/cart/";
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setup() {
    System.setProperty("webdriver.chrome.driver", "//home//likewise-open//LVIVSOFT//spolyakov//chromedriver");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get(homePage);
    }

    @Test
    public void testAddFirstItemToTheCart() {

        driver.findElement(By.cssSelector("[href='#et-offer-post-30']")).click();
        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));
        Assert.assertTrue(addToCartPopup.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(By.id("addToCart_6_2")));
    }

    @Test (dependsOnMethods = "testAddFirstItemToTheCart")
    public void testAddToCartInPopUpFirstItem(){
        waitFor(2000);
        driver.findElement(By.id("addToCart_6_2")).click();
        Assert.assertEquals(driver.getCurrentUrl(), cartPage, "Incorrect URL after click on " +
                "'Add to Cart First Item button");
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("continueShopping")));

    }
    @Test(dependsOnMethods = "testAddToCartInPopUpFirstItem")
    public void cartPageClickContinueShoppingFirstItem(){
        waitFor(2000);
        driver.findElement(By.id("continueShopping")).click();
        Assert.assertEquals(driver.getCurrentUrl(), homePage, "Redirect to incorrect page.");
       // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#et-offer-post-27']")));
    }
    @Test(dependsOnMethods = "cartPageClickContinueShoppingFirstItem")
    public void addToCartSecondItem(){
        waitFor(2000);
        driver.findElement(By.cssSelector("[href='#et-offer-post-27']")).click();
        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));
        Assert.assertTrue(addToCartPopup.isDisplayed());

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("addToCart_5_2")));
    }
    @Test(dependsOnMethods = "addToCartSecondItem")
    public void testAddToCartInPopUpSecondItem(){
        waitFor(2000);
        driver.findElement(By.id("addToCart_5_2")).click();
        Assert.assertEquals(driver.getCurrentUrl(), cartPage, "Incorrect URL after click on " +
                "'Add to Cart Second Item' button");
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("continueShopping")));
    }
    @Test(dependsOnMethods = "testAddToCartInPopUpSecondItem")
    public void cartPageClickContinueShoppingWithTwoItems(){
        waitFor(2000);
        driver.findElement(By.id("continueShopping")).click();
        Assert.assertEquals(driver.getCurrentUrl(), homePage, "Redirect to incorrect page.");
    }
    @Test(dependsOnMethods = "cartPageClickContinueShoppingWithTwoItems")
    public void addToCartThirdItem(){
        waitFor(2000);
        driver.findElement(By.cssSelector("[href='#et-offer-post-24']")).click();
        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));
        Assert.assertTrue(addToCartPopup.isDisplayed());
    }
    @Test(dependsOnMethods = "addToCartThirdItem")
    public void testAddToCartInPopUpThirdItem(){
        waitFor(2000);
        driver.findElement(By.id("addToCart_4_2")).click();
        Assert.assertEquals(driver.getCurrentUrl(), cartPage, "Incorrect URL after click on " +
                "'Add to Cart Third Item' button");
    }
    @Test(dependsOnMethods = "testAddToCartInPopUpThirdItem")
    public void cartPageClickContinueShoppingWithThreeItems(){
        waitFor(2000);
        driver.findElement(By.id("continueShopping")).click();
        Assert.assertEquals(driver.getCurrentUrl(), homePage, "Redirect to incorrect page.");
    }
    @Test (dependsOnMethods = "cartPageClickContinueShoppingWithThreeItems")
    public void addCartFourthItem(){
        waitFor(2000);
        driver.findElement(By.cssSelector("[href='#et-offer-post-21']")).click();
        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));
        Assert.assertTrue(addToCartPopup.isDisplayed());
    }
    @Test(dependsOnMethods = "addCartFourthItem")
    public void testAddToCartInPopUpFourthItem(){
        waitFor(2000);
        driver.findElement(By.id("addToCart_3")).click();
        Assert.assertEquals(driver.getCurrentUrl(), cartPage, "Incorrect URL after click on " +
                "'Add to Cart Fourth Item' button");
    }
    @Test(dependsOnMethods = "testAddToCartInPopUpFourthItem")
    public void cartPageClickContinueShoppingWithFourItems(){
        waitFor(2000);
        driver.findElement(By.id("continueShopping")).click();
        Assert.assertEquals(driver.getCurrentUrl(), homePage, "Redirect to incorrect page.");
    }
    @Test(dependsOnMethods = "cartPageClickContinueShoppingWithFourItems")
    public void addToCartFifthItem(){
        waitFor(2000);
        driver.findElement(By.cssSelector("[href='#et-offer-post-18']")).click();
        WebElement addToCartPopup = driver.findElement(By.id("fancybox-wrap"));
        Assert.assertTrue(addToCartPopup.isDisplayed());
    }
    @Test(dependsOnMethods = "addToCartFifthItem")
    public void testAddToCartInPopupFifthItem(){
        waitFor(2000);
        driver.findElement(By.id("addToCart_1")).click();
        Assert.assertEquals(driver.getCurrentUrl(), cartPage, "Incorrect URL after click on " +
                "'Add to Cart Fifth Item' button");
    }
    @Test(dependsOnMethods = "testAddToCartInPopupFifthItem")
    public void cartPageClickContinueShoppingWithFiveItems(){
        waitFor(2000);
        /*Bug Last Item added to the cart with Quantity 100*/
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

