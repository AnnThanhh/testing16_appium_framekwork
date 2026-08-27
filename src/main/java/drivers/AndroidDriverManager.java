package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigManager;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        ConfigManager.loadProperties();

        String platform = ConfigManager.getProperty("platform");
        String UiAutomator2 = ConfigManager.getProperty("automationName");
        String udid = ConfigManager.getProperty("android.udid");
        String platformVersion = ConfigManager.getProperty("android.platformVersion");
        String appPackage = ConfigManager.getProperty("android.package");
        String appActivity = ConfigManager.getProperty("android.startActivity");
        String host = ConfigManager.getProperty("appium.host");
        String port = ConfigManager.getProperty("appium.port");

        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName(platform);
        androidOptions.setAutomationName(UiAutomator2);
        androidOptions.setUdid(udid); //deviceName
        androidOptions.setPlatformVersion(platformVersion);
        androidOptions.setAppPackage(appPackage);
        androidOptions.setAppActivity(appActivity);

        try{
            this.driver = new AndroidDriver(new URL("http://" + host + ":" + port + "/"), androidOptions);
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }
}
