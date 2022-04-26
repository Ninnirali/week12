package electronics;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() throws InterruptedException {
//        1.1 Mouse Hover on “Electronics” Tab
        Thread.sleep(1000);
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
//        1.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
//        1.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
//        2.1 Mouse Hover on “Electronics”Tab
        Thread.sleep(1000);
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
//        2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(2000);
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
//        2.3 Verify the text “Cell phones”
        assertVerifyText(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones");
//        2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[@data-viewmode='list']"));
//        2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='details']//a[contains(text(),'Nokia Lumia 1020')]"));
//        2.6 Verify the text “Nokia Lumia 1020”
        assertVerifyText(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"Nokia Lumia 1020");
//        2.7 Verify the price “$349.00”
        assertVerifyText(By.id("price-value-20"),"$349.00");
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
//        2.8 Change quantity to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
//        2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
//        2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertVerifyText(By.xpath("//p[@class='content']"),"The product has been added to your shopping cart");
//        After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
//        2.12 Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
//        2.13 Verify the quantity is 2
        ////assertVerifyText(By.id("itemquantity11217"),"2");
        //identify element
        WebElement xyz = driver.findElement(By.xpath("//input[@class=\"qty-input\"]"));
        // get value attribute with getAttribute()
        String qty = xyz.getAttribute("value");
        //verify the quantity
        Assert.assertEquals("Error> Quanti mismatch:", "2", qty);

//        2.14 Verify the Total $698.00
        assertVerifyText(By.xpath("//span[@class='product-subtotal']"),"$698.00");
//        2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
//        2.16 Click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
//        2.17 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
//        2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
//        2.19 Verify the text “Register”
        assertVerifyText(By.xpath("//h1[contains(text(),'Register')]"),"Register");
//        2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"),"Anie");
        sendTextToElement(By.id("LastName"),"Mosse");
        sendTextToElement(By.id("Email"),"annmoss113@gmail.com");
        clickOnElement(By.id("Newsletter"));
        sendTextToElement(By.id("Password"),"AnnMoss1234");
        sendTextToElement(By.id("ConfirmPassword"),"AnnMoss1234");
//        2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
//        2.22 Verify the message “Your registration completed”
        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");
//        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
//        2.24 Verify the text “Shopping cart”
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart");
//        2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
//        2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
//        2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"123 street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"HA3 9AB");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"07123456789");
//        2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text() = 'Continue']"));
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
//        2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

//        2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        // click on continue
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));
//        2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Visa");
//        2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Anne Moss");
        sendTextToElement(By.id("CardNumber"), "4462 0000 0000 0003");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"02");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2024");
        sendTextToElement(By.id("CardCode"),"123");
//        2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
//        2.35 Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card");
//        2.36 Verify “Shipping Method” is “2nd Day Air”
        assertVerifyText(By.xpath("//span[contains(text(),'(2nd Day Air)')]"),"(2nd Day Air)");
//        2.37 Verify Total is “$698.00”
        Thread.sleep(2000);
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"),"$698.00");
//        2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
//        2.39 Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
//        2.40 Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
//        2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
//        2.42 Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
//        2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
//        2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/",url);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
