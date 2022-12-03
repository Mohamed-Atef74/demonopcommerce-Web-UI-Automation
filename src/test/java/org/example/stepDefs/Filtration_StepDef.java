package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.ProductsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class Filtration_StepDef {

    HomePage homeElements = new HomePage();
    ProductsPage productsPageElements = new ProductsPage();
    Random random = new Random();
    int x;
    String[] selectedTag = new String[3];
    String[] url = new String[3];
    String[] title = new String[3];
    SoftAssert soft = new SoftAssert();

    @And("The user opens the shoes subcategory from the apparel category")
    public void openShoesSubcategory(){
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(homeElements.categories().get(2)).perform();
        homeElements.shoesSubCategory().click();
    }

    @When("User filters the products by red color")
    public void filterByColor(){
        productsPageElements.colorFilter().click();
    }

    @Then("The products should be filtered according to the selected color")
    public void colorFilterApplied(){
        soft.assertTrue(productsPageElements.colorFilter().isSelected() , "Color checkbox assertion");
        soft.assertTrue(productsPageElements.redShoes().isDisplayed(),"Red shoes assertion");
        soft.assertAll();
    }

    @And("The user searches for something")
    public void search(){
        homeElements.searchField().sendKeys("laptop" , Keys.ENTER);
    }

    @When("The user selects a tag from the popular tags section")
    public void selectTag() throws InterruptedException {
        for (int i=0;i<3;i++) {
            x = random.nextInt(15);
            selectedTag[i] = productsPageElements.popularTags().get(x).getText();
            productsPageElements.popularTags().get(x).click();
            title[i] = productsPageElements.titleText().getText();
            url[i] = Hooks.driver.getCurrentUrl();
            Thread.sleep(1000);
        }
    }

    @Then("The products should be filtered according to the selected tag")
    public void selectedTagPage(){
        for (int i=0;i<3;i++) {
            soft.assertTrue(title[i].contains(selectedTag[i]), "Title assertion");
            soft.assertTrue(url[i].contains(selectedTag[i]), "URL assertion");
            soft.assertAll();
        }
    }
}
