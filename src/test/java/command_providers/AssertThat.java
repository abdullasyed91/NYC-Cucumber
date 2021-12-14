package command_providers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssertThat {
    public static ElementAssertion elementAssertion(WebDriver driver, By locator) {
        return new ElementAssertion(driver, locator);
    }
}
