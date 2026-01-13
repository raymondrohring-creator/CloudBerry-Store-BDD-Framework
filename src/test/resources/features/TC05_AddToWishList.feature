@regression
Feature: Add Product to Wish List

  Background:
    Given user opens the application
    When user logs in

  Scenario: Add a product to wishlist
    When user navigates to a product category
    And user selects a product
    And user adds the product to wishlist
    Then success message should be displayed for wishlist
    And wishlist should contain the added product
