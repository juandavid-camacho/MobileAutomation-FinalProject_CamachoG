package com.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends HomeScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Drag and Drop\")")
    private WebElement title;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"drag-l2\"]/android.widget.ImageView")
    private WebElement firstTile;

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean amIHere(){

        return isElementHere(title) && isElementHere(firstTile);

    }

}
