package com.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends HomeScreen{

    @AndroidFindBy(id = "RNE__Input__text-input")
    private WebElement inputField;

    @AndroidFindBy(className = "android.widget.Switch")
    private WebElement theSwitch;

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    public Boolean isInputFieldHere(){
        return inputField.isDisplayed();
    }

    public Boolean isTheSwitchHere(){
        return theSwitch.isDisplayed();
    }

}
