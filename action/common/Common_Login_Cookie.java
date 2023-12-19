package common;

import com.wordpress.admin.Post01_Create_Search_View_Edit_Delete_Post;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.wordPress.admin.AdminDashboardPageObject;
import pageObject.wordPress.admin.AdminLoginPageObject;


import java.util.Set;
import java.util.logging.Logger;

public class Common_Login_Cookie extends BaseTest {
    WebDriver driver;

    public static Set<Cookie> LoggedCookies;
    public static String emailAddress;
    public static String password;

    private AdminDashboardPageObject dashboardPage;
    private AdminLoginPageObject loginPage;

    Logger logger
            = Logger.getLogger(
            Common_Login_Cookie.class.getName());


    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        logger.info ("Pre-condition: Step 1: Open browser and access url");
        driver = getBrowerDriver(browserName, environmentName);

        dashboardPage = new AdminDashboardPageObject(driver);
        loginPage = new AdminLoginPageObject(driver);

        password ="WVTvsgkr4ZmS!MLFo3&IXI^1";
        emailAddress = "nhukhanhle@gmail.com";
    }

    @Test
    public void Precondition_Login_Successfully () {
        logger.info ("Pre-condition: Step 2: Enter username / email with value: " + emailAddress);
        loginPage.enterToUsernameTextbox(emailAddress);
        logger.info ("Pre-condition: Step 4: Click to Continue button");
        loginPage.clickContinueButton();
        logger.info ("Pre-condition: Step 3: Enter password with value: ");
        loginPage.enterToPasswordTextbox(password);
        logger.info ("Pre-condition: Step 4: Click to Login button");
        dashboardPage = loginPage.clickToLoginButton();
        // get cookies
        LoggedCookies = dashboardPage.getAllCookies(driver);
        for (Cookie cookie : Common_Login_Cookie.LoggedCookies) {
            System.out.println("Cookie la: " + cookie);
        }

    }

     @AfterClass
    public void afterClass () {
    }
}