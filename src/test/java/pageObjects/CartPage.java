package pageObjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = ".totalRow button")
    private WebElement checkoutButton;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> productTitles;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProductIsDisplayed(String productName) {
        return productTitles.stream().anyMatch(pt -> pt.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage goToCheckout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
