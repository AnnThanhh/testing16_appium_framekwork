package drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import utils.ConfigManager;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        ConfigManager.loadProperties();

        String platformName = ConfigManager.getProperty("platform");
        String XCUITest = ConfigManager.getProperty("automationName");
        String udid = ConfigManager.getProperty("ios.udid");
        String deviceName = ConfigManager.getProperty("ios.deviceName");
        String app = ConfigManager.getProperty("ios.bundleid");
        String host = ConfigManager.getProperty("appium.host");
        String port = ConfigManager.getProperty("appium.port");

        XCUITestOptions iosOption = new XCUITestOptions();
        iosOption.setPlatformName(platformName);
        iosOption.setAutomationName(XCUITest);
        iosOption.setDeviceName(deviceName);
        iosOption.setUdid(udid);
        iosOption.setApp(app);

        try{
            this.driver = new IOSDriver(new URL("http://" + host + ":" + port + "/"), iosOption);
        }catch(MalformedURLException e){
            throw new RuntimeException();
        }
    }
}
