package pageObject.wordPress.admin;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import wordPress.adminpageUIs.AdminPostSearchPageUI;

public class AdminPostSearchPageObject extends BasePage {

    private WebDriver driver;

    public AdminPostSearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddNewPostButton () {
        waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_POST_BUTTON);
        clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_POST_BUTTON);
    }



}
