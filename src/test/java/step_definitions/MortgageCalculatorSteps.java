package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;
import utilities.ReadConfigFiles;
import java.util.List;
import java.util.Map;

public class MortgageCalculatorSteps {
    private static final Logger LOGGER = LogManager.getLogger(MortgageCalculatorSteps.class);
    WebDriver driver = Hooks.driver;

    @Given("^a user is on the mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage() {
        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageUrl"));
        LOGGER.info("User Landed on the mortgage calculator home page");
    }

    @And("^user navigates to the Real Apr page$")
    public void navigateToRealApr() {
        new Home(driver).mouseHoverToRates()
                .navigateToRealApr();
        LOGGER.info("navigated to Real Apr page");
    }

    @When("^user clicks on calculate button upon entering the data$")
    public void clickOnCalculateButtonUponEnteringData(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : data) {
            new RealApr(driver)
                    .typeHomePrice(cells.get("HomePrice"))
                    .typeDownPayment(cells.get("DownPayment"))
                    .selectDownPaymentInDollar()
                    .typeIntrestRate(cells.get("InterestRate"))
                    .clickCalculateButton();
        }
        LOGGER.info("Real Apr rate is calculated upon entering the data");
    }

    @Then("^the real Apr Rate is \"(.+?)\"$")
    public void validateRealAprRate(String realApr) {
        new RealApr(driver)
                .validateAprRate(realApr);
        LOGGER.info("The real Apr is validated");
    }
}
