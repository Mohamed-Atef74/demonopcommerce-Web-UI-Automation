package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    public WebElement titleText(){
        return Hooks.driver.findElement(By.className("page-title"));
    }

    public WebElement colorFilter(){
        return Hooks.driver.findElement(By.id("attribute-option-15"));
    }

    public WebElement redShoes(){
        return Hooks.driver.findElement(By.linkText("adidas Consortium Campus 80s Running Shoes"));
    }

    public List<WebElement> popularTags(){
        return Hooks.driver.findElements(By.cssSelector("div[class=\"tags\"]>ul>li"));
    }

    public List<WebElement> addToCartButton(){
        return Hooks.driver.findElements(By.cssSelector("div[class=\"buttons\"]>button[class=\"button-2 product-box-add-to-cart-button\"]"));
    }

    public WebElement successMessage(){
        return Hooks.driver.findElement(By.cssSelector("div>[class=\"bar-notification success\"]"));
    }

    public List<WebElement> addToCompareListButton(){
        return Hooks.driver.findElements(By.cssSelector("div[class=\"buttons\"]>button[class=\"button-2 add-to-compare-list-button\"]"));
    }

}
