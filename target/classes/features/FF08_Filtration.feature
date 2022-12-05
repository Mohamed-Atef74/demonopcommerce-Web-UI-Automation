@smoke
Feature: User could filter the products with color and with different tags

  Scenario: Logged user could filter with color
    Given The user is logged in
    And The user opens the shoes subcategory from the apparel category
    When User filters the products by red color
    Then The products should be filtered according to the selected color

  Scenario: Logged user could select different tags
    Given The user is logged in
    And The user searches for something
    When The user selects a tag from the popular tags section
    Then The products should be filtered according to the selected tag
