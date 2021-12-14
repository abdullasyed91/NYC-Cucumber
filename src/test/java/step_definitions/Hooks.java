package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    public static WebDriver driver;

    @Before
    public void browserInitialization() {
        driver = DriverFactory.getInstance().getDriver();
        LOGGER.info("Launch browser");
    }

    @After
    public void closeBrowser() {
        DriverFactory.getInstance().removerDrive();
        LOGGER.info("Closed the browser");
    }
}
