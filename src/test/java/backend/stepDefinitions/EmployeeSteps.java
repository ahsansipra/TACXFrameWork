package backend.stepDefinitions;

import backend.httpRequestsBeans.GetEmployeesDataBean;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import backend.modelClasses.ListOfEmployee;
import org.junit.Assert;

public class EmployeeSteps {

    private GetEmployeesDataBean employeeBean;
    Response response;
    ListOfEmployee listOfEmployee;

    public EmployeeSteps(GetEmployeesDataBean employeeContext) {
        this.employeeBean = employeeContext;
    }

    @Given("There is an api available to fetch all Employees data")
    public void FetchAllEmployeesData() throws Throwable {
    }

    @When("perform Get operation to Employees api")
    public void getAllEmployeesAPICall() throws Throwable {
        employeeBean.getAllEmployeesList();
        listOfEmployee = employeeBean.getListOfEmployee();
    }

    @And("Validate Api status is {string}")
    public void apiStatusIsSuccess(String responseStatus) throws Throwable {
        Assert.assertEquals("api success is not equals", responseStatus, listOfEmployee.getStatus());
    }

    @When("Client perform the Get function of Employee api with {int}")
    public void getEmployeeDetailsByEmpID(Integer id) {
        response = employeeBean.getEmployeeDetailByID(id);
    }

    @Then("Api response should be matched with {int}")
    public void employeeApiResponseWithId(Integer id) {
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals("id is not matched", id, response.path("data.'id'"));
    }

}
