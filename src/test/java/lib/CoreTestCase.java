package lib;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;

public class CoreTestCase {
    protected RemoteWebDriver driver;


    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
        this.openWikiWebPageForMobileWeb();
    }
    @After
    @Step("Remove driver and session")
    public void tearDown()throws Exception
    {
        driver.quit();
    }

    @Step("open Wiki URL for Mobile Web")
    protected void openWikiWebPageForMobileWeb()
    {
        if (Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        } else {
        System.out.println("Method do nothing for platform"+ Platform.getInstance().getPlatformVar());
        }
    }
    private void createAllurePropertyFile()
    {
        String path =System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path+ "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos,"See https://github.com/allure-framework/allure-app/wiki/Environment");
            fos.close();
        }catch (Exception e){
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }

}
