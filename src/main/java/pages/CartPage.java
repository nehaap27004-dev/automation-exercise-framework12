package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By productsMenu = By.xpath("//a[@href='/products']");
    By addToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    public void addProductToCart() {

        driver.findElement(productsMenu).click();

        WebElement cartBtn = driver.findElement(addToCart);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", cartBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", cartBtn);
    }

    public void clickViewCart() {

        driver.get("https://automationexercise.com/view_cart");
    }
}