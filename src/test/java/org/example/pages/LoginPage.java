package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement loginLink(){
        return Hooks.driver.findElement(By.className("ico-login"));
    }

    public WebElement email(){
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement password(){
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement loginButton(){
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }

    public WebElement loginError(){
        return Hooks.driver.findElement(By.cssSelector("[class=\"message-error validation-summary-errors\"]"));
    }

    public WebElement myAccount(){
        return Hooks.driver.findElement(By.className("ico-account"));
    }

    public WebElement forgotPassword(){
        return Hooks.driver.findElement(By.linkText("Forgot password?"));
    }

    public WebElement recoverButton(){
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 password-recovery-button\"]"));
    }

    public WebElement successMessage(){
        return Hooks.driver.findElement(By.className("content"));
    }
}
