package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    public WebElement searchField(){
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchButton(){
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }

    public List<WebElement> searchResults(){
        return Hooks.driver.findElements(By.cssSelector("div > div[class=\"product-item\"]"));
    }

    public List<WebElement> searchResultsTitle(){
        return Hooks.driver.findElements(By.cssSelector("div > h2[class=\"product-title\"]"));
    }

    public Select currency(){
        WebElement DDL = Hooks.driver.findElement(By.id("customerCurrency"));
        Select currencies = new Select(DDL);
        return currencies;
    }

    public List<WebElement> homeProductsTitle(){
        return Hooks.driver.findElements(By.cssSelector("div > h2[class=\"product-title\"]"));
    }

    public List<WebElement> homeProducts(){
        return Hooks.driver.findElements(By.cssSelector("div > div[class=\"product-item\"]"));
    }

    public List<WebElement> categories(){
        return Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li"));
    }

    public List<WebElement> subCategories(){
        return Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>ul>li"));
    }

    public WebElement shoesSubCategory(){
        return Hooks.driver.findElement(By.linkText("Shoes"));
    }

    public List<WebElement> addToCartButton(){
        return Hooks.driver.findElements(By.cssSelector("div[class=\"buttons\"]>button[class=\"button-2 product-box-add-to-cart-button\"]"));
    }

    public WebElement cart(){
        return Hooks.driver.findElement(By.linkText("shopping cart"));
    }

    public WebElement cartQuantity(){return Hooks.driver.findElement(By.className("cart-qty"));}

    public List<WebElement> addToWishListButton(){
        return Hooks.driver.findElements(By.cssSelector("div[class=\"buttons\"]>button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    public WebElement wishList(){
        return Hooks.driver.findElement(By.className("ico-wishlist"));
    }

    public WebElement wishListQuantity(){return Hooks.driver.findElement(By.className("wishlist-qty"));}

    public WebElement compareList(){
        return Hooks.driver.findElement(By.linkText("product comparison"));
    }

    public WebElement ordersPage(){
        return Hooks.driver.findElement(By.linkText("Orders"));
    }

    public WebElement homeSlider(){
        return Hooks.driver.findElement(By.id("nivo-slider"));
    }

    public WebElement homeSlider1(){
        return Hooks.driver.findElement(By.cssSelector("[rel=\"0\"]"));
    }
    public WebElement homeSlider2(){
        return Hooks.driver.findElement(By.cssSelector("[rel=\"1\"]"));
    }

    public WebElement socialMedia(String name){
        return Hooks.driver.findElement(By.linkText(name));
    }
}
