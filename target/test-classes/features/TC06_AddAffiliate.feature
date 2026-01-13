@regression
Feature: Affiliate Registration

  Background:
    Given user opens the application
    When user logs in

  Scenario: Register as an affiliate
    When user navigates to affiliate page
    And user submits affiliate registration details
    Then affiliate registration should be successful
