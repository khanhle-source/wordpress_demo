package common;

import org.openqa.selenium.WebDriver;
import pageObject.wordPress.admin.AdminDashboardPageObject;
import pageObject.wordPress.admin.AdminLoginPageObject;
import pageObject.wordPress.admin.AdminPostAddNewPageObject;
import pageObject.wordPress.admin.AdminPostSearchPageObject;
import pageObject.wordPress.user.UserHomePageObject;
import pageObject.wordPress.user.UserPostDetailPageObject;

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

    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserPostDetailPageObject getUserPageDetail(WebDriver driver) {
        return new UserPostDetailPageObject(driver);
    }
}
