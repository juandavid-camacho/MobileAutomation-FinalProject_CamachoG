package com.example.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends LoginScreen{

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement repeatPasswordInput;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement finishSignUpButton;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement signUpAlertTitle;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement signUpOkButton;

    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }

    public void fillSignUp(String email, String password){

        waitForItem(emailInput);
        emailInput.click();
        emailInput.sendKeys(email);

        passwordInput.click();
        passwordInput.sendKeys(password);

        repeatPasswordInput.click();
        repeatPasswordInput.sendKeys(password);

        finishSignUpButton.click();

    }

    public boolean wasSignUpSuccessful(){

        return isElementHere(signUpAlertTitle) && isElementHere(signUpOkButton);

    }

    public void tapSignUpOkButton(){
        signUpOkButton.click();
    }

}
