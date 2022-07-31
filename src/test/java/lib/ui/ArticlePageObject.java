package lib.ui;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            TITLE,
            OPTIONS_BUTTON_1,
            OPTIONS_ADD_TO_MY_LIST_BUTTON_1,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY_1,
            MY_LIST_NAME_INPUT_1,
            MY_LIST_OK_BUTTON_1,
            CLOSE_ARTICLE_BUTTON,
            OPTIONS_BUTTON_2,
            OPTIONS_ADD_TO_MY_LIST_BUTTON_2,
            MY_LIST_BUTTON,
            AREA_CAPTURE;


    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void addArticleToMyList1() {
 //       this.waitForElementPresent(
 //               AREA_CAPTURE,
  //              "15",
 //               10
  //      );
//        this.waitForElementAndClick(
//                OPTIONS_BUTTON_1,
//               "5.1",
//                15
//        );
 //       this.waitForElementPresent(
 //               ADD_TO_MY_LIST_OVERLAY_1,
 //               "5.2",
 //               10
 //       );
 //       this.waitForElementAndClick(
 //               OPTIONS_ADD_TO_MY_LIST_BUTTON_1,
 //               "6",
 //               20
 //       );
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY_1,
                "7",
                20
        );
//        this.waitForElementAndClear(
//                MY_LIST_NAME_INPUT_1,
 //               "8",
 //               5
 //       );

//        this.waitForElementAndSendKeys(
 //               MY_LIST_NAME_INPUT_1,
 //               "Test",
 //               "9",
 //               5
 //       );
 //       this.waitForElementAndClick(
 //               MY_LIST_OK_BUTTON_1,
 //               "10",
 //               5
 //       );
    }

    public void closeArticle() {
       this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "11",
                5
        );
    }

    public void addArticleToMyList_2(String name_of_folder) {
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY_1,
                "7",
                20
        );
        /*  this.waitForElementPresent(
                AREA_CAPTURE,
                "15",
                10
        );
        this.waitForElementAndClick(
                OPTIONS_BUTTON_2,
                "5.1",
                15
        );
        this.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON_2,
                "5.2",
                10
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON_2,
                "6",
                20
        );
        this.waitForElementAndClick(
                MY_LIST_BUTTON,
                "18",
                15
        ); */
    }

  //  public void addArticlesToMySaved()
//    {
  //   if (Platform.getInstans().isMW())
 //       this.removeArticleFromSavedIfAdded();

 //     this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON_1,"123",5);
//    }
    public void removeArticleFromSavedIfAdded(){
if(this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
    this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON," cannot click button", 3);
    this.waitForElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON_1,"List 1",2);}
    }
}
