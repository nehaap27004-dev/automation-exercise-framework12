package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        System.out.println("Checkout Test Started");

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.addProductAndCheckout();

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);

        Assert.assertTrue(
        	    currentUrl.contains("view_cart")
        	    || currentUrl.contains("checkout")
        	    || currentUrl.contains("login"),
        	    "Checkout flow failed!"
        	);

        System.out.println("Checkout Successful - Test Passed");
    }
}