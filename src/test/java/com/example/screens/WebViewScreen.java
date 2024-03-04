package com.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebViewScreen extends HomeScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Next-gen browser and mobile automation test framework for Node.js\")")
    private WebElement mainText;

    @AndroidFindBy(accessibility = "Get Started")
    private WebElement getStartedButton;

    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean amIHere(){

        return isElementHere(mainText) && isElementHere(getStartedButton);

    }

}
