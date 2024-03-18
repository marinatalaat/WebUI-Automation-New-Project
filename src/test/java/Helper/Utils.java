package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Utils {


    public static void ClickOnElement(WebDriver driver, WebDriverWait wait, By Element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
        driver.findElement(Element).click();
    }

    public static void waitVisibilityOfElement(WebDriverWait wait, By Element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
    }

    public static String GetDataInCell(WebDriver driver, WebDriverWait wait, int rowNum, int ColNum, By TableElement){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TableElement));
        List<WebElement> TableRows = driver.findElement(TableElement).findElements(By.tagName("tr"));
        return TableRows.get(rowNum).findElements(By.tagName("td")).get(ColNum).getText();
    }

}
