package com.example.tests;

import com.example.screens.*;
import com.example.utils.load_files.CredentialList;
import com.example.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTests extends BaseTest {

    @Test(priority = 0)
    public void bottomMenuNavigation(){

        HomeScreen home = getHomeScreen();
        Assert.assertTrue(home.amIHere(), "Couldn't find an element in the Home screen");

        WebViewScreen webView = home.tapWebview();
        Assert.assertTrue(webView.amIHere(), "Couldn't find an element in the WebView screen");

        LoginScreen login = webView.tapLogin();
        Assert.assertTrue(login.amIHere(), "Couldn't find an element in the Login screen");

        FormsScreen forms = login.tapForms();
        Assert.assertTrue(forms.amIHere(), "Couldn't find an element in the Swipe screen");

        SwipeScreen swipe = forms.tapSwipe();
        Assert.assertTrue(swipe.amIHere(), "Couldn't find an element in the Forms screen");

        DragScreen drag = swipe.tapDrag();
        Assert.assertTrue(drag.amIHere(), "Couldn't find an element in the Drag screen");

    }

    @Test(priority = 1)
    public void successfulSignUp(){

        HomeScreen home = getHomeScreen();
        LoginScreen login = home.tapLogin();

        SignUpScreen signUp = login.tapSignUp();

        CredentialList.readCredentialList();
        String[] credentials = CredentialList.getRandomCredentials();

        signUp.fillSignUp(credentials[0], credentials[1]);

        Assert.assertTrue(signUp.wasSuccessful(), "Sign up was not successful");

        signUp.tapSignUpOkButton();

    }

    @Test(priority = 2)
    public void successfulLogin(){

        HomeScreen home = getHomeScreen();
        LoginScreen login = home.tapLogin();

        CredentialList.readRegisteredCredentials();
        String[] credentials = CredentialList.getRegisteredCredentials();

        login.fillLogIn(credentials[0], credentials[1]);

        Assert.assertTrue(login.wasSuccessful(), "Login was not successful");

        login.tapOkButton();

    }

    @Test(priority = 3)
    public void swipeCards(){

        HomeScreen home = getHomeScreen();
        SwipeScreen swipe = home.tapSwipe();

        swipe.swipeRight();

        Assert.assertTrue(swipe.firstSwipeVerifications(), "Old card is not hidden (first swipe)");

        swipe.swipeAllTheWayToTheRight();

        Assert.assertTrue(swipe.secondSwipeVerifications(), "Verification failed after swiping all the way to the right (second swipe)");

        swipe.swipeDown();

        Assert.assertTrue(swipe.verticalSwipeVerifications(), "You found me text was not found after scrolling down");

    }

}
