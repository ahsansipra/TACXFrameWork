package client.stepDefinitions;


import driverUtils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import client.pageObjects.CreateAccountPage;
import client.pageObjects.LoginPage;
import java.io.IOException;

public class CreateAccountSteps {
    private DriverManager webDriver;

    public CreateAccountSteps(DriverManager webDriver) {
        this.webDriver = webDriver;
    }

    @When("user click on the create account button")
    public void userClickOnCreateAccountButton() throws IOException {
        LoginPage loginPage = new LoginPage(webDriver.getWebDriver());
        loginPage.clickSignInWithGarmin();
        loginPage.waitCreateAccountToBeVisible();
        loginPage.clickCreateAccount();
    }

    @And("user submits all fields with correct data {string} {string} {string}")
    public void userSubmitsAllFieldsWithCorrectData(String name, String password, String repeatPassword) throws IOException {
        CreateAccountPage createAccountPage = new CreateAccountPage(webDriver.getWebDriver());
        createAccountPage.fillCreateAccountForm(name, password, repeatPassword);
    }

    @And("Current page url contains {string}")
    public void validateCurrentPageUrlContains(String expectedValue) throws IOException {
        Assert.assertTrue("URL does not contain: " + expectedValue,
                webDriver.getWebDriver().getCurrentUrl().contains(expectedValue));
    }
}
