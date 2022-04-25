package backend.stepDefinitions;

import backend.httpRequestsBeans.DeleteEmployeeDataBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class DeleteEmployeeSteps {

    private DeleteEmployeeDataBean deleteEmployeeBean;
    Response response;

    public DeleteEmployeeSteps(DeleteEmployeeDataBean deleteEmployeeContext) {
        this.deleteEmployeeBean = deleteEmployeeContext;
    }

    @When("User perform the delete Api request with id {int}")
    public void performDeleteOperation(Integer id) {
        response = deleteEmployeeBean.deleteEmployee(id);
    }

    @And("Verify that success message is shown {string}")
    public void verifySuccessMessage(String message) {
        Assert.assertEquals(message,response.path("message"));
    }
}
