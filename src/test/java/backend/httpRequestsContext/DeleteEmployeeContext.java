package backend.httpRequestsContext;


import io.restassured.http.Method;
import io.restassured.response.Response;
import backend.restclient.Endpoint;
import backend.restclient.HttpRestClient;

public class DeleteEmployeeContext {

    private HttpRestClient httpRestClient;
    private Response response;

    public DeleteEmployeeContext(HttpRestClient httpRestClient) {
        this.httpRestClient = httpRestClient;
    }

    public Response deleteEmployee(Integer id) {
        httpRestClient.addHeader("content-type", "application/json;charset=utf-8");
        response = httpRestClient.sendHttpRequest(Method.DELETE, Endpoint.DELETE_EMPLOYEE, id);
        return response;
    }

}
