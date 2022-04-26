package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    //***************************************  Alerts Methods ****************************//

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept the alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //*************************** Select class methods **************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    /**
     * This method will select the option from dropdown using select by value
     */

    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown1 = driver.findElement(by);
        dropDown1.click();
        Select select1 = new Select(dropDown1);
        select1.selectByValue(value);
    }
    /**
     * Assert Method verification
     */

    public String verifyPage(String expectedMessage, By by, String message) {

        String actualMessage = driver.findElement(by).getText();
        Assert.assertEquals(message,expectedMessage,actualMessage);
        return message;
    }
    public void assertVerifyText(By by,String expectedtext){
        String actualText = getTextFromElement(by);
        String expectedText =expectedtext;
        Assert.assertEquals("Error>Test failed  : ",expectedText,actualText);
    }

}


