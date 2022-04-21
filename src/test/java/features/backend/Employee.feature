@backend
Feature: Employee API

  Scenario: To verify that Employees api successfully return data of all employee
    Given There is an api available to fetch all Employees data
    When client perform the Get function of Employees api
    Then Api response code is 200
    And Api status is "success"

  Scenario Outline: To verify that specific employee details are fetched based on empID
    When Client perform the Get function of Employee api with <id>
    Then Api response code is 200
    And Api response should be matched with <id>
    Examples:
      | id |
      | 1  |
      | 3  |

  Scenario: To verify that system should return response code 404 when endpoint does not exist
    When Client calls the "GET" method of "/test" endpoint
    Then Api response code is 404

  Scenario: To verify that system should return response code 404 when wrong end point given
    When Client calls the "GET" method of "api/v1/employeesssss" endpoint
    Then Api response code is 404

  Scenario Outline: To verify that User successfully able to create new employee
    Given User has an initial employee data "<name>" <salary> <age>
    When client perform the Post function of create Employees api
    Then Api response code is 200
    And Create Api status is "success" and name is "<name>" and salary is <salary> and age is <age>
    Examples:
      | name    | salary | age |
      | testOne | 34567  | 25  |
      | testTwo | 12345  | 23  |

  Scenario Outline: To verify that User successfully able to update employee data
    Given User has an initial employee data for update employee <id> "<name>" <salary> <age>
    When client perform the Put function of update Employees api with <id>
    Then Api response code is 200
    And verify record is updated and success message is shown "Successfully! Record has been updated."
    Examples:
      | id | name    | salary | age |
      | 21 | testOne | 900000 | 25  |

  Scenario: To verify that user is able delete employee data using employee id
    When User perform the delete Api request with id 22
    Then Api response code is 200
    And Verify that success message is shown "Successfully! Record has been deleted"
