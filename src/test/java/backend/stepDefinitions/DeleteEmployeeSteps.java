package backend.stepDefinitions;

import backend.httpRequestsContext.DeleteEmployeeContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class DeleteEmployeeSteps {

    private DeleteEmployeeContext deleteEmployeeContext;
    Response response;

    public DeleteEmployeeSteps(DeleteEmployeeContext deleteEmployeeContext) {
        this.deleteEmployeeContext = deleteEmployeeContext;
    }

    @When("User perform the delete Api request with id {int}")
    public void userPerformDeleteApiRequestWithId(Integer id) {
        response = deleteEmployeeContext.deleteEmployee(id);
    }

    @And("Verify that success message is shown {string}")
    public void verifySuccessMessage(String message) {
        Assert.assertEquals(message,response.path("message"));
    }
}
