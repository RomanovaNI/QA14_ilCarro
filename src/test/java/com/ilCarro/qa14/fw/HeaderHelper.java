package com.ilCarro.qa14.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderHelper extends HelperBase{
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnSignUpTab() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void isLoginFormPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".style_title_block__fCXs6")));
    }

    public boolean isLogInFormPresent() {
            return isElementPresent(By.cssSelector(".Login_login__right_block__1niYm"));
        }



    public void isSearchFormPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".search-sidebar__tab.tab-first")));
    }

    public void clickOnSearchTab() {
        click(By.cssSelector("[href='/search']"));
    }

    public void isTermsOfUseFormPresent() {
        Assert.assertTrue(isElementPresent(By.id("root")));
    }

    public void clickOnTermsOfUseTab() {
        click(By.xpath("//ul[@class='header__nav desktop']//li[3]"));
    }

    public void isPricePerDayTabPresent() {
        String text = wd.findElement(By.xpath("//h4[contains(.,'Price per day')]")).getText();
        Assert.assertEquals(text.toLowerCase(), "price per day:");
    }

    public void isLoginTitlePresent() {
        String text = wd.findElement(By.xpath("//div[@class='signup__registration_title ']//h2")).getText();
        Assert.assertEquals(text.toLowerCase(), "log in");
    }
    public void isLogOutTabPresent() {
        Assert.assertTrue(isElementsPresent(By.xpath("//a[contains(.,'logOut')]")));
    }
    public boolean isLogOutTabPresentBoolean() {
        return isElementsPresent(By.xpath("//a[contains(.,'logOut')]"));
    }

}
