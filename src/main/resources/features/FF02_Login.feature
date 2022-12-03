@smoke
  Feature: User could login to the website and reset his password

    Scenario: User could log in with valid email and password
      Given User is on the login page
      When User enters a valid email and password
      And Clicks on login button
      Then User should be logged-in successfully

    Scenario: User could reset his/her password successfully
      Given User is on the login page
      When User clicks on forgot password link
      And Enters the registered email
      And Clicks on recover button
      Then The password should be reset successfully