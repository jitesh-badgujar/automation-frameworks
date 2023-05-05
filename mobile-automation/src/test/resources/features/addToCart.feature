@sanity
Feature: Add Product to Cart

  Background: 
    Given I am on landing screen
    And I select "Amazon" as online shopping site

  Scenario: As a user I should be able to search and add multiple products to the cart
    Given I search for "Monk who sold his ferrari" product
    And I select "first" product from the search results
    And I provide below data as buying options
      | format    | quantity |
      | Paperback |        1 |
    When I add product to the cart
    And I search for "Think like a monk" product
    And I select "first" product from the search results
    And I provide below data as buying options
      | format    | quantity |
      | Hardcover |        1 |
    And I add product to the cart
    And I go to the cart
    Then I should see "2" products in the cart
    And I should see total updated correctly
