package client.pageObjects.basepages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;
    protected Select select;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, 15, 60);
        this.actions = new Actions(this.webDriver);
    }

    protected void waitElementToBeVisible(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitElementToBeClickable(WebElement webElement){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitElementToBeInvisible(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    protected void setText(WebElement webElement, String value) {
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        webElement.sendKeys(value);
    }

    protected void switchToFrameForLogin(WebElement webElement) {
        webDriver.switchTo().frame(webElement);
    }

    protected void switchFrameToCreateAccount(){
        webDriver.switchTo().parentFrame();
        webDriver.switchTo().frame("popup-iframe-id");
    }


//    public void ValidateContainsText(String expectedValue){
//        Assert.assertTrue("URL does not contain: " + expectedValue,
//                webDriver.getCurrentUrl().contains(expectedValue));
//    }

}
