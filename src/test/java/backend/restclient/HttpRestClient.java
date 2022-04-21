package backend.restclient;

import commonUtils.Utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * HttpRestClient is use to call Rest Api and perform all the functions
 * specifically relating to the API requests and responses
 */

public class HttpRestClient extends Utils {

    private static Logger logger = LoggerFactory.getLogger(HttpRestClient.class.getName());
    private RequestSpecification requestSpecification;
    private JsonPath responseBody;
    private Integer statusCode;

    public HttpRestClient() throws IOException {
        RestAssured.baseURI = getProperties("baseurl");
        requestSpecification = RestAssured.given().log().uri();
    }

    public void addHeader(String header, String value) {
        requestSpecification.header(header, value);
    }

    public void setBody(Object body) {
        requestSpecification.body(body);
    }

    /**
     * sendHttpRequest method calls the Rest API and return response of Rest API with two parameter method type
     * and EndPoint
     */
    public Response sendHttpRequest(Method method, String endPoint) {
        logger.debug("creating request for method : {}, with endPoint : {}",
                method, endPoint);
        Response response = requestSpecification.request(method, endPoint);
        setResponseBody(response.getBody().jsonPath());
        setStatusCode(response.getStatusCode());
        return response;
    }

    /**
     * sendHttpRequest method calls the Rest API and return response of Rest API with two parameter method type,
     * EndPoint and path param
     */
    public Response sendHttpRequest(Method method, String endPoint, Integer id) {
        logger.debug("creating request for method : {}, with endPoint : {}",
                method, endPoint);
        requestSpecification.pathParam("id", id);
        Response response = requestSpecification.request(method, endPoint);
        setResponseBody(response.getBody().jsonPath());
        setStatusCode(response.getStatusCode());
        return response;
    }

    public JsonPath getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(JsonPath responseBody) {
        this.responseBody = responseBody;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
