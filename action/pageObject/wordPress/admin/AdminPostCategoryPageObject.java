package pageObject.wordPress.admin;

import org.openqa.selenium.WebDriver;

public class AdminPostCategoryPageObject {
    private WebDriver driver;

    public AdminPostCategoryPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public static AdminPostCategoryPageObject getAdminPostCategoryhPage (WebDriver driver) {
        return new AdminPostCategoryPageObject(driver);
    }

}
