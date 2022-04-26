package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
//1. create class "TopMenuTest"
// 	1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
//	1.2 This method should click on the menu whatever name is passed as parameter.
//	1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.

    public void selectMenu(String name) {
    if (name == "Computers") {
        //find computer tab and click
        clickOnElement(By.linkText("Computers"));
        //validate actual and expected text
        assertVerifyText(By.tagName("h1"), "Computers");
    } else if (name == "Electronics") {
        clickOnElement(By.linkText("Electronics"));
        assertVerifyText(By.tagName("h1"), "Electronics");
    } else if (name == "Apparel") {
        clickOnElement(By.linkText("Apparel"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Apparel')]"), "Apparel");
    } else if (name == "Digital downloads") {
        clickOnElement(By.linkText("Digital downloads"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Digital downloads')]"), "Digital downloads");
    } else if (name == "Books") {
        clickOnElement(By.linkText("Books"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Books')]"), "Books");
    } else if (name == "Jewelry") {
        clickOnElement(By.linkText("Jewelry"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Jewelry')]"), "Jewelry");
    } else if (name == "Gift Cards") {
        clickOnElement(By.xpath("//a[contains(text(),'Gift Cards')]"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Gift Cards')]"), "Gift Cards");
    } else {
        System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
    }
}
    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }

  @After
    public void tearDown(){
        closeBrowser();
    }

}
