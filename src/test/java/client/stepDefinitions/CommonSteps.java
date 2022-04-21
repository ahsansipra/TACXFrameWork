package client.stepDefinitions;


import client.pageObjects.HomePage;
import commonUtils.Utils;
import driverUtils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;


public class CommonSteps extends Utils {

    private DriverManager webDriver;

    public CommonSteps(DriverManager webDriver) {
        this.webDriver = webDriver;
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            webDriver.createScreenshot(scenario);
        }
        if ( webDriver != null) {
              webDriver.closeDriver();
        }
    }

    @Given("user is on TACX site")
    public void userIsOnTacxSite() throws IOException {
        webDriver.getWebDriver().get(getProperties("clienturl"));
    }

    @Then("{string} page is opened")
    public void ValidatePageIsOpened(String pageTitle) throws InterruptedException, IOException {
        HomePage homePage = new HomePage(webDriver.getWebDriver());
        homePage.waitHomePageTitleToBeVisible();
        Thread.sleep(4000);
        Assert.assertEquals("Page Title is not equals", pageTitle, homePage.getPageTitle());
    }
}
