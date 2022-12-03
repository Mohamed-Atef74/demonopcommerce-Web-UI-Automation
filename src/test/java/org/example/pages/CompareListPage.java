package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CompareListPage {

    public WebElement compareListProducts(){
        return Hooks.driver.findElement(By.className("page-body"));
    }

}
