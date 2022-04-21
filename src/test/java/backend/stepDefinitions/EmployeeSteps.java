package backend.stepDefinitions;

import backend.httpRequestsContext.GetEmployeesContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import backend.modelClasses.ListOfEmployee;
import org.junit.Assert;

public class EmployeeSteps {

    private GetEmployeesContext employeeContext;
    Response response;
    ListOfEmployee listOfEmployee;

    public EmployeeSteps(GetEmployeesContext employeeContext) {
        this.employeeContext = employeeContext;
    }

    @Given("There is an api available to fetch all Employees data")
    public void FetchAllEmployeesData() throws Throwable {
    }

    @When("client perform the Get function of Employees api")
    public void getAllEmployeesAPICall() throws Throwable {
        employeeContext.getAllEmployeesList();
        listOfEmployee = employeeContext.getListOfEmployee();
    }

    @And("Api status is {string}")
    public void apiStatusIsSuccess(String responseStatus) throws Throwable {
        Assert.assertEquals("api success is not equals", responseStatus, listOfEmployee.getStatus());
    }

    @When("Client perform the Get function of Employee api with {int}")
    public void getEmployeeDetailsByEmpID(Integer id) {
        response = employeeContext.getEmployeeDetailByID(id);
    }

    @Then("Api response should be matched with {int}")
    public void employeeApiResponseWithId(Integer id) {
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals("id is not matched", id, response.path("data.'id'"));
    }

}
