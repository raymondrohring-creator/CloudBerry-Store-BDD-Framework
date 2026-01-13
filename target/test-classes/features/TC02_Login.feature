@sanity @regression
Feature: Login

  Scenario: Login with valid credentials
    Given user opens the application
    When user navigates to login page
    And user enters valid email and password
    And user clicks login button
    Then user should be logged in successfully
