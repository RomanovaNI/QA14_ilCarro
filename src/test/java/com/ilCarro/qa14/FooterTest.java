package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends TestBase {

    @Test
    public void scrollDownAndUpTest1() {
        jumpToFooter();
        isFooterInfoTabPresent();
        clickOnFooterMainLogo();
    }

    @Test
    public void scrollDownAndUp2() {
        jumpToFooter();
        isFooterNavLetTheCarWorkPresent();
        jumpToHeader();

    }


}
