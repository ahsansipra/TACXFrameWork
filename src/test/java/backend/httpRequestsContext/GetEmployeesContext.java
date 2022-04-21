package backend.httpRequestsContext;


import io.restassured.http.Method;
import io.restassured.response.Response;
import lombok.Getter;
import backend.modelClasses.ListOfEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import backend.restclient.Endpoint;
import backend.restclient.HttpRestClient;

/**
 * The EmployeeContext class holds the functionality
 * specifically relating to the get Employee endpoint.
 */

@Getter
public class GetEmployeesContext {
    private static final Logger logger = LoggerFactory.getLogger(GetEmployeesContext.class.getName());
    private HttpRestClient httpRestClient;
    private ListOfEmployee listOfEmployee;

    public GetEmployeesContext(HttpRestClient httpRestClient) {
        this.httpRestClient = httpRestClient;
    }

    public Response getAllEmployeesList() {
        Response response = httpRestClient.sendHttpRequest(Method.GET, Endpoint.GET_EMPLOYEES);
        if (response.getStatusCode() != 429 ) {
            listOfEmployee = response.getBody().as(ListOfEmployee.class);
        } else {
            logger.error("response is invalid", response);
        }
        return response;
    }


    public Response getEmployeeDetailByID(int id) {
        httpRestClient.addHeader("content-type", "application/json;charset=utf-8");
        Response response = httpRestClient.sendHttpRequest(Method.GET, Endpoint.GET_EMPLOYEE_ID, id);
        if (response.getStatusCode() != 429) {
            return response;
        } else {
            logger.error("response is invalid", response);
        }
        return response;
    }

}
