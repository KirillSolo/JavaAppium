package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject
{
        static {
            SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
            SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]";
            SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text(),'{SUBSTRING}')]";
        }
    public AndroidSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
//            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]";
//                  SEARCH_INPUT = "//*[contains(@text,'Search…')]";
//                  SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn";
//                 SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text(),'{SUBSTRING}')]";
