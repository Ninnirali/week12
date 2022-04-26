package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // find and click on the 'Sign In' link
        clickOnElement(By.linkText("Sign In"));
        // Verify the text ‘Welcome Back!’
        verifyText("Welcome Back!",By.xpath("//h1[@class='page__heading']"),"'WelcomeBack!' text is not displayed");
    }

    @Test
    public void verifyTheErrorMessage(){
        // find and click on the 'Sign In' link
        clickOnElement(By.linkText("Sign In"));
        // find emailField and enter invalid username
        sendTextToElement(By.id("user[email]"),"prime123@gmail.com");
        // find passwordField and enter invalid password
        sendTextToElement(By.id("user[password]"),"Password123");
        // find and click on Login button
        clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        // Verify the error message ‘Invalid email or password.’
        verifyText("Invalid email or password.",By.xpath("//li[@class='form-error__list-item']"),"'Invalid email or password.' text is not displayed");

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
