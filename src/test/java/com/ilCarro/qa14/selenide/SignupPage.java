package com.ilCarro.qa14.selenide;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SignupPage {
    private By signupTabLocator = By.cssSelector("[href='/signup']");
    private By firstNameLocator = By.cssSelector("#first_name");
    private By secondNameLocator = By.cssSelector("#second_name");
    private By emailLocator = By.cssSelector("#email");
    private By passwordLocator = By.cssSelector("#password");
    private By checkPolicyLocator = By.cssSelector("#check_policy");
    private By submitLocator = By.cssSelector("[type=\"submit\"]");
    private By logoutTabLocator=By.xpath("//a[contains(.,'logOut')]");


    public SignupPage() {

        open("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    public void with(String name, String lastName, String email, String password) {
        $(signupTabLocator).click();
        $(firstNameLocator).val(name);
        $(secondNameLocator).val(lastName);
        $(emailLocator).val(email);
        $(passwordLocator).val(password);
        $(checkPolicyLocator).click();
        $(submitLocator).click();

    }
    public void validSignup(){
        $(emailLocator).shouldBe(Condition.visible).waitUntil(Condition.visible,4000);
    }


}
