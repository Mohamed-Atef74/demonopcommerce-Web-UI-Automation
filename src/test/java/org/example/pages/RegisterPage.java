package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    Hooks hook = new Hooks();

    public WebElement registerLink(){
        return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }

    public WebElement gender(){
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement firstName(){
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName(){
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public Select dateOfBirth_Day(){
        WebElement DDL = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select birthDay = new Select(DDL);
        return birthDay;
    }

    public Select dateOfBirth_Month(){
        WebElement DDL = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        Select birthMonth = new Select(DDL);
        return birthMonth;
    }

    public Select dateOfBirth_Year(){
        WebElement DDL = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        Select birthYear = new Select(DDL);
        return birthYear;
    }

    public WebElement email(){
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement password(){
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassword(){
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerButton(){
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement successMessage(){
        return Hooks.driver.findElement(By.className("result"));
    }

}
