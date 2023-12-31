package wordPress.userpageUIs;

public class UserPostDetailPageUI {
public static final String POST_TITLE="xpath=//main[@id='main']//header[@class='entry-header']//h3[text()='%s']";
public static final String POST_DATE= "xpath=//header[@class='entry-header']//h3[text()='%s']/parent::header//span[@class='posted-on']//time[contains(text(), '%s')]";
public static final String POST_AUTHOR = "xpath=//header[@class='entry-header']//h3[text()='%s']/parent::header//span[@class='author vcard']/a[text()='%s']";
public static final String POST_CONTENT = "xpath=//header[@class='entry-header']//h3[text()='%s']//parent::header//following-sibling::div[@class='entry-content']/p[text()='%s']";
}
