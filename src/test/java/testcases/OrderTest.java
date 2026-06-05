package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.OrderPage;

public class OrderTest extends BaseTest {

    @Test
    public void orderTest() {

        System.out.println("Order Test Started");

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.addProductAndCheckout();

        OrderPage order = new OrderPage(driver);
        order.placeOrder();

        String pageSource = driver.getPageSource();

        Assert.assertTrue(
                pageSource.contains("Order Placed")
                || pageSource.contains("Congratulations")
                || pageSource.contains("order has been confirmed"),
                "Order was not placed successfully!"
        );

        System.out.println("Order Placed Successfully");
    }
}