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

    @And("User Selects Power workout")
    public void SelectPowerWorkout() throws IOException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickPowerOption();
    }

    @And("User selects distance as target")
    public void setDistanceTarget() throws IOException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickDistanceOption();
    }

    @And("User selects continue option")
    public void selectContinue() throws IOException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickContinue();
    }

    @And("User sets distance to {int} KM")
    public void setDistance(Integer distanceValue) throws IOException, InterruptedException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickDistanceIndicator(distanceValue);
    }

    @And("User saves the workout and gives title name")
    public void saveWorkoutWithTitle() throws InterruptedException, IOException {
        CreateWorkoutPage createWorkoutPage = new CreateWorkoutPage(webDriverManager.getWebDriver());
        createWorkoutPage.clickSaveButton();
        createWorkoutPage.setTitle();
        expectedTitle = createWorkoutPage.getTitle();
        createWorkoutPage.clickSaveTitle();
    }

    @And("select Workouts menu item")
    public void openWorkoutsMenu() throws IOException {
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
    public void userLogout() throws IOException {
        HomePage homePage = new HomePage(webDriverManager.getWebDriver());
        homePage.clickSignOut();
    }
}
