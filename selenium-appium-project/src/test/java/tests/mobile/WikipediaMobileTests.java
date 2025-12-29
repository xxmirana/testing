package tests.mobile;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mobile.WelcomePage;
import utils.AppiumDriverSetup;
import java.io.IOException;

public class WikipediaMobileTests {
    WelcomePage welcomePage;

    @BeforeClass
    public void setUp() throws IOException {
        AppiumDriverSetup.initializeDriver();
        welcomePage = new WelcomePage(AppiumDriverSetup.driver);
        welcomePage.skipWelcomeScreen();
    }

    @Test(priority = 1)
    public void testSearchBoxIsPresent() {
        Assert.assertTrue(welcomePage.isSearchBoxDisplayed());
    }

    @Test(priority = 2)
    public void testSearchAndOpenArticle() {
        welcomePage.clickSearchBox();
        AppiumDriverSetup.driver.findElement(AppiumBy.id("org.wikipedia:id/search_src_text")).sendKeys("Appium");
        AppiumDriverSetup.driver.findElement(AppiumBy.xpath("//*[@text='Software']")).click();
        String articleTitle = AppiumDriverSetup.driver.findElement(AppiumBy.id("org.wikipedia:id/view_page_title_text")).getText();
        Assert.assertTrue(articleTitle.contains("Appium"));
    }

    @Test(priority = 3)
    public void testScrollInArticle() {
        welcomePage.clickSearchBox();
        AppiumDriverSetup.driver.findElement(AppiumBy.id("org.wikipedia:id/search_src_text")).sendKeys("Java");
        AppiumDriverSetup.driver.findElement(AppiumBy.xpath("//*[@text='Object-oriented programming language']")).click();
        String scrollableUiSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
        AppiumDriverSetup.driver.findElement(AppiumBy.androidUIAutomator(scrollableUiSelector));
        boolean isContentDisplayed = AppiumDriverSetup.driver.findElement(AppiumBy.xpath("//*[@text='History']")).isDisplayed();
        Assert.assertTrue(isContentDisplayed);
    }

    @AfterClass
    public void tearDown() {
        AppiumDriverSetup.quitDriver();
    }
}