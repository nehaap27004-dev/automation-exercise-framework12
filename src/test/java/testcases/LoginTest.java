package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
    public void validLoginTest (){

        HomePage home = new HomePage(driver);

        home.clickSignupLogin();
        
       
        LoginPage login = new LoginPage(driver);

        login.login("snigdha.d4405@gmailcom",
                    "sni1124");
        System.out.println("Login Successful");
    }
}


