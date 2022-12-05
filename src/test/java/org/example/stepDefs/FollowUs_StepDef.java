package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Set;

import static org.example.stepDefs.Hooks.*;

public class FollowUs_StepDef {

    String parentWindow;
    Set<String> allWindows;
    String[] currentWindow;

    @When("The user clicks on {string} button")
    public void clickOnSocialMediaButton(String socialMediaName) {
        parentWindow = driver.getWindowHandle();
        homeElements.socialMedia(socialMediaName).click();
    }

    @Then("The user should be redirected to the related {string}")
    public void openSocialMedia(String socialMediaLink) throws InterruptedException {
        Thread.sleep(2000);
        allWindows = driver.getWindowHandles();
        for (String currentWindow : allWindows)
            if (!currentWindow.equalsIgnoreCase(parentWindow))
                driver.switchTo().window(currentWindow);
        Assert.assertEquals(driver.getCurrentUrl(),socialMediaLink,"Social media link assertion");
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}
