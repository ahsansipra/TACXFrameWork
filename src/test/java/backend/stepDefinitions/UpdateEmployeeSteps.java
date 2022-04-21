package backend.stepDefinitions;

import backend.httpRequestsContext.UpdateEmployeeContext;
import backend.restclient.HttpRestClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;

public class UpdateEmployeeSteps {

    private UpdateEmployeeContext updateEmployeeContext;
    private HttpRestClient httpRestClient;
    Response response;

    public UpdateEmployeeSteps(HttpRestClient httpRestClient, UpdateEmployeeContext updateEmployeeContext) {
        this.httpRestClient = httpRestClient;
        this.updateEmployeeContext = updateEmployeeContext;
    }

    @Given("User has an initial employee data for update employee {int} {string} {int} {int}")
    public void initialDataForUpdateEmployee(Integer id, String name, Integer salary, Integer age) {
        updateEmployeeContext.updateEmployeeData(id, name, salary, age);
    }

    @When("client perform the Put function of update Employees api with {int}")
    public void clientPerformPutFunctionOfUpdateEmployeesApi(Integer id) {
        response = updateEmployeeContext.callUpdateEmployee(id);
    }

    @Then("verify record is updated and success message is shown {string}")
    public void validateUpdateApiResponse(String message) {
        Assert.assertEquals("Response Code is not proper from API", Integer.valueOf(HttpStatus.SC_OK), httpRestClient.getStatusCode());
        Assert.assertEquals("Record is not updated", message, response.path("message"));

    }
}
