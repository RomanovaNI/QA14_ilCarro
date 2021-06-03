package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    //preconditions: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/signup']"))) {
            wd.findElement(By.xpath("//a[contains(.,'logOut')]")).click();
            //sign up not present
            //click on logout button
        }
    }

    @Test
    public void signUpTest() {
        //click on SignUp Button
        //first_name second_name email password check_policy
        wd.findElement(By.cssSelector("[href='/signup']")).click();
        isElementPresent(By.cssSelector("form.signup__fields"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        wd.findElement(By.cssSelector("#first_name")).clear();
        wd.findElement(By.cssSelector("#first_name")).sendKeys("Leila");
        wd.findElement(By.cssSelector("#second_name")).clear();
        wd.findElement(By.cssSelector("#second_name")).sendKeys("Kirova");
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys("ll@ll.ua");
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("1234KKKKkk");
        wd.findElement(By.cssSelector("#check_policy")).click();

    }
    //click on SignUp Button
    //fill registration form
    //click Submit button
    //check login form  displayed
}
