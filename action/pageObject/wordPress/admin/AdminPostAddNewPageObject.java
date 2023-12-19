package pageObject.wordPress.admin;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import wordPress.adminpageUIs.AdminPostAddNewPageUI;

public class AdminPostAddNewPageObject extends BasePage {
    private WebDriver driver;

    public AdminPostAddNewPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTitle (String postTitle) {
        waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTBOX);
        sendKeyToElement(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTBOX,postTitle);
    }

    public void enterBody (String postBody) {
        waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX);
        sendKeyToElement(driver, AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX, postBody);
    }

    public void clickPublishButton () {
        waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
        clickToElement(driver,AdminPostAddNewPageUI.PUBLISH_BUTTON);
        clickToElement(driver,AdminPostAddNewPageUI.PUBLISH_BUTTON);
    }

    public boolean isPostPublishMessageDisplay (String postPublishedMessage) {
        waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_SUCCESSFUL_MESSAGE, postPublishedMessage);
        return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_SUCCESSFUL_MESSAGE, postPublishedMessage);
    }
}
