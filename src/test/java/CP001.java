import config.Config;
import org.testng.annotations.Test;
import pageObject.Login_page;

/**
 * Go to https://app.auditate.mx/
 * Login successfully
 *
 */

public class CP001 extends Config {

    @Test(testName = "TestCase001", description = "validate a successful search and get the numbers of links")
    public void searchFunction() {
        Login_page login = new Login_page(driver);
        login.successLogin("ashprod","arantza@cbqasolutions.com","Admin123.");
    }
}
