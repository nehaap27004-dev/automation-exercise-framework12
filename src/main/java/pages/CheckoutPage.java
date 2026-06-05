package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By productsMenu = By.xpath("//a[@href='/products']");
    By addToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    public void addProductAndCheckout() {

        // Open Products Page
        driver.findElement(productsMenu).click();

        // Wait for Add To Cart button
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));

        WebElement product = driver.findElement(addToCart);

        // Click Add To Cart using JavaScript
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", product);

        System.out.println("Product Added To Cart");

        // Wait for Cart Popup
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("cartModal")));

        // View Cart Button
        WebElement viewCart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//u[text()='View Cart']")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", viewCart);

        System.out.println("View Cart Clicked");

        // Verify Product Added
        int products = driver.findElements(
                By.xpath("//tr[contains(@id,'product')]"))
                .size();

        System.out.println("Products in Cart = " + products);

        if (products == 0) {
            throw new RuntimeException("Cart is empty!");
        }

        // Proceed To Checkout
        By proceedToCheckout =
                By.xpath("//a[contains(@class,'check_out')]");

        WebElement checkoutBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        proceedToCheckout));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkoutBtn);

        System.out.println("Proceed To Checkout Clicked");

        System.out.println("Current URL: "
                + driver.getCurrentUrl());
    }
}