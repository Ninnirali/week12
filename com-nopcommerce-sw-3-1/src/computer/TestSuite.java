package computer;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void testName(){
        // 1.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
         // 1.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        // 1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.id("products-orderby"));
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Price: Low to High");
        // 1.4 Verify the Product will arrange in Descending order.


    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Click on Computer Menu.
        Thread.sleep(1000);
        clickOnElement(By.linkText("Computers"));
        // 2.2 click on Desktop
        clickOnElement(By.linkText("Desktops"));
        // 2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.id("products-orderby"), "5");
        // 2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        // 2.5 Verify the Text "Build your own computer"
        Thread.sleep(2000);
        assertVerifyText(By.tagName("h1"), "Build your own computer");
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropDown(By.id("product_attribute_1"),"1");
        // 2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"),"8GB [+$60.00]");
        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        // 2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        // 2.11 Verify the price "$1,475.00"

//        assertVerifyText(By.xpath("//span[@id='price-value-1']"),"$1,475.00");
        // 2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button.
        assertVerifyText(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"),"The product has been added to your shopping cart");
        // assertVerifyText(By.xpath("//a[contains(text(),'shopping cart')]"),"The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@class='close']"));
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions = new Actions(driver);
        WebElement shopingcart = driver.findElement(By.xpath("//li[@id='topcartlink']/a/span[1]"));
        actions.moveToElement(shopingcart).build().perform();
        clickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        // 2.15 Verify the message "Shopping cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(2000);
        //updating the qty to 2
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//tbody/tr/td[5]/input")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        //updating the qty to 2
        sendTextToElement(By.xpath("//tbody/tr/td[5]/input"), "2");
        // update shopping cart
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        // 2.17 Verify the Total"$2,950.00"
        assertVerifyText(By.xpath("//tr/td[6]/span"),"$2,950.00");
        // 2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // 2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        // 2.21Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        // 2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"A");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"B");
        sendTextToElement(By.id("BillingNewAddress_Email"),"abc@gmail.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"),"London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"1, under umbrella lane");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"EC13ER");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"07812345678");
        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 new-address-next-step-button' and @name ='save']"));
        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // 2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        // click on continue button
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        // 2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");
        // 2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"),"A B Babs");
        sendTextToElement(By.id("CardNumber"),"5404 0000 0000 0068");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"11");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2024");
        sendTextToElement(By.id("CardCode"),"034");
        // 2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // 2.30 Verify “Payment Method” is “Credit Card”
        assertVerifyText(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card");
        // 2.32 Verify “Shipping Method” is “Next Day Air”
        assertVerifyText(By.xpath("//span[contains(text(),'(Next Day Air)')]"),"(Next Day Air)");
        // 2.33 Verify Total is “$2,950.00”
        assertVerifyText(By.xpath("//span[@class='value-summary']//strong"),"$2,950.00");
        // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        // 2.35 Verify the Text “Thank You”
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
        // 2.36 Verify the message “Your order has been successfully processed!”
        assertVerifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        // 2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        // 2.37 Verify the text “Welcome to our store”
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
