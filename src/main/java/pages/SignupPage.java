package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
	
	 WebDriver driver;

	    public SignupPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By name = By.xpath("//input[@data-qa='signup-name']");

	    By email = By.xpath("//input[@data-qa='signup-email']");

	    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

	    public void enterSignupDetails(String uname, String uemail) {

	        driver.findElement(name).sendKeys(uname);
	        driver.findElement(email).sendKeys(uemail);
	    }

	    public void clickSignup() {

	        driver.findElement(signupBtn).click();
	    }
	}


