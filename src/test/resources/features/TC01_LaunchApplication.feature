@sanity @regression
Feature: Launch Application

  Scenario: User launches application successfully
    Given user opens the application
    Then application home page should be displayed
    And page title should contain "Your Store"
