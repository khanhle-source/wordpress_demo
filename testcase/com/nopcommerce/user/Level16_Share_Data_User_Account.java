package com.nopcommerce.user;

import common.BaseTest;
import common.Common_Register_User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.nopCommerce.portal.*;

import java.util.Random;

//1 class ke thua duoc 1 class, nhung 1 class ke thua dc nhieu interface
public class Level16_Share_Data_User_Account extends BaseTest {
    WebDriver driver;


    private UserHomePageObject homePage;
    private UserLoginPageObject loginPage;

    private String password;
    private String emailAddress;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowerDriver(browserName, environmentName);

        homePage = new UserHomePageObject(driver);
        loginPage = new UserLoginPageObject(driver);

        emailAddress = Common_Register_User.emailAddress;
        password = Common_Register_User.password;

        loginPage = homePage.clicktoLoginLink();
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
    }

    @Test
    public void tc_01_Search () {

    }

    @Test
    public void tc_02_Add_To_Cart () {

    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}