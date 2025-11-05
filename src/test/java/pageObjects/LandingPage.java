package pageObjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WebElement userEmail = driver.findElement(By.id("userEmail"));
    //Page Factory
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    public ProductCataloguePage login(String email, String pwd) {

        userEmail.sendKeys(email);
        password.sendKeys(pwd);
        submit.click();
        return new ProductCataloguePage(driver);
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }
}
