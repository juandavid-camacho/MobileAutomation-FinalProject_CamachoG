package com.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends HomeScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Login / Sign up Form\")")
    private WebElement title;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"LOGIN\")")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Sign up\")")
    private WebElement signUpButton;



    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean amIHere(){

        return isElementHere(title) && isElementHere(loginButton);

    }

    public SignUpScreen tapSignUp(){
        waitForItem(signUpButton);
        signUpButton.click();
        return new SignUpScreen(getDriver());
    }



}
