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
    String searchPostURL= "";
    String postBody, postTitle;
    String postTitleUpdated, postBodyUpdated;
    String adminURL, userURL;
    String currentDay = getToday();

    Logger logger
            = Logger.getLogger(
            Post01_Create_Search_View_Edit_Delete_Post.class.getName());


    @Parameters({"browser", "urlAdmin", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlAdmin, String urlUser) {
        logger.info ("Pre-condition: Step 1: Open browser and access url");
        //dung this vi gan gia tri adminURL o bien local toi bien adminURL global
        this.adminURL = urlAdmin;
        this.userURL = urlUser;

        driver = getBrowerDriver(browserName, this.adminURL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        postTitle="Title Name" + random();
        postBody ="Body Content" + random();
        postTitleUpdated = postTitle + random();
        postBodyUpdated = postBody + random();

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

        searchPostURL = adminSearchPostPage.getPageURL(driver);
        System.out.println("search URL: " + searchPostURL);

        logger.info ("Create Post - Step 2: Click to Add new post button");
        adminAddNewPostPage = adminSearchPostPage.clickAddNewPostButton();

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
        System.out.println("search URL: " + searchPostURL);
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
        Assert.assertTrue(userPostDetailPage.isPostInfoDisplayedWithDate(postTitle, currentDay));


    }


    @Test
    public void Post04_Edit_Post () {
        logger.info ("Search Post - Step 1: Open search post url");
        System.out.println("search URL: " + searchPostURL);
        adminAddNewPostPage.openSearchPostPageURL(searchPostURL);

        logger.info ("Search Post - Step 2: Click on Search icon");
        adminSearchPostPage.clickToSearchPostsButton();

        logger.info ("Edit Post - Step 4: Input search keyword in search box");
        adminSearchPostPage.enterToSearchTextbox(postTitle);

        logger.info ("Edit Post - Step 5: Click on post title");
        adminAddNewPostPage = adminSearchPostPage.clickToPostTitle (postTitle);

        logger.info ("Edit Post - Step 5: Update Post Title");
        adminAddNewPostPage.enterTitle(postTitleUpdated);

        logger.info("Edit Post - Step 6: Update Post Body");
        adminAddNewPostPage.enterBodyUpdated(postBodyUpdated);
        postBodyUpdated = postBody + postBodyUpdated;

                logger.info("Edit Post - Step 7: Click Update button");
        adminAddNewPostPage.clickUpdateButton();


        logger.info("Edit Post - Step 8: Verify Update Post message display");
        adminAddNewPostPage.isPostUpdatedMessageDisplay();

        logger.info("Edit Post - Step 9: Click on View Post link and redirect to user URL");
        //userHomePage = adminAddNewPostPage.clickViewPostLink();
        userHomePage = adminSearchPostPage.openEndUserSite(driver, this.userURL);

        logger.info ("Edit Post - Step 10: Verify Post infor displayed at User Homepage");
        Assert.assertTrue(userHomePage.isPostInfoDisplayedWithPostTitle(postTitleUpdated));
        Assert.assertTrue(userHomePage.isPostInfoDisplayedWithPostContent(postTitleUpdated, postBodyUpdated));
        Assert.assertTrue(userHomePage.isPostInfoDisplayedWithDate(postTitleUpdated, currentDay));

        logger.info ("Edit Post - Step 11: Go to User Detail page");
        userPostDetailPage = userHomePage.clickToPostTitle(postTitleUpdated);

        logger.info ("Edit Post - Step 12: Verify Post infor displayed at User Detail page");
        Assert.assertTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(postTitleUpdated));
        Assert.assertTrue(userPostDetailPage.isPostInfoDisplayedWithPostContent(postTitleUpdated, postBodyUpdated));
        Assert.assertTrue(userPostDetailPage.isPostInfoDisplayedWithDate(postTitleUpdated, currentDay));

    }


    @Test
    public void Post05_Delete_Post () {
        logger.info ("Delete Post - Step 1: Open admin site");
        adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminURL);

        logger.info("Delete Post - Step 2: Click Post on menu bar");
        adminSearchPostPage = adminDashboardPage.clicktoPostMenuLink();

        logger.info ("Delete Post - Step 3: Click on Search icon");
        adminSearchPostPage.clickToSearchPostsButton();

        logger.info ("Delete Post - Step 4: Input search keyword in search box");
        adminSearchPostPage.enterToSearchTextbox(postTitle);

        logger.info("Delete Post - Step 5: Click ellipsis menu");
        adminSearchPostPage.clickToEllipsisMenu(postTitle);

        logger.info ("Delete Post - Step 6: Click Trash button");
        adminSearchPostPage.clickToTrashButton();

        logger.info("Delete Post - Step 7: Verify move to trash message displayed");
        adminSearchPostPage.isMoveToTrashSuccessfulMessageDisplayed();

        logger.info ("Delete Post - Step 8: Click on Search icon");
        adminSearchPostPage.clickToSearchPostsButton();

        logger.info ("Delete Post - Step 9: Input search keyword in search box");
        adminSearchPostPage.enterToSearchTextbox(postTitleUpdated);

        logger.info("Delete Post - Step 10: Click ellipsis menu");
        adminSearchPostPage.clickToEllipsisMenu(postTitleUpdated);

        logger.info ("Delete Post - Step 11: Click Trash button");
        adminSearchPostPage.clickToTrashButton();

        logger.info("Delete Post - Step 12: Verify move to trash message displayed");
        adminSearchPostPage.isMoveToTrashSuccessfulMessageDisplayed();

    }


    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver(driver);
    }
}

