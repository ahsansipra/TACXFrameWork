## tacx-assignment

### Description:
This test automation framework is used to automate both frontend UI based as well as backend api based test cases.
**Note:**. For jenkin integration, need to create a job and integrate git repo with Jenkins
and also generating Cucumber reports

### Overview of Framework:

**TestRunner** - it has the functionality of cucumber (feature files, result file) 
and control the execution with junit

Framework is divided into packages "client" , "backend" and common utils

- backend has all the code related to API automation
       - restclient package hold functionality of API requests and responses
       - Step definition are linked to feature files
       - context controls the logic (create requests and get the response)
- "Feature" package contains feauture files for both "client,backend"
- "DriverUtils" to initiate webdriver as per the property configurations

- client has all the code related to web automation
       - Page object Model is used and for every page, objects are identified (Pages has the object
    repository).
    
**TEST CASES**

**Backend API based test cases**

- To verify that Employees api successfully return data of all employee
- To verify that Employee api should successfully return data when search with id parameter
- To verify that system should return response code 404 when endpoint does not exist
- To verify that system should return response code 404 when wrong end point given
- To verify that User successfully able to create new employee
- To verify that User successfully able to update employee data
- To verify that user is able to delete employee data using employee id

**UI based test cases**
- Verify User account creation
- Verify Logging in to system
- Verify that user is successfully able to create workout

**Issue:**
1. API are returning 429 http response code randomly and change the response content to html/text which cause the 
parsing issue
2. While using latest webdriver, context detaching issue is observed, so had to switch back to previous version
3. Explicit wait commands are deprecated in latest version,

**Prerequisites:**
This framework requires following

Java 8
Maven

**Steps to execute:**

Go to the project root folder through cmd cd {Project-Path}

Execute below command on cmd
"mvn clean test" or "mvn verify"

This framework is supporting following browsers:
**Note:** : as of now configured in property files, changing the browser name in property file will work
- chrome
- firefox


**REPORTING**
for report generation, following is the command:

"mvn verify"
A detailed cucumber jvm report is being generated after every execution on following path
target/cucumber-JVM-reports/cucumber-html-reports/overview-features.html


**TAGGING**

There are two tags in this framework

@frontend
This tag is used for executing client UI based tests.

@backend
This tags is used for executing backend api based tests.

Following command is used to execute test based on tagging:

mvn clean test -Dcucumber.options="--tags '@frontend'"

**Note**: if we do not give any tag with the command then it will execute all test cases
