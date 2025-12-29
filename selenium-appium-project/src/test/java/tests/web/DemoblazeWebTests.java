package tests.web;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.web.MainPage;
import utils.WebDriverSetup;
import java.io.IOException;

public class DemoblazeWebTests {
    MainPage mainPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverSetup.initializeDriver();
        mainPage = new MainPage(WebDriverSetup.driver);
    }

    @Test(priority = 1)
    public void testHomePageLogoIsDisplayed() {
        Assert.assertTrue(mainPage.isHomeLogoDisplayed());
    }

    @Test(priority = 2)
    public void testNavigationToCategories() {
        mainPage.clickPhonesCategory();
        String currentUrl = WebDriverSetup.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("#"));
    }

    @Test(priority = 3)
    public void testCartPageNavigation() {
        mainPage.clickCartLink();
        String currentUrl = WebDriverSetup.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("cart"));
    }

    @Test(priority = 4)
    public void testSignUpModalAppears() {
        mainPage.clickSignUpLink();
        WebDriverSetup.wait.until(driver -> driver.getCurrentUrl().contains("#"));
        String pageSource = WebDriverSetup.driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Sign up"));
    }

    @AfterClass
    public void tearDown() {
        WebDriverSetup.quitDriver();
    }
}