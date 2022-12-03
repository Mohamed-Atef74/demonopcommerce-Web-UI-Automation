@smoke
Feature: User can add products to the wishlist so that he can buy them later
  Scenario: Logged user could add different products to Wishlist
    Given The user is logged in
    When The user clicks on the heart icon for a product
    Then The product should be added to the wishlist successfully
    And The wishlist should contain the product