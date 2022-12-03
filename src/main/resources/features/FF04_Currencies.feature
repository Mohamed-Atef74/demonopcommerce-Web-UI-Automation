@smoke
Feature: User can change the selected currency
  Scenario: Logged User could switch between currencies US-Euro
    Given The user is logged in
    Then The products price should appear with the Dollar symbol
    When User sets the currency to Euro
    Then The products price should appear with the Euro symbol
