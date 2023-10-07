package pageObject.wordPress.admin;

import common.BasePage;
import common.PageGeneratorManager;
import nopCommerce.adminpageUIs.AdminLoginPageUI;
import org.openqa.selenium.WebDriver;
import pageObject.nopCommerce.admin.AdminDashboardPageObject;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //Action
    public AdminDashboardPageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboard(driver);
    }

    public void inputToEmailTextbox (String validEmail) {
        waitForElementVisible (driver, AdminLoginPageUI.EMAIL_TEXTBOX );
        sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, validEmail);
    }


    public void inputToPasswordTextbox (String password) {
        waitForElementVisible (driver, AdminLoginPageUI.PASSWORD_TEXTBOX );
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public AdminDashboardPageObject loginAsAdmin (String emailAddress, String password) {
        inputToEmailTextbox(emailAddress);
        inputToPasswordTextbox(password);
        return clickToLoginButton();
    }

}
