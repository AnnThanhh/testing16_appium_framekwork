package pages.abstracts.components;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class HeaderComponent extends BasePage {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public abstract void clickMenuBtn();

    public abstract void navigateToLoginPage();
}
