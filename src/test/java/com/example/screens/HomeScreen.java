package com.example.screens;

import com.example.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"WEBDRIVER\")")
    private WebElement title;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Support\")")
    private WebElement supportButton;

    @AndroidFindBy(accessibility = "Webview")
    private WebElement webViewButton;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginButton;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsButton;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeButton;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragButton;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public WebViewScreen tapWebview(){
        waitForItem(webViewButton);
        webViewButton.click();
        return new WebViewScreen(getDriver());
    }

    public LoginScreen tapLogin(){
        waitForItem(loginButton);
        loginButton.click();
        return new LoginScreen(getDriver());
    }

    public FormsScreen tapForms(){
        waitForItem(formsButton);
        formsButton.click();
        return new FormsScreen(getDriver());
    }

    public SwipeScreen tapSwipe(){
        waitForItem(swipeButton);
        swipeButton.click();
        return new SwipeScreen(getDriver());
    }

    public DragScreen tapDrag(){
        waitForItem(dragButton);
        dragButton.click();
        return new DragScreen(getDriver());
    }

    public boolean amIHere(){

        return isElementHere(title) && isElementHere(supportButton);

    }

}
