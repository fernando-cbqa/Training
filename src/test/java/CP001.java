import config.Config;
import org.testng.annotations.Test;
import pageObject.Login_page;

/**
 * Go to https://www.google.com/
 * Enter the term "cheese"
 * Click on  “Google Search” button
 * Get and print the number of links from the first page
 * Click on second link
 */

public class CP001 extends Config {

    @Test(testName = "TestCase001", description = "validate a successful search and get the numbers of links")
    public void searchFunction() {
        Login_page login = new Login_page(driver);
        login.search("Chess");
        login.validateNumbersOfLinks();
        login.clickOnNextLink("Chess.com - Play Chess Online - Free Games");
    }
}
