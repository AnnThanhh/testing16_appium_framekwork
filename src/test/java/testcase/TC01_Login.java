package testcase;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageFactory;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;

public class TC01_Login {

    @Test
    public void verify_login_successful() {
        //khởi tạo driver
        DriverManager driverManager = DriverManagerFactory.getDriverManager("ios");

        driverManager.createDriver();

        WebDriver driver = driverManager.getDriver();

        //khởi tạo các page
        HomePage homePage = PageFactory.getHomePage(driver);
        LoginPage loginPage = PageFactory.getLoginPage(driver);

        //điều hướng veề login page và thực hiện login
        homePage.getHeaderComponent().clickMenuBtn();
        homePage.getHeaderComponent().navigateToLoginPage();

        loginPage.enterCredentials("bod@example.com", "10203040");
        loginPage.clickLoginButton();

        //VP1: Verify that the user is redirected to the homepage after successful login
        Assert.assertEquals(homePage.getPageTitle(), "Products", "Homepage does not display");

        driver.quit();

    }
}
