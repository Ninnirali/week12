package hotdeals;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Mouse;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
//        1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Hot deals')]"));
//        1.2 Mouse hover on the “Sale”  link and click
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
//        1.3 Verify the text “Sale”
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"Sale");
//        1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Recommended')]"));
        clickOnMouseHoverOnElement(By.partialLinkText("Name A -"));
//        1.5 Verify that the product arrange alphabetically
        assertVerifyText(By.xpath("//span[contains(text(),'Name A - Z')]"),"Name A - Z");
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh(){
//        2.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@id='header-area']//span[contains(text(),'Hot deals')]"));
//        2.2 Mouse hover on the “Sale”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
//        2.3 Verify the text “Sale”
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"Sale");
//        2.4 Mouse hover on “Sort By” and select “Price Low-High”
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.partialLinkText("Price Low"));
//        2.5 Verify that the product’s price arrange Low to High
        assertVerifyText(By.xpath("//span[contains(text(),'Price Low - High')]"),"Price Low - High");
    }

    @Test
    public void verifySaleProductsArrangeByRates(){
//        3.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
//        3.2 Mouse hover on the “Sale”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
//        3.3 Verify the text “Sale”
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"Sale");
//        3.4 Mouse hover on “Sort By” and select “Rates”
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/li[7]/child::a"));
//        3.5 Verify that the product’s arrange Rates
        assertVerifyText(By.xpath("//span[contains(text(),'Rates')]"),"Rates");

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
//        1.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
//        1.2 Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul[1]/li[2]/child::a"));
//        1.3 Verify the text “Bestsellers”
        assertVerifyText(By.tagName("h1"),"Bestsellers");
//        1.4 Mouse hover on “Sort By” and select “Name Z-A”
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Name Z - A"));
//        1.5 Verify that the product arrange by Z to A
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/h5/a"));
        // Create the list object
        List<String> sortPriceList = new ArrayList();
        // Add all web element value to list object
        for (WebElement element : originalProductList) {
            sortPriceList.add(element.getText());
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        // Sort by Z to A
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.partialLinkText("Name Z -"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/h5/a"));
        // Create the list object
        List<String> actualPriceList = new ArrayList();
        // Add all web element value to list object
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(element.getText());
        }
        Assert.assertEquals(sortPriceList, actualPriceList);
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
//        2.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));
//        2.2 Mouse hover on the “Bestsellers” link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul[1]/li[2]/child::a"));
//        2.3 Verify the text “Bestsellers”
        assertVerifyText(By.tagName("h1"),"Bestsellers");
//        2.4 Mouse hover on “Sort By” and select “Price High-Low”
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Price High - Low"));
//        2.5 Verify that the product’s price arrange High to Low
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> sortPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        //add all web element value to list object*/
        for (WebElement element : originalProductList) {
            sortPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        //Mouse hover on “Sort By”
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Price: Low to High”
        clickOnElement(By.partialLinkText("Price High - L"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> actualPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        add all web element value to list object*/
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Assert.assertEquals(sortPriceList, actualPriceList);

    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
//        3.1 Mouse hover on the “Hot deals” link
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
//        3.2 Mouse hover on the “Bestsellers”  link and click
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul[1]/li[2]/child::a"));
//        3.3 Verify the text “Bestsellers”
        assertVerifyText(By.tagName("h1"),"Bestsellers");
//        3.4 Mouse hover on “Sort By” and select “Rates”
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Rates"));
//        3.5 Verify that the product’s arrange Rates


    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
