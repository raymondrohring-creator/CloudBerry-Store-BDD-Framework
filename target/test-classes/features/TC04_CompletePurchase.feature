@regression
Feature: Complete Purchase

  Background:
    Given user opens the application
    When user logs in

  Scenario: Complete purchase successfully
    When user navigates to a product category
    And user selects a product
    And user adds the product to cart
    And user opens shopping cart
    And user proceeds to checkout
    And user enters billing and shipping details
    And user confirms the order
    Then order should be placed successfully
    And order confirmation message should be displayed
