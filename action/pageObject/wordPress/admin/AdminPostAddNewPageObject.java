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
        waitForElementClickable(driver, AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX_BEFORE);
        clickToElement(driver,AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX_BEFORE );
        clickToElement(driver, AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX_AFTER);
        sendKeyToElement(driver, AdminPostAddNewPageUI.ADD_CONTENT_TEXTBOX_AFTER, postBody);
    }

    public void clickPublishButton () {
        waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
        clickToElement(driver,AdminPostAddNewPageUI.PUBLISH_BUTTON);
        clickToElement(driver,AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
    }

    public void clickToolsButton () {
        waitForElementClickable(driver, AdminPostAddNewPageUI.TOOL_BUTTON);
        clickToElement(driver, AdminPostAddNewPageUI.TOOL_BUTTON);
    }

    public boolean isPostPublishMessageDisplay () {
        waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_SUCCESSFUL_MESSAGE);
        return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_SUCCESSFUL_MESSAGE);
    }

    public void openSearchPostPageURL(String URL) {
        getURl(driver, URL);
        sleepInSecond(5);
    }
}
