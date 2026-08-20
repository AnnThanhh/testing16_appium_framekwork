import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class DemoStartApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName("Android");
        androidOptions.setAutomationName("Uiautomator2");
        androidOptions.setUdid("emulator-5554"); //deviceName
        androidOptions.setPlatformVersion("15");
        androidOptions.setAppPackage("com.saucelabs.mydemoapp.android");
        androidOptions.setAppActivity("com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), androidOptions);

        Thread.sleep(5000);

        driver.quit();
    }
}
