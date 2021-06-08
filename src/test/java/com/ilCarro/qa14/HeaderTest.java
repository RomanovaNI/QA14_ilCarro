package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isSignUpButtonPresent()) {
            logout();
            //sign up not present
            //click on logout button
        }
    }


    @Test
    public void searchButtonTest() {
        clickOnSearchTab();
        isSearchFormPresent();

    }

    @Test
    public void letTheCarWorkButtonTest() {
        clickOnAddCarTab();
        isPricePerDayTabPresent();
    }

    @Test
    public void termsOfUseButtonTest() {
        clickOnTermsOfUseTab();
        isTermsOfUseFormPresent();
        goToHomePage();

    }

    @Test
    public void logInButtonTest() {
        clickOnLoginTab();
        isLoginTitlePresent();

    }

}
