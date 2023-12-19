package wordPress.adminpageUIs;

public class AdminPostAddNewPageUI {
    public static final String IFRAME = "xpath=//iframe[@class='is-loaded']";
    public static final String ADD_TITLE_TEXTBOX ="xpath=//h1[@role='textbox' and @aria-label='Add title']";
    public static final String ADD_CONTENT_TEXTBOX ="xpath=//span[@data-rich-text-placeholder='Type / to choose a block']";
    public static final String PUBLISH_BUTTON = "xpath=//button[@type='button' and text()='Publish']";
    public static final String TOOL_BUTTON = "xpath=//button[@class='components-button has-icon' and @aria-label='Tools']";
    public static final String PUBLISHED_SUCCESSFUL_MESSAGE = "xpath=//div[@class='components-snackbar__content' and text()='$s']";
}
