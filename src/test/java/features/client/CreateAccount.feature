@frontend

Feature: Create Account

  Background:
    Given user is on TACX site

  Scenario Outline: Verify that system is successfully creating user account
    When user click on the create account button
    And user submits all fields with correct data "<firstName>" "<password>" "<repeatPassword>"
    Then "Dashboard" page is opened
    And Current page url contains "dashboard"
    Examples:
      | firstName | password  | repeatPassword |
      | TestOne   | Tacx12345 | Tacx12345      |
