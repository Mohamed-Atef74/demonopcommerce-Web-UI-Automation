package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.ProductsPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class Categories_StepDef {
    HomePage homeElements = new HomePage();
    ProductsPage productsPageElements = new ProductsPage();
    SoftAssert soft = new SoftAssert();
    Random random=new Random();
    String categoryName;
    String subCategoryName;
    int x = random.nextInt(7);
    int y;

    @When("User hovers on a random category")
    public void hoverOnCategory(){
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(homeElements.categories().get(x)).perform();
        categoryName = homeElements.categories().get(x).getText();
    }

    @And("Clicks on a random subcategory if found or the category itself if there's no subcategory")
    public void selectSubCategory(){
        if(x<=2) {
            if (categoryName.contains("Computers"))
                y = random.nextInt(3);
            else if (categoryName.contains("Electronics"))
                y = random.nextInt(3) + 3;
            else if (categoryName.contains("Apparel"))
                y = random.nextInt(3) + 6;
            subCategoryName = homeElements.subCategories().get(y).getText();
            homeElements.subCategories().get(y).click();
        }
        else
            homeElements.categories().get(x).click();
    }

    @Then("User should be redirected to the selected page correctly")
    public void categoryRedirection(){
        if (x<=2) {
            soft.assertEquals(productsPageElements.titleText().getText(), subCategoryName, "Subcategory name assertion");
        }
        else
            soft.assertEquals(productsPageElements.titleText().getText(),categoryName,"Category name assertion");
    }
}
