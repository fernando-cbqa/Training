package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class Login_page {

    private final WebDriver driver;

    By searchBar = By.name("q");

    public Login_page(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys(text, Keys.RETURN);
    }

    public void validateNumbersOfLinks() {
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='yuRUbf']/a"));
        System.out.println(links.size() + " Links in Page 1");
    }

    public void clickOnNextLink(String numero) {
        driver.get("https://www.chess.com/es");
    }
}