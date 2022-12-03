@smoke
  Feature: User could search the website for a specific product
    Scenario Outline: Logged User could search for any product
      Given The user is logged in
      When User enters "<searchText>" in the search field
      And Clicks on search button
      Then The related results should contain the "<searchText>"
      Examples:
      |searchText|
      |laptop|
      |apple |
      |nike  |
