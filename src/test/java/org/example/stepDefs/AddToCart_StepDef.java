package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.ProductsPage;
import org.testng.asserts.SoftAssert;

public class AddToCart_StepDef {
    HomePage homeElements = new HomePage();
    ProductsPage productsPageElements = new ProductsPage();
    CartPage cartPageElements = new CartPage();
    SoftAssert soft = new SoftAssert();
    String product1;
    String product2;

    @When("User adds a product to the cart")
    public void addToCart() {
        product1 = homeElements.searchResultsTitle().get(0).getText();
        productsPageElements.addToCartButton().get(0).click();
    }

    @When("User adds another product to the cart")
    public void addAnotherToCart() throws InterruptedException {
        product2 = homeElements.searchResultsTitle().get(1).getText();
        productsPageElements.addToCartButton().get(1).click();
        Thread.sleep(2000);
    }

    @Then("The product should be added to the cart successfully")
    public void successfullyAddedToCart(){
        soft.assertTrue(productsPageElements.successMessage().getText().contains("The product has been added to your shopping cart"), "Product added successfully assertion");
        soft.assertAll();
    }

    @And("The cart should contain the added products")
    public void openCart(){
        soft.assertFalse(homeElements.cartQuantity().getText().contains("0"),"Cart quantity assertion");
        homeElements.cart().click();
        soft.assertTrue(cartPageElements.cartProducts().getText().contains(product1),"Product 1 assertion");
        soft.assertTrue(cartPageElements.cartProducts().getText().contains(product2),"Product 2 assertion");
        soft.assertAll();
    }
}
