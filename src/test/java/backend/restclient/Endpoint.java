package backend.restclient;

public interface Endpoint {

    String GET_EMPLOYEES = "/api/v1/employees";
    String GET_EMPLOYEE_ID = "/api/v1/employee/{id}";
    String POST_CREATE_EMPLOYEE = "/api/v1/create";
    String PUT_UPDATE_EMPLOYEE = "/api/v1/update/{id}";
    String DELETE_EMPLOYEE = "/api/v1/delete/{id}";
}
