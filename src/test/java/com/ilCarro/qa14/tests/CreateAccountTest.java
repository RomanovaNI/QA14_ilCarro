package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTest extends TestBase {



    //preconditions: user should be logged out

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.user().isSignUpButtonPresent()) {
            app.user().logout();
            //sign up not present
            //click on logout button
        }
    }

    @Test
    public void signUpTest() {
        //click on SignUp Button
        //fill registration form
        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        app.user().fillRegistrationForm(new User()
                .withFirstName("Leila")
                .withSecondName("Kirova")
                .withEmail("k2k" + System.currentTimeMillis() + "@ll.ua")
                .withPassword("1234KKKKkk"));

        app.user().clickCheckPolicy();
        //click Submit button
        app.user().submit();
        //check login form  displayed
        app.header().isLoginFormPresent();


    }

    @Test(enabled = false, dataProvider = "validUser", dataProviderClass = DataProviders.class)
    public void signUpFromDataProviderTest(String fName, String sName, String email, String password) {

        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        app.user().fillRegistrationForm(new User()
                .withFirstName(fName)
                .withSecondName(sName)
                .withEmail(email)
                .withPassword(password));

        app.user().clickCheckPolicy();
        app.user().submit();
        logger.info("Login form present. Actual result: " + app.header().isLogInFormPresent()
                + ". Expected result: true.");
        app.header().isLoginFormPresent();


    }
    @Test(enabled = false,dataProvider = "validUserFromCSV", dataProviderClass = DataProviders.class)
    public void signUpFromDataProviderFromCSVTest(User user) {

        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        app.user().fillRegistrationForm(user);

        app.user().clickCheckPolicy();
        app.user().submit();
        logger.info("Login form present. Actual result: " + app.header().isLogInFormPresent()
                + ". Expected result: true.");
        app.header().isLoginFormPresent();


    }


}



