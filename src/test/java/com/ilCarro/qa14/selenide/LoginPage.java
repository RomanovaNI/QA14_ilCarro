package com.ilCarro.qa14.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private By loginTabLocator = By.cssSelector("[href='/login']");
    private By emailLocator = By.cssSelector("[name='email']");
    private By passwordLocator = By.name("password");
    private By submitLocator = By.cssSelector("[type=\"submit\"]");

    private By logoutTabLocator=By.xpath("//a[contains(.,'logOut')]");


    public LoginPage() {
        // Configuration.startMaximized=true;
        open("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    public void with(String email, String password) {
        $(loginTabLocator).click();
        $(emailLocator).val(email);
        $(passwordLocator).val(password);
        $(submitLocator).click();
    }

    public void validLogin(){
        $(emailLocator).shouldBe(Condition.visible).waitUntil(Condition.visible,4000);
    }

}
