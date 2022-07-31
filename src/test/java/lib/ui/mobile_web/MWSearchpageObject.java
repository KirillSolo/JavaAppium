package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchpageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "xpath://input[contains(@class, 'mw-ui-background-icon-search')]";//"xpath://button[contains(@class, 'mw-ui-icon-wikimedia-search-base20')]";//"css:button#searchIcon";
        SEARCH_INPUT = "xpath://form/input[contains(@aria-label, 'Search Wiktionary' )]";
        SEARCH_INIT_ELEMENT_2 = "xpath://input[contains(@class, 'mw-ui-background-icon-search')]";//"//*[@id='searchIcon']/text()";//"css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikipedia-description')][contains(@text(),'{SUBSTRING}')]";
        //SEARCH_RESULT_ELEMENT ="css:ul.page-list>li.page-summary";
    }
    public MWSearchpageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
