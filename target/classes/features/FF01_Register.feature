@smoke
Feature: User could register to the website
  Scenario: User registers with valid data successfully
    Given User is on the registration page
    When User selects a gender
    And Enters a first name
    And Enters a last name
    And Enters a date of birth
    And Enters an email
    And Enters a password
    And Clicks on register button
    Then User should be registered successfully