package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FooterTest extends TestBase {

    @Test
    public void scrollDownAndUpTest1() {
        jumpToFooter();
        isElementPresent(By.cssSelector(".footer__info"));
        click(By.cssSelector("[class='footer__top_row_logo']"));
    }

    @Test
    public void scrollDownAndUp2() {
        jumpToFooter();
        isFindCarFormPresent(By.xpath("//ul[@class=\"footer__nav\"]//li[2]"));
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.HOME, Keys.COMMAND);

    }


}
