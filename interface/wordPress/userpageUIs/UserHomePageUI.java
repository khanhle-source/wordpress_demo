package wordPress.userpageUIs;

public class UserHomePageUI {
    public static final String POST_TITLE = "xpath=//main[@id='main']//header[@class='entry-header']//h3[@class='entry-title']/a[text()='%s']";
    public static final String POST_DATE = "xpath=//main[@id='main']//header[@class='entry-header']//h3[@class='entry-title']/a[text()='%s']/parent::h3/following-sibling::div[contains(text(), '%s')]";
    public static final String POST_CONTENT = "xpath=//main[@id='main']//header[@class='entry-header']//h3[@class='entry-title']/a[text()='%s']/parent::h3/parent::header/following-sibling::div[@class='entry-summary']/p[text()='%s']";
}
