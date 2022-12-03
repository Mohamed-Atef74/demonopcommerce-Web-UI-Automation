@smoke
Feature: User can add products to the shopping cart and can manage the added products there
  Scenario: Logged user could add different products to Shopping cart
    Given The user is logged in
    And The user searches for something
    When User adds a product to the cart
    Then The product should be added to the cart successfully
    When User adds another product to the cart
    Then The product should be added to the cart successfully
    And The cart should contain the added products