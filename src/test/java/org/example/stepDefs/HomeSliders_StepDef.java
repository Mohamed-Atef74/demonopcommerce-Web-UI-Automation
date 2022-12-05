package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.stepDefs.Hooks.*;

public class HomeSliders_StepDef {
    @When("The user clicks on the Ad in the home slider")
    public void clickOnAd(){
        homeElements.homeSlider().click();
    }

    @Then("The user should be redirected to the related lumia product page")
    public void lumiaProductPage(){

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
        soft.assertAll();
    }

    @When("The user switches the Ad in the home slider")
    public void switchAd() throws InterruptedException {
        homeElements.homeSlider2().click();
        Thread.sleep(1500);
    }

    @Then("The user should be redirected to the related iphone product page")
    public void iphoneProductPage(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                urlContains("https://demo.nopcommerce.com/iphone-6"));
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
        soft.assertAll();
    }
}
