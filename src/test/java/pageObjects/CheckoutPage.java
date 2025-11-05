package pageObjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = "[placeholder='Select Country']")
    WebElement selectCountry;

    @FindBy(xpath = "(//button[contains(@class, 'ta-item')])[1]")
    WebElement country;

    @FindBy(css = ".action__submit")
    WebElement submitButton;

    By results = By.cssSelector(".ta-results");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
            PageFactory.initElements(driver, this);
    }

    public void selectCountry(String countryName) {
        Actions actions = new Actions(driver);
        actions.sendKeys(selectCountry, countryName).build().perform();
        waitForElementToAppear(results);
        country.click();
        actions.scrollToElement(driver.findElement(By.cssSelector(".action__submit"))).build().perform();
    }

    public ConfirmationPage submitOrder() {
        submitButton.click();
        return new ConfirmationPage(driver);
    }
}
