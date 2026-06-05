package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactusPage {
	
	WebDriver driver;

    public ContactusPage(WebDriver driver) {
        this.driver = driver;   // IMPORTANT
    }

    // locators and methods
    

    By contactUsMenu = By.xpath("//a[contains(text(),'Contact us')]");
    By name = By.name("name");
    By email = By.name("email");
    By subject = By.name("subject");
    By message = By.id("message");
    By submitBtn = By.name("submit");

    public void submitContactForm() {

        driver.findElement(contactUsMenu).click();

        driver.findElement(name).sendKeys("Test User");
        driver.findElement(email).sendKeys("testuser@gmail.com");
        driver.findElement(subject).sendKeys("Automation Testing");

        driver.findElement(message)
              .sendKeys("This is a test message from Selenium Automation.");

        driver.findElement(submitBtn).click();

        driver.switchTo().alert().accept();
        
    }

}
