package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.example.stepDefs.Hooks.*;

public class CompareList_StepDef {

    String product1;
    String product2;

    @When("The user adds a product to the compare list")
    public void addToCompareList() {
        product1 = homeElements.searchResultsTitle().get(0).getText();
        productsPageElements.addToCompareListButton().get(0).click();
    }

    @When("The user adds another product to the compare list")
    public void addAnotherToCompareList() throws InterruptedException {
        product2 = homeElements.searchResultsTitle().get(1).getText();
        productsPageElements.addToCompareListButton().get(1).click();
        Thread.sleep(1000);
    }

    @Then("The product should be added to the compare list successfully")
    public void successfullyAddedToCompareList(){
        soft.assertTrue(productsPageElements.successMessage().getText().contains("The product has been added to your product comparison"),"Success message assertion");
        soft.assertAll();
    }

    @And("The compare list should contain the added products")
    public void compareList(){
        homeElements.compareList().click();
        soft.assertTrue(compareListElements.compareListProducts().getText().contains(product1),"Product 1 assertion");
        soft.assertTrue(compareListElements.compareListProducts().getText().contains(product2),"Product 2 assertion");
        soft.assertAll();
    }
}
