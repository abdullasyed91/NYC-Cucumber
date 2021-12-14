package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    public WebDriver driver;
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");

    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    //Navigate to the homepage
    public Home navigateToHome() {
        LOGGER.debug("Navigating to Home Page");
        ActOn.element(driver, MortgageCalculatorLogo).click();
        return new Home(driver);
    }

    //Mouse Hover to the Rates Link
    public NavigationBar mouseHoverToRates() {
        LOGGER.debug("Mouse hover to Rates Link");
        ActOn.element(driver, RatesLink).mouseHover();
        return this;
    }

    //navigate to real Apr page
    public RealApr navigateToRealApr() {
        LOGGER.debug("Navigating to real Apr");
        ActOn.element(driver, RealAprLink).click();
        return new RealApr(driver);
    }

}
