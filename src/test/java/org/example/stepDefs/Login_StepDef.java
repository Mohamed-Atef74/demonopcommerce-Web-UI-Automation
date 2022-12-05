package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.example.stepDefs.Hooks.*;

public class Login_StepDef {

    @Given("User is on the login page")
    public void openLoginPage(){
        loginElements.loginLink().click();
    }

    @When("User enters {string} as email and {string} as password")
    public void enterEmailAndPassword(String email, String password){
        loginElements.email().sendKeys(email);
        loginElements.password().sendKeys(password);
    }

    @And("Clicks on login button")
    public void clickLogin(){
        loginElements.loginButton().click();
    }

    @Then("User should be logged-in successfully")
    public void loggedinSuccessfully(){
        String expectedResults1 = "https://demo.nopcommerce.com/";
        soft.assertEquals(Hooks.driver.getCurrentUrl() , expectedResults1 , "URL assertion");
        soft.assertTrue(loginElements.myAccount().isDisplayed() , "My account tab assertion");
        soft.assertAll();
    }

    @Then("An error message should appear and user can't login")
    public void unSuccessfulLogin(){
        soft.assertTrue(loginElements.loginError().getText().contains("Login was unsuccessful"),"Error message assertion");
        soft.assertEquals(loginElements.loginError().getCssValue("color"),"rgba(228, 67, 75, 1)","Error message color assertion");
        soft.assertAll();
    }

    @When("User clicks on forgot password link")
    public void clickForgotPassword(){
        loginElements.forgotPassword().click();
    }

    @And("Enters the registered email")
    public void enterEmail(){
        loginElements.email().sendKeys("Test123@test.com");
    }

    @And("Clicks on recover button")
    public void clickRecover(){
        loginElements.recoverButton().click();
    }

    @Then("The password should be reset successfully")
    public void resetSuccessfully(){
        String expectedResults = "Email with instructions has been sent to you.";
        soft.assertEquals(loginElements.successMessage().getText() , expectedResults , "Sucess message assertion" );
        soft.assertAll();
    }
}
