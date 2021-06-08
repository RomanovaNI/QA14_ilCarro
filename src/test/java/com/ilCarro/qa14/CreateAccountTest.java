package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isSignUpButtonPresent()) {
            logout();
            //sign up not present
            //click on logout button
        }
    }

    @Test
    public void signUpTest() {
        //click on SignUp Button
        //fill registration form
        clickOnSignUpTab();
        isSignUpFormPresent();

        fillRegistrationForm(new User()
                .withFirstName("Leila")
                .withSecondName("Kirova")
                .withEmail("k2k@ll.ua")
                .withPassword("1234KKKKkk"));

        clickCheckPolicy();
        //click Submit button
        submit();
        //check login form  displayed
        isLoginFormPresent();


    }


}



