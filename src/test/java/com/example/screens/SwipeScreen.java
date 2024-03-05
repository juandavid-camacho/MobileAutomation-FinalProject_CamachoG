package com.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class SwipeScreen extends HomeScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Swipe horizontal\")")
    private WebElement title;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.view.ViewGroup).resourceId(\"__CAROUSEL_ITEM_0_READY__\")")
    private WebElement carouselItem0;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.view.ViewGroup).resourceId(\"__CAROUSEL_ITEM_1_READY__\")")
    private WebElement carouselItem1;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.view.ViewGroup).resourceId(\"__CAROUSEL_ITEM_2_READY__\")")
    private WebElement carouselItem2;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.view.ViewGroup).resourceId(\"__CAROUSEL_ITEM_3_READY__\")")
    private WebElement carouselItem3;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.view.ViewGroup).resourceId(\"__CAROUSEL_ITEM_4_READY__\")")
    private WebElement carouselItem4;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Adding helper functions, or more complicated sets and combinations of existing commands is simple and really useful\")")
    private WebElement carouselItem4Text;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.view.ViewGroup).resourceId(\"__CAROUSEL_ITEM_5_READY__\")")
    private WebElement carouselItem5;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"WebdriverIO works in combination with most of the TDD and BDD test frameworks in the JavaScript world\")")
    private WebElement carouselItem5Text;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"You found me!!!\")")
    private WebElement youFoundMeText;

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean amIHere(){

        return isElementHere(title) && isElementHere(carouselItem0);
    }

    public void swipeItem(Integer[] coordinates, boolean upToDown){

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        int x1 = coordinates[0];

        int y1 = coordinates[1];

        int finalXPosition = (upToDown == true) ? getScreenWidth()/2 : 0;

        int finalYPosition = (upToDown == true) ? 0 : y1;

        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), x1, y1));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), finalXPosition, finalYPosition));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Arrays.asList(swipe));
    }

    public Integer[] getCoordinatesForSwipe(WebElement element){

        return new Integer[]{element.getRect().x + (element.getSize().width/2), element.getRect().y + (element.getSize().height/2)};

    }

    public void swipeRight(){

        waitForItem(carouselItem0);

        swipeItem(getCoordinatesForSwipe(carouselItem0),false);
        swipeItem(getCoordinatesForSwipe(carouselItem1),false);

    }

    public void swipeAllTheWayToTheRight(){

        waitForItem(carouselItem2);
        swipeItem(getCoordinatesForSwipe(carouselItem2),false);
        swipeItem(getCoordinatesForSwipe(carouselItem3),false);
        swipeItem(getCoordinatesForSwipe(carouselItem4),false);

    }

    public void swipeDown(){

        Integer[] coordinates = new Integer[]{getScreenWidth()/2, getScreenHeight()/3};

        waitForItem(title);
        swipeItem(coordinates, true);
        swipeItem(coordinates, true);
        swipeItem(coordinates, true);
        swipeItem(coordinates, true);

    }

    public boolean firstSwipeVerifications(){

        return !isElementHere(carouselItem0);

    }

    public boolean secondSwipeVerifications(){

        return isElementHere(carouselItem5Text) && !isElementHere(carouselItem4Text);

    }

    public boolean verticalSwipeVerifications(){

        return isElementHere(youFoundMeText);

    }

}
