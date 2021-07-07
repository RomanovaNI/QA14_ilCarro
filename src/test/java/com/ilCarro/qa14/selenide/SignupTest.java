package com.ilCarro.qa14.selenide;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest {
SignupPage registration;


@BeforeMethod
    public void setUp(){
    registration=new SignupPage();
}

@Test
    public void signupTet(){
    registration.with("lika", "popova", "lika@lika.ua", "1234KKKKkk");
    registration.validSignup();
}


}
