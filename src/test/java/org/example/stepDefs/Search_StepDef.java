package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.example.stepDefs.Hooks.*;

public class Search_StepDef {

    @When("User enters {string} in the search field")
    public void enterSearchText(String searchText){
        homeElements.searchField().sendKeys(searchText);
    }

    @And("Clicks on search button")
    public void clickSearch(){
        homeElements.searchButton().click();
    }

    @Then("The related results should contain the {string}")
    public void searchResults(String searchText){
        for (int i = 0; i<homeElements.searchResultsTitle().size(); i++)
            soft.assertTrue(homeElements.searchResultsTitle().get(i).getText().toLowerCase().contains(searchText) , "Search results assertion");

        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("search"), "URL assertion");
        soft.assertAll();
    }

    @And("Opens the product's page")
    public void openProductPage(){
        homeElements.searchResults().get(0).click();

    }

    @Then("The product's page should contain the entered {string}")
    public void skuName(String sku){
        soft.assertEquals(productsPageElements.sku().getText(),sku,"SKU assertion");
        soft.assertAll();
    }
}
