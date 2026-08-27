package base;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ExtentReportManager;

import org.apache.logging.log4j.Logger;
import utils.ConfigManager;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    //khai báo logger để ghi log và có thể sử dụng trong các class kế thừa BaseTest
    protected final Logger LOG = LogManager.getLogger(getClass());

    @BeforeSuite
    public void BeforeSuit() {
        LOG.info("BeforeSuite: Initialize ExtentReports");
        //khởi tạo ExtentReports trước khi chạy test suite
        ExtentReportManager.initializeExtentReports();

        ConfigManager.loadProperties();
    }

    @BeforeClass
    public void BeforeClass() {
        LOG.info("BeforeClass: Create driver instance");
        String platform = ConfigManager.getProperty("platform");
        LOG.info("Platform from configure.properties: " + platform);
        DriverManager driverManager = DriverManagerFactory.getDriverManager(platform);

        driverManager.createDriver();

        driver = driverManager.getDriver();
    }

    @BeforeMethod
    public void BeforeMethod(Method method) {
        LOG.info("BeforeMethod: Create test in ExtentReports for method: " + method.getName());
        //ví dụ: nếu method đang được gọi/chạy là test_valid_register thì sẽ trả về của method.getName là test_valid_register
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void AfterMethod(ITestResult result) {
        LOG.info("AfterMethod: Test method " + result.getMethod().getMethodName() + " finished with status: " + result.getStatus());
        if(result.getStatus() == ITestResult.FAILURE){
            //chụp hình khi lỗi
            ExtentReportManager.captureScreenshot(driver, result.getMethod().getMethodName());

            //ghi log lỗi vào report
            ExtentReportManager.fail(result.getThrowable().toString());
        }
    }

    @AfterClass
    public void AfterClass() {
        LOG.info("AfterClass: Quit driver instance");
        driver.quit();
    }

    @AfterSuite
    public void AfterSuit() {
        LOG.info("AfterSuite: Flush ExtentReports");
        //kết thúc ExtentReports sau khi chạy xong test suite
        ExtentReportManager.flushReports();
    }
}
