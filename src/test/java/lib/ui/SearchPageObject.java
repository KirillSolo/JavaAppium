package lib.ui;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {
     protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INIT_ELEMENT_2,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL;

     public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /*TEMLATES METHODS*/
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    /*TEMLATES METHODS*/
    @Step("Initializing the search field 1")
    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }
    @Step("Initializing the search field 2")
    public void initSearchInput2() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT_2, "Cannot find search input after clicking search init element", 5);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT_2, "Cannot find and click search init element", 5);
    }
    @Step("Click to Java")
    public void clickJava() {
        this.waitForElementAndClick("xpath://html/body/div[3]/div/div[2]/div/div[3]/div/ul/li[3]/a/div[2]", "Cannot find and click search init element", 5);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button!", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present!", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button.", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys("xpath:/html/body/div[3]/div/div[1]/div/div[1]/form/input[1]", search_line, "Cannot find and type into search input", 5);

        //SEARCH_INPUT
    }
@Step("Waiting for search result and select an article by substring in article title")
    public void clickByArticleWithSubstring(String substring) {
        this.waitForElementAndClick("xpath:/html/body/div[3]/div/div[2]/div/div[3]/div/ul/li[1]/a[1]/div[2]", "Cannot find and click search init element", 5);
    }

    public void waitForSearchResuil(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,"Cannot find search result with substryng"+ substring,3);
    }
    @Step("Return to the mobile version of the Wikipedia site")
    public void openWikiWebPage()
    {
        if (Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method do nothing for platform"+ Platform.getInstance().getPlatformVar());
        }
    }

    /*public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),"Cannot find search result with substryng"+ substring,3);
    }*/
}
