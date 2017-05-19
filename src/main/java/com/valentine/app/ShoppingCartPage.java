package com.valentine.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

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
	@Step
	public HomePage clickContinueShoppingButton() {
		continueShoppingButton.click();
		return new HomePage(driver);
	}
	@Step("Read current URL")
	@Attachment("URL")	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	@Step("Read Summary")
	@Attachment("Summary")
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
