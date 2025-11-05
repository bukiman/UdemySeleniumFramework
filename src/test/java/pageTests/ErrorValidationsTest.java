package pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.ProductCataloguePage;
import testComponents.BaseTest;
import testComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer =  Retry.class)
    public void loginErrorValidation() {

        landingPage.login("ejemplo1@ejemplo.com", "Test1235");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email password.");
    }

    @Test
    public void productErrorValidation() {

        String productName = "ZARA COAT 3";
        ProductCataloguePage productCataloguePage =
                landingPage.login("ejemplo1@ejemplo.com", "Test1234");
        productCataloguePage.addProductToCart(productName);
        CartPage cartPage = productCataloguePage.goToCartPage();

        boolean match = cartPage.verifyProductIsDisplayed("ZARA COAT 3");
        Assert.assertTrue(match);
    }
}
