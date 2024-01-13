package wordPress.adminpageUIs;

public class AdminPostSearchPageUI {
    public static final String ADD_NEW_POST_BUTTON ="xpath=//a[@class='button post-type-list__add-post is-compact is-primary']";
    public static final String SEARCH_BUTTON = "xpath=//div[@class='search__icon-navigation']";
    public static final String POST_SEARCHBOX = "xpath=//input[@role='searchbox' and @class='form-text-input search__input']";
    public static final String SEARCH_RESULT = "xpath=//h1[@class='post-item__title']/a[@data-e2e-title='%s']";
    public static final String ELLIPSIS_MENU = "xpath=//button[@title='Toggle menu']";
    public static final String TRASH_BUTTON = "xpath=//button[text()='Trash']";
    public static final String SUCCESSFUL_MOVE_TO_TRASH_MESSAGE = "xpath=//span[text()='Post successfully moved to trash.']";

}
