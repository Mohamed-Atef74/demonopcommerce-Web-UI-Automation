package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    public WebElement cartProducts(){
        return Hooks.driver.findElement(By.className("cart"));
    }

    public WebElement termsCheckbox(){
        return Hooks.driver.findElement(By.id("termsofservice"));
    }

    public WebElement checkoutButton(){
        return Hooks.driver.findElement(By.id("checkout"));
    }
}
