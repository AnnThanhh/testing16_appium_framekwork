package drivers;

import io.appium.java_client.AppiumDriver;

public abstract class DriverManager {
    protected AppiumDriver driver;

    public abstract void createDriver();

    public AppiumDriver getDriver() {
        return driver;
    }
}
