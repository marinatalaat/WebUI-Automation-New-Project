package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Helper.Utils.*;


public class HomePage {

    // By Locators and driver
    private WebDriver driver;
    private WebDriverWait wait;
    private final By SearchBox= By.id("s");
    private final By BookTitle= By.xpath("//*[@class='post-title entry-title']/a");
    private final By ShopCart= By.className("cartcontents");


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    // Actions


@Step ("Navigate to Home Page")
    public HomePage navigateToHomepage(String URL){
        driver.navigate().to(URL);
        waitVisibilityOfElement(wait, SearchBox);
        return this;
    }
@Step ("Search for a Book in home page")
    public HomePage SearchInHomePage(String KeyWord){
        driver.findElement(SearchBox).sendKeys(KeyWord);
        driver.findElement(SearchBox).sendKeys(Keys.ENTER);
        return this;
    }

@Step("Click on book to see its details")
    public ProductPage OpenBookDetails(){
        ClickOnElement(driver, wait, BookTitle);
        return new ProductPage(driver);
    }

@Step("Click on shop cart in the Home page")
    public Basket ClickOnShopCart(){
       ClickOnElement(driver, wait, ShopCart);
       return new Basket(driver);
    }



    // validations

    @Step("Validate on Book title in home page")
    public HomePage ValidateOnBookTitle(String bookTitle){
        waitVisibilityOfElement(wait, BookTitle);
        Assert.assertEquals(driver.findElement(BookTitle).getText(), bookTitle);
        return this;
    }

}
