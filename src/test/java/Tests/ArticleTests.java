package Tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;


import io.appium.java_client.AppiumDriver;

import java.util.List;

public class ArticleTests extends CoreTestCase {

    /* @Test
     public void testEx3() {
         AppiumDriver driver = null;
         SearchPageObject SerchPageObject = SearchPageObjectFactory.get(driver);
         SerchPageObject.initSearchInput();
         SerchPageObject.typeSearchLine("Java");

         List<WebElement> counts_of_elements = driver.findElementsById("org.wikipedia:id/page_list_item_container");
         System.out.println(counts_of_elements.size());
         assert (counts_of_elements.size() > 1);

         SerchPageObject.waitForCancelButtonToAppear();
         SerchPageObject.clickCancelSearch();

         List<WebElement> counts_of_elements_2 = driver.findElementsById("org.wikipedia:id/page_list_item_container");
         System.out.println(counts_of_elements_2.size());
         assert (counts_of_elements_2.size() == 0);

     }
    */ @Test
    public void testEx6() {
        SearchPageObject SerchPageObject = SearchPageObjectFactory.get(driver);
        SerchPageObject.initSearchInput();
        SerchPageObject.typeSearchLine("Wikipedia");
        SerchPageObject.clickByArticleWithSubstring ("Free multilingual online encyclopedia");
        List<WebElement> counts_of_elements = driver.findElementsById("org.wikipedia:id/view_page_title_text");
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        System.out.println(counts_of_elements.size());
        assert (counts_of_elements.size() > 0);
    }
}
