package testcase;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageFactory;
import pages.abstracts.HomePage;
import pages.abstracts.LoginPage;
import report.ExtentReportManager;

public class TC01_Login extends BaseTest {

    @Test
    public void verify_login_successful() {
        //khởi tạo các page
        HomePage homePage = PageFactory.getHomePage(driver);
        LoginPage loginPage = PageFactory.getLoginPage(driver);

        //điều hướng veề login page và thực hiện login
        ExtentReportManager.info("Step 1: Click menu button");
        LOG.info("Step 1: Click menu button");
        homePage.getHeaderComponent().clickMenuBtn();

        ExtentReportManager.info("Step 2: Navigate to login page");
        LOG.info("Step 2: Navigate to login page");
        homePage.getHeaderComponent().navigateToLoginPage();

        ExtentReportManager.info("Step 3: Enter credentials");
        LOG.info("Step 3: Enter credentials");
        loginPage.enterCredentials("bod@example.com", "10203040");

        ExtentReportManager.info("Step 4: Click login button");
        LOG.info("Step 4: Click login button");
        loginPage.clickLoginButton();

        //VP1: Verify that the user is redirected to the homepage after successful login
        ExtentReportManager.info("Step 5: Verify that the user is redirected to the homepage after successful login");
        LOG.info("Step 5: Verify that the user is redirected to the homepage after successful login");
        Assert.assertEquals(homePage.getPageTitle(), "Products", "Homepage does not display");

    }
}
