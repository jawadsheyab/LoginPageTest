package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //WebElements
    private By userNameField = By.cssSelector("input[name='username']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton = By.cssSelector(".oxd-button.orangehrm-login-button");
    private By invalidErrorMsg = By.xpath("//p[contains(., 'Invalid')]");
    private By requiredErrorMsg = By.tagName("span");
    //private By requiredErrorMsg = By.cssSelector("span.oxd-input-field-error-message");

    //Constructor
    public LoginPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
    }

    //Methods
    public void addUserName(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(username);
    }

    public void addPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    //Invalid credentials Message
    public boolean isInvalidErrorMsgVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidErrorMsg));
        return driver.findElement(invalidErrorMsg).isDisplayed();
    }

    public boolean isRequiredErrorMsgVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrorMsg));
        return driver.findElement(requiredErrorMsg).isDisplayed();
    }

    public boolean isDuplicateRequiredMsgVisible() {
        List<WebElement> requiredErrorList = driver.findElements(requiredErrorMsg);
        for (int i = 0; i < requiredErrorList.size(); i++) {
            if (!requiredErrorList.get(i).isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
