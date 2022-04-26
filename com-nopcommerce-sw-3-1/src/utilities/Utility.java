package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    /**
     * This method will verify the expected text // Assert Method verification
     */
    public String verifyText(String expectedMessage, By by, String message) {

        String actualMessage = driver.findElement(by).getText();
        Assert.assertEquals(message, expectedMessage, actualMessage);
        return message;
    }

    //This method verify the expected text
    public void assertVerifyText(By by, String expectedtext) {
        String actualText = getTextFromElement(by);
        String expectedText = expectedtext;
        Assert.assertEquals("Error>Test failed  : ", expectedText, actualText);
    }

    //*********************************  Alert Interface Methods ****************************//

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

    /**
     * This method will dismiss the alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will send text to alert
     */
    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //*************************** Select class methods **************************************//

    /**
     * This method will select the option by visible text in dropdown
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value in dropdown
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown1 = driver.findElement(by);
        dropDown1.click();
        Select select1 = new Select(dropDown1);
        select1.selectByValue(value);
    }

    /**
     * This method will select the option by index no. in dropdown
     */
    public void selectByIndexFromDropDown(By by, int a) {
        WebElement dropDown2 = driver.findElement(by);
        Select select2 = new Select(dropDown2);
        select2.selectByIndex(a);
    }

    /**
     * This method will select all the options from dropdown
     */
    public void selectByGetAllOptionFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions
        ) {
            //System.out.println(element.getText());//to print all countries
            if (element.getText().equals(text)) {
                element.click();
            }
        }
    }
    //*************************** Action class methods **************************************//

    public void mouseHoverOnElement (By by){
        Actions actions = new Actions(driver);
        WebElement element =driver.findElement(by);
        actions.moveToElement(element).build().perform();
    }
    public void clickOnMouseHoverOnElement (By by){
        Actions actions = new Actions(driver);
        WebElement element =driver.findElement(by);
        actions.moveToElement(element).click().build().perform();
    }
}


