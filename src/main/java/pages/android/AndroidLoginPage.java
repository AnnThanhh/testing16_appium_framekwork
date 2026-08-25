package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.LoginPage;

public class AndroidLoginPage extends LoginPage {
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/nameET\")")
    private WebElement usernameField;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/passwordET\")")
    private WebElement passwordField;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/loginBtn\")")
    private WebElement loginButton;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterUsername(String username) {
        inputText(usernameField, username);
    }

    @Override
    public void enterPassword(String password) {
        inputText(passwordField, password);
    }

    @Override
    public void enterCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }

    @Override
    public void clickLoginButton() {
        clickElement(loginButton);
    }
}
