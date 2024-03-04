package com.example.tests;

import com.example.screens.*;
import com.example.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTests extends BaseTest {

    @Test
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

}
