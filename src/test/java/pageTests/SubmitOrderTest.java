package pageTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.*;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "dataSet", groups = {"Purchase"})
    public void submitOrder(HashMap<Object, Object> input) {

        ProductCataloguePage productCataloguePage =
                landingPage.login(input.get("email").toString(), input.get("password").toString());

        List<WebElement> products = productCataloguePage.getProductList();
        System.out.println(products);
        productCataloguePage.addProductToCart(input.get("product").toString());
        CartPage cartPage = productCataloguePage.goToCartPage();

        boolean match = cartPage.verifyProductIsDisplayed(input.get("product").toString());
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();

        checkoutPage.selectCountry("mexico");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistory() {

        ProductCataloguePage productCataloguePage = landingPage.login("ejemplo1@ejemplo.com", "Test1234");
        OrderPage ordersPage = productCataloguePage.goToOrdersPage();
        Assert.assertTrue(ordersPage.verifyOrderIsDisplayed(productName));
    }

    @DataProvider(name = "dataSet")
    public Object[][] getData() throws IOException {

        List<HashMap<Object, Object>> data = getJsonDataToMap("\\src\\main\\resources\\PurchaseOrder.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }

    /*
    public Object[][] getData() {
        HashMap<Object, Object> map1 = new HashMap<Object, Object>();
        map1.put("email", "ejemplo1@ejemplo.com");
        map1.put("password", "Test1234");
        map1.put("product", "ZARA COAT 3");

        HashMap<Object, Object> map2 = new HashMap<Object, Object>();
        map2.put("email", "example1@ejemplo.com");
        map2.put("password", "Hello456");
        map2.put("product", "ADIDAS ORIGINAL");
    }
    */
}
