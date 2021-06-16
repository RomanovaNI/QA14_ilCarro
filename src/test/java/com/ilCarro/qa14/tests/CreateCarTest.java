package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCarTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.user.isUserLoggedIn()) {
            app.user.logIn();
        }

    }

    @Test
    public void addCarTest() throws InterruptedException {
        app.user.pause();
        app.car.clickOnAddCarTab();

        app.car.fillCarForm(new Car()
                .setCountry("Germany")
                .setAddress("Friedrichstrasse")
                .setDistance("1000"));

    }

}
