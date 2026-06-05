package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactusPage;

public class ContactUsTest extends BaseTest {


@Test
public void contactUsTest() {

	System.out.println("Driver Object: " + driver); // Debug line

    ContactusPage contact = new ContactusPage(driver);

    contact.submitContactForm();

    Assert.assertTrue(
            driver.getPageSource()
                  .contains("Success! Your details have been submitted successfully."),
            "Contact Us form submission failed!"
    );

    System.out.println("Contact Us Successful");
}
}

