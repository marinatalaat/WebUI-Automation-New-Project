package Pages;

import static Helper.Utils.*;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage {

    // By Locators and driver
    private WebDriver driver;
    private WebDriverWait wait;
    private final By BookTitle= By.xpath("//h1[@class='product_title entry-title']");
    private final By Price= By.xpath("//*[@class='price']/ins/span");
    private final By AddToBasketBtn= By.xpath("//button[@class='single_add_to_cart_button button alt']");


    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    // Actions

    @Step("add book to basket")
    public HomePage AddToBasket(){
        ClickOnElement(driver,wait,AddToBasketBtn);
        return new HomePage(driver);
    }

    //Assertions

    @Step("Validate on book title in basket page")
    public ProductPage ValidateOnBookTitleInDetailsPage(String bookTitle){
        waitVisibilityOfElement(wait, BookTitle);
        Assert.assertEquals(driver.findElement(BookTitle).getText(), bookTitle);
        return this;
    }

    @Step("Validate on book price in basket page")
    public ProductPage ValidateOnBookPriceInDetailsPage(String bookPrice){
        waitVisibilityOfElement(wait, Price);
        Assert.assertTrue(driver.findElement(Price).getText().contains(bookPrice));
        return this;
    }

}
