package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{
    private static final String
    LOGIN_BUTTON ="xpath://*[@id='p-personal']/li/a",//a[contains(text(), 'Войти')]
    LOGIN_INPUT="css:input[name='wpName']",
    PASSWORD_INPUT ="css:input[name='wpPassword']",
    SUBMIT_BUTTON="css:button#wpLoginAttempt";//*[@id="mw-mf-main-menu-button"]

    public AuthorizationPageObject(RemoteWebDriver driver){super(driver);}

    public void clickAuthButton(){
        this.waitForElementPresent(LOGIN_BUTTON,"Cannot find auth button",5);
        this.waitForElementAndClick(LOGIN_BUTTON,"Cannot find and click auth button",5);
    }
    public void enterLoginData(String login){
        this.waitForElementAndSendKeys(LOGIN_INPUT, login,"Cannot find and put a login to the login",5);
    }
    public void enterPasswordData( String password){
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password,"Cannot find and put a password to the password",5);
    }
    public void submitForm(){
        this.waitForElementAndClick(SUBMIT_BUTTON,"Cannon find and click submit auth button",5);
    }
}
