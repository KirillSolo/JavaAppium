package lib.ui.factories;

import lib.Platform;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.android.AndroidMyListsPageObject;
import lib.ui.android.AndroidNavigationUI;
import lib.ui.mobile_web.MWMyListsPageObject;
import lib.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory
{
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        }else {
            return new MWNavigationUI(driver);
        }
    }
}