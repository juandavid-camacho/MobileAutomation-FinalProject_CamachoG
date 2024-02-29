package com.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends HomeScreen{

    @AndroidFindBy(accessibility = "Login / Sign up Form")
    private WebElement title;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"LOGIN\")")
    private WebElement loginButton;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public Boolean isTitleHere(){
        return title.isDisplayed();
    }

    public Boolean isLoginButtonHere(){
        return loginButton.isDisplayed();
    }

}
