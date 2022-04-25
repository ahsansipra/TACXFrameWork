package backend.stepDefinitions;

import backend.httpRequestsBeans.AddEmployeeDataBean;
import backend.modelClasses.PostEmployeeResponse;
import backend.restclient.HttpRestClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.junit.Assert;

public class CreateEmployeeSteps {

    private AddEmployeeDataBean createEmployeeBean;
    private HttpRestClient httpRestClient;
    PostEmployeeResponse postEmployeeResponse;

    public CreateEmployeeSteps(AddEmployeeDataBean createEmployeeContext, HttpRestClient httpRestClient) {
        this.createEmployeeBean = createEmployeeContext;
        this.httpRestClient = httpRestClient;
    }

    @Given("User sets required employee data {string} {int} {int}")
    public void fillEmployeeData(String name, Integer salary, Integer age) {
        createEmployeeBean.setEmployeeData(name, salary, age);
    }

    @When("client perform the Post operation to post Employees api")
    public void createEmployeePostRequest() {
        createEmployeeBean.createEmployeePostCall();
        postEmployeeResponse = createEmployeeBean.postEmployeeResponse;
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
