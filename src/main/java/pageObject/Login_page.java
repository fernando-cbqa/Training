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

    public void successLogin(String Alias, String Email,String Pass){
        driver.findElement(By.cssSelector("input[placeholder='Alias de la Empresa']")).sendKeys(Alias);
        driver.findElement(By.cssSelector("input[placeholder='Correo Electrónico']")).sendKeys(Email);
        driver.findElement(By.cssSelector("input[placeholder='Contraseña']")).sendKeys(Pass);
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        //Validation to login successfully
        driver.findElement(By.id("panel-settings-button")).isDisplayed();
        driver.findElement(By.cssSelector("button.sc-bUKjYF.joRqPq")).isDisplayed();
        //Assertions
        String CurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(CurrentUrl,"https://app.auditate.mx/panel/principal");
    }

    public void unsuccessLogin(String Alias, String Email,String Pass){
        driver.findElement(By.cssSelector("input[placeholder='Alias de la Empresa']")).sendKeys(Alias);
        driver.findElement(By.cssSelector("input[placeholder='Correo Electrónico']")).sendKeys(Email);
        driver.findElement(By.cssSelector("input[placeholder='Contraseña']")).sendKeys(Pass);
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        //Validation to login successfully
        driver.findElement(By.xpath("//div[text()='Ocurrió un error']")).isDisplayed();
        String textError = driver.findElement(By.xpath("//div[@class='sc-bqiRlB kbNZbF']")).getText();
        Assert.assertEquals(textError,"Ocurrió un error");
    }
    public void search(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys(text, Keys.ENTER);
    }

    public void validateNumbersOfLinks() {
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='yuRUbf']/a"));
        System.out.println(links.size() + " Links in Page 1");
    }

    public void clickOnNextLink(String numero) {
        driver.get("https://www.chess.com/es");
    }
}