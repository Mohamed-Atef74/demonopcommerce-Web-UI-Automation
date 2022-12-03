package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.testng.asserts.SoftAssert;

public class CreateOrder_StefDef {
    HomePage homeElements = new HomePage();
    CartPage cartPageElements = new CartPage();
    CheckoutPage checkoutElements = new CheckoutPage();
    OrdersPage ordersPageElements = new OrdersPage();
    SoftAssert soft = new SoftAssert();
    String orderNumber;

    @And("User has a product in the shopping cart")
    public void shoppingCart(){
        homeElements.addToCartButton().get(2).click();
        homeElements.cart().click();
    }

    @When("The user accepts the terms of service and goes to the checkout page")
    public void acceptAndCheckout(){
        cartPageElements.termsCheckbox().click();
        cartPageElements.checkoutButton().click();
    }

    @And("Fills in the billing address")
    public void fillBillingAddress(){
        if(!checkoutElements.billingAddress().getText().contains("Select a billing address from your address book or enter a new address.")) {
            checkoutElements.country().selectByValue("1");
            checkoutElements.state().selectByValue("1");
            checkoutElements.city().sendKeys("Chicago");
            checkoutElements.address().sendKeys("Apartment 1024");
            checkoutElements.zipCode().sendKeys("13614");
            checkoutElements.phoneNumber().sendKeys("0123456789");
        }
        checkoutElements.continueToShippingMethod().click();
    }

    @And("Selects the shipping method")
    public void selectShippingMethod(){
        checkoutElements.continueToPaymentMethod().click();
    }

    @And("Selects the payment method")
    public void selectPaymentMethod(){
        checkoutElements.continueToPaymentInformation().click();
    }

    @And("Reviews the payment information")
    public void reviewPaymentInformation(){
        checkoutElements.continueToConfirmOrder().click();
    }

    @And("Confirms the order")
    public void confirmOrder(){
        checkoutElements.confirmOrder().click();
    }

    @Then("The order should be created successfully")
    public void orderCreatedSuccessfully(){
        soft.assertTrue(checkoutElements.successMessage().getText().contains("Your order has been successfully processed!"),"Success message assertion");
        orderNumber = checkoutElements.orderNumber().getText().toLowerCase();
        soft.assertAll();
    }

    @And("The orders list should contain the created order")
    public void ordersList(){
        homeElements.ordersPage().click();
        soft.assertTrue(ordersPageElements.createdOrders().getText().toLowerCase().contains(orderNumber), "Order exists assertion");
        soft.assertAll();
    }
}
