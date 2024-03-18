package Tests;

import Helper.PropertiesLoader;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class AddBookToCartTest {

    String FilePath="Config/Data.properties";
    String URL= PropertiesLoader.readPropertyFile(FilePath).getProperty("URL");
    public WebDriver driver;
    String BookName = PropertiesLoader.readPropertyFile(FilePath).getProperty("BookName");
    String BookPrice = PropertiesLoader.readPropertyFile(FilePath).getProperty("BookPrice");


    @Test()
    public void AddBookToCart() {
        new HomePage(driver).SearchInHomePage(BookName)
                .OpenBookDetails().AddToBasket()
                .ClickOnShopCart().
                ValidateOnBookNameInBasketPage(BookName).ValidateOnBookPriceInBasketPage(BookPrice)
                .ClickOnProceedToCheckOut()
                .ValidateOnBillingTitleInCheckoutPage()
                .ValidateOnFirstNameInCheckoutPage().ValidateOnLastNameInCheckoutPage()
                .ValidateOnCompanyNameInCheckoutPage();
    }


    // Configurations
    @BeforeClass
    @Parameters({"BrowserName"})
    public void startDriver(String BrowserName) {
        if(BrowserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(BrowserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        new HomePage(driver).navigateToHomepage(URL);
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }
}
