@frontend

Feature: Create Training Workouts Feature

  Background:
    Given user is on TACX site
    And User logs in to the system with "random@email.com" and "Tacx12345"

  Scenario: Verify that user is able to create workouts Successfully
    When User Select Create workout menu item from left pane in dashboard
    And User Selects Power workout
    And User selects distance as target
    And User selects continue option
    And User sets distance to 12 KM
    And User saves the workout and gives title name
    And select Workouts menu item
    Then Verify Workout is created with title name
    And User Logout from the account
