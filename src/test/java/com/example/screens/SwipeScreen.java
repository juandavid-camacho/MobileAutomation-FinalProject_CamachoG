package com.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends HomeScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Swipe horizontal\")")
    private WebElement title;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.view.ViewGroup).resourceId(\"__CAROUSEL_ITEM_0_READY__\")")
    private WebElement carouselItem0;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean amIHere(){

        return isElementHere(title) && isElementHere(carouselItem0);
    }

}
