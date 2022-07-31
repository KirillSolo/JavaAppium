package Tests;

import lib.Platform;
import lib.ui.*;
import lib.ui.factories.*;
import lib.CoreTestCase;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyListsTests extends CoreTestCase
{
    private  static final String name_of_folder="Learning programming";
    private static final String login="Kirill13131";
    private static final String password="Smailik987";
    @Test
    public void testEx5() {
        SearchPageObject SerchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        AuthorizationPageObject Auth = new AuthorizationPageObject(driver);

        NavigationUI.openNavigation();
        Auth.clickAuthButton();
        Auth.enterLoginData(login);
        SerchPageObject.waitForElementPresent("css:input[name='wpPassword']","4",5);
        Auth.enterPasswordData(password);
        Auth.submitForm();
        SerchPageObject.openWikiWebPage();

        SerchPageObject.initSearchInput();
        SerchPageObject.typeSearchLine("Java");
        SerchPageObject.clickJava();
        ArticlePageObject.addArticleToMyList1();
        String article_title = "bject-oriented programming language";
        String name_of_folder = "Test";
        SerchPageObject.initSearchInput2();
        SerchPageObject.typeSearchLine("Wikipedia");
        SerchPageObject.clickByArticleWithSubstring("ree multilingual online encyclopedia");
        ArticlePageObject.addArticleToMyList_2(name_of_folder);
        NavigationUI.openNavigation();
        NavigationUI.ClickMyList();
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.swipeByArticleToDelete(article_title);

        List<WebElement> counts_of_elements = driver.findElementsByXPath("//a[contains(@class, 'mw-ui-icon-wikimedia-unStar-progressive')]");
        System.out.println(counts_of_elements.size());
        assert (counts_of_elements.size() < 2);
    }
}
