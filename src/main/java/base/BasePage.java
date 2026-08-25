package base;

import constants.TimeOutConstant;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(TimeOutConstant.TIMEOUT_DEFAULT)), this);
    }

    public WebElement waitForElementVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void inputText(WebElement element, String text, int timeoutInSeconds) {
        WebElement webElement = waitForElementVisibility(element, timeoutInSeconds);
        webElement.sendKeys(text);
        //waitForElementVisibility(element, timeoutInSeconds).sendKeys(text);
    }

    public void inputText(WebElement element, String text) {
        inputText(element, text, TimeOutConstant.TIMEOUT_DEFAULT);
    }

    public void clickElement(WebElement element, int timeoutInSeconds) {
        waitForElementClickable(element, timeoutInSeconds).click();
    }

    public void clickElement(WebElement element) {
        clickElement(element, TimeOutConstant.TIMEOUT_DEFAULT);
    }

    public String getElementText(WebElement element, int timeoutInSeconds) {
        return waitForElementVisibility(element, timeoutInSeconds).getText();
    }

    public String getElementText(WebElement element) {
        return getElementText(element, TimeOutConstant.TIMEOUT_DEFAULT);
    }
}
