package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/signup']"))) {
            wd.findElement(By.xpath("//a[contains(.,'logOut')]")).click();
            //sign up not present
            //click on logout button
        }
    }


    @Test
    public void searchButtonTest() {
        wd.findElement(By.cssSelector("[href='/search']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".search-sidebar__tab.tab-first")));

    }
    @Test
    public void letTheCarWorkButtonTest(){
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']//li//a[@href='/car']")).click();
        String text = wd.findElement(By.xpath("//h4[contains(.,'Price per day')]")).getText();
        Assert.assertEquals(text.toLowerCase(), "price per day:");
    }
    @Test
    public void termsOfUseButtonTest(){
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']//li[3]")).click();
        Assert.assertTrue(isElementPresent(By.id("root")));

    }
    @Test
    public void logOutButtonTest(){
        wd.findElement(By.cssSelector("[href='/login']")).click();
        String text = wd.findElement(By.xpath("//div[@class='signup__registration_title ']//h2")).getText();
        Assert.assertEquals(text.toLowerCase(), "log in");

    }
}
