package com.ilCarro.qa14.selenide;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

LoginPage login;

@BeforeMethod

    public void setUp(){
    login=new LoginPage();
}

@Test
    public void loginPositiveTest(){
    login.with("ll@ll.ua", "1234KKKKkk");
    login.validLogin();
}

}
