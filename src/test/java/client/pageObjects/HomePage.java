package client.pageObjects;

import com.paulhammant.ngwebdriver.ByAngularButtonText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import client.pageObjects.basepages.BasePage;

public class HomePage extends BasePage {

    @FindBy(tagName = "h2")
    private WebElement pageTitle;

    @FindBy(className = "sidenav-logout")
    private WebElement signOut;

    @ByAngularButtonText.FindBy(buttonText = "Create Workout")
    private WebElement createWorkOut;

    @ByAngularButtonText.FindBy(buttonText = "Workouts")
    private WebElement workOut;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickCreateWorkOut() {
        waitElementToBeVisible(createWorkOut);
        createWorkOut.click();
    }

    public void clickWorkout() {
        waitElementToBeVisible(workOut);
        workOut.click();
    }
    public void clickSignOut(){
        signOut.click();
    }

    public void waitHomePageTitleToBeVisible() {
        webDriver.switchTo().parentFrame();
        waitElementToBeVisible(pageTitle);
    }

    public void waitSignOutToBeVisible() throws InterruptedException {
        waitElementToBeVisible(signOut);
    }

    public String getPageTitle() throws InterruptedException {
        waitElementToBeVisible(pageTitle);
        return pageTitle.getText();
    }
}
