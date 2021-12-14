package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar{

    private final By HomeValue = By.id("homeval");
    private final By DownPayment = By.id("downpayment");
    private final By DownPaymentInDollar = By.name("param[downpayment_type]");
    private final By LoanAmount = By.id("loanamt");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTerm = By.id("loanterm");
    private final By StartMonth = By.name("param[start_month]");
    private final By StartYear = By.id("start_year");
    private final By PropertyTax = By.id("pptytax");
    private final By PMI = By.id("pmi");
    private final By HOI = By.id("hoi");
    private final By HOA = By.id("hoa");
    private final By LoanType = By.name("param[milserve]");
    private final By RefiOrBuy = By.name("param[refiorbuy]");
    private final By Calculate = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public Home(WebDriver driver) {
        super(driver);
    }

    //Enter home value
    public Home typeHomePrice(String value) {
        LOGGER.debug("Typing the home value " + value);
        ActOn.element(driver, HomeValue).setValue(value);
        return this;
    }

    //Enter downpayment
    public Home typeDownPayment(String value) {
        LOGGER.debug("Typing the down payment " + value);
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    public Home clickDownPaymentInDollar() {
        LOGGER.debug("Clicking on the $ down payment option");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    //Enter Loan amount
    public Home typeLoanAmount(String value) {
        LOGGER.debug("Typing the loan amount " + value);
        ActOn.element(driver, LoanAmount).setValue(value);
        return this;
    }

    //Enter interest rate
    public Home typeInterestRate(String value) {
        LOGGER.debug("Typing the interest rate " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    //Enter loan term in years
    public Home typeLoanTerm(String value) {
        LOGGER.debug("Typing the loan term " + value);
        ActOn.element(driver, LoanTerm).setValue(value);
        return this;
    }

    //Select the month
    public Home selectMonth(String month) {
        LOGGER.debug("Selecting the starting month " + month);
        ActOn.element(driver, StartMonth).selectValue(month);
        return this;
    }

    //Enter the year
    public Home typeYear(String year) {
        LOGGER.debug("Typing the starting year " + year);
        ActOn.element(driver, StartYear).setValue(year);
        return this;
    }

    //Enter property tax
    public Home typePropertyTax(String value) {
        LOGGER.debug("Typing the property tax " + value);
        ActOn.element(driver, PropertyTax).setValue(value);
        return this;
    }

    //Enter PMI
    public Home typePmi(String value) {
        LOGGER.debug("Typing PMI " + value);
        ActOn.element(driver, PMI).setValue(value);
        return this;
    }

    //Enter Homeowner Insurance
    public Home typeHomeOwnerInsurance(String value) {
        LOGGER.debug("Typing HOI " + value);
        ActOn.element(driver, HOI).setValue(value);
        return this;
    }

    //Enter HOA
    public Home typeMonthlyHoa(String value) {
        LOGGER.debug("Typing HOA " + value);
        ActOn.element(driver, HOA).setValue(value);
        return this;
    }

    //Select loan type
    public Home selectLoanType(String value) {
        LOGGER.debug("Selecting loan type " + value);
        ActOn.element(driver, LoanType).selectValue(value);
        return this;
    }

    //Select Buy or Refi
    public Home selectBuyOrRefi(String value) {
        LOGGER.debug("Selecting Buy or Refi option " + value);
        ActOn.element(driver, RefiOrBuy).selectValue(value);
        return this;
    }

    //Click on Calculate Button
    public Home clickCalculateButton() {
        LOGGER.debug("CLicking on calculate button");
        ActOn.element(driver, Calculate).click();
        return this;
    }

    public Home validateMonthlyPayment(String monthlyPayment) {
        LOGGER.debug("Validating the monthly payment " + monthlyPayment);
        By monthlyPaymentLocator = By.xpath("//*[@id='calc']//h3[text()='" + monthlyPayment + "']");
        AssertThat.elementAssertion(driver, monthlyPaymentLocator).elementIsDisplayed();
        return this;
    }
}
