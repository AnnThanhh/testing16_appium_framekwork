package pages.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.LoginPage;

import java.util.Map;

public class IOSLoginPage extends LoginPage {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"User Name\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement accountNameInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private WebElement passwordInput;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
    private WebElement loginBtn;

    @iOSXCUITFindBy(xpath= "(//XCUIElementTypeStaticText[@name=\"Login\"])[1]")
    private WebElement loginPageTitle;

    public IOSLoginPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void enterUsername(String username) {
        inputText(accountNameInput, username);
    }

    @Override
    public void enterPassword(String password) {
        inputText(passwordInput, password);
    }

    @Override
    public void enterCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }

    @Override
    public void clickLoginButton() {
        ((IOSDriver) driver).hideKeyboard();

//        IOSDriver iosDriver = (IOSDriver) driver;
//        // tap vào vùng phía trên keyboard để đóng keyboard
//        iosDriver.executeScript("mobile: tap", Map.of(
//                "x", 200,
//                "y", 200
//        ));

        clickElement(loginPageTitle);

        clickElement(loginBtn);
    }
}