package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    public Select country(){
        WebElement DDL = Hooks.driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select country = new Select(DDL);
        return country;
    }

    public Select state(){
        WebElement DDL = Hooks.driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        Select state = new Select(DDL);
        return state;
    }

    public WebElement city(){
        return Hooks.driver.findElement(By.id("BillingNewAddress_City"));
    }

    public WebElement address(){
        return Hooks.driver.findElement(By.id("BillingNewAddress_Address1"));
    }

    public WebElement zipCode(){
        return Hooks.driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
    }

    public WebElement phoneNumber(){
        return Hooks.driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
    }

    public WebElement continueToShippingMethod(){
        return Hooks.driver.findElement(By.cssSelector("div > button[class=\"button-1 new-address-next-step-button\"]"));
    }

    public WebElement billingAddress(){
        return Hooks.driver.findElement(By.id("opc-billing"));
    }

    public WebElement continueToPaymentMethod(){
        return Hooks.driver.findElement(By.cssSelector("div > button[class=\"button-1 shipping-method-next-step-button\"]"));
    }

    public WebElement continueToPaymentInformation(){
        return Hooks.driver.findElement(By.cssSelector("div > button[class=\"button-1 payment-method-next-step-button\"]"));
    }

    public WebElement continueToConfirmOrder(){
        return Hooks.driver.findElement(By.cssSelector("div > button[class=\"button-1 payment-info-next-step-button\"]"));
    }

    public WebElement confirmOrder(){
        return Hooks.driver.findElement(By.cssSelector("div > button[class=\"button-1 confirm-order-next-step-button\"]"));
    }

    public WebElement successMessage(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"section order-completed\"] > div > strong"));
    }

    public WebElement orderNumber(){
        return Hooks.driver.findElement(By.className("order-number"));
    }
}
