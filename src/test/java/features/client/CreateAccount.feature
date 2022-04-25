@frontend

Feature: Create Customer Account Feature

  Background:
    Given user is on TACX site

  Scenario Outline: Verify that user account is created successfully with given details
    When click on the create account button
    And user submits all fields with data "<firstName>" "<password>" "<repeatPassword>"
    Then User is on "Dashboard" page
    And Verify current page url contains "dashboard"
    Examples:
      | firstName | password  | repeatPassword |
      | TestOne   | Tacx12345 | Tacx12345      |
