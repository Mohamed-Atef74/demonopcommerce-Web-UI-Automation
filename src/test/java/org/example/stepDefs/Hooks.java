package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    public static RegisterPage registerElements = new RegisterPage();
    public static LoginPage loginElements = new LoginPage();
    public static HomePage homeElements = new HomePage();
    public static ProductsPage productsPageElements = new ProductsPage();
    public static CartPage cartPageElements = new CartPage();
    public static WishListPage wishListElements = new WishListPage();
    public static CompareListPage compareListElements = new CompareListPage();
    public static CheckoutPage checkoutElements = new CheckoutPage();
    public static OrdersPage ordersPageElements = new OrdersPage();
    public static SoftAssert soft = new SoftAssert();

    @Given("The user is logged in")
    public void loggedIn(){
        loginElements.loginLink().click();
        loginElements.email().sendKeys("Test123@test.com");
        loginElements.password().sendKeys("Test@1234");
        loginElements.loginButton().click();
    }

    @Before
    public static void openBrowser(){
        String driverLocation = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
}
