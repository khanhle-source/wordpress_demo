package wordPress.adminpageUIs;

public class AdminPostAddNewPageUI {
    public static final String ADD_TITLE_TEXTBOX ="css=h1.wp-block-post-title";
    public static final String ADD_CONTENT_TEXTBOX ="xpath=//span[@data-rich-text-placeholder='Type / to choose a block']";
    public static final String PUBLISH_BUTTON = "xpath=//button[@type='button' and text()='Publish']";
    public static final String SAVE_AS_DRAFT_BUTTON = "xpath=//button[@type='button' and @class='components-button editor-post-save-draft is-tertiary']";
    public static final String PUBLISHED_SUCCESSFUL_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='$s']";
}
