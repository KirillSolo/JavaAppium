package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver)
    {
        this.driver =driver;
    }

    public void assertElementHasText(String locator, String searchingText, String error_message, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecond);

        By element = By.id(locator);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        String foundedText = driver.findElement(By.id(locator)).getText();
        Assert.assertEquals(error_message, searchingText, foundedText);
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by =this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
               ExpectedConditions.presenceOfElementLocated(by)
                //ExpectedConditions.elementToBeClickable(by)
        );
    }
 //   public WebElement waitForElementPresent(By by)
 //   {
 //     WebDriverWait wait = new WebDriverWait(driver, 5);
 //
 //       return wait.until(
 //               ExpectedConditions.presenceOfElementLocated(by)
 //       );
 //   }

    public Boolean waitForElementNotPresent (String locator, String error_message, long timeoutInSeconds)
    {
        By by =this.getLocatorString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
//    private WebElement waitForElementNotPresent(By by, String error_message)
//    {
//        return waitForElementPresent(by, error_message, 5);
//    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public void swipeUp (int timeOfSwipe)
    {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);
            action
                    .press(x, start_y)
                    .waitAction(timeOfSwipe)
                    .moveTo(x, end_y)
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeUp() do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    public void swipefElementToLeft(String locator, String error_message)
    {
        if (driver instanceof AppiumDriver) {
            WebElement element = waitForElementPresent(
                    locator,
                    error_message,
                    10
            );
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;

            TouchAction action = new TouchAction((AppiumDriver) driver);
            action
                    .press(right_x, middle_y)
                    .waitAction(600)
                    .moveTo(left_x, middle_y)
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeUp() do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }
    private By getLocatorString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator [0];
        String locator = exploded_locator [1];

        if (by_type.equals("xpath")){
            return By.xpath(locator);
        } else if (by_type.equals("id")){
            return By.id(locator);
        } else if (by_type.equals("css")){
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator:" + locator_with_type);
        }
    }
    public boolean isElementPresent(String locator){
        return getAmountOfElement(locator)>0;
    }
    public int getAmountOfElement(String locator)
    {
        By by= this.getLocatorString(locator);
        List elemets = (List) driver.findElement(by);
        return elemets.size();
    }
    public void tryClickElementWithFewAttempts(String locator, String error_message, int amount_of_attemts) {
        int current_attempts = 0;
        boolean need_more_attempts = true;

        while (need_more_attempts) {
            try {

                this.waitForElementAndClick(locator, error_message, 2);
                need_more_attempts = false;

            } catch (Exception e) {
                if (current_attempts > amount_of_attemts) ;
            }
        }
        ++current_attempts;
    }
}
