package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.SignInPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {


    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks sign in icon visibility")
    public void checkSignInLinkVisibility() {
        homePage.isSignInLinkVisible();
    }

    @When("User clicks on 'sign in' link")
    public void clickSignInLink() {
        homePage.clickSignInLink();
    }

    @Then("User checks email and password fields visibility")
    public void checkEmailVisibility() {
        signInPage = pageFactoryManager.getSignInPage();
        assertTrue(signInPage.isEmailFieldVisible());
        assertTrue(signInPage.isPasswordFieldVisible());

    }

    @And("User enter {string} into email field")
    public void enterEmailIntoSearchField(final String email) {

        signInPage.enterEmail(email);
    }

    @And("User enter {string} into password field")
    public void enterPasswordIntoSearchField(final String password) {
        signInPage.enterPassword(password);
    }

    @And("User click on 'sign in' button")
    public void clickSignInButton() {
        signInPage.clickSignInButton();
    }

    @And("User checks that current url {string}")
    public void checkCurrentUrl(final String word) {

        assertTrue(driver.getCurrentUrl().contains(word));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
