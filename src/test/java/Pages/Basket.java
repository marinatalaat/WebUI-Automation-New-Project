package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Helper.Utils.ClickOnElement;
import static Helper.Utils.GetDataInCell;

public class Basket{

    // By Locators and driver
    private WebDriver driver;
    private WebDriverWait wait;

    private final By ProceedBtn = By.xpath("//a[@class='checkout-button button alt wc-forward']");
    private final By ProductTable = By.xpath("//table[@class='shop_table shop_table_responsive cart']");


    //Constructor
    public Basket(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    //Actions

@Step("Click on Proceed to checkout CTA")
    public Checkout ClickOnProceedToCheckOut(){
        ClickOnElement(driver, wait, ProceedBtn);
        return new Checkout(driver);
    }



    //Validations

@Step("Validate on Product name in Basket Page")
    public Basket ValidateOnBookNameInBasketPage(String bookName){
    Assert.assertEquals(GetDataInCell(driver, wait, 1,2,ProductTable), bookName);
        return this;
    }

@Step("Validate on price in Basket page")
    public Basket ValidateOnBookPriceInBasketPage(String bookPrice){
        Assert.assertTrue(GetDataInCell(driver, wait, 1,3,ProductTable).contains(bookPrice));
        return this;
    }
}
