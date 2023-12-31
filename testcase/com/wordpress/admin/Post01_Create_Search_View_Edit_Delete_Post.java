package com.wordpress.admin;

import common.BaseTest;
import common.Common_Login_Cookie;
import common.PageGeneratorManager;
import org.openqa.selenium.Cookie;
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
import pageObject.wordPress.user.UserHomePageObject;
import pageObject.wordPress.user.UserPostDetailPageObject;

import java.util.Set;
import java.util.logging.Logger;


public class Post01_Create_Search_View_Edit_Delete_Post extends BaseTest {
    WebDriver driver;
    AdminLoginPageObject adminLoginPage;
    AdminDashboardPageObject adminDashboardPage;
    AdminPostAddNewPageObject adminAddNewPostPage;
    AdminPostSearchPageObject adminSearchPostPage;
    UserHomePageObject userHomePage;
    UserPostDetailPageObject userPostDetailPage;

   // public static Set<Cookie> LoggedCookies;
    public static String emailAddress = "nhukhanhle@gmail.com";
    public static String password = "WVTvsgkr4ZmS!MLFo3&IXI^1";
    String searchPostURL;
    String postBody, postTitle, authorName;
    String adminURL, userURL;
    String currentDay = getToday();

    Logger logger
            = Logger.getLogger(
            Post01_Create_Search_View_Edit_Delete_Post.class.getName());


    @Parameters({"browser", "urlAdmin", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String adminURL, String userURL) {
        logger.info ("Pre-condition: Step 1: Open browser and access url");
        //dung this vi gan gia tri adminURL o bien local toi bien adminURL global
        this.adminURL = adminURL;
        this.userURL = userURL;

        driver = getBrowerDriver(browserName, this.adminURL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        postTitle="Title Name" + random();
        postBody ="Body Content" + random();

        logger.info ("Pre-condition: Step 2: Enter username / email with value: " + emailAddress);
        adminLoginPage.enterToUsernameTextbox(emailAddress);

        logger.info ("Pre-condition: Step 4: Click to Continue button");
        adminLoginPage.clickContinueButton();

        logger.info ("Pre-condition: Step 3: Enter password with value: ");
        adminLoginPage.enterToPasswordTextbox(password);

        logger.info ("Pre-condition: Step 4: Click to Login button");
        adminDashboardPage = adminLoginPage.clickToLoginButton();

       /* // get cookies
        LoggedCookies = adminDashboardPage.getAllCookies(driver);
        for (Cookie cookie : Common_Login_Cookie.LoggedCookies) {
            System.out.println("Cookie la: " + cookie);
        }
        //set cookies
        adminLoginPage.setCookies(driver, Common_Login_Cookie.LoggedCookies);
        for (Cookie cookie : Common_Login_Cookie.LoggedCookies) {
            System.out.println("Cookie la: " + cookie);
        }
        adminLoginPage.refreshPage(driver);
*/
    }

    @Test
    public void Post01_Create_Post() {
        logger.info("Create Post - Step 1: Click Post in menubar");
        adminSearchPostPage = adminDashboardPage.clicktoPostMenuLink();

        searchPostURL = "";
        logger.info ("Create Post - Step 2: Click to Add new post button");
        adminAddNewPostPage = adminSearchPostPage.clickAddNewPostButton();
        searchPostURL = adminSearchPostPage.getPageURL(driver);
        System.out.println("search URL" + searchPostURL);

        logger.info ("Create Post - Step 3: Enter title");
        adminAddNewPostPage.enterTitle(postTitle);

        logger.info ("Create Post - Step 4: Enter body");
        adminAddNewPostPage.enterBody(postBody);


        logger.info ("Create Post - Step 5: Click Publish button");
        adminAddNewPostPage.clickPublishButton();

        logger.info ("Create Post - Step 6: Verify message Publish Successful");
        Assert.assertTrue(adminAddNewPostPage.isPostPublishMessageDisplay());

    }

    @Test
    public void Post02_Search_Post () {
        logger.info ("Search Post - Step 1: Open search post url");
        adminAddNewPostPage.openSearchPostPageURL(searchPostURL);

        logger.info ("Search Post - Step 2: Click on Search icon");
        adminSearchPostPage.clickToSearchPostsButton();

        logger.info ("Search Post - Step 3: Input search keyword in search box");
        adminSearchPostPage.enterToSearchTextbox(postTitle);

        logger.info ("Search Post - Step 4: Verify search table contains '" + postTitle + "'");
        Assert.assertTrue(adminSearchPostPage.isPostSearchTableDisplayed(postTitle));

       // logger.info ("Search Post - Step 5: Verify search table contains '" + authorName + "'");
       // Assert.assertTrue(adminSearchPostPage.isPostSearchTableDisplayed("Author", authorName));

        logger.info ("Search Post - Step 6: Open End User site");
        userHomePage = adminSearchPostPage.openEndUserSite(driver, this.userURL);

        logger.info ("Search Post - Step 7: Verify Post infor displayed at User Homepage");
        Assert.assertTrue(userHomePage.isPostInfoDisplayedWithPostTitle(postTitle));
        Assert.assertTrue(userHomePage.isPostInfoDisplayedWithPostContent(postTitle, postBody));
        Assert.assertTrue(userHomePage.isPostInfoDisplayedWithDate(postTitle, currentDay));

        logger.info ("Search Post - Step 8: Go to User Detail page");
        userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

        logger.info ("Search Post - Step 7: Verify Post infor displayed at User Detail page");
        Assert.assertTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(postTitle));
        Assert.assertTrue(userPostDetailPage.isPostInfoDisplayedWithPostContent(postTitle, postBody));
        Assert.assertTrue(userPostDetailPage.isPostInfoDisplayedWithAuthor(postTitle, authorName));
        Assert.assertTrue(userPostDetailPage.isPostInfoDisplayedWithDate(postTitle, currentDay));


    }

/*
    @Test
    public void Post04_Edit_Post () {
    }

    @Test
    public void Post05_Delete_Post () {
    }

    */

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver(driver);
    }
}

