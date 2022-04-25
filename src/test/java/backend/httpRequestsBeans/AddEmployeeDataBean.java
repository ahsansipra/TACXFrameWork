package backend.httpRequestsBeans;

import io.restassured.http.Method;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import backend.modelClasses.PostEmployeeRequest;
import backend.modelClasses.PostEmployeeResponse;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import backend.restclient.Endpoint;
import backend.restclient.HttpRestClient;

/**
 * The CreateEmployeeContext class holds the functionality
 * specifically relating to the Create Employee endpoint
 */

@Getter
@Setter
public class AddEmployeeDataBean {
    private Logger logger = LoggerFactory.getLogger(AddEmployeeDataBean.class.getName());
    private HttpRestClient httpRestClient;
    private PostEmployeeRequest employeeRequest = new PostEmployeeRequest();
    public PostEmployeeResponse postEmployeeResponse;

    public AddEmployeeDataBean(HttpRestClient httpRestClient) {
        this.httpRestClient = httpRestClient;
    }

    public void setEmployeeData(String name, Integer salary, Integer age) {
        employeeRequest.setName(name);
        employeeRequest.setSalary(salary);
        employeeRequest.setAge(age);
    }
    /**
     * The callCreateEmployeeApi method will call the sendHttpRequest Method and pass the end point
     * method type, This dummy api was crashing after some request and sending html response body
     * which is wrong so checking the status and then doing the parsing
     */
    public Response createEmployeePostCall() {
        httpRestClient.addHeader("content-type", "application/json;charset=utf-8");
        httpRestClient.setBody(employeeRequest);
        Response response = httpRestClient.sendHttpRequest(Method.POST, Endpoint.POST_CREATE_EMPLOYEE);
        if (response.getStatusCode() == HttpStatus.SC_OK) {
            postEmployeeResponse = response.getBody().as(PostEmployeeResponse.class);
        } else {
            logger.error("response {} is not proper", response);
        }
        return response;
    }
}
