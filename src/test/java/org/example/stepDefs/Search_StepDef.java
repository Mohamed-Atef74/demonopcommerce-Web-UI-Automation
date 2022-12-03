package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.asserts.SoftAssert;

public class Search_StepDef {

    HomePage homeElements = new HomePage();
    LoginPage loginElements = new LoginPage();
    SoftAssert soft = new SoftAssert();



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
}
