@frontend

Feature: Create Workout

  Background:
    Given user is on TACX site
    And User logs in to the system with "random@email.com" and "Tacx12345"

  Scenario: Verify that user is successfully able to create workout
    When User Select Create workout menu item from left pane in dashboard
    And User Select Power workout
    And User select distance as target
    And User select continue
    And User set distance to 12 KM
    And User save the workout with title name
    And User navigate to Workouts menu item
    Then Verify Workout is created with title name
    And User Logout from the account
