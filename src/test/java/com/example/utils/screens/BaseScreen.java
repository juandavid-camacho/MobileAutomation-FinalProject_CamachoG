package com.example.utils.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BaseScreen {

    protected AndroidDriver driver;
    protected static WebDriverWait wait;

    public BaseScreen(AndroidDriver driver){

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public AndroidDriver getDriver() {
        return driver;
    }

    public static void waitForItem(WebElement item){
        wait.until(ExpectedConditions.visibilityOf(item));
    }

    public boolean isElementHere(WebElement element){

        try {
            waitForItem(element);
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }

    }

    public int getScreenWidth(){

        return driver.manage().window().getSize().getWidth();

    }

    public int getScreenHeight(){

        return driver.manage().window().getSize().getHeight();

    }

}
