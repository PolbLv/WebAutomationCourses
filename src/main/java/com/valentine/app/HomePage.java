package com.valentine.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HomePage {

	@FindBy(css =".main-product")
	private List<WebElement> recentProducts;
	
	@FindBy(css =".special-item")
	private List<WebElement> specialOffers;
	
	@FindBy(id ="fancybox-wrap")
	private WebElement addToCartPopup;
	
	private WebDriver driver;
	
	Faker faker = new Faker();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlToBe("http://awful-valentine.com/"));
		PageFactory.initElements(driver, this);
	}
	public ShoppingCartPage addToCartSpecialOffer(int position) {
		clickAddToCartOnSpecialOffer(position);
		clickAddToCartButtonOnPopup();
		return new ShoppingCartPage(driver);
	}

	public ShoppingCartPage addToCartRecentProduct(int position) {
		clickCartOnRecentProduct(position);
		return clickAddToCartButtonOnPopup();
	}

	/**
	 * Clicks on 'Add to Cart' button on a special offer found by {@code index}
	 *
	 * @param position
	 *            1-based position in the list
	 */
	public HomePage clickAddToCartOnSpecialOffer(int position) {
		WebElement specialOffer = specialOffers.get(position - 1);
		specialOffer.findElement(By.cssSelector(".add-to-cart")).click();
		return this;
	}

	public HomePage clickMoreInfoOnSpecialOffer(int pos) {
		WebElement specialOfferInfo = specialOffers.get(pos - 1);
		specialOfferInfo.findElement(By.cssSelector(".more-info")).click();
		return this;
	}

//	private List<WebElement> specialOffers() {
//		return driver.findElements(By.cssSelector(".special-item"));
//	}

	public HomePage clickCartOnRecentProduct(int position) {
		WebElement recentProduct = recentProducts.get(position - 1);
		recentProduct.findElement(By.cssSelector(".add-to-cart")).click();
		return this;
	}

//	private List<WebElement> recentProducts() {
//		return driver.findElements(By.cssSelector(".main-product"));
//	}

	public boolean isAddToCartPopupShown() {
		return addToCartPopup.isDisplayed();
	}

	public String getPopupProductTitle() {
		return addToCartPopup.findElement(By.cssSelector(".et_popup_title")).getText();
	}

	public ShoppingCartPage clickAddToCartButtonOnPopup() {
		WebDriverWait driverWait = new WebDriverWait(driver, 10);
		driverWait.until(visibilityOfElementLocated(By.cssSelector("#fancybox-wrap [value='Add to Cart']")));

		addToCartPopup.findElement(By.cssSelector("[value='Add to Cart']")).click();
		return new ShoppingCartPage(driver);
	}

//	private WebElement addToCartPopup() {
//		return driver.findElement(By.id("fancybox-wrap"));
//	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void fillNameField(String text){
		driver.findElement(By.id("author")).sendKeys(text);
		  
	}
	public void fillEmailField(String text) {
		driver.findElement(By.id("email")).sendKeys(text);
		
	}
	public void fillWebSiteField(String text) {
		driver.findElement(By.id("url")).sendKeys(text);
		
	}
//	public void fakerName(String text){
//		String firstName = faker.name().firstName(); // Emory
//	}		
	public void clickToRatingStars() {
		driver.findElement((By.xpath("//*[@id='et-rating']/div/span/div[4]"))).click();
		
	}
	public void clickSubmitButton() {
		driver.findElement(By.id("submit")).click();
		
	}
}
