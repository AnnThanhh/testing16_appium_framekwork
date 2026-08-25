package pages.android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.HomePage;

public class AndroidHomePage  extends HomePage {
    @AndroidFindBy(accessibility = "title")
    private WebElement titleHomePage;

    public AndroidHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return getElementText(titleHomePage);
    }
}
