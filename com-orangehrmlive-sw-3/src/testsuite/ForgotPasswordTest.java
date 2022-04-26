package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        // click on the ‘Forgot your password’ link
        clickOnElement(By.xpath("//a[@href='/index.php/auth/requestPasswordResetCode']"));
        //  Verify the text ‘Forgot Your Password?’
        verifyText("Forgot Your Password?",By.xpath("//h1[contains(text(),'Forgot Your Password?')]"),"Not navigate to password reset page with text 'Forgot Your Password?'");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
