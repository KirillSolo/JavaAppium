package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject
{
    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

   protected static String
    FOLDER_BY_NAME_TPL,
    ARTICLE_BY_TITLE_TPL,
    REMOVE_FROM_SAVED_BUTTON;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }
    private static String getSavedArticleXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }
    private static String getRemoveButtonBytitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public void openFolderByName(String name_of_folder)
    {

       /* String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementPresent(
                folder_name_xpath,
                "21.1",
                5
        );

        this.waitForElementAndClick(
                folder_name_xpath,
                "22",
                5
        );*/
    }

    public void swipeByArticleToDelete(String article_title)
    {
        //     this.waitForElementPresent(
        //            ARTICLE_BY_TITLE_TPL,
        //            "21.1",
        //            5
        //);
        if (Platform.getInstance().isAndroid()){
         //   this.swipefElementToLeft(
        //            ARTICLE_BY_TITLE_TPL,
        //            "23"
        //    );
       // } else {
            String remove_locator = getRemoveButtonBytitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot clic button to remove",
                    10
            );
        }
        if (Platform.getInstance().isMW()){
            driver.navigate().refresh();
        }
        if (Platform.getInstance().isMW()){
            driver.navigate().refresh();
        }
    }
    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath,"Saved article still present with title" + article_title,20);
    }
    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath,"Cannot find saved article by title" + article_title,15);
    }

}
