package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By productsMenu = By.xpath("//a[contains(text(),'Products')]");
    By searchBox = By.id("search_product");
    By searchBtn = By.id("submit_search");

    public void openProducts() {

        driver.findElement(productsMenu).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    public void searchProduct(String productName) {

        driver.findElement(searchBox).sendKeys(productName);

        driver.findElement(searchBtn).click();
    }
}
