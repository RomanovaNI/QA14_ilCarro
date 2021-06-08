package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCarTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isUserLoggedIn()) {
            logIn();
        }

    }

    @Test
    public void addCarTest() throws InterruptedException {
        pause();
        clickOnAddCarTab();

        fillCarForm(new Car()
                .setCountry("Germany")
                .setAddress("Friedrichstrasse")
                .setDistance("1000"));

    }

}
