package com.ilCarro.qa14.tests;

import org.testng.annotations.Test;

public class FooterTest extends TestBase {

    @Test
    public void scrollDownAndUpTest1() {
        app.footer().jumpToFooter();
        app.footer().isFooterInfoTabPresent();
        app.footer().clickOnFooterMainLogo();
    }

    @Test
    public void scrollDownAndUp2() {
        app.footer().jumpToFooter();
        app.footer().isFooterNavLetTheCarWorkPresent();
        app.footer().jumpToHeader();

    }


}
