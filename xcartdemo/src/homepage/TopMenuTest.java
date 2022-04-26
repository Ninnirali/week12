package homepage;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
//        1.1 Click on the “Shipping” link
        clickOnElement(By.linkText("Shipping"));
//        1.2 Verify the text “Shipping”
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"Shipping");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
//        2.1 Click on the “New!” link
        clickOnElement(By.linkText("New!"));
//        2.2 Verify the text “New arrivals”
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"New arrivals");
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
//        3.1 Click on the “Coming soon” link
        clickOnElement(By.linkText("Coming soon"));
//        3.2 Verify the text “Coming soon”
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"Coming soon");
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
//        4.1 Click on the “Contact us” link
        clickOnElement(By.linkText("Contact us"));
//        4.2 Verify the text “Contact us”
        assertVerifyText(By.tagName("h1"),"Contact us");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
