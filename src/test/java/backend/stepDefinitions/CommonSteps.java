package backend.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import org.junit.Assert;
import backend.restclient.HttpRestClient;

public class CommonSteps {

    private HttpRestClient httpRestClient;

    public CommonSteps(HttpRestClient httpRestClient) {
        this.httpRestClient = httpRestClient;
    }

    @When("Client calls the {string} method of {string} endpoint")
    public void clientCallGetMethodOfWrongEndPoint(String method, String endpoint) {
        httpRestClient.sendHttpRequest(Method.valueOf(method), endpoint);
    }

    @Then("Validate Api response code is {int}")
    public void validateApiResponseCode(Integer statusCode) throws Throwable {
        Assert.assertEquals("Status code is not equals", statusCode, httpRestClient.getStatusCode());
    }


}
