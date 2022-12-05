package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.example.stepDefs.Hooks.*;

public class Currencies_StepDef {

    @Then("The products price should appear with the Dollar symbol")
    public void productPriceCurrencyInDollars(){
        for (int i=0; i<homeElements.homeProducts().size(); i++) {
            soft.assertTrue(homeElements.homeProducts().get(i).getText().contains("$"), "Dollar currency symbol assertion");
            System.out.println(homeElements.homeProducts().get(i).getText());
        }

        soft.assertAll();
    }

    @When("User sets the currency to Euro")
    public void selectEuroCurrency(){
        homeElements.currency().selectByVisibleText("Euro");
    }

    @Then("The products price should appear with the Euro symbol")
    public void productPriceCurrencyInEuros() throws InterruptedException {
        for (int i=0; i<homeElements.homeProducts().size(); i++)
            soft.assertTrue(homeElements.homeProducts().get(i).getText().contains("€") ,"Euro currency symbol assertion");

        soft.assertAll();
    }

}
