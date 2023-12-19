package pageObject.wordPress.admin;

import common.BasePage;
import common.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wordPress.adminpageUIs.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public static AdminLoginPageObject getAdminLoginPage (WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public void enterToUsernameTextbox (String adminUsername) {
        waitForElementVisible (driver, AdminLoginPageUI.USERNAME_TEXTBOX );
        sendKeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);
    }

    public void clickContinueButton () {
        waitForElementClickable(driver,AdminLoginPageUI.CONTINUE_BUTTON);
        clickToElement(driver, AdminLoginPageUI.CONTINUE_BUTTON);
    }

    public void enterToPasswordTextbox (String adminPassword) {
        waitForElementVisible (driver, AdminLoginPageUI.PASSWORD_TEXTBOX );
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
    }

    public AdminDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }
}
