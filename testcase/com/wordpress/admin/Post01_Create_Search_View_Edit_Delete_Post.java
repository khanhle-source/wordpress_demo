package com.wordpress.admin;

import common.BaseTest;
import common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.wordPress.admin.AdminLoginPageObject;
import pageObject.wordPress.admin.AdminDashboardPageObject;
import pageObject.wordPress.admin.AdminPostAddNewPageObject;
import pageObject.wordPress.admin.AdminPostSearchPageObject;

import java.util.logging.Logger;


public class Post01_Create_Search_View_Edit_Delete_Post extends BaseTest {
    WebDriver driver;
    AdminLoginPageObject adminLoginPage;
    AdminDashboardPageObject adminDashboardPage;
    AdminPostAddNewPageObject adminAddNewPostPage;
    AdminPostSearchPageObject adminSearchPostPage;

    Logger logger
            = Logger.getLogger(
            Post01_Create_Search_View_Edit_Delete_Post.class.getName());

    String adminUsername = "nhukhanhle@gmail.com";
    String adminPassword = "";
    String searchPostURL;
    String postBody, postTitle;


    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) {
        driver = getBrowerDriver(browserName, environmentName);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);


        logger.info ("Pre-condition: Step 1: Open browser and access url");

        logger.info ("Pre-condition: Step 2: Enter username / email with value: " + adminUsername);
        adminLoginPage.enterToUsernameTextbox (adminUsername);

        logger.info ("Pre-condition: Step 4: Click to Continue button");
        adminLoginPage.clickContinueButton();

        logger.info ("Pre-condition: Step 3: Enter password with value: " + adminPassword);
        adminLoginPage.enterToPassword(adminPassword);

        logger.info ("Pre-condition: Step 4: Click to Login button");
        adminLoginPage.clickLoginButton();



    }

    @Test
    public void Post01_Create_Post () {
        adminDashboardPage = PageGeneratorManager.getAdminDashboardPage(driver);
        logger.info ("Create Post - Step 1: Click Post in menubar");
        adminDashboardPage.clicktoPostMenuLink();
        searchPostURL = "";

        logger.info ("Create Post - Step 2: Click to Add new post button");
        adminSearchPostPage = PageGeneratorManager.getAdminPostSearch(driver);
        adminSearchPostPage.clickAddNewPostButton();

        logger.info ("Create Post - Step 3: Enter title");
        adminAddNewPostPage = PageGeneratorManager.getAdminPostAddNew(driver);
        postTitle="";
        adminAddNewPostPage.enterTitle(postTitle);
        logger.info ("Create Post - Step 4: Enter body");
        postBody ="";
        adminAddNewPostPage.enterBody(postBody);
        logger.info ("Create Post - Step 5: Click Publish button");
        adminAddNewPostPage.clickPublishButton();
        logger.info ("Create Post - Step 6: Verify message Publish Successful");
        adminAddNewPostPage.isPostPublishMessageDisplay();
    }

    @Test
    public void Post02_Search_Post () {
        adminAddNewPostPage.openSearchPostPageURL(searchPostURL);
        logger.info ("Search Post - Step 1: Open search post url");
        // searchPostURL

        logger.info ("Search Post - Step 2: Open user url");


        logger.info ("Search Post - Step 3: Verify title");

        logger.info ("Search Post - Step 4: Verify body");

        logger.info ("Search Post - Step 5: Verify post by");

        logger.info ("Search Post - Step 6: Verify post on");
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