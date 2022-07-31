package lib.ui.android;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePajeObject extends ArticlePageObject {
    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        OPTIONS_BUTTON_1 = "xpath://android.widget.ImageView[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON_1 = "xpath://*[@text='Add to reading list']";
        ADD_TO_MY_LIST_OVERLAY_1 = "id:org.wikipedia:id/onboarding_button";
        MY_LIST_NAME_INPUT_1 = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON_1 = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        OPTIONS_BUTTON_2 = "xpath://android.widget.ImageView[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON_2 = "xpath://*[@text='Add to reading list']";
        MY_LIST_BUTTON = "xpath://*[@text='Test']";
        AREA_CAPTURE = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }
    public AndroidArticlePajeObject(RemoteWebDriver driver){super(driver);}
}
