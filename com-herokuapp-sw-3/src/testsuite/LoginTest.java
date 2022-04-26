package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {


    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find username field and enter "tomsmith" username
        sendTextToElement(By.id("username"),"tomsmith");
        // Find password field and enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        // Find and Click on 'LOGIN' button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        // Verify the text “Secure Area”
        verifyPage("Secure Area",By.tagName("h2"),"No navigation to next page with display text 'Secure Area'");
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        // find username field and Enter “tomsmith1” username
        sendTextToElement(By.id("username"),"tomsmith1");
        // Find password field and enter “SuperSecretPassword!” password
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        // Find and Click on 'LOGIN' button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        // Verify the error message “Your username is invalid!”
        verifyPage("Your username is invalid!",By.xpath("//div[@id='flash']"),"can't read the text 'Your username is invalid!'");

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // find username field and Enter “tomsmith” username
        sendTextToElement(By.id("username"),"tomsmith");
        // Find password field and enter “SuperSecretPassword” password
        sendTextToElement(By.id("password"),"SuperSecretPassword");
        // Find and Click on 'LOGIN' button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        // Verify the error message “Your password is invalid!”
        verifyPage("Your password is invalid!",By.xpath("//div[@id='flash']"),"can't read the text 'Your password is invalid!'");

    }

    @After
    public void tearDown() {
        closeBrowser();


    }
}