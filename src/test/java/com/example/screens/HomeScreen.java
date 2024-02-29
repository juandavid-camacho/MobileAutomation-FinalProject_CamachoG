package com.example.screens;

import com.example.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

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

    public void tapWebview(){
        waitForItem(webViewButton);
        webViewButton.click();
    }

    public void tapLogin(){
        waitForItem(loginButton);
        loginButton.click();
    }

    public void tapForms(){
        waitForItem(formsButton);
        formsButton.click();
    }

    public void tapSwipe(){
        waitForItem(swipeButton);
        swipeButton.click();
    }

    public void tapDrag(){
        waitForItem(dragButton);
        dragButton.click();
    }

}
