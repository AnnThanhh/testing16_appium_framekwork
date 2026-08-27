package drivers;

import io.appium.java_client.AppiumDriver;

public abstract class DriverManager {
    protected static AppiumDriver driver;

    public abstract void createDriver();

    public static AppiumDriver getDriver() {
        return driver;
    }
}
