package pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(css = "h4.card-title")
    private List<WebElement> productTitles;

    @FindBy(css = "h5.card-title")
    private List<WebElement> productPrices;

    @FindBy(css = "p.card-text")
    private List<WebElement> productDescriptions;

    @FindBy(linkText = "Home")
    private WebElement homeLink;

    @FindBy(id = "next2")
    private WebElement nextButton;

    @FindBy(id = "prev2")
    private WebElement previousButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int getProductCount() {
        return productTitles.size();
    }

    public String getFirstProductTitle() {
        if (productTitles.size() > 0) {
            return productTitles.get(0).getText();
        }
        return "";
    }

    public String getFirstProductPrice() {
        if (productPrices.size() > 0) {
            return productPrices.get(0).getText();
        }
        return "";
    }

    public String getFirstProductDescription() {
        if (productDescriptions.size() > 0) {
            return productDescriptions.get(0).getText();
        }
        return "";
    }

    public void clickFirstProduct() {
        if (productTitles.size() > 0) {
            productTitles.get(0).click();
        }
    }

    public void clickHomeLink() {
        homeLink.click();
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void clickPreviousButton() {
        previousButton.click();
    }

    public boolean isNextButtonEnabled() {
        return nextButton.isEnabled();
    }

    public boolean isPreviousButtonEnabled() {
        return previousButton.isEnabled();
    }

    public boolean areResultsDisplayed() {
        return productTitles.size() > 0;
    }
}