package backend.stepDefinitions;

import backend.httpRequestsContext.CreateEmployeeContext;
import backend.modelClasses.PostEmployeeResponse;
import backend.restclient.HttpRestClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.junit.Assert;

public class CreateEmployeeSteps {

    private CreateEmployeeContext createEmployeeContext;
    private HttpRestClient httpRestClient;
    PostEmployeeResponse postEmployeeResponse;

    public CreateEmployeeSteps(CreateEmployeeContext createEmployeeContext, HttpRestClient httpRestClient) {
        this.createEmployeeContext = createEmployeeContext;
        this.httpRestClient = httpRestClient;
    }

    @Given("User has an initial employee data {string} {int} {int}")
    public void initialEmployeeData(String name, Integer salary, Integer age) {
        createEmployeeContext.setEmployeeData(name, salary, age);
    }

    @When("client perform the Post function of create Employees api")
    public void createEmployeePostRequest() {
        createEmployeeContext.createEmployeePostCall();
        postEmployeeResponse = createEmployeeContext.postEmployeeResponse;
    }

    @Then("Create Api status is {string} and name is {string} and salary is {int} and age is {int}")
    public void validateCreateApiResponse(String responseStatus, String name, Integer salary, Integer age) {

        Assert.assertEquals("Response Code is not proper from API", Integer.valueOf(HttpStatus.SC_OK), httpRestClient.getStatusCode());
        Assert.assertEquals("status is not equals", responseStatus, postEmployeeResponse.getStatus());
        Assert.assertEquals("name is not equals", name, postEmployeeResponse.getData().getName());
        Assert.assertEquals("salary is not equals", salary, postEmployeeResponse.getData().getSalary());
        Assert.assertEquals("age is not equals", age, postEmployeeResponse.getData().getAge());
    }

}
