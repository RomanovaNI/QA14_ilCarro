package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //to go logintest
        //if user logged in, click logout,
        if (!app.user.isSignUpButtonPresent()) {
            app.user.logout();

        }

    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //go to login page
        app.user.clickOnLoginTab();
        //fill login form
        app.user.fillLoginForm(new User().withEmail("ll@ll.ua").withPassword("1234KKKKkk"));
        app.user.submit();
        app.header.isLogOutTabPresent();

        //submit login
        //assert user logged in

    }@Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {
        app.user.clickOnLoginTab();
        app.user.fillLoginForm(new User().withEmail("ll@ll.ua").withPassword("1235KKKKkk"));
        app.user.submit();
        app.user.isLogOutTabNotPresent();

    }

}
