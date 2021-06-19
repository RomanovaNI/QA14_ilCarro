package com.ilCarro.qa14.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FooterHelper extends HelperBase {
    public FooterHelper(WebDriver wd) {
        super(wd);
    }

    public void jumpToFooter() {
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.END, Keys.COMMAND);
    }

    public void clickOnFooterMainLogo() {
        click(By.cssSelector("[class='footer__top_row_logo']"));
    }

    public void isFooterInfoTabPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".footer__info")));
    }

    public void isFooterNavLetTheCarWorkPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//ul[@class=\"footer__nav\"]//li[2]")));
    }



    public void jumpToHeader() {
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.HOME, Keys.COMMAND);
    }
}
