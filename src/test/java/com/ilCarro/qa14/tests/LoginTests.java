package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //to go logintest
        //if user logged in, click logout,
        if (!app.user().isSignUpButtonPresent()) {
            app.user().logout();

        }

    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //go to login page
        app.user().clickOnLoginTab();
        //fill login form
        app.user().fillLoginForm(new User().withEmail("ll@ll.ua").withPassword("1234KKKKkk"));
        app.user().submit();
        app.header().isLogOutTabPresent();


        //submit login
        //assert user logged in

    }
    @Test (enabled = false, dataProvider = "validRegisteredUserFromCSV", dataProviderClass = DataProviders.class)
    public void loginRegisteredUserPositiveTestFromCSV(User user) {
        //go to login page
        app.user().clickOnLoginTab();
        //fill login form
        app.user().fillLoginForm(user);
        app.user().submit();
        logger.info("Log out form present. Actual result: " + app.header().isLogInFormPresent()
                + ". Expected result: true.");
        app.header().isLogOutTabPresent();

        //submit login
        //assert user logged in

    }
    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {
        app.user().clickOnLoginTab();
        app.user().fillLoginForm(new User().withEmail("ll@ll.ua").withPassword("1235KKKKkk"));
        app.user().submit();
        app.user().isLogOutTabNotPresent();


    }
    @Test(enabled = false, dataProvider = "invalidRegisteredUserFromCSV", dataProviderClass = DataProviders.class)
    public void loginRegisteredUserWithWrongPasswordNegativeTestFromCSV(User user) {
        app.user().clickOnLoginTab();
        app.user().fillLoginForm(user);;
        app.user().submit();
        logger.info("Log out form present. Actual result: " + app.user().isLogOutTabNotPresentBoolean()
                + ". Expected result: true.");
        app.user().isLogOutTabNotPresent();
       // app.user().refresh();


    }

}
