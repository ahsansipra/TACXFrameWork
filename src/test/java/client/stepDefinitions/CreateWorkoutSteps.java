package client.stepDefinitions;

import client.pageObjects.CreateWorkoutPage;
import client.pageObjects.HomePage;
import client.pageObjects.WorkoutsPage;
import driverUtils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class CreateWorkoutSteps {

    private DriverManager webDriverManager;
    private String expectedTitle;

    public CreateWorkoutSteps(DriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    @When("User Select Create workout menu item from left pane in dashboard")
    public void userSelectCreateWorkoutMenuItemFromLeftPaneInDashboard() throws IOException {
        HomePage homePage = new HomePage(webDriverManager.getWebDriver());
        homePage.clickCreateWorkOut();
    }

    @And("User Select Power workout")
    public void userSelectPowerWorkout() throws IOException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickPower();
    }

    @And("User select distance as target")
    public void userSelectDistanceAsTarget() throws IOException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickDistance();
    }

    @And("User select continue")
    public void userSelectContinue() throws IOException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickContinue();
    }

    @And("User set distance to {int} KM")
    public void userSetDistance(Integer distanceValue) throws IOException, InterruptedException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickDistanceIndicator(distanceValue);
    }

    @And("User save the workout with title name")
    public void userSaveTheWorkoutWithTitleName() throws InterruptedException, IOException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickSaveBtn();
        createWorkoutPage.setTitle();
        expectedTitle = createWorkoutPage.getTitle();
        createWorkoutPage.clickSaveTitle();
    }

    @And("User navigate to Workouts menu item")
    public void userNavigateToWorkoutsMenuItem() throws IOException {
        HomePage homePage = new HomePage(webDriverManager.getWebDriver());
        homePage.clickWorkout();
    }

    @Then("Verify Workout is created with title name")
    public void verifyWorkOutTitleName() throws IOException {
        WorkoutsPage workoutsPage = new WorkoutsPage(webDriverManager.getWebDriver());
        Assert.assertTrue("Save Title is not found on workout card",
                workoutsPage.ifTitleFoundOnWorkout(expectedTitle));
    }
    @Then("User Logout from the account")
    public void userLogoutFromTheAccount() throws IOException {
        HomePage homePage = new HomePage(webDriverManager.getWebDriver());
        homePage.clickSignOut();
    }
}
