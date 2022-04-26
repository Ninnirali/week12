package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {

     String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        //Find and Click on the 'Computers' Tab
        clickOnElement(By.linkText("Computers"));
       //Verify the text 'Computers'
        verifyText("Computers",By.linkText("Computers"),"Not navigate to 'Computers' Tab ");
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //Find and click on the ‘Electronics’ Tab
        clickOnElement(By.linkText("Electronics"));
         //Verify the text ‘Electronics’
        verifyText("Electronics",By.linkText("Electronics"),"Not navigate to'Electronics' Tab");
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        // find and click on the ‘Apparel’Tab
        clickOnElement(By.linkText("Apparel"));
        //Verify the text ‘Apparel’
        verifyText("Apparel",By.linkText("Apparel"),"Not navigate to 'Apparel' Tab");
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        // find and click on the ‘Digital downloads’ Tab
        clickOnElement(By.linkText("Digital downloads"));
        //Verify the text ‘Digital downloads’
        verifyText("Digital downloads",By.linkText("Digital downloads"),"Not navigate to 'Digital downloads' Tab");
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //find and click on the ‘Books’ Tab
        clickOnElement(By.xpath("//a[@href='/books']"));
        // Verify the text ‘Books’
        verifyText("Books",By.xpath("//a[@href='/books']"),"Not navigate to 'Book' Tab");
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //find and click on the ‘Jewelry’ Tab
        clickOnElement(By.xpath("//a[@href='/jewelry']"));
        // Verify the text ‘Jewelry’
        verifyText("Jewelry",By.xpath("//a[@href='/jewelry']"),"not navigate to 'Jewelry' Tab");
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        // find and click on the ‘Gift Cards’ Tab
        clickOnElement(By.xpath("//a[@href='/gift-cards']"));
        // Verify the text ‘Gift Cards’
        verifyText("Gift Cards",By.xpath("//a[@href='/gift-cards']"),"No navigate to 'Gift Cards' Tab");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
