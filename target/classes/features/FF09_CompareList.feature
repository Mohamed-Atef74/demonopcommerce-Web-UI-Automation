@smoke
Feature: User can add products to the compare list to compare between their details
  Scenario: Logged user could add different products to compare list
    Given The user is logged in
    And The user searches for something
    When The user adds a product to the compare list
    Then The product should be added to the compare list successfully
    When The user adds another product to the compare list
    Then The product should be added to the compare list successfully
    And The compare list should contain the added products