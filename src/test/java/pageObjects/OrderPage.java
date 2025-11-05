package pageObjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkoutButton;

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> productNames;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyOrderIsDisplayed(String productName) {
        return productNames.stream().anyMatch(pn -> pn.getText().equalsIgnoreCase(productName));
    }

}
