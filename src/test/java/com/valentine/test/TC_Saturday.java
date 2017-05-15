package com.valentine.test;

import com.valentine.app.AwfulValentine;
import com.valentine.app.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TC_Saturday {
    private WebDriver driver;
    private HomePage onHomePage;


    @Test
    public void testAddTheCartButtonOpensPopup(){
        onHomePage = AwfulValentine.openHomePage();
        onHomePage.clickAddToCartOnSpecialOffer(1);

        assertTrue(onHomePage.isAddToCartPopupShown(), "'Add to cart' Popup did  not appear." );

        String productTitle = onHomePage.getPopupProductTitle();
        assertEquals(productTitle, "Closeness and Togetherness", "Incorrect product tittle on 'Add to Cart' popup");

    }

}

