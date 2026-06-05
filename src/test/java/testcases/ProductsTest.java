package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void searchProductTest() {

        ProductsPage product = new ProductsPage(driver);

        product.openProducts();

        product.searchProduct("Top");

        Assert.assertTrue(
                driver.getPageSource().contains("Top"),
                "Product search failed!"
        );

        System.out.println("Product Search Successful");
    }
}


