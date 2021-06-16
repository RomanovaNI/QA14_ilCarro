package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.user.isSignUpButtonPresent()) {
            app.user.logout();
            //sign up not present
            //click on logout button
        }
    }

    @Test
    public void signUpTest() {
        //click on SignUp Button
        //fill registration form
        app.header.clickOnSignUpTab();
        app.user.isSignUpFormPresent();

        app.user.fillRegistrationForm(new User()
                .withFirstName("Leila")
                .withSecondName("Kirova")
                .withEmail("k2k@ll.ua")
                .withPassword("1234KKKKkk"));

        app.user.clickCheckPolicy();
        //click Submit button
        app.user.submit();
        //check login form  displayed
        app.header.isLoginFormPresent();


    }


}



