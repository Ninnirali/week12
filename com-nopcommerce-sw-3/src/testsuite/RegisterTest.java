package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;


public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        // find and click on the 'Register' link
        clickOnElement(By.xpath("//a[@href='/register?returnUrl=%2F']"));
        // Verify the text ‘Register’
        verifyText("Register",By.xpath("//a[@href='/register?returnUrl=%2F']"),"No navigate to 'Register' link ");
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // find and click on the ‘Register’ link
        clickOnElement(By.xpath("//a[@href='/register?returnUrl=%2F']"));
        // find and Select gender radio button and select / click on it
        clickOnElement(By.id("gender-female"));
        // find First name filed and Enter First name
        sendTextToElement(By.id("FirstName"),"A");
        // find Last name filed and Enter First name
        sendTextToElement(By.id("LastName"),"X");
        // find and select Day Month and Year
        selectByVisibleTextFromDropDown(By.name("DateOfBirthDay"),"1");
        selectByVisibleTextFromDropDown(By.name("DateOfBirthMonth"),"January");
        selectByVisibleTextFromDropDown(By.name("DateOfBirthYear"),"2000");
        // find email field and enter email address
        sendTextToElement(By.id("Email"),"xyz78999@gmail.com");
        //deselect the Newsletter option by clicking on it
        clickOnElement(By.id("Newsletter"));
        // find passwordField and enter Password
        sendTextToElement(By.id("Password"),"Abcd123");
        // find confirmPasswordField and enter password
        sendTextToElement(By.id("ConfirmPassword"),"Abcd123");
         // find Register button and click on it
        clickOnElement(By.id("register-button"));
        // Verify the text 'Your registration completed’
        verifyText("Your registration completed",By.xpath("//div[contains(text(),'Your registration completed')]"),"Can't navigate to registration confirmation page");

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
