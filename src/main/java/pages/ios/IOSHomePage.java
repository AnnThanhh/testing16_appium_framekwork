package pages.ios;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;

public class IOSHomePage extends HomePage {
    @iOSXCUITFindBy(accessibility = "title")
    private WebElement titleHomePage;

    public IOSHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return getElementText(titleHomePage);
    }

}
