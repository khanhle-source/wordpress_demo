package pageObject.wordPress.admin;

import common.BasePage;
import common.PageGeneratorManager;
import org.openqa.grid.internal.exception.NewSessionException;
import org.openqa.selenium.WebDriver;
import wordPress.adminpageUIs.AdminPostSearchPageUI;

public class AdminPostSearchPageObject extends BasePage {

    private WebDriver driver;

    public AdminPostSearchPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public static AdminPostSearchPageObject getAdminPostSearchPage (WebDriver driver) {
        return new AdminPostSearchPageObject(driver);
    }

    public AdminPostAddNewPageObject clickAddNewPostButton () {
        waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_POST_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_POST_BUTTON);
        return PageGeneratorManager.getAdminPostAddNew(driver);
    }

    public void clickToSearchPostsButton() {
        waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
        clickToElement(driver,AdminPostSearchPageUI.SEARCH_BUTTON);
    }

    public void enterToSearchTextbox(String postTitle) {
        waitForElementVisible(driver, AdminPostSearchPageUI.POST_SEARCHBOX);
        sendKeyToElement(driver, AdminPostSearchPageUI.POST_SEARCHBOX,postTitle);
    }

    public boolean isPostSearchTableDisplayed(String postTitle) {
        return isElementDisplayed(driver,AdminPostSearchPageUI.SEARCH_RESULT,postTitle);
    }

    public AdminPostAddNewPageObject clickToPostTitle(String postTitle) {
        waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_RESULT,postTitle);
        clickToElement(driver, AdminPostSearchPageUI.SEARCH_RESULT,postTitle );
        return PageGeneratorManager.getAdminPostAddNew(driver);
    }

    public void clickToEllipsisMenu (String postTitle) {
        waitForElementClickable(driver, AdminPostSearchPageUI.ELLIPSIS_MENU,postTitle);
        clickToElement(driver, AdminPostSearchPageUI.ELLIPSIS_MENU,postTitle );
    }

    public void clickToTrashButton () {
        waitForElementClickable(driver, AdminPostSearchPageUI.TRASH_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.TRASH_BUTTON);
    }

    public boolean isMoveToTrashSuccessfulMessageDisplayed() {
        waitForElementVisible(driver,AdminPostSearchPageUI.SUCCESSFUL_MOVE_TO_TRASH_MESSAGE);
        return isElementDisplayed(driver,AdminPostSearchPageUI.SUCCESSFUL_MOVE_TO_TRASH_MESSAGE);
    }
}
