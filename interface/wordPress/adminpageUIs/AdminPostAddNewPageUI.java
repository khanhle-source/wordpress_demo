package wordPress.adminpageUIs;

public class AdminPostAddNewPageUI {
    public static final String IFRAME = "xpath=//iframe[@class='is-loaded']";
    public static final String ADD_TITLE_TEXTBOX ="xpath=//h1[@role='textbox' and @aria-label='Add title']";
    public static final String ADD_CONTENT_TEXTBOX_BEFORE = "xpath=//p[@class='block-editor-default-block-appender__content']";
    public static final String ADD_CONTENT_TEXTBOX_AFTER ="xpath=//p[@class='block-editor-rich-text__editable block-editor-block-list__block wp-block is-selected wp-block-paragraph rich-text']";
    public static final String UPDATE_CONTENT_TEXTBOX_BEFORE ="xpath=//p[@class='block-editor-rich-text__editable block-editor-block-list__block wp-block wp-block-paragraph rich-text']";
    public static final String UPDATE_CONTENT_TEXTBOX_AFTER = "xpath=//p[@class='block-editor-rich-text__editable block-editor-block-list__block wp-block is-selected wp-block-paragraph rich-text']";
    public static final String PUBLISH_BUTTON = "xpath=//button[@aria-disabled='false' and text()='Publish']";
    public static final String PRE_PUBLISH_BUTTON = "xpath=(//button[@aria-disabled='false' and text()='Publish'])[2]";
    public static final String TOOL_BUTTON = "xpath=//button[@class='components-button has-icon' and @aria-label='Tools']";
    public static final String PUBLISHED_SUCCESSFUL_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='Post published.']";
    public static final String UPDATE_BUTTON = "xpath=//button[text()='Update']";
    public static final String VIEW_POST_LINK_SNACKBAR = "xpath=//a[@class='components-button components-snackbar__action is-tertiary']";
    public static final String POST_UPDATED_MASSEGE_SNACKBAR = "xpath=//div[@class='components-snackbar__content' and text() = 'Post updated.']";
}