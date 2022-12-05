@smoke
  Feature: User could search the website for a specific product
    Scenario Outline: Logged User could search for products using product name
      Given The user is logged in
      When User enters "<searchText>" in the search field
      And Clicks on search button
      Then The related results should contain the "<searchText>"
      Examples:
      |searchText|
      |laptop|
      |apple |
      |nike  |

      Scenario Outline: Logged User could search for products using sku
        Given The user is logged in
        When User enters "<sku>" in the search field
        And Clicks on search button
        And Opens the product's page
        Then The product's page should contain the entered "<sku>"
        Examples:
        |sku|
        |SCI_FAITH|
        |APPLE_CAM|
        |SF_PRO_11|
