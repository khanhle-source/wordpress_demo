package com.wordpress.admin;

import common.BaseTest;
import common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.nopCommerce.portal.UserHomePageObject;
import pageObject.nopCommerce.portal.UserLoginPageObject;
import pageObject.nopCommerce.portal.UserMyAccountPageObject;
import pageObject.nopCommerce.portal.UserRegisterPageObject;


public class Post01_Create_Search_View_Edit_Delete_Post extends BaseTest {
    WebDriver driver;
    String emailAddress;
    String date, month, year;

    private UserHomePageObject homePage;
    private UserRegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private UserMyAccountPageObject myAccountPage;
    private String firstName;
    private String lastName;
    private String password;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowerDriver(browserName, environmentName);

        homePage = new UserHomePageObject(driver);
        registerPage = new UserRegisterPageObject(driver);
        loginPage = new UserLoginPageObject(driver);


    }

    @Test
    public void Post01_Create_Post () {
        System.out.println("Home Page - Step 01: Click to Register link");

    }

    @Test
    public void Post02_Search_Post () {

    }

    @Test
    public void Post03_View_Post () {

    }

    @Test
    public void Post04_Edit_Post () {
    }

    @Test
    public void Post05_Delete_Post () {
    }

    @AfterClass (alwaysRun = true)
    public void afterClass () {
        closeBrowserDriver(driver);
    }
}