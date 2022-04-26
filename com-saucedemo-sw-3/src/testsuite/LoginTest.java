package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // find username field and enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        // find passwordField and enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        // find and click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        // Verify the text “PRODUCTS”
        verifyText("PRODUCTS",By.xpath("//span[@class='title']"),"Can't see text : 'PRODUCTS'");

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        // find username field and enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        // find passwordField and enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        // find and click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        // Verify that six products are displayed on page

        // it is from requirements
        int sizeOfExpectedItemList = 6;
        // count no. of 'Products' displayed on webpage using item label
        List<WebElement> itemList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        int sizeOfActualItemList = itemList.size();
        System.out.println("sizeOfActualItemList is " + sizeOfActualItemList);
        // Verify expected and actual size of item / product list
        Assert.assertEquals("6 no. products are not displayed on the webpage", sizeOfExpectedItemList,sizeOfActualItemList);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
