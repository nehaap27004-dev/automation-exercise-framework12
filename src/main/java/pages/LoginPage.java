package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	 WebDriver driver;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By email = By.xpath("//input[@data-qa='login-email']");

	    By password = By.xpath("//input[@data-qa='login-password']");

	    By loginButton =
	            By.xpath("//button[@data-qa='login-button']");

	    public void login(String user, String pass) {

	        driver.findElement(email).sendKeys(user);

	        driver.findElement(password).sendKeys(pass);

	        driver.findElement(loginButton).click();
	    }
	}


