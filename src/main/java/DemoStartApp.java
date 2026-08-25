import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //bước 1: click menu
        By byMenu = AppiumBy.accessibilityId("View menu");
        WebElement mainMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(byMenu));
        mainMenu.click();

        //bước 2: click btn login
        By byLoginBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"Log In\")");
        //dành cho máy small, thì cuộn xuống cho đến khi thấy button login
//        By byLoginBtn = AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollIntoView(new UiSelector().text(\"Log In\"))"
//        );

        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn));
        loginBtn.click();

        //bước 3: nhập username và password
        By byUsername = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/nameET\")");
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(byUsername));
        usernameInput.sendKeys("bod@example.com");

        By byPassword = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/passwordET\")");
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword));
        passwordInput.sendKeys("10203040");

        //bước 4: click btn login ở page login
        By byLoginBtnPage = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/loginBtn\")");
        WebElement loginBtnPage = wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtnPage));
        loginBtnPage.click();

        Thread.sleep(2000);

        driver.quit();
    }
}
