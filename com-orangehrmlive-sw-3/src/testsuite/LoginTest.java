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

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Find username field and enter “Admin” username
        sendTextToElement(By.id("txtUsername"),"Admin");
        // Find password field and enter “admin123" password
        sendTextToElement(By.id("txtPassword"),"admin123");
        // Find and click on ‘LOGIN’ button
        clickOnElement(By.id("btnLogin"));
        //Verify the 'Welcome' text is display
        verifyText("Welcome",By.xpath("//a[@id='welcome']"),"Not navigated to successful login page with 'Welcome' text");

        
//        String expectedText = "Welcome";
//        // Get text from successful login page
//        WebElement actualTextElement = driver.findElement(By.xpath("//a[@id='welcome']"));
//         String actualTextFUll = actualTextElement.getText();
//         String actualText = actualTextFUll.substring(0,7); // get first 7 letters ('welcome' only)
//        System.out.println(actualText);
//         // Verify expected and actual text
//        Assert.assertEquals("Not navigated to successful login page with 'Welcome' text", expectedText,actualText );
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
