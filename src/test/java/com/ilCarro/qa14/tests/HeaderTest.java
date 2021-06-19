package com.ilCarro.qa14.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.user().isSignUpButtonPresent()) {
            app.user().logout();
            //sign up not present
            //click on logout button
        }
    }


    @Test
    public void searchButtonTest() {
        app.header().clickOnSearchTab();
        app.header().isSearchFormPresent();

    }

    @Test
    public void letTheCarWorkButtonTest() {
        app.car().clickOnAddCarTab();
        app.header().isPricePerDayTabPresent();
    }

    @Test
    public void termsOfUseButtonTest() {
        app.header().clickOnTermsOfUseTab();
        app.header().isTermsOfUseFormPresent();
        app.header().goToHomePage();

    }

    @Test
    public void logInButtonTest() {
        app.user().clickOnLoginTab();
        app.header().isLoginTitlePresent();

    }

}
