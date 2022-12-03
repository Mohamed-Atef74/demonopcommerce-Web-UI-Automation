package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.RegisterPage;
import org.testng.asserts.SoftAssert;

public class Register_StepDef {

    RegisterPage registerElements = new RegisterPage();
    SoftAssert soft = new SoftAssert();

    @Given("User is on the registration page")
    public void openRegistrationPage(){
        registerElements.registerLink().click();
    }

    @When("User selects a gender")
    public void selectGender(){
        registerElements.gender().click();
    }

    @And("Enters a first name")
    public void enterFirstName(){
        registerElements.firstName().sendKeys("Test");
    }

    @And("Enters a last name")
    public void enterLastName(){
        registerElements.lastName().sendKeys("Automation");
    }

    @And("Enters a date of birth")
    public void enterDateOfBirth(){
        registerElements.dateOfBirth_Day().selectByValue("12");
        registerElements.dateOfBirth_Month().selectByValue("7");
        registerElements.dateOfBirth_Year().selectByValue("1998");
    }

    @And("Enters an email")
    public void enterEmail(){
        registerElements.email().sendKeys("Test123@test.com");
    }

    @And("Enters a password")
    public void enterPassword(){
        registerElements.password().sendKeys("Test@1234");
        registerElements.confirmPassword().sendKeys("Test@1234");
    }

    @And("Clicks on register button")
    public void clickRegister(){
        registerElements.registerButton().click();
    }

    @Then("User should be registered successfully")
    public void registeredSuccessfully(){
        String expectedResults1 = "Your registration completed";
        String expectedResults2 = "rgba(76, 177, 124, 1)";
        soft.assertEquals(registerElements.successMessage().getText() , expectedResults1 , "Success message assertion");
        soft.assertEquals(registerElements.successMessage().getCssValue("color") , expectedResults2 , "Color assertion");
        soft.assertAll();
    }
}
