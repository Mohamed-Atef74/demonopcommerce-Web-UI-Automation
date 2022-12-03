package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrdersPage {
    public WebElement createdOrders(){
        return Hooks.driver.findElement(By.className("order-list"));
    }
}
