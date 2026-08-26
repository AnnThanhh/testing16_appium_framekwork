package pages.ios.components;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.components.HeaderComponent;

public class IOSHeaderComponent extends HeaderComponent {
    @iOSXCUITFindBy(accessibility = "More-tab-item")
    private WebElement mainMenuBtn;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    private WebElement loginMenuBtn;

    public IOSHeaderComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenuBtn() {
        clickElement(mainMenuBtn);
    }

    @Override
    public void navigateToLoginPage() {
        clickElement(loginMenuBtn);
    }
}
