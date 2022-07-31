package lib;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String PLATFORM_ANDROID = "lib/ui/android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    private static Platform instance;

    private Platform() {
    }

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()) {
            System.out.println("+");
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());

        } else
            if (this.isMW()){
                System.out.println("-");
            return new ChromeDriver(this.getMWChromeOptions());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value:" + this.getPlatformVar());
        }
    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isMW() {
        return isPlatform(PLATFORM_MOBILE_WEB);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("plarformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Users\\k.solovyev\\Desktop\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");
        return capabilities;
    }

    private ChromeOptions getMWChromeOptions()
    {
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put ("width", 360);
        deviceMetrics.put ("height",640);
        deviceMetrics.put ("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation =new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions cromeOptions = new ChromeOptions();
        cromeOptions.addArguments("window-size=1000,1000");
         return cromeOptions;
    }
    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        System.out.println(platform+ " "+ my_platform);

        return  my_platform.equals(platform);
    }
    public String getPlatformVar(){return System.getenv("PLATFORM");}
}
