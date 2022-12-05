package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.example.stepDefs.Hooks.*;

import java.time.Duration;

public class WishList_StepDef {
    String product;

    @When("The user clicks on the heart icon for a product")
    public void addToWishList(){
        product = homeElements.homeProductsTitle().get(2).getText();
        homeElements.addToWishListButton().get(2).click();
    }

    @Then("The product should be added to the wishlist successfully")
    public void successfullyAddedToWishList(){
        soft.assertTrue(productsPageElements.successMessage().getText().contains("The product has been added to your wishlist"),"Success message assertion");
        soft.assertEquals(productsPageElements.successMessage().getCssValue("background-color"),"rgba(75, 176, 122, 1)","Color assertion");
        soft.assertAll();
    }

    @And("The wishlist should contain the product")
    public void openWishList(){
        soft.assertFalse(homeElements.wishListQuantity().getText().contains("0"),"Wishlist quantity assertion");
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOf(productsPageElements.successMessage()));
        homeElements.wishList().click();
        soft.assertTrue(wishListElements.wishListProducts().getText().contains(product),"Product assertion");
        soft.assertAll();
    }
}
