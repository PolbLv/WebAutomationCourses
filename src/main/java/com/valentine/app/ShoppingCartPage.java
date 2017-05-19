package com.valentine.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class ShoppingCartPage {

	@FindBy(id = "continueShopping")
	private WebElement continueShoppingButton;

	@FindBy(id = "Cart66WidgetCartEmptyAdvanced")
	private WebElement summaryElement;

	private WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		new WebDriverWait(driver, 10).until(urlContains("cart"));
		PageFactory.initElements(driver, this);
	}

	public HomePage clickContinueShoppingButton() {
		continueShoppingButton.click();
		return new HomePage(driver);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getSummary() {
		return summaryElement.getText();
	}

}
// private WebElement continueShoppingButton() {
// return driver.findElement(By.id("continueShopping"));
// }

// private WebElement summaryElement() {
// return driver.findElement(By.id("Cart66WidgetCartEmptyAdvanced"));
// }
