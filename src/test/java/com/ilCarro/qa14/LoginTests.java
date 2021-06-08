package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //to go logintest
        //if user logged in, click logout,
        if (!isSignUpButtonPresent()) {
            logout();

        }

    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //go to login page
        clickOnLoginTab();
        //fill login form
        fillLoginForm(new User().withEmail("ll@ll.ua").withPassword("1234KKKKkk"));
        submit();
        isLogOutTabPresent();

        //submit login
        //assert user logged in

    }@Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {
        clickOnLoginTab();
        fillLoginForm(new User().withEmail("ll@ll.ua").withPassword("1235KKKKkk"));
        submit();
        isLogOutTabNotPresent();

    }

}
