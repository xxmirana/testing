package pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ArticlePage extends BasePage {
    @AndroidFindBy(id = "org.wikipedia:id/view_page_title_text")
    private WebElement articleTitle;
    @AndroidFindBy(accessibilityId = "Add this article to a reading list")
    private WebElement saveButton;

    public ArticlePage(AndroidDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        return articleTitle.getText();
    }

    public boolean isSaveButtonDisplayed() {
        return saveButton.isDisplayed();
    }
}