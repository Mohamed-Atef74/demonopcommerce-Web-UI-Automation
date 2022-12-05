@smoke
Feature: User can select subcategories of different categories
  Scenario: Logged user could select different Categories
    Given The user is logged in
    When User hovers on a random category
    And Clicks on a random subcategory if found or the category itself if there's no subcategory
    Then User should be redirected to the selected page correctly
