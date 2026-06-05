package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        CartPage cart = new CartPage(driver);

        cart.addProductToCart();

        cart.clickViewCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"));

        System.out.println("Add To Cart Successful");
    }
}