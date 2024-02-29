package com.example.tests;

import com.example.screens.HomeScreen;
import com.example.utils.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTests extends BaseTest {

    @Test
    public void bottomMenuNavegation(){

        HomeScreen home = getHomeScreen();
        home.tapWebview();
        home.tapLogin();
        home.tapForms();
        home.tapSwipe();
        home.tapDrag();

    }

}
