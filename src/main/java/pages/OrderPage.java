package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    WebDriver driver;
    WebDriverWait wait;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By commentBox = By.name("message");
    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");

    By nameOnCard = By.name("name_on_card");
    By cardNumber = By.name("card_number");
    By cvc = By.name("cvc");
    By expiryMonth = By.name("expiry_month");
    By expiryYear = By.name("expiry_year");

    By payBtn = By.id("submit");

    public void placeOrder() {

        // If login page appears
        if (driver.getCurrentUrl().contains("login")) {
            System.out.println("User redirected to Login Page. Login required.");
            return;
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(commentBox));

        driver.findElement(commentBox)
              .sendKeys("Automation Testing Order");

        driver.findElement(placeOrderBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCard));

        driver.findElement(nameOnCard)
              .sendKeys("Test User");

        driver.findElement(cardNumber)
              .sendKeys("4111111111111111");

        driver.findElement(cvc)
              .sendKeys("123");

        driver.findElement(expiryMonth)
              .sendKeys("12");

        driver.findElement(expiryYear)
              .sendKeys("2030");

        driver.findElement(payBtn).click();

        System.out.println("Payment Submitted");
    }
}
