package pages.android.components;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.components.HeaderComponent;

public class AndroidHeaderComponent extends HeaderComponent {
    @AndroidFindBy(accessibility = "View menu")
    private WebElement viewMenuBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log In\")")
    private WebElement loginBtn;

    public AndroidHeaderComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMenuBtn() {
       clickElement(viewMenuBtn);
    }

    @Override
    public void navigateToLoginPage() {
        // Scroll cho tới khi Log In xuất hiện
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"Log In\"))"
                )
        );

        clickElement(loginBtn);
    }
}
