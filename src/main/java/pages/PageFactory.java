package pages;

import org.openqa.selenium.WebDriver;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;
import pages.abstracts.components.HeaderComponent;
import pages.android.AndroidHomePage;
import pages.android.AndroidLoginPage;
import pages.android.components.AndroidHeaderComponent;
import pages.ios.IOSHomePage;
import pages.ios.IOSLoginPage;
import pages.ios.components.IOSHeaderComponent;
import utils.PlatformUtil;

public class PageFactory {
    public static HeaderComponent getHeaderComponent(WebDriver driver){
        if(PlatformUtil.isAndroid(driver)){
            return new AndroidHeaderComponent(driver);
        }else{
            return new IOSHeaderComponent(driver);
        }
    }

    public static HomePage getHomePage(WebDriver driver){
        if(PlatformUtil.isAndroid(driver)){
            return new AndroidHomePage(driver);
        }else{
            return new IOSHomePage(driver);
        }
    }

    public static LoginPage getLoginPage(WebDriver driver){
        if(PlatformUtil.isAndroid(driver)){
            return new AndroidLoginPage(driver);
        }else{
            return new IOSLoginPage(driver);
        }
    }

}
