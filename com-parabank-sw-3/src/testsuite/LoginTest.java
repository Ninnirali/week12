package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import static java.lang.Thread.*;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // find usernameField and enter valid username
        sendTextToElement(By.xpath("//input[@name = 'username']"),"A1234");
        // find passwordField and enter valid password
        sendTextToElement(By.xpath("//input[@name = 'password']"),"password@1");
        // find and click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@type='submit']"));
        // Verify the ‘Accounts Overview’ text is displayed
        verifyText("Accounts Overview",By.xpath("//h1[@class='title']"),"Expected Text is not displayed");

    }
    @Test
    public void verifyTheErrorMessage(){
        // find usernameField and enter invalid username
        sendTextToElement(By.xpath("//input[@name = 'username']"),"AAAA");
        // find passwordField and enter invalid password
        sendTextToElement(By.xpath("//input[@name = 'password']"),"p@1");
        // find and click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@class='button'][1]"));
        // Verify the error message ‘The username and password could not be verified.'
        verifyText("The username and password could not be verified.",By.xpath("//p[@class='error']"),"error Occurred");


    }
    @Test
    public void userShouldLogOutSuccessfully1() throws InterruptedException {
//find username filed and sen values
        sendTextToElement(By.xpath("//input[@name=\"username\"]"),"Kapil123");

        //to find the password field element
        sendTextToElement(By.xpath("//input[@name=\"password\"]"),"Find@123");


        //find login element and click
        clickOnElement(By.xpath("//input[@value=\"Log In\"]"));
        Thread.sleep(6000);

        //find logout element and click
        clickOnElement(By.xpath("//a[@href=\"/parabank/logout.htm\"]"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login");
    }
    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {
        // find usernameField and enter valid username
        sendTextToElement(By.xpath("//input[@name = 'username']"),"A1234");
        // find passwordField and enter valid password
        sendTextToElement(By.xpath("//input[@name = 'password']"),"password@1");
        // find and click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value=\"Log In\"]"));
        Thread.sleep(6000);
        driver.switchTo().alert().dismiss();
        // find and click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        // Verify the text ‘Customer Login’
        verifyText("Customer Login",By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login' text can't be found");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
