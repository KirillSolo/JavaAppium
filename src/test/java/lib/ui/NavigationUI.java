package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {
    protected static String
    MY_LISTS_LINK,
    AREA_CAPTURE,
    OPEN_NAVIGATION;
    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
    public void ClickMyList() {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "20",
                    5
            );
        } else {
            this.waitForElementPresent(
                    AREA_CAPTURE,
                    "20",
                    10
            );
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "21",
                    10
            );
        }
    }
        public void openNavigation () {
            if (Platform.getInstance().isMW()) {
                this.waitForElementAndClick(OPEN_NAVIGATION, "414", 5);
            } else {
                System.out.println("method openNavigation( do nothing for platform" + Platform.getInstance().getPlatformVar());
            }
        }
}
