package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Find login link and click on login link
        clickOnElement(By.linkText("Log in"));
        // Verify the text ‘Welcome, Please Sign In!’
        verifyText("Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Not navigate to login page");
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find and Click on 'Login' link
        clickOnElement(By.linkText("Log in"));
        // Find the username text field and enter valid username
        sendTextToElement(By.id("Email"),"stellabrown@gmail.com");
        // Find the password field and enter valid password
        sendTextToElement(By.id("Password"),"password123");
        // Find and Click on Login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        //Verify the 'Log out' text is display
        verifyText("Log out",By.xpath("//a[contains(text(),'Log out')]"),"'Log out' Text is not Displayed");

    }

    @Test
    public void verifyTheErrorMessage() {
        // Find and Click on 'Login' link
        clickOnElement(By.linkText("Log in"));
        // Find the username text field and enter invalid username
        sendTextToElement(By.id("Email"),"abc@gmail.com");
        // Find the password field and enter invalid password
        sendTextToElement(By.id("Password"),"Abcd1234");
        // Find and Click on Login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        //Verify the error message ‘Login was unsuccessful. Please correct the errors and try again. No customer account found’
        verifyText("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found",By.xpath("//div[@class='message-error validation-summary-errors']"),"Error message can't be found");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}




