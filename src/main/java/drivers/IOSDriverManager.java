package drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        XCUITestOptions iosOptions = new XCUITestOptions();
        iosOptions.setPlatformName("iOS");
        iosOptions.setAutomationName("XCUITest");
        iosOptions.setDeviceName("iPhone 17 Pro Max");
        iosOptions.setUdid("07C579B9-11C0-47C9-85CE-D8E556917C41");
        iosOptions.setBundleId("com.saucelabs.mydemo.app.ios");

        try{
            this.driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), iosOptions);
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
    }
}
