package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Logger;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
