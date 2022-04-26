package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay(){
        // Find and click on the ‘Register’ link
        clickOnElement(By.xpath("//a[text()='Register']"));
        // Verify the text ‘Signing up is easy!’
        verifyText("Signing up is easy!",By.xpath("//h1[text()='Signing up is easy!']"),"Error occurred" );

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
       // find and click on the ‘Register’ link
        clickOnElement(By.xpath("//a[text()='Register']"));
       // find firstname field and enter First name
        sendTextToElement(By.id("customer.firstName"),"Alexa");
        // find last name field and enter last name
        sendTextToElement(By.id("customer.lastName"),"Smith");
        // find address field and enter address
        sendTextToElement(By.id("customer.address.street"),"13,London Road");
       // find city field and enter city
        sendTextToElement(By.name("customer.address.city"),"London");
        // find state field and enter state
        sendTextToElement(By.id("customer.address.state"),"Greater London");
      // find zip code field and enter zip code
        sendTextToElement(By.id("customer.address.zipCode"),"W13EC");
        // find phone field and enter phone
        sendTextToElement(By.id("customer.phoneNumber"),"07888996756");
       // find ssnField and enter SSN
        sendTextToElement(By.id("customer.ssn"),"QQ 123456 C");
       // find userNameField and enter userName
        sendTextToElement(By.id("customer.username"),"ABC1234");
       // find passwordField  and enter password
        sendTextToElement(By.id("customer.password"),"password@1");
        // find confirm field and enter password again to confirm
        sendTextToElement(By.id("repeatedPassword"),"password@1");
        // find and click on REGISTER button
        clickOnElement(By.xpath("(//input[@class='button'])[2]"));
       // Verify the text 'Your account was created successfully. You are now logged in.’
        verifyText("Your account was created successfully. You are now logged in.",By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"),"Expected Text can't be found");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
