package pageObject.wordPress.admin;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import wordPress.adminpageUIs.AdminPostAddNewPageUI;

public class AdminPostAddNewPageObject extends BasePage {
    private WebDriver driver;

    public AdminPostAddNewPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public static AdminPostAddNewPageObject getAdminPostAddNewPage (WebDriver driver) {
        return new AdminPostAddNewPageObject(driver);
    }

    public void enterTitle (String postTitle) {
        switchToFrameIFrame (driver, AdminPostAddNewPageUI.IFRAME);
        waitForElementClickable(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTBOX);
        clickToElement(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTBOX);
        sendKeyToElement(driver, AdminPostAddNewPageUI.ADD_TITLE_TEXTBOX,postTitle);
    }

    public void enterBody (String postBody) {
        waitForElementClickable(driver, AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX);
        clickToElement(driver,AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX );

        sendKeyToElement(driver, AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX, postBody);
    }

    public void clickPublishButton () {
        switchToFrameIFrame (driver, AdminPostAddNewPageUI.IFRAME);
        waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
        clickToElement(driver,AdminPostAddNewPageUI.PUBLISH_BUTTON);
        clickToElement(driver,AdminPostAddNewPageUI.PUBLISH_BUTTON);
    }

    public void clickToolsButton () {
        switchToFrameIFrame (driver, AdminPostAddNewPageUI.IFRAME);
        waitForElementClickable(driver, AdminPostAddNewPageUI.TOOL_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.TOOL_BUTTON);
    }

    public boolean isPostPublishMessageDisplay (String postPublishedMessage) {
        switchToFrameIFrame (driver, AdminPostAddNewPageUI.IFRAME);
        waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_SUCCESSFUL_MESSAGE, postPublishedMessage);
        return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_SUCCESSFUL_MESSAGE, postPublishedMessage);
    }
}
