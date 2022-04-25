@backend
Feature: Employee API Functions

  Scenario: To verify that all employees data is fetched successfully
    Given There is an api available to fetch all Employees data
    When perform Get operation to Employees api
    Then Validate Api response code is 200
    And Validate Api status is "success"

  Scenario Outline: To verify that specific employee details are fetched based on empID
    When Client perform the Get function of Employee api with <id>
    Then Validate Api response code is 200
    And Api response should be matched with <id>
    Examples:
      | id |
      | 1  |
      | 3  |

  Scenario: To verify that system should return response code 404 when endpoint does not exist
    When Client calls the "GET" method of "/test" endpoint
    Then Validate Api response code is 404

  Scenario: To verify that system should return response code 404 when wrong end point given
    When Client calls the "GET" method of "api/v1/employeesRandom" endpoint
    Then Validate Api response code is 404

  Scenario Outline: To verify that User successfully able to create new employee
    Given User sets required employee data "<name>" <salary> <age>
    When client perform the Post operation to post Employees api
    Then Validate Api response code is 200
    And Create Api status is "success" and name is "<name>" and salary is <salary> and age is <age>
    Examples:
      | name    | salary | age |
      | testOne | 34567  | 25  |
      | testTwo | 12345  | 23  |

  Scenario Outline: To verify that employee data is updated successfully
    Given User has an initial employee data for update employee <id> "<name>" <salary> <age>
    When client perform the Put function of update Employees api with <id>
    Then Validate Api response code is 200
    And verify record is updated and success message is shown "Successfully! Record has been updated."
    Examples:
      | id | name    | salary | age |
      | 21 | testOne | 600000 | 25  |

  Scenario: To verify that employee data is deleted successfully using employee id
    When User perform the delete Api request with id 22
    Then Validate Api response code is 200
    And Verify that success message is shown "Successfully! Record has been deleted"
