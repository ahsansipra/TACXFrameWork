@login

Feature: Login User Feature

  Background:
    Given user is on TACX site

  Scenario: Verify that user is successfully logging in to system
    When User enter email Id "random@email.com"
    And User enter password "Tacx12345"
    And User Clicks on Login Button
    Then User is on "Dashboard" page
    And SIGN OUT action is available
