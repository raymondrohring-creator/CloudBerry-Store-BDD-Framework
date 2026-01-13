@regression
Feature: Add Product to Cart

  Background:
    Given user opens the application
    When user logs in

  Scenario: Add a product to shopping cart
    When user navigates to a product category
    And user selects a product
    And user adds the product to cart
    Then success message should be displayed for add to cart
    And cart should show the added product
