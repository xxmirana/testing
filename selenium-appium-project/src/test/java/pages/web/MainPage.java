package pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(id = "login2")
    private WebElement loginLink;
    @FindBy(id = "signin2")
    private WebElement signUpLink;
    @FindBy(id = "cartur")
    private WebElement cartLink;
    @FindBy(linkText = "Phones")
    private WebElement phonesCategory;
    @FindBy(linkText = "Laptops")
    private WebElement laptopsCategory;
    @FindBy(linkText = "Monitors")
    private WebElement monitorsCategory;
    @FindBy(id = "nava")
    private WebElement homeLogo;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickSignUpLink() {
        signUpLink.click();
    }

    public void clickCartLink() {
        cartLink.click();
    }

    public void clickPhonesCategory() {
        phonesCategory.click();
    }

    public void clickLaptopsCategory() {
        laptopsCategory.click();
    }

    public void clickMonitorsCategory() {
        monitorsCategory.click();
    }

    public void clickHomeLogo() {
        homeLogo.click();
    }

    public boolean isHomeLogoDisplayed() {
        return homeLogo.isDisplayed();
    }
}