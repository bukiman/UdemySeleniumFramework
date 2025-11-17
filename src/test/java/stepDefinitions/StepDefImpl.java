package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.ProductCataloguePage;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.List;

public class StepDefImpl extends BaseTest {

    public ProductCataloguePage productCataloguePage;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void gotoEcommercePage() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void loginWithGivenCredentials(String username, String password) {
        productCataloguePage = landingPage.login(username, password);
    }

    @When("^I add product (.+) to Cart$")
    public void addProductToCart(String productName) {
        List<WebElement> products = productCataloguePage.getProductList();
        productCataloguePage.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void submitOrder(String productName) {
        CartPage cartPage = productCataloguePage.goToCartPage();

        boolean match = cartPage.verifyProductIsDisplayed(productName);
        Assert.assertTrue(match);
        checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("mexico");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void messageDisplayedOnConfirmationPage(String message) {
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String message) {
        Assert.assertEquals(message, landingPage.getErrorMessage());
    }

    @After
    public void tearDownCucumber(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        driver.quit();
    }
}
