package pages.abstracts;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import pages.PageFactory;
import pages.abstracts.components.HeaderComponent;

public class CommonPage extends BasePage {
    private HeaderComponent headerComponent;

    public  CommonPage(WebDriver driver){
        super(driver);
        this.headerComponent = PageFactory.getHeaderComponent(driver);
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }
}
