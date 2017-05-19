package com.valentine.test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import com.valentine.app.ShoppingCartPage;
import com.valentine.data.ProductDataModel;

import ru.yandex.qatools.allure.annotations.Step;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

public class TCAddItemToCartTest {
	private HomePage onHomePage;
	private ShoppingCartPage onShoppingCartPage;
	private ProductDataModel testItem;

	@Test
	public void testAddTheCartButtonOpensPopup() {
		onHomePage = AwfulValentine.openHomePage();
		int randomIndex = new Random().nextInt(5) + 1;
		testItem = onHomePage.getSpecialOffer(randomIndex);

		onHomePage.clickAddToCartOnSpecialOffer(randomIndex);

		// onHomePage.clickAddToCartOnSpecialOffer(testItem);

		assertTrue(onHomePage.isAddToCartPopupShown(), "'Add to cart' Popup did  not appear.");

		// String productTitle = onHomePage.getPopupProductTitle();
		// double productPrice = onHomePage.getPopupProductPrice();
		// assertEquals(productTitle, testItem.getTitle(), "Incorrect product
		// tittle on 'Add to Cart' popup");
		// assertEquals(productPrice, testItem.getUnitPrice(), "Incorrect
		// product price on 'Add to Cart' popup");

		assertEquals(onHomePage.getProductInfoFromPopup(), testItem, "incorrect data on popup");
		// productsShouldBeEqual(onHomePage.getProductInfoFromPopup(),
		// testItem);
	}

	@Test(dependsOnMethods = "testAddTheCartButtonOpensPopup")
	public void testAddToCartButtonOnPopupRedirectsToCartPage() {
		onShoppingCartPage = onHomePage.clickAddToCartButtonOnPopup();
		assertEquals(onShoppingCartPage.getCurrentUrl(), "http://awful-valentine.com/store/cart/",
				"Incorrect URL after click on 'Add to Cart' button");
	}

	@Step("Product details on Popup should be equal to product details on selected item")
	private void productsShouldBeEqual(ProductDataModel actual, ProductDataModel expected) {
		String message = "";

		if (!actual.getTitle().equals(expected.getTitle())) {
			message = message.concat("Expected product title: " + expected.getTitle());
			message = message.concat("\nActual product title; " + actual.getTitle());
		}
		if (actual.getUnitPrice() != expected.getUnitPrice()) {
			message = message.concat("\nExpected product title: " + expected.getUnitPrice());
			message = message.concat("\nActual product title; " + actual.getUnitPrice());
		}
		if (message.equals("")) {
			throw new AssertionError(message);
		}
	}

	@AfterClass
	public void tearDown() {
		AwfulValentine.close();
	}
}
