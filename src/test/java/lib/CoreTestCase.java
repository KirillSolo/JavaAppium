package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected RemoteWebDriver driver;


    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.openWikiWebPageForMobileWeb();
    }
    @Override
    protected void tearDown()throws Exception
    {
        driver.quit();
        super.tearDown();
    }
    protected void openWikiWebPageForMobileWeb()
    {
        if (Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        } else {
        System.out.println("Method do nothing for platform"+ Platform.getInstance().getPlatformVar());
        }
    }

}
