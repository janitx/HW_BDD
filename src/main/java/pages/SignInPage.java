package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "(//input[@type='email'])[1]")
    private WebElement emailField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Sign In')]")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(final String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(final String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }
}
