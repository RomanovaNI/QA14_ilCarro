package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver wd;

    @BeforeSuite
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public boolean isElementsPresent(By by){
            return wd.findElements(by).size()>0;
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }

    @AfterMethod(enabled = false)
        public void tearDown() {
            wd.quit();
        }

    public void logout() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public boolean isSignUpButtonPresent() {
        return isElementsPresent(By.cssSelector("[href='/signup']"));
    }

    public void isSignUpFormPresent() {
        Assert.assertTrue(isElementsPresent(By.cssSelector("form.signup__fields")));
    }

    public void type(By locator, String text) {
        if(text!=null){
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
        }

    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void submit() {
        click(By.cssSelector("[type=\"submit\"]"));
    }

    public void isLogOutTabPresent() {
        Assert.assertTrue(isElementsPresent(By.xpath("//a[contains(.,'logOut')]")));
    }
    public void jumpToFooter(){
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.END,Keys.COMMAND);
    }

    public boolean isFindCarForPresent() {
        return isElementsPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }

    public void clickOnLoginTab() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("[name='email']"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void logIn() {
        clickOnLoginTab();
        type(By.cssSelector("[name='email']"), "ll@ll.ua");
        type(By.name("password"), "1234KKKKkk");
        submit();

    }

    public boolean isUserLoggedIn() {
        return isElementsPresent(By.xpath("//a[contains(.,'logOut')]"));

    }

    public void pause() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void clickOnAddCarTab() {
        click(By.xpath("//ul[@class='header__nav desktop']//li[2]"));
        //  click(By.xpath("//ul[@class='header__nav desktop']//li//a[@href='/car']"));
    }

    public void fillCarForm(Car car) {
        type(By.cssSelector(".country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistance());
    }

    public void clickCheckPolicy() {
        click(By.cssSelector("#check_policy"));
    }

    public void clickOnSignUpTab() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getFirstName());
        type(By.cssSelector("#second_name"), user.getSecondName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void isLoginFormPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".style_title_block__fCXs6")));
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

    public void goToHomePage() {
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    public void isLoginTitlePresent() {
        String text = wd.findElement(By.xpath("//div[@class='signup__registration_title ']//h2")).getText();
        Assert.assertEquals(text.toLowerCase(), "log in");
    }

    public void clickOnFooterMainLogo() {
        click(By.cssSelector("[class='footer__top_row_logo']"));
    }

    public void jumpToHeader() {
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.HOME, Keys.COMMAND);
    }

    public void isFooterInfoTabPresent() {
        Assert.assertTrue(isElementPresent(By.cssSelector(".footer__info")));
    }

    public void isFooterNavLetTheCarWorkPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//ul[@class=\"footer__nav\"]//li[2]")));
    }

    public void isLogOutTabNotPresent() {
        Assert.assertFalse(isElementsPresent(By.xpath("//a[contains(.,'logOut')]")));
    }
}
