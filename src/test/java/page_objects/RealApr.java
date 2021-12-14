package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar {


    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomePrice = By.name("HomeValue");
    private final By DownPayment = By.name("DownPayment");
    private final By SelectDownPaymentInDollar = By.id("DownPaymentSel0");
    private final By InterestRate = By.name("Interest");
    private final By CalculateRateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//td[1]/strong/../../td[2]/strong");

    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    public RealApr(WebDriver driver) {
        super(driver);
    }

    public RealApr waitForPageToLoad() {
        LOGGER.debug("Waiting for the page to load");
        ActOn.wait(driver, CalculatorTab).waitForElementToBeVisible();
        return this;
    }

    //Enter Home value
    public RealApr typeHomePrice(String value) {
        LOGGER.debug("Typing the home price: " + value);
        ActOn.element(driver, HomePrice).setValue(value);
        return this;
    }

    //Enter DownPayment
    public RealApr typeDownPayment(String value) {
        LOGGER.debug("Typing the down payment " + value);
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    //Click on down payment $ radio button
    public RealApr selectDownPaymentInDollar () {
        LOGGER.debug("Clicking on the radio button of down payment");
        ActOn.element(driver, SelectDownPaymentInDollar).click();
        return this;
    }

    //Enter Interest rate
    public RealApr typeIntrestRate(String value) {
        LOGGER.debug("Typing the interest rate " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    //Click on calculate button
    public RealApr clickCalculateButton() {
        LOGGER.debug("Clicking on the calculate button");
        ActOn.element(driver, CalculateRateButton).click();
        return this;
    }

    //Validate the APR
    public RealApr validateAprRate(String expectedValue) {
        String aprRate = ActOn.element(driver, ActualAprRate).getTextValue();
        Assert.assertEquals(expectedValue, aprRate);
        return this;
    }
}
