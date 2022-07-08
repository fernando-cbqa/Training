package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Login_page {

    private final WebDriver driver;
    By searchBar = By.name("q");
    @FindBy(css = "input[placeholder='Alias de la Empresa']")
    WebElement InputAliasEmpresa;

    @FindBy(css = "input[placeholder='Correo Electrónico']")
    WebElement InputCorreoElectronico;

    @FindBy(css = "input[placeholder='Contraseña']")
    WebElement InputContrasena;

    @FindBy(css = "button[type=submit]")
    WebElement ButtonSubmit;

    @FindBy(id = "panel-settings-button")
    WebElement ButtonPanel;

    //TODO: Maintenance
    @FindBy(css = "button.sc-bUKjYF.joRqPq")
    WebElement Button;

    @FindBy(xpath = "//div[text()='Ocurrió un error']")
    WebElement TxtOcurrioUnError;

    //TODO: Maintenance
    @FindBy(id = "//div[@class='sc-bqiRlB kbNZbF']")
    WebElement TxtError;

    public Login_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void successLogin(String Alias, String Email, String Pass) {
        InputAliasEmpresa.sendKeys(Alias);
        InputCorreoElectronico.sendKeys(Email);
        InputContrasena.sendKeys(Pass);
        ButtonSubmit.click();
        //Validation to login successfully
        ButtonPanel.isDisplayed();
        //Assertions
        String CurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(CurrentUrl, "https://app.auditate.mx/panel/principal");
    }

    public void unsuccessLogin(String Alias, String Email,String Pass){
        InputAliasEmpresa.sendKeys(Alias);
        InputCorreoElectronico.sendKeys(Email);
        InputContrasena.sendKeys(Pass);
        ButtonSubmit.click();
        //Validation to login successfully
        TxtOcurrioUnError.isDisplayed();
        String textError = TxtError.getText();
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