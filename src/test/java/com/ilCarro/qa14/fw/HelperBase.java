package com.ilCarro.qa14.fw;


import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementsPresent(By by) {
        return wd.findElements(by).size() > 0;
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
         //   wd.findElement(locator).sendKeys(Keys.chord(Keys.COMMAND,"a")+Keys.DELETE+text);
        }

    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void goToHomePage() {
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot=new File("/Users/natalia/ProjectTelRan/QA/QA14_ilCarro/src/test/screenshots/screenshot"+System.currentTimeMillis()+".png");
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }

    public void refresh() {
        wd.navigate().refresh();
    }

}
