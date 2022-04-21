package client.stepDefinitions;

import client.pageObjects.HomePage;
import client.pageObjects.LoginPage;
import driverUtils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class LoginSteps {
    private DriverManager webDriverManager;

    public LoginSteps(DriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    @When("User enter email Id {string}")
    public void userEnterEmailId(String emailId) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(webDriverManager.getWebDriver());
        loginPage.clickSignInWithGarmin();
        loginPage.setEmailId(emailId);
    }

    @And("User enter password {string}")
    public void userEnterPassword(String password) throws IOException {
        LoginPage loginPage = new LoginPage(webDriverManager.getWebDriver());
        loginPage.setPassword(password);
    }

    @And("User Clicks on Login Button")
    public void userClicksOnLoginButton() throws IOException {
        LoginPage loginPage = new LoginPage(webDriverManager.getWebDriver());
        loginPage.clickLogin();
    }

    @Then("SIGN OUT action is available")
    public void signOutActionIsAvailable() throws IOException, InterruptedException {
        HomePage homePage = new HomePage(webDriverManager.getWebDriver());
        homePage.waitSignOutToBeVisible();
    }

    @And("User logs in to the system with {string} and {string}")
    public void userLogsInToTheSystem(String emailId, String password) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(webDriverManager.getWebDriver());
        loginPage.clickSignInWithGarmin();
        loginPage.setEmailId(emailId);
        loginPage.setPassword(password);
        loginPage.clickLogin();
        HomePage homePage = new HomePage(webDriverManager.getWebDriver());
        homePage.waitSignOutToBeVisible();
    }
}
