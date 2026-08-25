package pages.ios;

import org.openqa.selenium.WebDriver;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;

public class IOSHomePage extends HomePage {

    public IOSHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return "";
    }

}
