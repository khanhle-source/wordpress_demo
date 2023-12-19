package pageObject.wordPress.admin;

import common.BasePage;
import common.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import wordPress.adminpageUIs.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
    private WebDriver driver;

    public AdminDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public static AdminDashboardPageObject getAdminDashboardPage (WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }

    public AdminPostSearchPageObject clicktoPostMenuLink () {
        waitForElementClickable(driver,AdminDashboardPageUI.POST_LINK);
        clickToElement(driver, AdminDashboardPageUI.POST_LINK);
        return PageGeneratorManager.getAdminPostSearch(driver);
    }



}
