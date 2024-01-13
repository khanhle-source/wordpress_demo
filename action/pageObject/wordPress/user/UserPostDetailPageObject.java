package pageObject.wordPress.user;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageObject.wordPress.admin.AdminDashboardPageObject;
import wordPress.userpageUIs.UserPostDetailPageUI;

public class UserPostDetailPageObject extends BasePage {
    private WebDriver driver;

    public UserPostDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public static UserPostDetailPageObject getUserPostDetailPage (WebDriver driver) {
        return new UserPostDetailPageObject(driver);
    }

    public boolean isPostInfoDisplayedWithPostTitle(String postTitle) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE,postTitle);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE,postTitle);
    }

    public boolean isPostInfoDisplayedWithPostContent(String postTitle, String postBody) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_CONTENT, postTitle, postBody);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_CONTENT,postTitle, postBody);
    }

    public boolean isPostInfoDisplayedWithAuthor(String postTitle, String authorName) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR, postTitle, authorName);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_AUTHOR,postTitle, authorName);
    }

    public boolean isPostInfoDisplayedWithDate(String postTitle, String currentDay) {
        waitForElementVisible(driver, UserPostDetailPageUI.POST_DATE, postTitle, currentDay);
        return isElementDisplayed(driver, UserPostDetailPageUI.POST_DATE,postTitle, currentDay);
    }

}
