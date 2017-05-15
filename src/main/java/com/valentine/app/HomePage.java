package com.valentine.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 *Clicks on 'Add to Cart' button on a special offer found by {@code index}
 	 * @param index 1 -  based position in the list
	*/
	public void clickAddToCartOnSpecialOffer(int index){
		WebElement specialOffer = specialOffers().get(index -1);
		specialOffer.findElement(By.cssSelector(".add-to-cart")).click();

	}
	private List<WebElement> specialOffers(){
		return driver.findElements(By.cssSelector(".special-item"));
	}

	public boolean isAddToCartPopupShown() {
		return addToCartPopup().isDisplayed();
	}
	public String getPopupProductTitle() {
			return addToCartPopup().findElement(By.cssSelector(".et_popup_title")).getText();
		}

	private WebElement addToCartPopup(){
		return driver.findElement(By.id("fancybox-wrap"));
	}


}
