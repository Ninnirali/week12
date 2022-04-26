package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        // set up browser
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        // launch url
        driver.get(baseUrl);
        // Maximise window
        driver.manage().window().maximize();
        // delete all cookies
        driver.manage().deleteAllCookies();
        // give implicite time to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser(){
        driver.quit();
    }

}
