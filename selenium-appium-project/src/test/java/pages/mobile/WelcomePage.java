package pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {
    @AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_skip_button")
    private WebElement skipButton;
    @AndroidFindBy(accessibilityId = "Search Wikipedia")
    private WebElement searchBox;

    public WelcomePage(AndroidDriver driver) {
        super(driver);
    }

    public void skipWelcomeScreen() {
        skipButton.click();
    }

    public void clickSearchBox() {
        searchBox.click();
    }

    public boolean isSearchBoxDisplayed() {
        return searchBox.isDisplayed();
    }
}