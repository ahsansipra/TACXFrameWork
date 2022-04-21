package driverUtils;

import commonUtils.Utils;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DriverManager {
    private static Logger logger = LoggerFactory.getLogger(DriverManager.class.getName());
    public WebDriver driver;

    public void closeDriver(){
        if (null != driver) {
            logger.info("Closing web driver");
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver() throws IOException {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver() throws IOException {

        driver = new WebDriverBuilder().buildWebDriver(Utils.getProperties("driver"));
        driver.manage().window().maximize();
        return driver;
    }

    public void createScreenshot(Scenario scenario) {
        if ( driver != null) {
            logger.info("Taking screenshots of failure scenario");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
       //    scenario.embed(screenshot, "image/png");
        }
    }

}
