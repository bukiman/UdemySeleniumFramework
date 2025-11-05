package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testComponents.BaseTest;

public class Hooks {
/*
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("inside after hook");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        driver.quit();
    }*/
}
