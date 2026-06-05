package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignupPage;

public class SignupTest extends BaseTest {
	
	@Test
    public void registerUserTest() {

        HomePage home = new HomePage(driver);

        home.clickSignupLogin();

        SignupPage signup = new SignupPage(driver);

        signup.enterSignupDetails(
                "Devarinti Snigdha",
                "testuser" + System.currentTimeMillis() + "snigdha.d4405@gmail.com");

        signup.clickSignup();
        
        System.out.println("Signup Successful");
    }
}


