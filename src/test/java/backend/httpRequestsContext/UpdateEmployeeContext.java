package backend.httpRequestsContext;

import io.restassured.http.Method;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import backend.restclient.Endpoint;
import backend.restclient.HttpRestClient;
import java.util.HashMap;


@Getter
@Setter
public class UpdateEmployeeContext {

    private Logger logger = LoggerFactory.getLogger(UpdateEmployeeContext.class.getName());
    private HttpRestClient httpRestClient;
    HashMap<String, Object> requestBody;

    public UpdateEmployeeContext(HttpRestClient httpRestClient) {
        this.httpRestClient = httpRestClient;
    }

    public void updateEmployeeData(Integer id, String name, Integer salary, Integer age) {
        requestBody = new HashMap<String, Object>();
        requestBody.put("id",id);
        requestBody.put("name",name);
        requestBody.put("salary", salary);
        requestBody.put("age",age);
    }

    public Response callUpdateEmployee(Integer Id) {
        httpRestClient.addHeader("content-type", "application/json;charset=utf-8");
        httpRestClient.setBody(requestBody);
        Response response = httpRestClient.sendHttpRequest(Method.PUT, Endpoint.PUT_UPDATE_EMPLOYEE, Id);
        if (response.getStatusCode() == HttpStatus.SC_OK) {
            return response;
        } else {
            logger.error("response is not proper", response);
        }
        return response;
    }

}
