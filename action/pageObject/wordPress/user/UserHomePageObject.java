package pageObject.wordPress.user;

import common.BasePage;
import common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObject.wordPress.admin.AdminPostSearchPageObject;
import wordPress.userpageUIs.UserHomePageUI;

public class UserHomePageObject extends BasePage {
    private WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public static UserHomePageObject getUserHomePageO (WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public boolean isPostInfoDisplayedWithPostTitle(String postTitle) {
        waitForElementVisible(driver,UserHomePageUI.POST_TITLE, postTitle);
        return isElementDisplayed(driver,UserHomePageUI.POST_TITLE, postTitle);
    }

    public boolean isPostInfoDisplayedWithPostContent(String postTitle, String postBody) {
        waitForElementVisible(driver,UserHomePageUI.POST_CONTENT, postTitle, postBody );
        return isElementDisplayed(driver, UserHomePageUI.POST_CONTENT, postTitle, postBody);
    }

    public boolean isPostInfoDisplayedWithDate(String postTitle, String currentDay) {
        waitForElementVisible(driver, UserHomePageUI.POST_DATE, postTitle, currentDay);
        return isElementDisplayed(driver, UserHomePageUI.POST_DATE, postTitle, currentDay);
    }

    public UserPostDetailPageObject clickToPostTitle(String postTitle) {
        waitForElementVisible(driver, UserHomePageUI.POST_TITLE, postTitle);
        clickToElement(driver, UserHomePageUI.POST_TITLE, postTitle);
        return PageGeneratorManager.getUserPageDetail(driver);
    }
}
