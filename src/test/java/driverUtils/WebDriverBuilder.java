package driverUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverBuilder {

    private static Logger logger = LoggerFactory.getLogger(WebDriverBuilder.class.getName());

    public WebDriver buildWebDriver(String browserName) {
        switch (browserName.toUpperCase()) {
            case "CHROME":
                return getChromeDriver();
            case "FIREFOX":
                return getFireFoxDriver();
            default:
                throw new WebDriverException();
        }
    }

    private WebDriver getChromeDriver() {
        logger.info("Getting Chrome web driver");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver getFireFoxDriver() {
        logger.info("Getting Firefox web driver");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
