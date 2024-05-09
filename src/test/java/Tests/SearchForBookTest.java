package Tests;

import Helper.ExcelFileUtils;
import Helper.PropertiesLoader;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class SearchForBookTest {

    String FilePath="Config/Data.properties";
    String URL= PropertiesLoader.readPropertyFile(FilePath).getProperty("URL");
    public WebDriver driver;


    @DataProvider(name = "Book details data")
    public Object[][]bookDetailsData(){
        return new Object[][]{
                {"Android Quick Start Guide","450.00"},
                {"Thinking in HTML","400.00"}
        };
    }

    @DataProvider(name = "Book details data from Excel file")
    public Object[][]bookDetailsDataFromExcelSheet() throws IOException {
        return new ExcelFileUtils("TestDataSheet/TestDataFirst.xlsx","Sheet1").readFromExcelFile(0,0);
    }


//    @Test(dataProvider = "Book details data")
    @Test(dataProvider = "Book details data from Excel file")
    public void SearchForBook(String BookName, String BookPrice) {
        new HomePage(driver).
                SearchInHomePage(BookName).
                ValidateOnBookTitle(BookName);

        new HomePage(driver).OpenBookDetails().
                ValidateOnBookTitleInDetailsPage(BookName).
                ValidateOnBookPriceInDetailsPage(BookPrice);
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
