package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class PlatformUtil {
    public static boolean isAndroid(WebDriver driver){
        if(driver instanceof AndroidDriver){
            return true;
        } else {
            return false;
        }
    }
}
