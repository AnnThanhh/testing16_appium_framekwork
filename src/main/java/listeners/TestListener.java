package listeners;

import com.google.common.io.Files;
import drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TestListener implements ITestListener {

    private final Logger LOG = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("onTestSuccess: " + result.getMethod().getMethodName() + " - PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info("onTestFailure: " + result.getMethod().getMethodName() + " - FAILED");
        LOG.error("Exception: " + result.getThrowable().toString());
        //Handle capture screenshot
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + "/test_output/screenshots/";
        File screenshotFolder = new File(screenshotPath);
        if(!screenshotFolder.exists())
            screenshotFolder.mkdirs();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hh_mm_ss"));
        String fileName = result.getMethod().getMethodName() + "_" + timestamp + ".png";
        File dest = new File(screenshotPath + fileName);
        try {
            Files.copy(src, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOG.info("Saved screenshot: " + dest);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.info("onTestSkipped");
    }

    @Override
    public void onStart(ITestContext context) {
        LOG.info("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("onFinish");
    }
}