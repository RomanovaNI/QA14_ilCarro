package com.ilCarro.qa14.fw;

import com.ilCarro.qa14.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void logout() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public boolean isSignUpButtonPresent() {
        return isElementsPresent(By.cssSelector("[href='/signup']"));
    }

    public void isSignUpFormPresent() {
        Assert.assertTrue(isElementsPresent(By.cssSelector("form.signup__fields")));
    }

    public void submit() {
        click(By.cssSelector("[type=\"submit\"]"));
    }

    public void clickOnLoginTab() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("[name='email']"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void logIn() {
        clickOnLoginTab();
        type(By.cssSelector("[name='email']"), "ll@ll.ua");
        type(By.name("password"), "1234KKKKkk");
        submit();

    }

    public boolean isUserLoggedIn() {
        return isElementsPresent(By.xpath("//a[contains(.,'logOut')]"));

    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getFirstName());
        type(By.cssSelector("#second_name"), user.getSecondName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }
    public void clickCheckPolicy() {
        click(By.cssSelector("#check_policy"));
    }

    public void isLogOutTabNotPresent() {
        Assert.assertFalse(isElementsPresent(By.xpath("//a[contains(.,'logOut')]")));
    }
    public boolean isLogOutTabNotPresentBoolean() {
       return !isElementsPresent(By.xpath("//a[contains(.,'logOut')]"));
    }
}
