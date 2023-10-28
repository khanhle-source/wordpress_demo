package common;

import org.openqa.selenium.WebDriver;
import pageObject.wordPress.admin.AdminDashboardPageObject;
import pageObject.wordPress.admin.AdminLoginPageObject;
import pageObject.wordPress.admin.AdminPostAddNewPageObject;
import pageObject.wordPress.admin.AdminPostSearchPageObject;

public class PageGeneratorManager {

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }

    public static AdminPostAddNewPageObject getAdminPostAddNew(WebDriver driver) {
        return new AdminPostAddNewPageObject(driver);
    }

    public static AdminPostSearchPageObject getAdminPostSearch(WebDriver driver) {
        return new AdminPostSearchPageObject(driver);
    }

}
