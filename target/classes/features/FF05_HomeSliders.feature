@smoke
Feature: Home slider contains Ads for some products and the user can interact with it
  Scenario: User can open the product's page from it's Ad in the home slider
    When The user clicks on the Ad in the home slider
    Then The user should be redirected to the related lumia product page

  Scenario: User can open different products from their Ad in the home slider
    When The user switches the Ad in the home slider
    And The user clicks on the Ad in the home slider
    Then The user should be redirected to the related iphone product page