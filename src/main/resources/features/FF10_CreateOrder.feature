@smoke
  Feature: User can create an order and checkout successfully
    Scenario: Create successful Order
      Given The user is logged in
      And User has a product in the shopping cart
      When The user accepts the terms of service and goes to the checkout page
      And Fills in the billing address
      And Selects the shipping method
      And Selects the payment method
      And Reviews the payment information
      And Confirms the order
      Then The order should be created successfully
      And The orders list should contain the created order