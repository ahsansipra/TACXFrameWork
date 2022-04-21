@login

Feature: Login User

  Background:
    Given user is on TACX site

  Scenario: Verify that user is successfully logging in to system
    When User enter email Id "random@email.com"
    And User enter password "Tacx12345"
    And User Clicks on Login Button
    Then "Dashboard" page is opened
    And SIGN OUT action is available
