package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Checkout {

    // By Locators and driver
    private WebDriver driver;
    private WebDriverWait wait;

    private final By FirstName= By.id("billing_first_name");
    private final By LastName= By.id("billing_last_name");
    private final By CompanyName= By.id("billing_company");
    private final By BillingDetails= By.xpath("//*[@class='woocommerce-billing-fields']/h3");


    //Constructor
    public Checkout(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    //Validations

    @Step("Validate on Billing details title in checkout page")
    public Checkout ValidateOnBillingTitleInCheckoutPage() {
        Assert.assertTrue(driver.findElement(BillingDetails).isDisplayed(), "Validate on Billing details title in checkout page");
        return this;
    }

    @Step("Validate on first name in checkout page")
    public Checkout ValidateOnFirstNameInCheckoutPage() {
        Assert.assertTrue(driver.findElement(FirstName).isDisplayed(), "Validate on first name in checkout page");
        return this;
    }

    @Step("Validate on company name in checkout page")
    public Checkout ValidateOnCompanyNameInCheckoutPage() {
        Assert.assertTrue(driver.findElement(CompanyName).isDisplayed(), "Validate on company name in checkout page");
        return this;
    }

    @Step("Validate on last name in checkout page")
    public Checkout ValidateOnLastNameInCheckoutPage() {
        Assert.assertTrue(driver.findElement(LastName).isDisplayed(), "Validate on last name in checkout page");
        return this;
    }
}

